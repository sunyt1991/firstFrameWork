package business.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import jxl.common.Logger;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import plug.Json;
import plug.PageData;
import plug.RandomValidateCode;
import plug.SessionInfo;
import util.ConfigUtil;
import util.IpUtil;
import business.base.controller.BaseController;
import business.system.entity.Admin;
import business.system.service.AdminService;
import business.system.service.RoleService;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

	private static final Logger logger = Logger.getLogger(AdminController.class);
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/login")
	@ResponseBody
	public Json login(String username,String password,String validCode,HttpSession session,HttpServletRequest request) {		
		Admin admin=adminService.login(username,password);
		//HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		Json json = new Json();
		if(!validCode(validCode,session)){
			json.setMessage("验证码不正确");
			json.setStatusCode(Json.STAE_CODE_ERROR);
		}else{
			if(admin!=null){
				SessionInfo sessionInfo = new SessionInfo();
				sessionInfo.setAdminId(admin.getId());
				sessionInfo.setLoginName(admin.getLoginname());
				
				sessionInfo.setIp(IpUtil.getIpAddr(request));
				request.getSession().setAttribute(ConfigUtil.getSessionInfoName(), sessionInfo);
				json.setMessage("登录成功");
				json.setStatusCode(Json.STAE_CODE_SUCCESS);
			}else{
				json.setMessage("用户名或密码错误");
				json.setStatusCode(Json.STAE_CODE_ERROR);
			}
			
		}
		return json;
	}
	
	@RequestMapping("/index")
	public String main() {
		return "system/admin/index";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public PageData<Admin> list(HttpServletRequest request,Admin admin){
		System.out.println(">>>>>>>>>>>>>>>>>adminL:"+admin);
		PageData<Admin> admins=adminService.list(admin);
		return admins;
	}
	
	
	private boolean validCode(String validCode, HttpSession session) {
		if(StringUtils.isBlank(validCode)){
			return false;
		}
		if(validCode.equalsIgnoreCase(session.getAttribute(RandomValidateCode.RANDOMCODEKEY).toString())){
			return true;
		}else{
			return false;
		}
	}

	
	
	
	
	
	
}

