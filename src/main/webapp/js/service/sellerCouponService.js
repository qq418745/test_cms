app.service('sellerCouponService',function ($http) {

    //搜索
    this.search=function(page,rows,searchEntity){
        return $http.post('../seller-coupon/obtain?page='+page+"&rows="+rows, searchEntity,config);
    }

    //搜索
    this.searchManager=function(page,rows){
        return $http.post('../seller-coupon/allSellers?page='+page+"&rows="+rows,{} ,config);
    }

    //搜索
    this.getUserMap=function(){
        return $http.post('../seller-coupon/getUserMap',{} ,config);
    }


    var config = {
        headers: { 'Content-Type': 'application/json' }
    };
});