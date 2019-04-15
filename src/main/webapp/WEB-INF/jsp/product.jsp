<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="fragments/headTag.jsp"/>
    <link rel="stylesheet" href="resources/css/header.css">
</head>
<body class="text-center" style="height: 100%">
<jsp:include page="fragments/bodyHeader.jsp"/>
<script src="https://use.fontawesome.com/c560c025cf.js"></script>
<div class="w-100 h-100">
    <header style="height: 97%;">
        <div class="overlay" style="height: max-content;"></div>
        <video playsinline="playsinline" autoplay="autoplay" muted="muted" loop="loop">
            <source src="${product.image}" type="video/mp4">
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
                                <div class="col-12 text-sm-center col-sm-12 text-md-left col-md-6">
                                    <h4 class="product-name"><strong>${product.name}</strong></h4>
                                    <h4>
                                        <small>${product.description}</small>
                                    </h4>
                                </div>
                                <div class="col-12 col-sm-12 text-sm-center col-md-4 text-md-right row">
                                    <div class="col-3 col-sm-3 col-md-6 text-md-right" style="padding-top: 5px">
                                        <h6><strong>${product.cost} <span class="text-muted">x</span></strong></h6>
                                    </div>
                                    <div class="col-4 col-sm-4 col-md-4">
                                        <div class="quantity">
                                            <input type="number" step="1" max="99" min="1" value="1" class="qty"
                                                   size="4">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <hr>
                        </div>
                        <div class="pull-right" style="margin: 10px">
                            <a href="/" class="btn btn-success pull-right">Add to order</a>
                        </div>
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