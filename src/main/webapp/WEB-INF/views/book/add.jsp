<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add book</title>
</head>
<body>

<h3>Add book</h3>
<style>
    .error {
        color:red;
    }
</style>

<form:form method="post" modelAttribute="book">

    <div>Title: <form:input path="title"/><form:errors path="title" cssClass="error"/></div>
    <div>Description: <form:input path="description"/><form:errors path="description" cssClass="error"/></div>
    <div>Rating: <form:input path="rating" type="number" min="1" max="10" value="1"/><form:errors path="rating" cssClass="error"/></div>
    <div>Publisher: <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id"/><form:errors
            path="publisher" cssClass="error"/></div>
    <div>Authors: <form:select path="authors" items="${authors}" itemLabel="fullName" itemValue="id"
                               multiple="true"/><form:errors path="authors" cssClass="error"/></div>
    <div>Pages: <form:input path="pages" type="number" min="1" value="" placeholder="Podaj coś"/><form:errors path="pages" cssClass="error"/></div>
    <div>Category: <form:select path="category.id" items="${categories}" itemLabel="name" itemValue="id"/><form:errors
            path="category" cssClass="error"/></div>
    <input type="submit" value="Add book">
</form:form>

</body>
</html>
