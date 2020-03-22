app.service('sellerCouponService',function ($http) {

    //搜索
    this.search=function(page,rows,searchEntity){
        return $http.post('../seller-coupon/obtain?page='+page+"&rows="+rows, searchEntity,config);
    }



    var config = {
        headers: { 'Content-Type': 'application/json' }
    };
});