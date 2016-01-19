package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import plug.SessionInfo;
import util.ConfigUtil;

/**
 * online user monitor
 * 
 */
public class OnlineListener implements ServletContextListener, ServletContextAttributeListener, 
	HttpSessionListener, HttpSessionAttributeListener, HttpSessionActivationListener, 
	HttpSessionBindingListener, ServletRequestListener, ServletRequestAttributeListener {

	
	private static final Logger logger = Logger.getLogger(OnlineListener.class);

	private static ApplicationContext ctx = null;

	public OnlineListener() {}
	
	@Override
	public void attributeAdded(ServletRequestAttributeEvent evt) {
		// TODO Auto-generated method stub
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent evt) {
		String name = evt.getName();
		logger.debug("The name of attribute saved in session: " + name);
		System.out.println(name);
		if (ConfigUtil.getSessionInfoName().equals(name)) {
			HttpSession session = evt.getSession();
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(name);
			if (sessionInfo != null) {
				//OnlineServiceI onlineService = (OnlineServiceI) ctx.getBean("onlineService");
				//onlineService.saveOrUpdateTonlineByLoginNameAndIp(sessionInfo.getLoginName(), sessionInfo.getIp());
			}
		}else{
			
		}
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ϵͳ���ʱ�ص�
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.debug("server closed");
		System.out.println("系统关闭");
	}

	/**
	 * ϵͳ����ʱ�ص�
	 */
	@Override
	public void contextInitialized(ServletContextEvent evt) {
		logger.debug("server started");
		ctx = WebApplicationContextUtils.getWebApplicationContext(evt.getServletContext());
		System.out.println("系统启动:"+ctx);
	}

	
	

}
