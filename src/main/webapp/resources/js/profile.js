var ajaxUrl = "profile";
var registerUrl = "register";
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

function register() {
    $.ajax({
        type: "POST",
        url: registerUrl,
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