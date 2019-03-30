<%@ page isErrorPage="true" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="../fragments/headTag.jsp"/>

<body>
<jsp:include page="../fragments/bodyHeader.jsp"/>

<div class="jumbotron">
    <div class="container text-center">
        <br>
        <h3>Application Error</h3>
        <h2>${message}</h2>
    </div>
</div>
</body>
</html>