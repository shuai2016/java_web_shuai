<%--
  Created by IntelliJ IDEA.
  User: shuai
  Date: 2019/1/3
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/myCaptcha">
    <input type="text" name="code"><img src="<%=request.getContextPath() %>/images/captcha.jpg"/>
    <br>
    <input type="submit" value="submit">
</form>
</body>
</html>
