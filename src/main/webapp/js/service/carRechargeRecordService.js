//服务层
app.service('carRechargeRecordService',function($http){
    //搜索
    this.search=function(page,rows,startTimeStamp,outTimeStamp,searchEntity){
        return $http.post('../order/get-report-data?page='+page+"&rows="+rows+"&startTimeStamp="+startTimeStamp+"&outTimeStamp="+outTimeStamp, searchEntity,config);
    };

    var config = {
        headers: { 'Content-Type': 'application/json' }
    };
});