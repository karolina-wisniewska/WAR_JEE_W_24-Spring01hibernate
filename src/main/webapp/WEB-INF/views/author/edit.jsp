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
    <title>Edit author</title>
</head>
<body>
<style>
    .error {
        color: red;
    }
</style>
<h3>Edycja autora</h3>
<form:form method="post" modelAttribute="author">
    <div><form:hidden path="id" value="${author.id}"/></div>
    <div>Imię: <form:input path="firstName"/><form:errors path="firstName" cssClass="error"/></div>
    <div>Nazwisko: <form:input path="lastName"/><form:errors path="lastName" cssClass="error"/></div>
    <div>PESEL: <form:input path="pesel"/><form:errors path="pesel" cssClass="error"/></div>
    <div>Email: <form:input type="email" path="email"/><form:errors path="email" cssClass="error"/></div>
    <input type="submit" value="Zapisz">
</form:form>
</body>
</html>
