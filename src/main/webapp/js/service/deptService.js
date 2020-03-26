app.service('deptService',function($http){
    //搜索
    this.findPage=function(page,rows){
        return $http.post('../dept/findPage?page='+page+"&rows="+rows,config);
    };


    var config = {
        headers: { 'Content-Type': 'application/json' }
    };
});