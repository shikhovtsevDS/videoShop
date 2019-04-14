<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="fragments/headTag.jsp"/>
</head>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<script src="https://use.fontawesome.com/c560c025cf.js"></script>
<div class="d-flex w-100 h-100 p-3 mx-auto flex-column" style="max-width: 64em">
    <header class="masthead mb-auto" style="height: 200px">
        <div class="inner">
            <h3 class="masthead-brand">Video store</h3>
            <nav class="nav nav-masthead justify-content-center">
                <a class="nav-link" href="/">Home</a>
                <a class="nav-link" href="login">Log in</a>
            </nav>
        </div>
    </header>
<div class="container" style="margin-bottom: 250px; margin-top: 100px">
    <div class="card shopping-cart">
        <div class="card-header bg-dark text-light">
            <i class="fa fa-shopping-cart" aria-hidden="true"></i>
            Shopping cart
            <a href="/products" class="btn btn-outline-info btn-sm pull-right">Back to products</a>
            <div class="clearfix"></div>
        </div>
        <div class="card-body" style="padding-bottom: 0px">
            <div class="row">
                <div class="col-12 col-sm-12 col-md-2 text-center">
                    <img class="img-responsive" src="http://placehold.it/120x80" alt="prewiew" width="120" height="80">
                </div>
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
                <a href="" class="btn btn-success pull-right">Add to order</a>
            </div>
    </div>
</div>

    <footer class="mastfoot mt-auto text-center">
        <div class="inner">
            <p class="mt-5 mb-3 text-muted">&copy; 2019</p>
        </div>
    </footer>
</div>
</body>
</html>