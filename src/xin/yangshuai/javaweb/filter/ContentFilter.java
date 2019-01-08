package xin.yangshuai.javaweb.filter;

import xin.yangshuai.javaweb.request.MyHttpServletRequest;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ContentFilter
 *
 * @author shuai
 * @date 2019/1/8
 */
public class ContentFilter extends MyHttpFilter {
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		String content = request.getParameter("content");
		System.out.println("内容为：" + content);
		System.out.println(request);

		//目标：改变HttpServletRequest 的 getParameter(String) 方法的行为
		//1. 对于一个类的方法不满意，需要进行重写，最常见的方法是，继承父类，重写方法
		//若实现则需要继承 org.apache.catalina.connector.RequestFacade，
		// 而这只是Tomcat服务器的实现，若更换服务器，该方案无法使用。 X

		//2.直接写个HttpServletRequest 接口的实现类：无法实现其中方法。 X

		//3.装饰目前的HttpServletRequest 对象：装饰其 getParameter 方法，而其他方法还和其实现相同
		//创建一个类，该类实现HttpServletRequest 接口，把当前 doFilter 中的request 传入到该类中，作为其成员变量，使用该成员变量去实现接口的全部方法。
		// HttpServletRequestWrapper

		HttpServletRequest servletRequest = new MyHttpServletRequest(request);

		chain.doFilter(servletRequest,response);
	}
}
