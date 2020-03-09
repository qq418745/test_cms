app.controller('configController' ,function($scope,$controller,configService){

    $controller('baseController',{$scope:$scope});//继承



    $scope.configList={}; //集合

    //分页查询
    $scope.search=function(page,rows){
        configService.findPage(page,rows).success(function (response) {
            $scope.configList=response.rows;
            $scope.paginationConf.totalItems=response.total;//更新总记录数
        });
    };




});
