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
	    //1. 创建一个Cookie对象
        Cookie cookie = new Cookie("name","cookie001");
        //2. setMaxAge：单位：秒，值为0，表示立即删除；值为负数，表示不储存该Cookie；值为正数，表示该Cookie的存储时间
        cookie.setMaxAge(30);
        //3. 设置Cookie 的作用范围
        cookie.setPath(request.getContextPath());
        //4. 调用response的一个方法把Cookie传给客户端
        response.addCookie(cookie);
        //5. 从浏览器读取Cookie
        Cookie[] cookies = request.getCookies();
    }
}
