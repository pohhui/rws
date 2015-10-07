$(document).ready(function () {
    $(window).load(function () {
        $(".loader").fadeOut(1000);        
    })

    //$(".alert").addClass("in").fadeOut(4500);

    /* swap open/close side menu icons */
    $('[data-toggle=collapse]').click(function () {
        // toggle icon
        $(this).find("i").toggleClass("fa fa-chevron-right fa fa-chevron-down");
    });
});
