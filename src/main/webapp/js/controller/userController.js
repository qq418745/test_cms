app.controller('userController' ,function($scope,$controller,userService){

    $controller('baseController',{$scope:$scope});//继承



    $scope.userList={}; //集合

    //分页查询
    $scope.search=function(page,rows){
        userService.findPage(page,rows).success(function (response) {
            $scope.userList=response.rows;
            $scope.paginationConf.totalItems=response.total;//更新总记录数
        });
    };




});
