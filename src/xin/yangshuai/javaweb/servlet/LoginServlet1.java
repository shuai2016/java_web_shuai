package xin.yangshuai.javaweb.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * LoginServlet1
 *
 * @author shuai
 * @date 2018/12/20
 */
public class LoginServlet1 extends MyHttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql:///test";
            String user = "root";
            String password2 = "root";
            connection = DriverManager.getConnection(url, user, password2);
            String sql = "SELECT count(id) FROM users WHERE username = ? AND password = ? ";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);

                if (count > 0) {
                    out.print("Hello: " + username);
                } else {
                    out.print("Sorry: " + username);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
