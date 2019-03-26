<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" href="/webjars/bootstrap/4.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="/webjars/datatables/1.10.16/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/webjars/noty/3.1.0/lib/noty.css"/>
    <link rel="stylesheet" href="/webjars/datetimepicker/2.5.11/jquery.datetimepicker.css">
    <link rel="shortcut icon" href="resources/images/icon-meal.png">

    <script type="text/javascript" src="/webjars/jquery/3.2.1/dist/jquery.min.js"></script>
    <script type="text/javascript" src="/webjars/bootstrap/4.3.0/js/bootstrap.min.js" defer></script>
    <script type="text/javascript" src="/webjars/datatables/1.10.16/js/jquery.dataTables.min.js" defer></script>
    <script type="text/javascript" src="/webjars/datatables/1.10.16/js/dataTables.bootstrap.min.js" defer></script>
    <script type="text/javascript" src="/webjars/noty/3.1.0/lib/noty.min.js" defer></script>
    <script type="text/javascript" src="/webjars/datetimepicker/2.5.11/build/jquery.datetimepicker.full.min.js"
            defer></script>
</head>
<body class="text-center">
    <form class="form-signin">
        <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <p class="mt-5 mb-3 text-muted">&copy; 2019</p>
    </form>
</body>

</html>