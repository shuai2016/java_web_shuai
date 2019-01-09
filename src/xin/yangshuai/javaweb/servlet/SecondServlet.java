package xin.yangshuai.javaweb.servlet;

import xin.yangshuai.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * SecondServlet
 *
 * @author shuai
 * @date 2018/12/18
 */
public class SecondServlet extends MyHttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        System.out.println("测试属性************start*******************************");

        System.out.println("测试属性************添加属性start*******************************");
        getServletContext().setAttribute("contextHello",new Customer("张三",24));
        request.getSession().setAttribute("sessionHello",new Customer("张三",24));
        request.setAttribute("requestHello",new Customer("张三",24));
        System.out.println("测试属性************添加属性end*********************************");
        System.out.println("测试属性************替换属性start*******************************");
        getServletContext().setAttribute("contextHello",new Customer("李四",20));
        request.getSession().setAttribute("sessionHello",new Customer("李四",20));
        request.setAttribute("requestHello",new Customer("李四",20));
        System.out.println("测试属性************替换属性end*********************************");
        System.out.println("测试属性************移除属性start*******************************");
        getServletContext().removeAttribute("contextHello");
        request.getSession().removeAttribute("sessionHello");
        request.removeAttribute("requestHello");
        System.out.println("测试属性************移除属性end*********************************");

        System.out.println("测试属性************end*********************************");

        HttpSession session = request.getSession(false);
        PrintWriter writer = response.getWriter();
        writer.println("SecondServlet's doGet");
        writer.println("session : " + session);

        request.setAttribute("request_hello","hello123");
        request.getSession().setAttribute("session_hello","hello456");

        request.getRequestDispatcher("/test.jsp").include(request,response);


    }
}
