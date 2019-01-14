package xin.yangshuai.javaweb.servlet;

import org.apache.tomcat.util.codec.binary.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

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
		String locale1 = request.getParameter("locale");
		if (locale1 != null && !"".equals(locale1)){
			String[] split = locale1.split("_");
			locale = new Locale(split[0],split[1]);
		}
		request.getSession().setAttribute("locale",locale);
		ResourceBundle i18n = ResourceBundle.getBundle("i18n", locale);
		String dateLable = i18n.getString("date");
		String salLable = i18n.getString("salary");
		request.setAttribute("dateLable",dateLable);
		request.setAttribute("salLable",salLable);
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
		String date = dateFormat.format(new Date());
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
		String salary = numberFormat.format(12345.67);
		request.setAttribute("date",date);
		request.setAttribute("salary",salary);
		request.setAttribute("date1",new Date());
		request.setAttribute("salary1",12345.67);
		request.getRequestDispatcher("/i18n/index.jsp").forward(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
