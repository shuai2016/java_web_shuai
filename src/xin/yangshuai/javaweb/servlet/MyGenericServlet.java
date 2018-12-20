package xin.yangshuai.javaweb.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * MyGenericServlet
 *
 * @author shuai
 * @date 2018/12/20
 */
public abstract class MyGenericServlet implements Servlet,ServletConfig{

	private ServletConfig servletConfig;


	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		this.servletConfig = servletConfig;
	}

	@Override
	public ServletConfig getServletConfig() {
		return servletConfig;
	}

	@Override
	public abstract void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException ;

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {

	}

	/** 以下方法为ServletConfig接口的方法 **/

	@Override
	public String getServletName() {
		return servletConfig.getServletName();
	}

	@Override
	public ServletContext getServletContext() {
		return servletConfig.getServletContext();
	}

	@Override
	public String getInitParameter(String s) {
		return servletConfig.getInitParameter(s);
	}

	@Override
	public Enumeration<String> getInitParameterNames() {
		return servletConfig.getInitParameterNames();
	}
}
