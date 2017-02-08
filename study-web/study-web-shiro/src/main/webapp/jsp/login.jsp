<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>login page</title>
</head>
<body>
<h1>登录页面-----${message}</h1>
<form:form action="/web/login" commandName="user" method="post">
    用户名：<form:input path="userName"/><form:errors path="userName" cssClass="error"/><br/>
    密&nbsp;码： <form:input path="pwd"/><form:errors path="pwd" cssClass="error"/><br/>
    <form:button name="button">submit</form:button>
</form:form>
</body>
</html>
