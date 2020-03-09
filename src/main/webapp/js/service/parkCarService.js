

//服务层
app.service('parkCarService',function($http){
	    	

	//分页 
	this.findPage=function(page,rows){
		return $http.get('../parkCar/findPage?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../parkCar/findOne?id='+id);
	}


	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../parkCar/search?page='+page+"&rows="+rows, searchEntity);
	}    	
});
