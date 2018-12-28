<%--
  Created by IntelliJ IDEA.
  User: shuai
  Date: 2018/12/28
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Cookie cookie = new Cookie("cookiepath","cookiepathvalue");
    cookie.setPath(request.getContextPath());
    response.addCookie(cookie);
%>
</body>
</html>
