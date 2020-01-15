//控制层
app.controller('orderReportController' ,function($scope,$controller,orderReportService){

    $controller('baseController',{$scope:$scope});//继承







  $scope.reportList={}; //集合
    $scope.reportCountList={}; //总
    $scope.reportYlList={}; //银联
    $scope.reportWXAndAilList={};// 微信支付宝
    $scope.reportOtherList={};// 其他的支付宝

    $scope.exportType=1;  // 1 日报  2 月报  3 年报
    $scope.searchEntity={};//定义搜索对象  order表

 var YlpayFlags = [2,3,4,5];
 var WeiXinAndAlipayFlags = [0,1];
 var elsepayFlags = [2,3,4,5,0,1];
    //搜索分页查询
    $scope.search=function(page,rows){

        if(  $scope.exportType === 1){

            orderReportService.search(page,rows,"","",$scope.searchEntity, $scope.exportType,"").success(
                function(response){
                    $scope.reportCountList=response.rows;
                    $scope.paginationConf.totalItems=response.total;//更新总记录数
                    searchYl(page,rows,   $scope.reportCountList.,"",YlpayFlags.toString());
                    searchWeiXinAndAli(page,rows,"","",WeiXinAndAlipayFlags.toString())
                }
            );

            //银联渠道
           // searchEX(page,rows,"","",$scope.searchEntity, $scope.exportType,   $scope.reportWXAndAilList);
        }
    };
     function searchYl(page,rows,startTimeStamp,outTimeStamp,payFlags) {
         orderReportService.search(page,rows,startTimeStamp,outTimeStamp,$scope.searchEntity, $scope.exportType,payFlags).success(
             function(response){
                 //$scope.reportYlList =response.rows;
                 for(i = 0 ;i < $scope.reportCountList.length;i++ ){
                     if($scope.reportCountList[i].day === response.rows[i].day ){
                     $scope.reportCountList[i].YlConut =    response.rows[i];
                     }
                 }
             }

         );
    }

    function searchWeiXinAndAli(page,rows,startTimeStamp,outTimeStamp,payFlags) {
        orderReportService.search(page,rows,startTimeStamp,outTimeStamp,$scope.searchEntity, $scope.exportType,payFlags).success(
            function(response){
                //$scope.reportYlList =response.rows;
                for(i = 0 ;i < $scope.reportCountList.length;i++ ){
                    $scope.reportCountList[i].weiXinAndAliConut =    response.rows[i];
                }
            }
        );
    }



});
