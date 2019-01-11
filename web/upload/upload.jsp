<%--
  Created by IntelliJ IDEA.
  User: shuai
  Date: 2019/1/10
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="<%= application.getContextPath() %>/upload" method="post" enctype="multipart/form-data">
    File : <input type="file" name="file">
    <br>
    Desc : <input type="text" name="desc">
    <br>
    Playing<input type="checkbox" name="interesting" value="playing">
    <br>
    Shopping<input type="checkbox" name="interesting" value="shopping">
    <br>
    TV<input type="checkbox" name="interesting" value="TV">
    <br>
    <input type="submit" value="提交">
</form>

</body>
</html>
