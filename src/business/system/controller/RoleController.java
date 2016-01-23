package business.system.controller;

import java.util.List;

import jxl.common.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import plug.Json;
import plug.ZTreeInfo;
import business.base.controller.BaseController;
import business.system.entity.Role;
import business.system.service.AdminService;
import business.system.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {
	
	private static final Logger logger = Logger.getLogger(RoleController.class);
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/leftmenu")
	public ModelAndView leftMenu(){
		Json json = new Json();
		int adminId=getSession().getAdminId();
		List<Role> roles=adminService.getRoles(adminId);
		Role role=null;
		if(roles!=null&&roles.size()>0){
			role=roles.get(0);
		}
		//根据角色获取菜单
		List<ZTreeInfo> resources=roleService.getResource(role);
		String resourcesStr=jsonUtil.toJson(resources);
		System.out.println(">>:"+resourcesStr);
		json.setParam(resourcesStr);
		json.setParam(resourcesStr);
		return new ModelAndView("frame/menu").addObject("json", json);
	}
}
