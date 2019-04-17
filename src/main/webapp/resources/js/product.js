var ajaxUrl = "ajax/profile/orders/bag/";

function save(id) {
    $.ajax({
        type: "POST",
        url: ajaxUrl  + id
    }).done(function () {
        successNoty("Added");
    });
}

$(function () {
    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        failNoty(jqXHR);
    });
});