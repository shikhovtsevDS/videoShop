<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<script type="text/javascript" src="resources/js/noty.js" defer></script>
<script type="text/javascript" src="resources/js/datatablesUtil.js" defer></script>
<script type="text/javascript" src="resources/js/ordersDatatables.js" defer></script>
<jsp:include page="fragments/bodyHeader.jsp"/>

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
</body>
</html>