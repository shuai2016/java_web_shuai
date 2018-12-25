package xin.yangshuai.javaweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * CookieServlet
 *
 * @author shuai
 * @date 2018/12/25
 */
public class CookieServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req,resp);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Cookie cookie = new Cookie("name","cookie001");
//		response.addCookie(cookie);
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie1 : cookies) {
			System.out.println(cookie1.getName() + " : " + cookie1.getValue());
		}
	}
}
