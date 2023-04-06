<%--
  Created by IntelliJ IDEA.
  User: karolina
  Date: 19.03.2023
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add author</title>
</head>
<body>
<h3>Add author</h3>
<style>
    .error {
        color:red;
    }
</style>
<form:form method="post" modelAttribute="author">
    <div>Name: <form:input path="firstName"/><form:errors path="firstName" cssClass="error"/></div>
    <div>Surname: <form:input path="lastName"/><form:errors path="lastName" cssClass="error"/></div>
    <div>PESEL: <form:input path="pesel"/><form:errors path="pesel" cssClass="error"/></div>
    <div>Email: <form:input path="email"/><form:errors path="email" cssClass="error"/></div>
    <input type="submit" value="Zapisz">
</form:form>


</body>
</html>
