package xin.yangshuai.javaweb.servlet;

import com.google.code.kaptcha.servlet.KaptchaServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * MyCaptchaServlet
 *
 * @author shuai
 * @date 2019/1/3
 */
public class MyCaptchaServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Object my_session_key = request.getSession().getAttribute("MY_SESSION_KEY");
		PrintWriter writer = response.getWriter();
		writer.println("MY_SESSION_KEY = " + my_session_key);
	}
}
