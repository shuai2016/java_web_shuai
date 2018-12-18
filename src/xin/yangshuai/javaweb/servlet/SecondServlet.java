package xin.yangshuai.javaweb.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * SecondServlet
 *
 * @author shuai
 * @date 2018/12/18
 */
public class SecondServlet implements Servlet {
	public SecondServlet() {
		System.out.println("SecondServlet's constructor");
	}

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		System.out.println("SecondServlet's init");
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("SecondServlet's getServletConfig");
		return null;
	}

	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
		System.out.println("SecondServlet's service");
	}

	@Override
	public String getServletInfo() {
		System.out.println("SecondServlet's getServletInfo");
		return null;
	}

	@Override
	public void destroy() {
		System.out.println("SecondServlet's destroy");
	}
}
