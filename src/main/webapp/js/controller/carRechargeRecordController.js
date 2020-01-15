//控制层
app.controller('carRechargeRecordController' ,function($scope,$controller,carRechargeRecordService){

    $controller('baseController',{$scope:$scope});//继承








    $scope.reportList={};//定义搜索对象
    $scope.searchEntity={};//定义搜索对象


    //搜索分页查询
    $scope.search=function(page,rows){

        orderService.search(page,rows,isBlank($('#startTimeStamp').val() ) ? "" : $('#startTimeStamp').val()+" 23:59:59",isBlank($('#outTimeStamp').val())? "":$('#outTimeStamp').val()+" 00:00:00",$scope.searchEntity).success(
            function(response){
                $scope.reportList=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    };



    $scope.autoRefreshSwitchVaule=false;
    $scope.autoRefreshSwitch=function(){
        $scope.autoRefreshSwitchVaule =  !  $scope.autoRefreshSwitchVaule;
        autoRefresh();
    };




});
