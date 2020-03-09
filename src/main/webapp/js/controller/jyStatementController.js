app.controller('jyStatementController' ,function($scope,$controller,jyStatementService){

    $controller('baseController',{$scope:$scope});//继承



    $scope.typeArray  = [{id: 0, name: '全部'},{id:1, name: ' 111测试停车场'},{id:2,name:'农商行测试停车场'}];
    $scope.typeArrayIndex = 0;
    $scope.typeSwitch=function(index){
        $scope.exportType= index+1;
        $scope.search(1,$scope.paginationConf.itemsPerPage)
    };



    $scope.jyStatementList={}; //集合


    $scope.exportType=1;  // 1 日报  2 月报  3 年报
    $scope.searchEntity={};//定义搜索对象  order表


    //搜索分页查询
    $scope.search=function(page,rows){
        jyStatementService.search(page,rows,null,null,$scope.searchEntity).success(
            function(response){
                $scope.jyStatementList=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
                //searchYl(page,rows,   $scope.reportCountList[$scope.reportCountList.length-1].time+" 00:00:00",$scope.reportCountList[0].time+" 23:59:59",YlpayFlags.toString());
            }
        );
    };


});
