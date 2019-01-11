package xin.yangshuai.javaweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

/**
 * I18nServlet
 *
 * @author shuai
 * @date 2019/1/11
 */
public class I18nServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Locale locale = request.getLocale();
		System.out.println(locale);
		locale = Locale.CHINA;
		System.out.println(locale);
		locale = new Locale("EN", "US");
		System.out.println(locale);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
