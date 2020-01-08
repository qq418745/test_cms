<!--
        * author: Mr.liuchengming
        * create: 2020-01-03 10:35
       -->

//控制层
app.controller('orderController' ,function($scope,$controller,orderService){
	
	$controller('baseController',{$scope:$scope});//继承

     //PAY_YL_WX = 3, PAY_YL_ALI = 4, PAY_YL_CLOUD = 5
    $scope.payFlayArray = ["微信", "支付宝", "银联", "银联(微)", "银联(支)", "银联(云)", "招行", "农商行(云)", "农商行(微)", "农商行(支)","pos扫码"];
    $scope.payStatusArray = [{name:'全部'},{id: 0, name: '未支付'},{id:1, name: '完成'},{id:2,name:'失败'},{id:7,name:'退款成功'},{id:8,name:'退款失败'}];
    $scope.payStatusArrayIndex = 0;
    $scope.payStatusSwitch = function(index){
        $scope.payStatusArrayIndex = index;
        if(index === 0){
            //notifyStatus条件 清除
            delete $scope.searchEntity.payStatus;
        }else{
            //加入notifyStatus条件 查询 页面
            $scope.searchEntity.payStatus = $scope.payStatusArray[index].id;

        }
        $scope.search(1,$scope.paginationConf.itemsPerPage);
    };

    $scope.notifyStatusArray  = [{name:'全部'},{id: 0, name: '未通知'},{id:1, name: '成功'},{id:2,name:'失败'}];
    $scope.notifyStatusArrayIndex = 0;
    $scope.notifyStatusSwitch = function(index){
        $scope.notifyStatusArrayIndex = index;
        if(index === 0){
            //notifyStatus条件 清除
          delete $scope.searchEntity.notifyStatus;
        }else{
            //加入notifyStatus条件 查询 页面
            $scope.searchEntity.notifyStatus = $scope.notifyStatusArray[index].id;

        }
            $scope.search(1,$scope.paginationConf.itemsPerPage);

    };



     //支付状态显示
    $scope.payStatus = function(v) {
        switch (v) {
            case 0:
                return '未支付';
            case 1:
                return  trustHtml('<span style="color: green;">完成</span>');
            case 2:
                return trustHtml('<span style="color: red;">失败</span>');
            case 7:
                return trustHtml('<span style="color: green;">退款成功</span>');
            case 8:
                return trustHtml('<span style="color: red;">退款失败</span>');
            default:
                return '未知';
        }
    };
    //通知状态显示
    $scope.notifyStatus = function(v) {
        if (v === 1) {
            return trustHtml('<span style="color: green;">成功</span>');
        }
        if (v === 2) {
            return trustHtml('<span style="color: red;">失败</span>');
        }
        return '未通知';
    };
	//分页
	$scope.findPage=function(page,rows){
		orderService.findPage(page,rows).success(
			function(response){
				$scope.orderList=response.rows;
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}
		);
	}

	//查询实体
	$scope.findOne=function(id){
		orderService.findOne(id).success(
			function(response){
				$scope.entity= response;
			}
		);
	}






	$scope.searchEntity={};//定义搜索对象

	//搜索分页查询
	$scope.search=function(page,rows){
		orderService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.orderList=response.rows;
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}
		);
	}








});	
