$(document).ready(function () {
    var navListItems = $('ul.setup-panel li a'),
            allWells = $('.setup-content');

    allWells.hide();

    navListItems.click(function (e)
    {
        e.preventDefault();
        var $target = $($(this).attr('href')),
                $item = $(this).closest('li');

        if (!$item.hasClass('disabled')) {
            navListItems.closest('li').removeClass('active');
            $item.addClass('active');
            allWells.hide();
            $target.show();
        }
    });

    $('ul.setup-panel li.active a').trigger('click');

    //buttons
    $('#next-step-2').on('click', function (e) {
        $('ul.setup-panel li:eq(1)').removeClass('disabled');
        $('ul.setup-panel li a[href="#step-2"]').trigger('click');
        $('html,body').scrollTop(0);
    });
    
    $('#previous-step-1').on('click', function (e) {
        $('ul.setup-panel li a[href="#step-1"]').trigger('click');
        $('html,body').scrollTop(0);
    });
    
    $('#next-step-3').on('click', function (e) {
        $('ul.setup-panel li:eq(2)').removeClass('disabled');
        $('ul.setup-panel li a[href="#step-3"]').trigger('click');
        $('html,body').scrollTop(0);
    });
    
    $('#previous-step-2').on('click', function (e) {
        $('ul.setup-panel li a[href="#step-2"]').trigger('click');
        $('html,body').scrollTop(0);
    });
    
    $('#next-step-4').on('click', function (e) {
        $('ul.setup-panel li:eq(3)').removeClass('disabled');
        $('ul.setup-panel li a[href="#step-4"]').trigger('click');
        $('html,body').scrollTop(0);
    });
    
    $('#previous-step-3').on('click', function (e) {
        $('ul.setup-panel li a[href="#step-3"]').trigger('click');
        $('html,body').scrollTop(0);
    });
    
    $('#next-step-5').on('click', function (e) {
        $('ul.setup-panel li:eq(4)').removeClass('disabled');
        $('ul.setup-panel li a[href="#step-5"]').trigger('click');
        $('html,body').scrollTop(0);
    });
    
    $('#previous-step-4').on('click', function (e) {
        $('ul.setup-panel li a[href="#step-4"]').trigger('click');
    });

    //for autocomplete
    var substringMatcher = function (strs) {
        return function findMatches(q, cb) {
            var matches, substringRegex;

            // an array that will be populated with substring matches
            matches = [];

            // regex used to determine if a string contains the substring `q`
            substrRegex = new RegExp(q, 'i');

            // iterate through the pool of strings and for any string that
            // contains the substring `q`, add it to the `matches` array
            $.each(strs, function (i, str) {
                if (substrRegex.test(str)) {
                    matches.push(str);
                }
            });

            cb(matches);
        };
    };

    //job autocomplete
    var jobs = [
        'J00851, Crew',
        'J00676, Production Manager',
        'J00342, Admin Assistant',
    ];

    $('#jobAutocomplete .typeahead').typeahead({
        hint: true,
        highlight: true,
        minLength: 1
    },
    {
        name: 'job',
        source: substringMatcher(jobs),
        templates: {
            empty: [
                '<div>',
                'Unable to find any results',
                '</div>'
            ].join('\n')
        }
    });

    //cost center autocomplete
    var costCenters = [
        '3000, USS-ENTRY OPERATIONS'
    ];

    $('#costCenterAutocomplete .typeahead').typeahead({
        hint: true,
        highlight: true,
        minLength: 1
    },
    {
        name: 'costCenter',
        source: substringMatcher(costCenters),
        templates: {
            empty: [
                '<div>',
                'Unable to find any results',
                '</div>'
            ].join('\n')
        }
    });

    //location autocomplete
    var locations = [
        'USS'
    ];

    $('#locationAutocomplete .typeahead').typeahead({
        hint: true,
        highlight: true,
        minLength: 1
    },
    {
        name: 'location',
        source: substringMatcher(locations),
        templates: {
            empty: [
                '<div>',
                'Unable to find any results',
                '</div>'
            ].join('\n')
        }
    });

    //department autocomplete
    var departments = [
        'D0091, Attractions Entry Operations'
    ];

    $('#departmentAutocomplete .typeahead').typeahead({
        hint: true,
        highlight: true,
        minLength: 1
    },
    {
        name: 'department',
        source: substringMatcher(departments),
        templates: {
            empty: [
                '<div>',
                'Unable to find any results',
                '</div>'
            ].join('\n')
        }
    });

    //area of interest autocomplete
    var interests = [
        'Entertainment',
        'Sales & Marketing',
        'Procurement'
    ];

    $('#areaOfInterestAutocomplete .typeahead').typeahead({
        hint: true,
        highlight: true,
        minLength: 1
    },
    {
        name: 'areaOfInterest',
        source: substringMatcher(interests),
        templates: {
            empty: [
                '<div>',
                'Unable to find any results',
                '</div>'
            ].join('\n')
        }
    });
});

