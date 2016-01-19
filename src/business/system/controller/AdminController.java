package business.system.controller;

import javax.servlet.http.HttpServletRequest;

import jxl.common.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import plug.Json;
import plug.SessionInfo;
import util.ConfigUtil;
import util.IpUtil;
import business.base.controller.BaseController;
import business.system.entity.Admin;
import business.system.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

	private static final Logger logger = Logger.getLogger(AdminController.class);
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/login")
	@ResponseBody
	public Json login(String username,String password) {		
		Admin admin=adminService.login(username,password);
		Json json = new Json();
		if(admin!=null){
			SessionInfo sessionInfo = new SessionInfo();
			sessionInfo.setAdminId(admin.getId());
			sessionInfo.setLoginName(admin.getLoginname());
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
			sessionInfo.setIp(IpUtil.getIpAddr(request));
			request.getSession().setAttribute(ConfigUtil.getSessionInfoName(), sessionInfo);
			json.setMessage("登录成功");
			json.setStatusCode(Json.STAE_CODE_SUCCESS);
		}else{
			json.setMessage("用户名或密码错误");
			json.setStatusCode(Json.STAE_CODE_ERROR);
		}
		return json;
	}

	
	
	
	
	
	
}

