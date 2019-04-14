<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
    <jsp:include page="fragments/headTag.jsp"/>
    <link rel="stylesheet" href="resources/css/register.css">
</head>
<body class="text-center" style="height: 100%;">
<jsp:include page="fragments/bodyHeader.jsp"/>
    <div class="container w-100 h-100" style="padding-top: 200px">
        <div class="row">
            <div class="col-lg-10 col-xl-9 mx-auto">
                <div class="card card-signin flex-row my-5">
                    <div class="card-img-left_login d-none d-md-flex">
                    </div>
                    <div class="card-body">
                        <h3 class="login-heading mb-4">Welcome back!</h3>
                        <form class="form-signin" name='f' action="spring_security_check" method='POST'>
                            <div class="form-label-group">
                                <input type="email" id="inputEmail" class="form-control" name="username" placeholder="Email address" required autofocus>
                                <label for="inputEmail">Email address</label>
                            </div>

                            <div class="form-label-group">
                                <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" required>
                                <label for="inputPassword">Password</label>
                            </div>
                            <button class="btn btn-lg btn-dark btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit">Sign in</button>
                            <a class="d-block text-center mt-2 small" href="register">Registration</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
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

<link rel="stylesheet" href="resources/css/register.css">
<body class="text-center" style="height: 100%;">

</body>
</html>