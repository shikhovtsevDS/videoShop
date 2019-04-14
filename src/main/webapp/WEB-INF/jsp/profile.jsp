<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<form class="form-signin" action="${register ? 'register' : 'profile'}" method="post">
    <h1 class="h3 mb-3 font-weight-normal">${register ? "Fill in the registration form" : "Profile"}</h1>
    <label for="inputFirstname" class="sr-only">Firstname</label>
    <input name="firstName" id="inputFirstname" class="form-control" placeholder="Firstname" required>
    <label for="inputMiddlename" class="sr-only">Middlename</label>
    <input name="middleName" id="inputMiddlename" class="form-control" placeholder="Middlename" required>
    <label for="inputLastname" class="sr-only">Lastname</label>
    <input name="lastName" id="inputLastname" class="form-control" placeholder="Lastname" required>
    <label for="inputEmail" class="sr-only">Email address</label>
    <input name="email" id="inputEmail" class="form-control" placeholder="Email address" required>
    <label for="inputPassword" class="sr-only">Password</label>
    <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
    <button class="btn btn-lg btn-secondary" type="submit">${register ? 'Зарегистрироваться' : 'Сохранить изменения'}</button>
</form>
</body>
</html>