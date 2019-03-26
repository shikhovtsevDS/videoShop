<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML>
<html>
<head>
    <jsp:include page="fragments/links.jsp"/>
</head>
<body class="text-center">
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
    <header class="masthead mb-auto">
        <div class="inner">
            <h3 class="masthead-brand">Video store</h3>
            <nav class="nav nav-masthead justify-content-center">
                <a class="nav-link" href="/">Home</a>
                <a class="nav-link" href="products">Products</a>
                <a class="nav-link " href="login">Log in</a>
            </nav>
        </div>
    </header>
    <form class="form-signin">
        <h1 class="h3 mb-3 font-weight-normal">Fill in the registration form</h1>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="password" id="inputEmail" class="form-control" placeholder="Email address" required>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <label for="inputFirstname" class="sr-only">Firstname</label>
        <input type="password" id="inputFirstname" class="form-control" placeholder="Firstname" required>
        <label for="inputMiddlename" class="sr-only">Middlename</label>
        <input type="password" id="inputMiddlename" class="form-control" placeholder="Middlename" required>
        <label for="inputLastname" class="sr-only">Lastname</label>
        <input type="password" id="inputLastname" class="form-control" placeholder="Lastname" required>
        <button class="btn btn-lg btn-secondary" type="submit">Register</button>
        <p class="mt-5 mb-3 text-muted">&copy; 2019</p>
    </form>
</div>
</body>
</html>