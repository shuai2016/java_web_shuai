package xin.yangshuai.javaweb.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * HelloServletContextListner
 *
 * @author shuai
 * @date 2019/1/8
 */
public class HelloServletContextListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.out.println("ServletContext 对象被创建。" + servletContextEvent.getServletContext());
	}
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.out.println("ServletContext 对象被销毁。" + servletContextEvent.getServletContext());
	}
}
