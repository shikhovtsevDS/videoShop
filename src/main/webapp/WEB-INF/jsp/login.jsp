<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
    <jsp:include page="fragments/headTag.jsp"/>
</head>
<body class="text-center">
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
    <header class="masthead mb-auto">
        <div class="inner">
            <h3 class="masthead-brand">Video store</h3>
            <nav class="nav nav-masthead justify-content-center">
                <a class="nav-link" href="/">Home</a>
                <a class="nav-link" href="products">Products</a>
                <a class="nav-link active" href="login" aria-disabled="true">Log in</a>
            </nav>
        </div>
    </header>
    <form class="form-signin" name='f' action="spring_security_check" method='POST'>
        <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control" name="username" placeholder="Email address" required
               autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" required>
        <button class="btn btn-lg btn-secondary" type="submit">Sign in</button>
    </form>
    <a class="btn-warning" href="register">Registration</a>
    <p class="mt-5 mb-3 text-muted">&copy; 2019</p>
</div>

<script type="text/javascript">
    <c:if test="${not empty param.email}">
    setCredentials("${param.email}", "");
    </c:if>

    function setCredentials(username, password) {
        $('input[id="inputEmail"]').val(username);
        $('input[id="inputPassword"]').val(password);
    }
</script>
</body>
</html>