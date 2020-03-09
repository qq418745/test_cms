app.service('homeService',function($http){
    //查询收款类型占比
    this.findChargeType=function(){
        return $http.post('../statistics/chargeType',config);
    };

    var config = {
        headers: { 'Content-Type': 'application/json' }
    };
});