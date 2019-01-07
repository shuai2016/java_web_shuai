<%--
  Created by IntelliJ IDEA.
  User: shuai
  Date: 2019/1/7
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%= session.getId() %>
<br>
session_hello : ${sessionScope.session_hello}
<br>
request_hello : ${requestScope.request_hello}
</body>
</html>
