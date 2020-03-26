app.service('roleService',function($http){
       //搜索
    this.findPage=function(page,rows){
        return $http.post('../role/findPage?page='+page+"&rows="+rows,config);
    };

    //保存
    this.save=function(entity,deptId){
        return $http.post('../role/save?deptId='+deptId,entity,config);
    };



    var config = {
        headers: { 'Content-Type': 'application/json' }
    };
});