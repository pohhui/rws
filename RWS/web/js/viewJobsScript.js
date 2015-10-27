$(document).ready(function () {
    $("#myTab a").click(function (e) {
        e.preventDefault();
        $(this).tab('show');
    });

    $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
    var target = this.href.split('#');
    $('.nav a').filter('a[href="#'+target[1]+'"]').tab('show');
    });
    
});

