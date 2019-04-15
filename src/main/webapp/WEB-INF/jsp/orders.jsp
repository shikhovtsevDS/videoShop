<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body class="text-center" style="height: 100%;">
<script type="text/javascript" src="resources/js/noty.js" defer></script>
<script type="text/javascript" src="resources/js/datatablesUtil.js" defer></script>
<script type="text/javascript" src="resources/js/ordersDatatables.js" defer></script>

<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-md-8 mx-auto" style="text-align: right; max-width: 100%">
            <h3>Orders</h3>
            <table class="table table-striped display" id="datatable">
                <thead>
                <tr>
                    <th>Location</th>
                    <th>Created date</th>
                    <th>Delivered date</th>
                    <th>State</th>
                    <th></th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>
</body>
</html>