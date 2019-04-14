<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">Video Shop</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <form:form class="navbar-form navbar-right" action="logout" method="post">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="order">Bucket</a>
                    </li>
                    <li>
                            <%--@elvariable id="userTo" type="ru.shikhovtsev.videoShop.to.UserTo"--%>
                        <sec:authorize access="isAuthenticated()">
                        <sec:authorize access="hasRole('ADMIN')">
                    <li>
                        <a class="nav-link" href="users">Users</a>
                    </li>
                    </sec:authorize>
                    <li>
                        <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                    </li>
                    <li>
                        <a class="nav-link" href="profile">${userTo.firstName}</a>
                    </li>
                    <li>
                        <button class="btn btn-dark" type="submit">Logout</button>
                    </li>
                    </sec:authorize>
                    </li>
                </ul>
            </form:form>
        </div>
    </div>
</nav>