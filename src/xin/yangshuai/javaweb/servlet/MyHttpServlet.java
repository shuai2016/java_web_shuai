package xin.yangshuai.javaweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * MyHttpServlet
 *
 * @author shuai
 * @date 2018/12/20
 */
public class MyHttpServlet extends MyGenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest httpServletRequest;
        HttpServletResponse httpServletResponse;
        try {
            httpServletRequest = (HttpServletRequest) servletRequest;
            httpServletResponse = (HttpServletResponse) servletResponse;
        } catch (ClassCastException e) {
            throw new ServletException("non-HTTP request or response");
        }
        service(httpServletRequest,httpServletResponse);
    }

    public void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        //1. 获取请求方式
        String method = httpServletRequest.getMethod();

        //2. 根据请求方式再调用对应的处理方法
        if("GET".equalsIgnoreCase(method)) {
            doGet(httpServletRequest,httpServletResponse);
        } else if("POST".equalsIgnoreCase(method)){
            doPost(httpServletRequest,httpServletResponse);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

}
