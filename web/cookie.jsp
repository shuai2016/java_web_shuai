<%--
  Created by IntelliJ IDEA.
  User: shuai
  Date: 2018/12/25
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  Cookie[] cookies = request.getCookies();
  for (Cookie cookie1 : cookies) {
    System.out.println(cookie1.getName() + " : " + cookie1.getValue());
  }
%>

</body>
</html>
