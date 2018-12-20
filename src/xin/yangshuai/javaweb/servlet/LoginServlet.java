package xin.yangshuai.javaweb.servlet;

import javafx.css.PseudoClass;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * LoginServlet
 *
 * @author shuai
 * @date 2018/12/20
 */
public class LoginServlet extends MyGenericServlet {

	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
		System.out.println("LoginServlet's service");
		String username = servletRequest.getParameter("username");
		System.out.println("username : " + username);
		String password = servletRequest.getParameter("password");
		System.out.println("password : " + password);
		String interesting = servletRequest.getParameter("interesting");
		System.out.println("interesting : " + interesting);
		String[] interestings = servletRequest.getParameterValues("interesting");
		for (String s : interestings) {
			System.out.println(s);
		}
		Enumeration<String> parameterNames = servletRequest.getParameterNames();
		while(parameterNames.hasMoreElements()){
			System.out.println(parameterNames.nextElement());
		}
		Map<String, String[]> parameterMap = servletRequest.getParameterMap();
		Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
		for (Map.Entry<String, String[]> entry : entries) {
			System.out.println(entry.getKey() + " : " + Arrays.asList(entry.getValue()));
		}

		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		//获取请求的URI
		String requestURI = httpServletRequest.getRequestURI();
		System.out.println(requestURI);
		//获取请求方法
		String method = httpServletRequest.getMethod();
		System.out.println(method);
		//若是一个GET请求，获取请求参数对应的那个字符串，即 ? 后的那个字符串。
		String queryString = httpServletRequest.getQueryString();
		System.out.println(queryString);
		//获取请求的Servlet的映射路径
		String servletPath = httpServletRequest.getServletPath();
		System.out.println(servletPath);

		servletResponse.setContentType("application/msword");
		PrintWriter writer = servletResponse.getWriter();
		writer.print("Hello World !");

		HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
	}

}
