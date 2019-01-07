package xin.yangshuai.javaweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * RedirectServlet
 *
 * @author shuai
 * @date 2018/12/21
 */
public class RedirectServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RedirectServlet's doGet");

		request.setAttribute("request_hello","hello123");
		request.getSession().setAttribute("session_hello","hello456");

		/**
		 * 请求重定向
		 * 直接调用 response 的 sendRedirect 方法
		 */
		response.sendRedirect(request.getContextPath()+"/test.jsp");
	}
}
