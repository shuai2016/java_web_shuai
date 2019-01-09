package xin.yangshuai.javaweb.servlet;

import xin.yangshuai.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ThirdServlet
 *
 * @author shuai
 * @date 2019/1/9
 */
public class ThirdServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("thirdSession",new Customer("王五",18));
	}
}
