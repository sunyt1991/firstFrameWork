package util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


public class RequestUtil {

	/**
	 * 获取request请求路径
	 * @param request
	 * @return
	 */
	public static String getRequestPath(HttpServletRequest request) {
		String requestPath = request.getRequestURI();
		requestPath = requestPath.substring(request.getContextPath().length());// remove path of project
		return requestPath;
	}
	
	/**
	 * 封装request参数到map中
	 * @param request
	 * @return
	 */
	public static Map<String,String> getRequestPara(HttpServletRequest request){
		Map<String,String> map = new HashMap<String,String>();  
		Enumeration<String> paramNames = request.getParameterNames();  
	    while (paramNames.hasMoreElements()) {  
	    	String paramName = (String) paramNames.nextElement();  
	    	String[] paramValues = request.getParameterValues(paramName);  
	    	if (paramValues.length == 1) {  
	    		String paramValue = paramValues[0];  
	    		if (paramValue.length() != 0) {  
	    			System.out.println("参数：" + paramName + "=" + paramValue);  
	    			map.put(paramName, paramValue);  
	    		}  
	    	}  
	    }
	    return map;
	}

}
