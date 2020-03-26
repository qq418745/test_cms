app.controller('deptController' ,function($scope,$controller,deptService){

    $controller('baseController',{$scope:$scope});//继承



    $scope.deptList={}; //集合

    //分页查询
    $scope.search=function(page,rows){
        deptService.findPage(page,rows).success(function (response) {
            $scope.deptList=response.rows;
            $scope.paginationConf.totalItems=response.total;//更新总记录数
        });
    };

    $scope.getRoles= function(dept){
        var rowNames = '';
        for (let i = 0; i < dept.roles.length ; i++) {
            rowNames +=  dept.roles[i].name+' ';
        }
        return rowNames;
    }




});