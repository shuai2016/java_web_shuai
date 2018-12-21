package xin.yangshuai.javaweb.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ForwardServlet
 *
 * @author shuai
 * @date 2018/12/21
 */
public class ForwardServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ForwardServlet's doGet");
		/**
		 * 请求转发
		 * 1. 调用 HttpServletRequest 的 getRequestDispatcher 方法获取 RequestDispatcher 对象
		 * 2. 调用 RequestDispatcher 的 forward(request,response) 方法进行请求的转发
		 */
		RequestDispatcher dispatcher = request.getRequestDispatcher("/second");
		dispatcher.forward(request,response);
	}
}
