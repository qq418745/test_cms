
//控制层
app.controller('parkCarController' ,function($scope,$controller,parkCarService){
	
	$controller('baseController',{$scope:$scope});//继承

	//分页
	$scope.findPage=function(page,rows){
		parkCarService.findPage(page,rows).success(
			function(response){
				$scope.parkCarList=response.rows;
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}
		);
	}

	//查询实体
	$scope.findOne=function(id){
        parkCarService.findOne(id).success(
			function(response){
				$scope.entity= response;
			}
		);
	}






	$scope.searchEntity={};//定义搜索对象

	//搜索分页查询
	$scope.search=function(page,rows){
		parkCarService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.parkCarList=response.rows;
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}
		);

	}








});	
