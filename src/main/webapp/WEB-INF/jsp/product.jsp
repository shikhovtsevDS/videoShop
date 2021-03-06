<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <jsp:include page="fragments/headTag.jsp"/>
    <link rel="stylesheet" href="resources/css/header.css">
</head>
<body class="text-center" style="height: 100%">
<script type="text/javascript" src="resources/js/noty.js" defer></script>
<script type="text/javascript" src="resources/js/product.js" defer></script>
<jsp:include page="fragments/bodyHeader.jsp"/>
<script src="https://use.fontawesome.com/c560c025cf.js"></script>
<div class="w-100 h-100">
    <header style="height: 97%;">
        <div class="overlay" style="height: max-content;"></div>
        <video playsinline="playsinline" autoplay="autoplay" muted="muted" loop="loop">
            <source src="${product.video}" type="video/mp4">
        </video>
        <div class="container h-100">
            <div class="d-flex h-100 text-center align-items-center">
                <div class="container" style="margin-bottom: 250px; margin-top: 100px">
                    <div class="card shopping-cart" style="margin: 0 auto; border-color: #7a7a7a;">
                        <div class="card-header bg-dark text-light">
                            <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                            Shopping cart
                            <a href="/" class="btn btn-outline-info btn-sm pull-right">Back</a>
                            <div class="clearfix"></div>
                        </div>
                        <div class="card-body" style="padding-bottom: 0px">
                            <div class="row">
                                <div class="col-12 col-sm-12 col-md-2 text-center">
                                    <img class="img-responsive" src="${product.image}" alt="prewiew" width="120" height="80">
                                </div>
                                <div class="col-12 text-sm-center col-sm-12 text-md-left col-md-6">
                                    <h4 class="product-name"><strong>${product.name}</strong></h4>
                                    <h4>
                                        <small>${product.description}</small>
                                    </h4>
                                </div>
                                <div class="col-12 col-sm-12 text-sm-center col-md-4 text-md-right row">
                                    <div class="col-3 col-sm-3 col-md-6 text-md-right" style="padding-top: 5px">
                                        <h6><strong>${product.cost} <span class="text-muted">€</span></strong></h6>
                                    </div>
                                </div>
                            </div>
                            <hr>
                        </div>
                        <sec:authorize access="isAuthenticated()">
                            <div class="pull-right" style="margin: 10px">
                                <a onclick="save(${product.id})" class="btn btn-success pull-right">Add to order</a>
                            </div>
                        </sec:authorize>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <section class="mastfoot mt-auto text-center">
        <div class="inner">
            <p class="mb-3 text-muted" style="padding-top: 15px">&copy; 2019</p>
        </div>
    </section>
</div>
</body>
</html>