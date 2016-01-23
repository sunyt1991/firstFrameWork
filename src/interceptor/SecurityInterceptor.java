package interceptor;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import plug.SessionInfo;
import util.ConfigUtil;

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
		if (url.indexOf("/front/") > -1 || excludeUrls.contains(url)) {//不进行拦截
			return true;
		}
		SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(ConfigUtil.getSessionInfoName());
		if (sessionInfo == null || sessionInfo.getLoginName().equalsIgnoreCase("")) {
			System.out.println("连接超时");
			response.getWriter().write(getJumpJsCode(request.getContextPath()));
			return false;
		}
		return true;
	}
	
	private String getJumpJsCode(String contextPath) {
		StringBuffer sb = new StringBuffer("<script type='text/javascript' charset='utf-8'>");
		sb.append("alert('系统超时，您需要重新登录');");
		sb.append("window.top.location.href='"+contextPath+"';");
		sb.append("</script>");
		return sb.toString();
	}
	
}
