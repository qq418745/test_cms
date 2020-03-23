app.controller('sellerCouponController' ,function($scope,$controller,sellerCouponService){

    $controller('baseController',{$scope:$scope});//继承


    $scope.searchEntity={};//定义搜索对象
    $scope.sellerCouponList={}; //优惠劵派发记录集合
    $scope.managerList={}; //商户集合
    var userMap= new Map(); //商户集合

    //分页查询
    $scope.search=function(page,rows){
        sellerCouponService.search(page,rows, $scope.searchEntity).success(function (response) {
            $scope.sellerCouponList=response.rows;
            $scope.paginationConf.totalItems=response.total;//更新总记录数
        });
    };

    $scope.searchManager=function (page,rows) {
        sellerCouponService.getUserMap().success(function (response) {

            userMap =  response.info;

            sellerCouponService.searchManager(page,rows).success(function (response) {
                $scope.managerList=response.rows;
                for (let i = 0; i < $scope.managerList.length; i++) {
                    $scope.managerList[i].userId = userMap[$scope.managerList[i].manager];
                }
                $scope.paginationConf.totalItems=response.total;//更新总记录数

            });
        });

    }





});
