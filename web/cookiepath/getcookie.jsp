<%--
  Created by IntelliJ IDEA.
  User: shuai
  Date: 2018/12/28
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String cookiepath = null;
    Cookie[] cookies = request.getCookies();
    if(cookies != null && cookies.length > 0){
        for (Cookie cookie : cookies) {
            if("cookiepath".equals(cookie.getName())){
            	cookiepath = cookie.getValue();
            }
        }
    }
    if(cookiepath == null){
    	out.print("没有cookiepath");
    } else {
    	out.print("cookiepath = " + cookiepath);
    }
%>
</body>
</html>
