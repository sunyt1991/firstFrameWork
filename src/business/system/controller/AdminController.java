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
		SessionInfo sessionInfo = new SessionInfo();
		sessionInfo.setAdminId(admin.getId());
		sessionInfo.setLoginName(admin.getLoginname());
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		sessionInfo.setIp(IpUtil.getIpAddr(request));
		request.getSession().setAttribute(ConfigUtil.getSessionInfoName(), sessionInfo);
		
		Json json = new Json();
		try {
			json.setMessage("yes");
			json.setStatusCode(Json.STAE_CODE_SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(">>jsonL:"+json);
		return json;
	}

	
	
	
	
	
	
}

