//控制层
app.controller('orderReportController' ,function($scope,$controller,orderReportService){

    $controller('baseController',{$scope:$scope});//继承



    $scope.typeArray  = [{id: 0, name: '日报'},{id:1, name: '月报'},{id:2,name:'年报'}];
    $scope.typeArrayIndex = 0;
    $scope.typeSwitch=function(index){

    };



  $scope.reportList={}; //集合
     // reportCountList={};   //总
     // reportYlList={};      //银联
     // reportWXAndAilList={};// 微信支付宝
     // reportOtherList={};  // 其他的

    $scope.exportType=1;  // 1 日报  2 月报  3 年报
    $scope.searchEntity={};//定义搜索对象  order表

 var YlpayFlags = [2,3,4,5];  //银联渠道
 var WeiXinAndAlipayFlags = [0,1]; // 支付宝微信
 var elsepayFlags = [2,3,4,5,0,1]; //除了银联和微信支付宝 (其他)
    //搜索分页查询
    $scope.search=function(page,rows){

        if(  $scope.exportType === 1){

            orderReportService.search(page,rows,"","",$scope.searchEntity, $scope.exportType,"").success(
                function(response){
                    $scope.reportCountList=response.rows;
                    $scope.paginationConf.totalItems=response.total;//更新总记录数
                    searchYl(page,rows,   $scope.reportCountList[$scope.reportCountList.length-1].day+" 00:00:00",$scope.reportCountList[0].day+" 23:59:59",YlpayFlags.toString());
                    searchWeiXinAndAli(page,rows,$scope.reportCountList[$scope.reportCountList.length-1].day+" 00:00:00",$scope.reportCountList[0].day+" 23:59:59",WeiXinAndAlipayFlags.toString());
                    searchElse(page,rows,$scope.reportCountList[$scope.reportCountList.length-1].day+" 00:00:00",$scope.reportCountList[0].day+" 23:59:59",elsepayFlags.toString())
                }
            );

        }
    };
     function searchYl(page,rows,startTimeStamp,outTimeStamp,payFlags) {
         orderReportService.search(page,rows,startTimeStamp,outTimeStamp,$scope.searchEntity, $scope.exportType,payFlags).success(
             function(response){

                     for(var i = 0 ;i < $scope.reportCountList.length;i++ ){

                         for(var j = 0 ; j < response.rows.length ; j++){
                             if($scope.reportCountList[i].day === response.rows[j].day ){
                                 $scope.reportCountList[i].YlConut =    response.rows[j];
                                 break;
                             }
                         }

                     }

             }

         );
    }

    function searchWeiXinAndAli(page,rows,startTimeStamp,outTimeStamp,payFlags) {
        orderReportService.search(page,rows,startTimeStamp,outTimeStamp,$scope.searchEntity, $scope.exportType,payFlags).success(
            function(response){


                for(var i = 0 ;i < $scope.reportCountList.length;i++ ){

                    for(var j = 0 ; j < response.rows.length ; j++){
                        if($scope.reportCountList[i].day === response.rows[j].day ){
                            $scope.reportCountList[i].weiXinAndAliConut =    response.rows[j];
                            break;
                        }
                    }

                }
            }
        );
    }


    function searchElse(page,rows,startTimeStamp,outTimeStamp,payFlags) {
        orderReportService.search(page,rows,startTimeStamp,outTimeStamp,$scope.searchEntity, $scope.exportType,payFlags,true).success(
            function(response){

                for(var i = 0 ;i < $scope.reportCountList.length;i++ ){

                    for(var j = 0 ; j < response.rows.length ; j++){
                        if($scope.reportCountList[i].day === response.rows[j].day ){
                            $scope.reportCountList[i].reportOtherList =    response.rows[j];
                            break;
                        }
                    }

                }
            }
        );
    }



});
