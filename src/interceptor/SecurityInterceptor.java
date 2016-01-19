package interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import plug.SessionInfo;
import util.ConfigUtil;

/**
 * 
 * @author Administrator
 *
 */
public class SecurityInterceptor implements HandlerInterceptor{

	private static final Logger logger = Logger.getLogger(SecurityInterceptor.class);

	private List<String> excludeUrls;

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) throws Exception {
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
		System.out.println(">>interceptor:"+url);
		if (url.indexOf("/baseController/") > -1 || excludeUrls.contains(url)) {// url does not need to validate
			return true;
		}
		SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(ConfigUtil.getSessionInfoName());
		if (sessionInfo == null || sessionInfo.getLoginName().equalsIgnoreCase("")) {// not logged in
			//System.out.println("not logged in");
			request.getRequestDispatcher("/error/404.jsp").forward(request, response);
			return false;
		}
//		if (!sessionInfo.getAuthUrls().contains(url)) {// has no authority
//			//System.out.println("has no authority");
//			request.getRequestDispatcher("/error/404.jsp").forward(request, response);
//			return false;
//		}
		return true;
	}

	
}
