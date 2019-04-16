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
            <source src="https://app.coverr.co/s3/mp4/Indian-Pedestrian.mp4" type="video/mp4">
        </video>
        <div class="container h-100">
            <div class="d-flex h-100 text-center align-items-center">
                <div class="container" style="margin-bottom: 250px; margin-top: 100px">
                    <div class="card shopping-cart" style="margin: 0 auto; border-color: #7a7a7a;">
                        <div class="card-header bg-dark text-light" style="text-align: left">
                            <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                            Shopping cart
                            <a href="/" class="btn btn-outline-info btn-sm pull-right">Continue shopping</a>
                            <div class="clearfix"></div>
                        </div>
                        <c:forEach var="product" items="${products}">
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
                                        <div class="col-2 col-sm-2 col-md-2 text-right">
                                            <button type="button" class="btn btn-outline-danger btn-xs">
                                                <i class="fa fa-trash" aria-hidden="true"></i>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                                <hr>
                            </div>
                        </c:forEach>
                        <div class="card-footer">
                            <div class="pull-right" style="margin: 10px">
                                <a onclick="makeOrder()" class="btn btn-success pull-right">Confirm</a>
                                <div class="pull-right" style="margin: 5px">
                                    Total price: <b>${totalCost}€</b>
                                </div>
                            </div>
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

<div class="modal fade" id="makeOrd">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title card-header info-color white-text text-center py-4" id="ordModalTitle"></h5>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">
                <form id="detailsForm">
                    <input type="hidden" id="id" name="id">

                    <div class="col-xs-9">
                        <input type="text" class="form-control mb-4" id="name" name="Name"
                               placeholder="Name">
                    </div>

                    <div class="col-xs-9">
                        <input type="text" class="form-control mb-4" id="location" name="location"
                               placeholder="Location">
                    </div>

                    <div class="col-xs-9">
                        <input type="date" class="form-control mb-4" id="deliveredDate" name="deliveredDate"
                               placeholder="Delivered date">
                    </div>

                    <div class="form-group">
                        <div class="col-xs-offset-3 col-xs-9">
                            <button type="button" onclick="save()" class="btn btn-primary">
                                <span class="badge badge-success" aria-hidden="true"></span>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>