package xin.yangshuai.javaweb.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * SecondFilter
 *
 * @author shuai
 * @date 2019/1/7
 */
public class SecondFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("SecondFilter's init...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("SecondFilter's doFilter...");

		//放行
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("SecondFilter's destroy...");
	}
}
