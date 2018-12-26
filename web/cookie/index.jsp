<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    boolean flag = false;
    if (name != null && !name.trim().equals("")){
    	Cookie cookie = new Cookie("name",name);
    	cookie.setMaxAge(30);
    	response.addCookie(cookie);
    	flag = true;
    } else {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies) {
                if ("name".equals(cookie.getName())){
                    name = cookie.getValue();
                    flag = true;
                    break;
                }
            }
        }
    }
    if (flag){
        out.println("hello : " + name);
    } else {
        response.sendRedirect("login.jsp");
    }
%>
</body>
</html>
