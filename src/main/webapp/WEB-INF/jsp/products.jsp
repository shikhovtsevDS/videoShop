<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <jsp:include page="fragments/headTag.jsp"/>
</head>
<body>
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
    <header class="masthead mb-auto">
        <div class="inner">
            <h3 class="masthead-brand">Video store</h3>
            <nav class="nav nav-masthead justify-content-center">
                <a class="nav-link" href="/">Home</a>
                <a class="nav-link" href="login">Log in</a>
            </nav>
        </div>
    </header>
    <div class="jumbotron">
        <div class="container">
            <label class="sr-only">Search </label>
            <select class="custom-select d-block w-100" required>
                <option value="">Choose...</option>
                <c:forEach var="category" items="${categories}">
                    <option value="${category.name}">${category.name}</option>
                </c:forEach>
            </select>
            <table class="table table-striped display">
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
                        <td>
                            <a class="nav-link active" href="products/${product.id}"
                               aria-disabled="true">${product.name}</a>
                        </td>
                        <td>${product.description}</td>
                        <td>${product.cost}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>