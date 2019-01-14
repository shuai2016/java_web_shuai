<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shuai
  Date: 2019/1/14
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>国际化</title>
</head>
<body>
<c:if test="${sessionScope.locale != null}">
  <fmt:setLocale value="${sessionScope.locale}"/>
</c:if>
<fmt:setBundle basename="i18n"/>
<fmt:message key="date"/> : <fmt:formatDate value="${date1}" dateStyle="FULL"/> ,
<fmt:message key="salary"/> : <fmt:formatNumber value="${salary1}" type="currency"/>
<br>
<a href="<%=request.getContextPath()%>/i18n?locale=zh_CN">中文</a>
<a href="<%=request.getContextPath()%>/i18n?locale=en_US">英文</a>
</body>
</html>
