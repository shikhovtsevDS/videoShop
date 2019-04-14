<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<body>
<table class="table table-striped display">
    <thead>
    <tr>
        <th>first</th>
        <th>middle</th>
        <th>last</th>
        <th>email</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.firstName}</td>
            <td>${user.middleName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>