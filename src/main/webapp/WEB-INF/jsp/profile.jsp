<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<link rel="stylesheet" href="resources/css/register.css">
<body class="text-center" style="height: 100%;">
<div class="container w-100 h-100" style="padding-top: 100px">
    <div class="row">
        <div class="col-lg-10 col-xl-9 mx-auto">
            <div class="card card-signin flex-row my-5">
                <div class="card-img-left d-none d-md-flex">
                </div>
                <div class="card-body">
                    <h5 class="card-title text-center">${register ? "Fill in the registration form" : "Profile"}</h5>
                    <form class="form-signin">
                        <div class="form-label-group">
                            <input type="text" id="inputFirstname" class="form-control" placeholder="Firstname" required>
                            <label for="inputFirstname">Firstname</label>
                        </div>

                        <div class="form-label-group">
                            <input name="middleName" id="inputMiddlename" class="form-control" placeholder="Middlename" required>
                            <label for="inputMiddlename">Middlename</label>
                        </div>

                        <div class="form-label-group">
                            <input name="lastName" id="inputLastname" class="form-control" placeholder="Lastname" required>
                            <label for="inputLastname">Lastname</label>
                        </div>

                        <div class="form-label-group">
                            <input name="email" id="inputEmail" class="form-control" placeholder="Email address" required>
                            <label for="inputEmail">Email address</label>
                        </div>

                        <hr>

                        <div class="form-label-group">
                            <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                            <label for="inputPassword">Password</label>
                        </div>

                        <button class="btn btn-lg btn-dark btn-block text-uppercase" type="submit">${register ? 'Register' : 'Save changes'}</button>
                        <a class="d-block text-center mt-2 small" href="login">Sign In</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>