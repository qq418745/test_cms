app.service('userService',function($http){
    //搜索
    this.findPage=function(page,rows){
        return $http.post('../user/findPage?page='+page+"&rows="+rows,config);
    };

    var config = {
        headers: { 'Content-Type': 'application/json' }
    };
});