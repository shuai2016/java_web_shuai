package xin.yangshuai.javaweb.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * HelloServlet
 *
 * @author shuai
 * @date 2018/12/18
 */
public class HelloServlet implements Servlet {

	public HelloServlet() {
		System.out.println("HelloServlet's constructor");
	}

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		System.out.println("HelloServlet's init");

		Enumeration<String> names = servletConfig.getInitParameterNames();
		while (names.hasMoreElements()){
			String name = names.nextElement();
			String value = servletConfig.getInitParameter(name);
			System.out.println(name + " : " + value);
		}

		String servletName = servletConfig.getServletName();
		System.out.println(servletName);
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("HelloServlet's getServletConfig");
		return null;
	}

	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
		System.out.println("HelloServlet's service");
	}

	@Override
	public String getServletInfo() {
		System.out.println("HelloServlet's getServletInfo");
		return null;
	}

	@Override
	public void destroy() {
		System.out.println("HelloServlet's destroy");
	}
}
