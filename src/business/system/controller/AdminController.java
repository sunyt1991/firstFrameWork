package business.system.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jxl.common.Logger;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import plug.Json;
import plug.PageData;
import plug.RandomValidateCode;
import plug.SessionInfo;
import util.ConfigUtil;
import util.EncryUtil;
import util.IpUtil;
import util.JacksonUtil;
import business.base.controller.BaseController;
import business.system.entity.Admin;
import business.system.entity.Role;
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
	
	@RequestMapping("/edit")
	public ModelAndView edit(Integer id) {
		Admin admin=adminService.getById(id);
		Role role=null;
		if(admin!=null){
			List<Role> roles=admin.getRoles();
			if(roles!=null&&roles.size()>0){
				role=roles.get(0);
			}
		}
		return new ModelAndView("system/admin/edit").addObject("bean",admin ).addObject("role",role);
	}
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request,Admin admin){
		PageData<Admin> admins=adminService.list(admin);
		JacksonUtil jsonUtil=new JacksonUtil("yyyy-MM-dd HH:mm:ss");
		return new ModelAndView(RESULT).addObject(RESULT,jsonUtil.toJson(admins));
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public Json save(Admin admin,HttpServletRequest request){
		Json json = new Json();
		try {
			String pwd="";
			if(StringUtils.isBlank(request.getParameter("id"))){
				pwd=EncryUtil.e("123");
				admin.setPwd(pwd);
			}
			Admin adminDb=adminService.save(admin);
			int roleId=Integer.parseInt(request.getParameter("roleid"));
			List<Role> roles=new ArrayList<Role>();
			Role role=roleService.getById(roleId);
			roles.add(role);
			adminDb.setRoles(roles);
			adminService.update(adminDb);
			json.setMessage("保存成功");
			json.setStatusCode(Json.STAE_CODE_SUCCESS);
		} catch (NumberFormatException e) {
			json.setMessage("保存失败");
			json.setStatusCode(Json.STAE_CODE_ERROR);
			e.printStackTrace();
		}
		return json;
	}
	
	@RequestMapping("/isdelete")
	public ModelAndView isdelete(HttpServletRequest request){
		Json json = new Json();
		try {
			Admin admin=adminService.getById(Integer.parseInt(request.getParameter("id")));
			admin.setIsdelete(1);
			adminService.update(admin);
			json.setMessage("删除成功");
			json.setStatusCode(Json.STAE_CODE_SUCCESS);
		} catch (NumberFormatException e) {
			json.setMessage("删除失败");
			json.setStatusCode(Json.STAE_CODE_ERROR);
			e.printStackTrace();
		}
		return new ModelAndView(RESULT).addObject(RESULT, json);
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

