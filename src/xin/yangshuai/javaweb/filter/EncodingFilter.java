package xin.yangshuai.javaweb.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * EncodingFilter
 *
 * @author shuai
 * @date 2019/1/7
 */
public class EncodingFilter extends MyHttpFilter {

	private String encoding;

	@Override
	protected void init() {
		this.encoding = getFilterConfig().getServletContext().getInitParameter("encoding");
	}

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("编码 ：" + encoding);
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}
}
