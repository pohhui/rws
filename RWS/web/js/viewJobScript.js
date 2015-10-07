$(document).ready(function () {
    // DataTable
    var table = $('#applicationsTable').DataTable();

    $('#applicationsTable')
            .removeClass('display')
            .addClass('table table-striped table-bordered');

    $('#download-submit').click(function () {
        $('#downloadCVModal').modal('hide');
    });

    $("#select-all").click(function () {
        var checkBoxes = $("input[name='download']");
        checkBoxes.prop("checked", !checkBoxes.prop("checked"));
        if (checkBoxes.prop("checked")) {
            $("#select-all").html('Deselect All &nbsp;<i class="fa fa-times"></i>');
        } else {
            $("#select-all").html('Select All &nbsp;<i class="fa fa-check"></i>');
        }
        
        $('#download-button').prop('disabled', !checkBoxes.prop("checked"));
    });

    $(':checkbox').click(function () {
        var canDownload = true;
        
        $('input[type=checkbox]').each(function () {
            if (this.checked) {
                canDownload = false;
            }
        });
        
        $('#download-button').prop('disabled', canDownload);
    });
});

