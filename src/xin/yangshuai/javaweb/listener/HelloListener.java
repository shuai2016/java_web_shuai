package xin.yangshuai.javaweb.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * HelloListener
 *
 * @author shuai
 * @date 2019/1/8
 */
public class HelloListener implements ServletContextListener, ServletRequestListener, HttpSessionListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("创建ServletContext：" + servletContextEvent.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("销毁ServletContext：" + servletContextEvent.getServletContext());
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("创建ServletRequest：" + servletRequestEvent.getServletRequest());

    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("销毁ServletRequest：" + servletRequestEvent.getServletRequest());
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("创建HttpSession：" + httpSessionEvent.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("销毁HttpSession：" + httpSessionEvent.getSession());
    }
}
