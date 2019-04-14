<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">Video Shop</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="order">Bucket</a>
                </li>
                <li>
                    <%--@elvariable id="userTo" type="ru.shikhovtsev.videoShop.to.UserTo"--%>
                    <form:form class="navbar-form navbar-right" action="logout" method="post">
                        <sec:authorize access="isAuthenticated()">
                            <sec:authorize access="hasRole('ADMIN')">
                                <a class="btn btn-info" href="users">Users</a>
                            </sec:authorize>
                            <a class="nav-link" href="profile"><i class="fa fa-android" aria-hidden="true"></i> ${userTo.firstName}</a>
                            <button class="btn btn-primary" type="submit">Logout</button>
                        </sec:authorize>
                    </form:form>
                </li>
            </ul>
        </div>
    </div>
</nav>