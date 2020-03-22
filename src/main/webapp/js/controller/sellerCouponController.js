app.controller('sellerCouponController' ,function($scope,$controller,sellerCouponService){

    $controller('baseController',{$scope:$scope});//继承


    $scope.searchEntity={};//定义搜索对象
    $scope.sellerCouponList={}; //集合

    //分页查询
    $scope.search=function(page,rows){
        sellerCouponService.search(page,rows, $scope.searchEntity).success(function (response) {
            $scope.sellerCouponList=response.rows;
            $scope.paginationConf.totalItems=response.total;//更新总记录数
        });
    };




});
