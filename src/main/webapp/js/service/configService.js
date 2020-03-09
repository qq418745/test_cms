app.service('configService',function($http){
    //搜索
    this.findPage=function(page,rows){
        return $http.post('../conf/findPage?page='+page+"&rows="+rows,config);
    };

    var config = {
        headers: { 'Content-Type': 'application/json' }
    };
});