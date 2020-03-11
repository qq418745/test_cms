app.service('configService',function($http){
    //搜索
    this.findPage=function(page,rows){
        return $http.post('../conf/findPage?page='+page+"&rows="+rows,config);
    };


    this.save=function(conf){
        return $http.post('../conf/save',conf,config);
    };

    this.delete=function(confId){
        return $http.post('../conf/delete?confId='+confId,{},config);
    };

    var config = {
        headers: { 'Content-Type': 'application/json' }
    };
});