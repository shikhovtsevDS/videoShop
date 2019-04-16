var ajaxUrl = "profile";
var form;

function save() {
    $.ajax({
        type: "POST",
        url: ajaxUrl,
        data: form.serialize()
    }).done(function () {
        successNoty("Saved");
    });
}

$(function () {
    form = $('#profileForm');
    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        failNoty(jqXHR);
    });
});