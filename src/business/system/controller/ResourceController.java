package business.system.controller;

import java.util.List;
import jxl.common.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import plug.TreeInfo;
import business.base.controller.BaseController;
import business.system.entity.Role;
import business.system.service.ResourceService;

@Controller
@RequestMapping("/resource")
public class ResourceController extends BaseController {
	
	private static final Logger logger = Logger.getLogger(ResourceController.class);
	
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping("/index")
	public String main() {
		return "system/resource/index";
	}

	@RequestMapping("/list")
	public ModelAndView list(Role role){
		List<TreeInfo> roles=resourceService.treeList(null);
		return new ModelAndView(RESULT).addObject(RESULT, "");
	}
	
	
}
