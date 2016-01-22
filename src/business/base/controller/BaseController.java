package business.base.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import plug.SessionInfo;
import util.ConfigUtil;
import util.JacksonUtil;
import util.StringEscapeEditor;

@Controller
@RequestMapping("/baseController")
public class BaseController {

	protected JacksonUtil jsonUtil = new JacksonUtil("yyyy-MM-dd HH:mm:ss");
	
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
		binder.registerCustomEditor(String.class, new StringEscapeEditor(true, false));
	}

	@RequestMapping("/{folder}/{jspName}")
	public String redirectJsp(@PathVariable String folder, @PathVariable String jspName) {
		return "/" + folder + "/" + jspName;
	}
	
	public SessionInfo getSession(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest(); 
		SessionInfo sessionInfo=(SessionInfo)request.getSession().getAttribute(ConfigUtil.getSessionInfoName());
		return sessionInfo;
	} 
	
}
