package xin.yangshuai.javaweb.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * MyHttpServletRequest
 *
 * @author shuai
 * @date 2019/1/8
 */
public class MyHttpServletRequest extends HttpServletRequestWrapper {
	public MyHttpServletRequest(HttpServletRequest request) {
		super(request);
	}
	@Override
	public String getParameter(String name) {
		String parameter = super.getParameter(name);
		return parameter + "Hello World !";
	}
}
