<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<div>
    <body>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>desc</th>
            <th>cost</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>>${product.name}</td>
                <td>>${product.description}</td>
                <td>>${product.cost}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </body>
</div>
</html>