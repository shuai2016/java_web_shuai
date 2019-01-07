package xin.yangshuai.javaweb.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * HelloFilter
 *
 * @author shuai
 * @date 2019/1/7
 */
public class HelloFilter extends MyHttpFilter {
	@Override
	protected void init() {
		System.out.println("HelloFilter's init...");
		Enumeration<String> initParameterNames = getFilterConfig().getInitParameterNames();
		while (initParameterNames.hasMoreElements()) {
			String s = initParameterNames.nextElement();
			String initParameter = getFilterConfig().getInitParameter(s);
			System.out.println(s + " : " + initParameter);
		}
	}

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("HelloFilter's doFilter...");
		//放行
		chain.doFilter(request, response);
	}
}
