/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    // Setup - add a text input to each footer cell
//    $('#example tfoot th').each(function () {
//        var title = $('#example thead th').eq($(this).index()).text();
//        $(this).html('<input type="text" placeholder="Search ' + title + '" />');
//    });

    // DataTable
    
    var table = $('#example').dataTable();
    var table1 = $('#example1').dataTable();


//    // Apply the search
//    table.columns().every(function () {
//        var that = this;
//
//        $('input', this.footer()).on('keyup change', function () {
//            if (that.search() !== this.value) {
//                that
//                        .search(this.value)
//                        .draw();
//            }
//        });
//    });
    
    $('#example')
            .removeClass('display')
            .addClass('table table-striped table-bordered');
    
    $('#example1')
            .removeClass('display')
            .addClass('table table-striped table-bordered');

    
});

