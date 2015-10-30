// Doughnut Chart Options
var doughnutOptions = {
    //Boolean - Whether we should show a stroke on each segment
    segmentShowStroke: true,
    //String - The colour of each segment stroke
    segmentStrokeColor: "#fff",
    //Number - The width of each segment stroke
    segmentStrokeWidth: 2,
    //The percentage of the chart that we cut out of the middle.
    percentageInnerCutout: 50,
    //Boolean - Whether we should animate the chart	
    animation: true,
    //Number - Amount of animation steps
    animationSteps: 100,
    //String - Animation easing effect
    animationEasing: "easeOutBounce",
    //Boolean - Whether we animate the rotation of the Doughnut
    animateRotate: true,
    //Boolean - Whether we animate scaling the Doughnut from the centre
    animateScale: true,
    //Function - Will fire on animation completion.
    onAnimationComplete: null
};

$('#businessUnit').on('change', function () {
    var businessUnit = this.value;

    if (businessUnit !== 'Choose one') {
        $.getJSON("http://localhost:8084/RESToutJSON/rest/getStatusBreakdownByBusinessUnit/" + businessUnit, function (response) {
               console.log(response);       
            var doughnutData = [
                {
                    value: response.pending,
                    label: 'Pending',
                    color: "#00aedb"
                },
                {
                    value: response.reviewed,
                    label: 'Reviewed',
                    color: "#f37735"
                },
            ];
            
            $('#doughnutChart').replaceWith('<canvas id="doughnutChart" width="200" height="200"></canvas>');

            //Get the context of the Doughnut Chart canvas element we want to select
            var ctx = document.getElementById("doughnutChart").getContext("2d");

            // Create the Doughnut Chart
            var mydoughnutChart = new Chart(ctx).Doughnut(doughnutData, doughnutOptions);
            
            document.getElementById('js-legend').innerHTML = mydoughnutChart.generateLegend();
        });
    }
});

