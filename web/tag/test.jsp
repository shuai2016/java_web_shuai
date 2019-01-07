<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: shuai
  Date: 2019/1/4
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="shuai" uri="http://www.yangshuai.xin/mytag/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("hello","Hello World !");
    List list = new ArrayList();
    list.add("q");
    list.add("w");
    list.add("e");
    request.setAttribute("list",list);

    Map map = new HashMap();
    map.put("0",list.get(0));
    map.put("1",list.get(1));
    map.put("2",list.get(2));
    request.setAttribute("map",map);

%>
  <span style="color: red">${hello}</span>
  <c:forEach items="${list}" var="temp">
      <span style="color: blue">${temp}</span>
  </c:forEach>
  <br>
  <shuai:foreach items="${list}" var="temp">
      <span style="color: darkblue">${temp}</span>
  </shuai:foreach>
  <br>
  <shuai:foreach items="${map}" var="temp">
    <span style="color: darkmagenta">${temp.key}</span> --> <span style="color: hotpink">${temp.value}</span>
  </shuai:foreach>
  <br>
  <font color="#0b70c9">2018年12月22日 11:37:02</font>
</body>
</html>
