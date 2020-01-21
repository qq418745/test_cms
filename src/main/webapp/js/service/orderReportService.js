//服务层
app.service('orderReportService',function($http){
    //搜索
    this.search=function(page,rows,startTimeStamp,outTimeStamp,searchEntity,exportType,payFlags,payFlagsNotIn){
        return $http.post('../order/get-report-data?page='+page+"&rows="+rows+"&startTimeStamp="+startTimeStamp+"&outTimeStamp="+outTimeStamp+"&exportType="+exportType+"&payFlags="+payFlags+"&payFlagsNotIn="+ (payFlagsNotIn === true ? true+"" : ""+false), searchEntity,config);
    };

    var config = {
        headers: { 'Content-Type': 'application/json' }
    };
});