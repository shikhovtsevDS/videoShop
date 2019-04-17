<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <jsp:include page="fragments/headTag.jsp"/>
    <link rel="stylesheet" href="resources/css/header.css">
</head>
<body class="text-center" style="height: max-content;">
<div class="w-100 h-100">
    <header>
        <div class="overlay"></div>
        <video playsinline="playsinline" autoplay="autoplay" muted="muted" loop="loop">
            <source src="https://storage.googleapis.com/coverr-main/mp4/Mt_Baker.mp4" type="video/mp4">
        </video>
        <div class="container h-100">
            <div class="d-flex h-100 text-center align-items-center">
                <div class="w-100 text-white">
                    <h1 class="display-3">Video store</h1>
                </div>
            </div>
        </div>
    </header>
    <sec:authorize access="isAuthenticated()">
        <jsp:include page="fragments/bodyHeader.jsp"/>
    </sec:authorize>

    <section class="my-5">
        <div class="container">
            <div class="row">
                <div class="col-md-8 mx-auto">
                    <p class="lead mb-0">Video store offers you a large selection of products to order. To make a purchase
                        requires authorization in the system.</p>
                    <br>
                    <sec:authorize access="!isAuthenticated()">
                        <p class="lead mb-0">
                        <div class="w3-bar">
                            <a href="login" class="btn btn-lg btn-secondary">Sign in</a>
                            <a href="register" class="btn btn-lg btn-secondary">Register</a>
                        </div>
                        </p>
                    </sec:authorize>
                </div>
            </div>
        </div><br><br>
        <div class="container">
            <label class="sr-only">Search </label>
            <select onchange="this.options[this.selectedIndex].value && (window.location = this.options[this.selectedIndex].value);" class="custom-select d-block w-100" required>
                <option value="/">Choose...</option>
                <c:forEach var="category" items="${categories}">
                    <option value="/category/${category.id}" ${catId == category.id ? "selected=\"selected\"" : ""}>${category.description}</option>
                </c:forEach>
            </select>
            <br>
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
                            <strong>
                                <a class="nav-link active" style="color: black" href="products/${product.id}"
                                   aria-disabled="true">${product.name}</a>
                            </strong>
                        </td>
                        <td>${product.description}</td>
                        <td>${product.cost}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </section>
    <hr>

    <footer class="mastfoot mt-auto">
        <div class="inner">
            <p class="mt-5 mb-3 text-muted">&copy; 2019</p>
        </div>
    </footer>
</div>
</body>
</html>