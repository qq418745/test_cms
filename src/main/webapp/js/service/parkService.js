app.service('parkService',function ($http) {

    //搜索
    this.search=function(page,rows,searchEntity){
    return $http.post('../park/search?page='+page+"&rows="+rows, searchEntity,config);
    }
    var config = {
        headers: { 'Content-Type': 'application/json' }
    };
});