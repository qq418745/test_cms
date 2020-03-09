$(function () {



    /**地图插件*/
    // World map by jvectormap
    $('#world-map').vectorMap({
        map              : 'cn_mill',
        backgroundColor  : 'transparent',
        regionStyle      : {
            initial: {
                fill            : 'rgba(255, 255, 255, 0.7)',
                'fill-opacity'  : 1,
                stroke          : 'rgba(0,0,0,.2)',
                'stroke-width'  : 1,
                'stroke-opacity': 1
            }
        },
        series           : {
            regions: [{
                values           : visitorsData,
                scale            : ['#ffffff', '#0154ad'],
                normalizeFunction: 'polynomial'
            }]
        },
        onRegionLabelShow: function (e, el, code) {
            if (typeof visitorsData[code] != 'undefined')
                el.html(el.html() + ': ' + visitorsData[code] + ' new visitors')
        }
    })

    // Sparkline charts
    var sparkline1 = new Sparkline($("#sparkline-1")[0], {width: 80, height: 50, lineColor: '#92c1dc', endColor: '#ebf4f9'});
    var sparkline2 = new Sparkline($("#sparkline-2")[0], {width: 80, height: 50, lineColor: '#92c1dc', endColor: '#ebf4f9'});
    var sparkline3 = new Sparkline($("#sparkline-3")[0], {width: 80, height: 50, lineColor: '#92c1dc', endColor: '#ebf4f9'});

    sparkline1.draw([1000, 1200, 920, 927, 931, 1027, 819, 930, 1021]);
    sparkline2.draw([515, 519, 520, 522, 652, 810, 370, 627, 319, 630, 921]);
    sparkline3.draw([15, 19, 20, 22, 33, 27, 31, 27, 19, 30, 21]);

    // jvectormap data
    var visitorsData = {
        'US': 398, //USA
        'SA': 400, //Saudi Arabia
        'CA': 1000, //Canada
        'DE': 500, //Germany
        'FR': 760, //France
        'CN': 300, //China
        'AU': 700, //Australia
        'BR': 600, //Brazil
        'IN': 800, //India
        'GB': 320, //Great Britain
        'RU': 3000 //Russia
    }



})