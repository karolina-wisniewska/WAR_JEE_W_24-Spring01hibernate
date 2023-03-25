<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All errors</title>
</head>
<body>

<table>
    <tr>
        <th>Nazwa pola</th>
        <th>Nazwa błędu</th>
    </tr>
    <c:forEach items="${errors}" var="error">
        <tr>
            <td>${error.propertyPath}</td>
            <td>${error.message}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
