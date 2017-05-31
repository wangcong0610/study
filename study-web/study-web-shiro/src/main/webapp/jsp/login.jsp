<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>login page</title>
</head>
<body>
<h1>登录页面-----${message}</h1>
<h1>$errMessage EL表达式获取的是SpringMVC Model的值-----${errMessage}</h1>
<h1>$redirectModelMessage-----${errMessage}</h1>
<h1>request.getParameter获取的是URL上面的值-----<%= request.getParameter("errMessage")%></h1>
<h1>request.getAttribute获取的是SpringMVC Model 的值-----<%= request.getAttribute("errMessage")%></h1>
<form:form action="/web/login" commandName="user" method="post">
    用户名：<form:input path="userName"/><form:errors path="userName" cssClass="error"/><br/>
    密&nbsp;码： <form:input path="pwd"/><form:errors path="pwd" cssClass="error"/><br/>
    <form:button name="button">submit</form:button>
</form:form>
</body>
</html>
