var form;

function makeEditable() {
    form = $('#detailsForm');
    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        failNoty(jqXHR);
    });
}

function add() {
    $("#modalTitle").html("Add");
    form.find(":input").val("");
    $("#editRow").modal();
}

function makeOrder() {
    $("#ordModalTitle").html("Make order");
    form.find(":input").val("");
    $("#makeOrd").modal();
}

function updateRow(id) {
    $("#modalTitle").html("Edit");
    $.get(ajaxUrl + id, function (data) {
        $.each(data, function (key, value) {
            form.find("input[name='" + key + "']").val(value);
        });
        $('#editRow').modal();
    });
}

function deleteRow(id) {
    $.ajax({
        url: ajaxUrl + id,
        type: "DELETE"
    }).done(function () {
        updateTable();
        successNoty("Deleted");
    });
}

function updateTableByData(data) {
    datatableApi.clear().rows.add(data).draw();
}

function save() {
    $.ajax({
        type: "POST",
        url: ajaxUrl,
        data: form.serialize()
    }).done(function () {
        $("#editRow").modal("hide");
        updateTable();
        successNoty("Saved");
    });
}

function renderEditBtn(data, type, row) {
    if (type === "display") {
        return "<button onclick='updateRow(" + row.id + ");'>" +
            "update</button>";
    }
}

function renderDeleteBtn(data, type, row) {
    if (type === "display") {
        return "<button onclick='deleteRow(" + row.id + ");'>" +
            "delete</i></button>";
    }
}