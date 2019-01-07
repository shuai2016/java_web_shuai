package xin.yangshuai.javaweb.servlet;

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
        HttpSession session = request.getSession(false);
        PrintWriter writer = response.getWriter();
        writer.println("SecondServlet's doGet");
        writer.println("session : " + session);

        request.setAttribute("request_hello","hello123");
        request.getSession().setAttribute("session_hello","hello456");

        request.getRequestDispatcher("/test.jsp").include(request,response);


    }
}
