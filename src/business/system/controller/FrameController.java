package business.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/frame")
public class FrameController {
	
	
	@RequestMapping("/main")
	public String main() {
		return "/frame/main";
	}
	
	@RequestMapping("/homepage")
	public String homepage() {
		return "/frame/homepage";
	}
	
}
