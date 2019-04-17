var form;
var ajaxUrl = "ajax/profile/orders/bag/";

$(function () {
    form = $('#detailsForm');
    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        failNoty(jqXHR);
    });
});

function makeOrder() {
    form.find(":input").val("");
    $("#editRow").modal();
}

function save() {
    $.ajax({
        type: "POST",
        url: ajaxUrl,
        data: form.serialize()
    }).done(function () {
        location.reload();
    });
}