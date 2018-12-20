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
    public void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        this.doPost(request, response);
    }
}
