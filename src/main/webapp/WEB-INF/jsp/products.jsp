<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <link rel="stylesheet" href="resources/css/style.css">
    <link rel="stylesheet" href="/webjars/bootstrap/4.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="/webjars/datatables/1.10.16/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/webjars/noty/3.1.0/lib/noty.css"/>
    <link rel="stylesheet" href="/webjars/datetimepicker/2.5.11/jquery.datetimepicker.css">
    <link rel="shortcut icon" href="resources/images/icon-meal.png">

    <!--http://stackoverflow.com/a/24070373/548473-->
    <script type="text/javascript" src="/webjars/jquery/3.2.1/dist/jquery.min.js"></script>
    <script type="text/javascript" src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js" defer></script>
    <script type="text/javascript" src="/webjars/datatables/1.10.16/js/jquery.dataTables.min.js" defer></script>
    <script type="text/javascript" src="/webjars/datatables/1.10.16/js/dataTables.bootstrap.min.js" defer></script>
    <script type="text/javascript" src="/webjars/noty/3.1.0/lib/noty.min.js" defer></script>
    <script type="text/javascript" src="/webjars/datetimepicker/2.5.11/build/jquery.datetimepicker.full.min.js"
            defer></script>
</head>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="jumbotron">
    <div class="container">
        <table class="table table-striped display">
            <thead>
            <tr>
                <th>Name</th>
                <th>desc</th>
                <th>cost</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.name}</td>
                    <td>${product.description}</td>
                    <td>${product.cost}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>