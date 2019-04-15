var failedNote;

function closeNoty() {
    if (failedNote) {
        failedNote.close();
        failedNote = undefined;
    }
}

function successNoty(message) {
    closeNoty();
    new Noty({
        text: "<span class='glyphicon glyphicon-ok'></span> &nbsp;" + message,
        type: 'success',
        layout: "bottomRight",
        timeout: 1000
    }).show();
}

function failNoty(jqXHR) {
    closeNoty();
    // https://stackoverflow.com/questions/48229776
    var errorInfo = JSON.parse(jqXHR.responseText);
    failedNote = new Noty({
        text: "<span class='fa fa-cog'></span> &nbsp;" + "Error status" + ": " + jqXHR.status + "<br>" + errorInfo.type + "<br>" + errorInfo.details.join("<br>"),
        type: "error",
        layout: "bottomRight"
    }).show();
}