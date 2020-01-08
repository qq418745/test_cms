
<!--
        * author: Mr.liuchengming
        * create: 2020-01-03 10:35
       -->

//服务层
app.service('orderService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../order/findAll');
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../order/findPage?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../order/findOne?id='+id);
	}

	//增加 
	this.add=function(entity){
		return  $http.post('../order/add',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../order/update',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../order/delete?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../order/search?page='+page+"&rows="+rows, searchEntity);
	}    	
});
