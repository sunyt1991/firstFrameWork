package business.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import business.base.controller.BaseController;
import business.system.entity.Admin;
import business.system.service.AdminService;
import jxl.common.Logger;
import plug.Json;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

	private static final Logger logger = Logger.getLogger(AdminController.class);
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/user")
	public String user() {
		return "/admin/user";
	}

	@RequestMapping("/userAdd")
	public String userAdd() {
		return "/admin/userAdd";
	}

	@RequestMapping("/userEdit")
	public String userEdit() {
		return "/admin/userEdit";
	}

	@RequestMapping("/userRoleEdit")
	public String userRoleEdit() {
		return "/admin/userRoleEdit";
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public Json doNotNeedSession_login(Admin admin,String username,String password) {		
		System.out.println(">>>>>>>>>>>:"+username+":"+password);
		adminService.login(username,password);
		Json json=new Json();
		json.setMsg("yes");
		json.setObj(null);
		json.setSuccess(true);
		return json;
	}

	
	
	
	
	
	
}

