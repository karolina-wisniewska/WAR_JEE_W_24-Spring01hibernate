<%--
  Created by IntelliJ IDEA.
  User: karolina
  Date: 19.03.2023
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>All authors</title>
</head>
<body>
<h3>Lista autorów</h3>
<table>
    <c:if test="${not empty authors}">
        <tr>
            <th>Id</th>
            <th>Imię</th>
            <th>Nazwisko</th>
            <th>PESEL</th>
            <th>Email</th>
            <th>Akcje</th>
        </tr>
    </c:if>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.id}</td>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td>${author.pesel}</td>
            <td>${author.email}</td>
            <td><a href="/author/edit?id=${author.id}">Edytuj</a> <a href="/author/delete/${author.id}">Usuń</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
