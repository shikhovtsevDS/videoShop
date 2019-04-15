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
});