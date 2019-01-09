package xin.yangshuai.javaweb.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * HelloAttributeListener
 *
 * @author shuai
 * @date 2019/1/9
 */
public class HelloAttributeListener implements ServletContextAttributeListener,HttpSessionAttributeListener,ServletRequestAttributeListener {
	@Override
	public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
		System.out.println("---------------------------------------------------");
		System.out.println("context属性添加：");
		System.out.println(servletContextAttributeEvent.getName());
		System.out.println(servletContextAttributeEvent.getValue());
		System.out.println("---------------------------------------------------");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
		System.out.println("---------------------------------------------------");
		System.out.println("context属性移除：");
		System.out.println(servletContextAttributeEvent.getName());
		System.out.println(servletContextAttributeEvent.getValue());
		System.out.println("---------------------------------------------------");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
		System.out.println("---------------------------------------------------");
		System.out.println("context属性替换：");
		System.out.println(servletContextAttributeEvent.getName());
		System.out.println(servletContextAttributeEvent.getValue());
		System.out.println("---------------------------------------------------");
	}

	@Override
	public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
		System.out.println("---------------------------------------------------");
		System.out.println("request属性添加：");
		System.out.println(servletRequestAttributeEvent.getName());
		System.out.println(servletRequestAttributeEvent.getValue());
		System.out.println("---------------------------------------------------");
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
		System.out.println("---------------------------------------------------");
		System.out.println("request属性移除：");
		System.out.println(servletRequestAttributeEvent.getName());
		System.out.println(servletRequestAttributeEvent.getValue());
		System.out.println("---------------------------------------------------");
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
		System.out.println("---------------------------------------------------");
		System.out.println("request属性替换：");
		System.out.println(servletRequestAttributeEvent.getName());
		System.out.println(servletRequestAttributeEvent.getValue());
		System.out.println("---------------------------------------------------");
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
		System.out.println("---------------------------------------------------");
		System.out.println("session属性添加：");
		System.out.println(httpSessionBindingEvent.getName());
		System.out.println(httpSessionBindingEvent.getValue());
		System.out.println(httpSessionBindingEvent.getSession().getId());
		System.out.println("---------------------------------------------------");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
		System.out.println("---------------------------------------------------");
		System.out.println("session属性移除：");
		System.out.println(httpSessionBindingEvent.getName());
		System.out.println(httpSessionBindingEvent.getValue());
		System.out.println(httpSessionBindingEvent.getSession().getId());
		System.out.println("---------------------------------------------------");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
		System.out.println("---------------------------------------------------");
		System.out.println("session属性替换：");
		System.out.println(httpSessionBindingEvent.getName());
		System.out.println(httpSessionBindingEvent.getValue());
		System.out.println(httpSessionBindingEvent.getSession().getId());
		System.out.println("---------------------------------------------------");
	}
}
