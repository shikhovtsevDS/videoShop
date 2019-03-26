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
                    <a class="nav-link active" href="login">Log in</a>
                    <a class="nav-link" href="#">Contact</a>
                </nav>
            </div>
        </header>
        <form class="form-signin">
            <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
            <label for="inputEmail" class="sr-only">Email address</label>
            <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
            <button class="btn btn-lg btn-secondary" type="submit">Sign in</button>
            <p class="mt-5 mb-3 text-muted">&copy; 2019</p>
        </form>
    </div>
</body>
</html>