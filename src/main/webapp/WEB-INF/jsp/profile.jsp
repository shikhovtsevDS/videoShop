<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<%--<jsp:include page="fragments/bodyHeader.jsp"/>--%>

<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
    <header class="masthead mb-auto">
        <div class="inner">
            <h3 class="masthead-brand">Video store</h3>
            <nav class="nav nav-masthead justify-content-center">
                <a class="nav-link" href="/">Home</a>
                <a class="nav-link active" href="products" aria-disabled="true">Products</a>
                <a class="nav-link" href="login">Log in</a>
            </nav>
        </div>
    </header>
    <table class="table table-striped display">
        <thead>
        <tr>
            <th>first</th>
            <th>middle</th>
            <th>last</th>
            <th>email</th>
            <th>password</th>
        </tr>
        </thead>
        <tbody>
        <%--@elvariable id="userTo" type="ru.shikhovtsev.videoShop.to.UserTo"--%>
        <tr>
            <td>${userTo.firstName}</td>
            <td>${userTo.middleName}</td>
            <td>${userTo.lastName}</td>
            <td>${userTo.email}</td>
            <td>${userTo.password}</td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>