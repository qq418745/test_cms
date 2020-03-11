app.controller('configController' ,function($scope,$controller,configService){

    $controller('baseController',{$scope:$scope});//继承



    $scope.configList={}; //集合
    $scope.config={};
    $scope.myModalLabelTitle='';
    $scope.updateConfig = function(string,config){
        $scope.myModalLabelTitle=string;
        $scope.config=   JSON.parse(JSON.stringify(config));

        $scope.inputCheckInit();
    };

    //分页查询
    $scope.search=function(page,rows){
        configService.findPage(page,rows).success(function (response) {
            $scope.configList=response.rows;
            $scope.paginationConf.totalItems=response.total;//更新总记录数
        });
    };
    $scope.save=function () {
        configService.save(JSON.stringify($scope.config) ).success(function (response) {
            $scope.loadConfigList();
        });
    }
    $scope.add = function () {
        $scope.config={};
    }
    $scope.delete = function () {
        if(deleteId !== ''){
            configService.delete(deleteId).success(function (response) {
            $scope.loadConfigList();
        });
        }

    }

    $scope.loadConfigList=function () {
        $scope.search(1,$scope.paginationConf.itemsPerPage)
    }














});
