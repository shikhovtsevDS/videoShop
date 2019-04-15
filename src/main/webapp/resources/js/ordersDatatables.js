var ajaxUrl = "ajax/orders/";
var datatableApi;

function updateTable() {
    $.get(ajaxUrl, updateTableByData);
}

// http://api.jquery.com/jQuery.ajax/#using-converters
/*$.ajaxSetup({
    converters: {
        "text json": function (stringData) {
            var json = JSON.parse(stringData);
            $(json).each(function () {
                this.dateTime = this.dateTime.replace('T', ' ').substr(0, 16);
            });
            return json;
        }
    }
});*/

$(function () {
    datatableApi = $("#datatable").DataTable({
        "ajax": {
            "url": ajaxUrl,
            "dataSrc": ""
        },
        "paging": false,
        "info": true,
        "columns": [
            {
                "data": "location"
            },
            {
                "data": "createdDate"
            },
            {
                "data": "deliveredDate"
            },
            {
                "render": function renderEditBtn(data, type, row) {
                    if (type === "display") {
                        return "<a class=\"nav-link active\" href=\"products/" + row.id + "}\"\n" +
                            "aria-disabled=\"true\">update</a>";
                    }
                },
                "defaultContent": "",
                "orderable": false
            },
            {
                "render": renderDeleteBtn,
                "defaultContent": "",
                "orderable": false
            }
        ],
        "order": [
            [
                0,
                "desc"
            ]
        ],
        "initComplete": makeEditable
    });
});