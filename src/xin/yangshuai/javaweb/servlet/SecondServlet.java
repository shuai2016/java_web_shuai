package xin.yangshuai.javaweb.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SecondServlet
 *
 * @author shuai
 * @date 2018/12/18
 */
public class SecondServlet extends MyHttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("SecondServlet's doGet");
    }
}
