var ajaxUrl = "ajax/profile/orders/";
var datatableApi;

function updateTable() {
    $.get(ajaxUrl, updateTableByData);
}

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
                "data": "name"
            },
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
                "data": "state"
            },
            {
                "render": function renderOrderBtn(data, type, row) {
                    if (type === "display") {
                        return "<a class=\"nav-link active\" href=\"orders/" + row.id + "\"\n" +
                            "aria-disabled=\"true\">Check Order</a>";
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