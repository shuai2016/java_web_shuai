package xin.yangshuai.javaweb.servlet;

import xin.yangshuai.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ThirdServlet
 *
 * @author shuai
 * @date 2019/1/9
 */
public class ThirdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = (Customer) request.getSession().getAttribute("thirdSession");
        if (customer == null) {
            System.out.println("创建一个新的Customer对象，并放到 session 中");
            request.getSession().setAttribute("thirdSession", new Customer("王五", 18));
        } else {
            System.out.println("从 session 中读取到Customer 对象：" + customer);
        }

        request.getSession().setMaxInactiveInterval(10);
    }
}
