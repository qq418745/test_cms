app.service('jyStatementService',function($http){
    //搜索
    this.search=function(page,rows,startTime,endTime,searchEntity){
        return $http.post('../parkStatement/search?page='+page+"&rows="+rows+"&startTime="+startTime+"&endTime="+endTime, searchEntity,config);
    };

    var config = {
        headers: { 'Content-Type': 'application/json' }
    };
});