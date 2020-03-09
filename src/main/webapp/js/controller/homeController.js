app.controller('homeController' ,function($scope,$controller,homeService,orderReportService){

    $controller('baseController',{$scope:$scope});//继承


//车辆流量统计图
    // Sales graph chart
    var salesGraphChartCanvas = $('#line-chart').get(0).getContext('2d');
//$('#revenue-chart').get(0).getContext('2d');
    var salesGraphChartData = {
        labels: ['2019 03月', '2019 04月', '2019 05月', '2019 06月', '2019 07月', '2019 08月', '2019 09月', '2019 10月', '2019 11月', '2019 12月'],
        datasets: [
            {
                label: 'Digital Goods',
                fill: false,
                borderWidth: 2,
                lineTension: 0,
                spanGaps: true,
                borderColor: '#efefef',
                pointRadius: 3,
                pointHoverRadius: 7,
                pointColor: '#efefef',
                pointBackgroundColor: '#efefef',
                data: [2560, 3856, 2800, 3767, 2810, 2670, 2820, 2073, 3687, 2432]
            }
        ]
    }

    var salesGraphChartOptions = {
        maintainAspectRatio: false,
        responsive: true,
        legend: {
            display: false,
        },
        scales: {
            xAxes: [{
                ticks: {
                    fontColor: '#efefef',
                },
                gridLines: {
                    display: false,
                    color: '#efefef',
                    drawBorder: false,
                }
            }],
            yAxes: [{
                ticks: {
                    stepSize: 1000,
                    fontColor: '#efefef',
                },
                gridLines: {
                    display: true,
                    color: '#efefef',
                    drawBorder: false,
                }
            }]
        }
    }

// This will get the first returned node in the jQuery collection.
    var salesGraphChart = new Chart(salesGraphChartCanvas, {
            type: 'line',
            data: salesGraphChartData,
            options: salesGraphChartOptions
        }
    )

    /* jQueryKnob */
    $('.knob').knob()


    /*柱形统计图插件*/
    var ticksStyle = {
        fontColor: '#495057',
        fontStyle: 'bold'
    }

    var mode      = 'index'
    var intersect = true


    var $visitorsChart = $('#visitors-chart')



    /*可动模块*/
    // Make the dashboard widgets sortable Using jquery UI
    $('.connectedSortable').sortable({
        placeholder         : 'sort-highlight',
        connectWith         : '.connectedSortable',
        handle              : '.card-header, .nav-tabs',
        forcePlaceholderSize: true,
        zIndex              : 999999
    })


    $scope.weixin = 0;
    $scope.ali = 0;
    $scope.other = 0;


    /*费用比例甜甜圈*/
//-------------
    //- PIE CHART -
    //-------------
    // Get context with jQuery - using jQuery's .get() method.
    var pieChartCanvas = $('#pieChart').get(0).getContext('2d')
    var pieData        = {
        labels: [
            '银联(微信)',
            '银联(支付宝)',
            '云闪付',
            '微信',
            '支付宝',
            '其他',
        ],
        datasets: [
            {
                 data: [0,0,0,0,0,0],
                backgroundColor : ['#f56954', '#00a65a', '#f39c12', '#00c0ef', '#3c8dbc', '#d2d6de'],
            }
        ]
    }
    var pieOptions     = {
        legend: {
            display: false
        }
    }


    $scope.init=function(){
        //加载收款类型占比
        search();

        homeService.findChargeType().success(function (response) {
            console.log(pieData);
            if(response.success){
                for (i = 0; i <response.info.length; i++) {
                    var v = response.info[i];
                   var value = parseInt( v.value);
                    switch (parseInt(v.key)) {
                        case 0:
                            pieData.datasets[0].data[3] = value;
                            break;
                        case 1:
                            pieData.datasets[0].data[4] = value;
                            break;
                        case 3:
                            pieData.datasets[0].data[0] = value;
                            break;
                        case 4:
                            pieData.datasets[0].data[1] = value;
                            break;
                        case 5:
                            pieData.datasets[0].data[2] = value;
                            break;
                        default :
                            pieData.datasets[0].data[5] += value;
                    }
                }
            }

            //$scope.payFlayArray = ["微信", "支付宝", "银联", "银联(微)", "银联(支)", "银联(云)", "招行", "农商行(云)", "农商行(微)", "农商行(支)","pos扫码"];

            //Create pie or douhnut chart
            // You can switch between pie and douhnut using the method below.
            var pieChart = new Chart(pieChartCanvas, {
                type: 'doughnut',
                data: pieData,
                options: pieOptions
            });


            var weiXin = 0;
            var ali= 0;
            var other= 0;
            var total = 0;
            for (i = 0; i <response.info.length; i++) {
                var v = response.info[i];
                var value = parseInt( v.value);
                total += value;
                switch (parseInt(v.key)) {
                    case 0:
                    case 3:
                    case 8:
                        weiXin += value;
                        break;
                    case 1:
                    case 4:
                    case 9:
                        ali += value;
                        break;
                    default :
                        other += value;

                }

            }

            $scope.weixin =    GetPercent(weiXin,total);
            $scope.ali = GetPercent(ali,total);
            $scope.other =  GetPercent(other,total);
                });



    }




    function GetPercent(num, total) {

        num = parseFloat(num);
        total = parseFloat(total);
        if (isNaN(num) || isNaN(total)) {
            return "-";
        }
        return total <= 0 ? "0%" : (Math.round(num / total * 10000) / 100.00)+"%";
    }
    $scope.searchEntity = {};



    var   visitorsChartInfo  =  {
        data: {
            labels  : ['月日', '月日', '月日', '月日', '月日', '月日', '月日'],
            datasets: [{
                type                : 'line',
                data                : [0, 0, 0, 0, 0, 0, 0],
                backgroundColor     : 'transparent',
                borderColor         : '#007bff',
                pointBorderColor    : '#007bff',
                pointBackgroundColor: '#007bff',
                fill                : false
                // pointHoverBackgroundColor: '#007bff',
                // pointHoverBorderColor    : '#007bff'
            },
                {
                    type                : 'line',
                    data                : [0, 0, 0, 0, 0, 0, 0],
                    backgroundColor     : 'tansparent',
                    borderColor         : '#ced4da',
                    pointBorderColor    : '#ced4da',
                    pointBackgroundColor: '#ced4da',
                    fill                : false
                    // pointHoverBackgroundColor: '#ced4da',
                    // pointHoverBorderColor    : '#ced4da'
                }]
        },
        options: {
            maintainAspectRatio: false,
            tooltips           : {
                mode     : mode,
                intersect: intersect
            },
            hover              : {
                mode     : mode,
                intersect: intersect
            },
            legend             : {
                display: false
            },
            scales             : {
                yAxes: [{
                    // display: false,
                    gridLines: {
                        display      : true,
                        lineWidth    : '4px',
                        color        : 'rgba(0, 0, 0, .2)',
                        zeroLineColor: 'transparent'
                    },
                    ticks    : $.extend({
                        beginAtZero : true,
                        suggestedMax: 100
                    }, ticksStyle)
                }],
                xAxes: [{
                    display  : true,
                    gridLines: {
                        display: false
                    },
                    ticks    : ticksStyle
                }]
            }
        }
    };
    //搜索分页查询



    function search(){
        orderReportService.search(1,8,"","",$scope.searchEntity,1,"").success(
            function(response){




             var  orderMoneyWeek = response.rows;

               var date=[];
               var count= [];
               var sumTotalFee=[];
                for (i = orderMoneyWeek.length-1; i > 0; i--) {

                    date.push(orderMoneyWeek[i].time);
                    count.push(orderMoneyWeek[i].count);
                    sumTotalFee.push(orderMoneyWeek[i].sumTotalFee/100);
                }

                visitorsChartInfo.data.datasets[0].data = sumTotalFee;
                visitorsChartInfo.data.datasets[1].data = count;
                visitorsChartInfo.data.labels = date;

                var visitorsChart  = new Chart($visitorsChart,visitorsChartInfo )
                // $scope.reportCountList=response.rows;
                // $scope.paginationConf.totalItems=response.total;//更新总记录数
    //            searchYl(page,rows,   $scope.reportCountList[$scope.reportCountList.length-1].time+" 00:00:00",$scope.reportCountList[0].time+" 23:59:59",YlpayFlags.toString());
  //              searchWeiXinAndAli(page,rows,$scope.reportCountList[$scope.reportCountList.length-1].time+" 00:00:00",$scope.reportCountList[0].time+" 23:59:59",WeiXinAndAlipayFlags.toString());
//                searchElse(page,rows,$scope.reportCountList[$scope.reportCountList.length-1].time+" 00:00:00",$scope.reportCountList[0].time+" 23:59:59",elsepayFlags.toString())
            }
        );
    };


});