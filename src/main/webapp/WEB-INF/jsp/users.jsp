<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>

<body class="text-center" style="height: 100%;">
<script type="text/javascript" src="resources/js/noty.js" defer></script>
<script type="text/javascript" src="resources/js/datatablesUtil.js" defer></script>
<script type="text/javascript" src="resources/js/userDatatables.js" defer></script>

<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-md-8 mx-auto" style="text-align: right; max-width: 100%">
            <h3>Users</h3>
            <br/>
            <a class="btn btn-primary" onclick="add()">
                Add
            </a>
            <table class="table table-striped display" id="datatable">
                <thead>
                <tr>
                    <th>First name</th>
                    <th>Middle name</th>
                    <th>Last name</th>
                    <th>Email</th>
                    <th>Roles</th>
                    <th>Active</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>

<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title card-header info-color white-text text-center py-4" id="modalTitle"></h5>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">
                <form id="detailsForm">
                    <input type="hidden" id="id" name="id">

                    <div class="col-xs-9">
                        <input type="text" class="form-control mb-4" id="firstName" name="firstName"
                               placeholder="First name" required>
                    </div>

                    <div class="col-xs-9">
                        <input type="text" class="form-control mb-4" id="middleName" name="middleName"
                               placeholder="Middle name" required>
                    </div>

                    <div class="col-xs-9">
                        <input type="text" class="form-control mb-4" id="lastName" name="lastName"
                               placeholder="Last name" required>
                    </div>

                    <div class="col-xs-9">
                        <input type="email" class="form-control mb-4" id="email" name="email" placeholder="Email" required>
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