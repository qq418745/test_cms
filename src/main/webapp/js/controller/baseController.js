app.controller("baseController",function($scope,$sce){
	// 分页的配置的信息
	$scope.paginationConf = {
		 currentPage: 1, // 当前页数
		 totalItems: 10, // 总记录数
		 itemsPerPage: 20, // 每页显示多少条记录
		 perPageOptions: [10, 20, 30, 40, 50],// 显示多少条下拉列表
		 onChange: function(){ // 当页码、每页显示多少条下拉列表发生变化的时候，自动触发了
			$scope.reloadList();// 重新加载列表
		 }
	}; 
	
	$scope.reloadList = function(){
		//$scope.findPage($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
		 $scope.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
	}


      //输入框效果
    $('.input-check')
        .focus(function() {
            $(this).css({ 'border': '1px solid #28a745', 'background': '#fff' });
        })
        .blur(function() {
            var value = $(this).val(); // 获取值
            if (value == '') {// 判断是否是空字符串，而不是null
                $(this).css({ 'border': '1px solid #dc3545', 'background': '#fff' });
                return false;
            }
        })

	//输入框
	$scope.inputCheckInit=function(){
        var input = $('.input-check');
        // var value = input.val();
        // if (value == '') {// 判断是否是空字符串，而不是null
        //     input.css({ 'border': '1px solid #dc3545', 'background': '#fff' });
        // }else{
            input.css({ 'border': '1px solid #28a745', 'background': '#fff' });
		// }

	}
    //输入框
    $scope.inputInit=function(){
         $('.input-check').css({ 'border': '1px solid #000', 'background': '#fff' });
    }

      //方法返回内容解析位 html
    trustHtml =function(input){
        return $sce.trustAsHtml(input);
    };
	
	// 定义一个数组:
	$scope.selectIds = [];
	// 更新复选框：
	$scope.updateSelection = function($event,id){
		// 复选框选中
		if($event.target.checked){
			// 向数组中添加元素
			$scope.selectIds.push(id);
		}else{
			// 从数组中移除
			var idx = $scope.selectIds.indexOf(id);
			$scope.selectIds.splice(idx,1);
		}
		
	}


    deleteId = '';
    // 更新deleteId：
    $scope.updateDeleteId = function(id){
        deleteId = id;
    }
	
	// 定义方法：获取JSON字符串中的某个key对应值的集合
	$scope.jsonToString = function(jsonStr,key){
		// 将字符串转成JSOn:
		var jsonObj = JSON.parse(jsonStr);
		
		var value = "";
		for(var i=0;i<jsonObj.length;i++){
			
			if(i>0){
				value += ",";
			}
			
			value += jsonObj[i][key];
		}
		return value;
	}


    isNullCharacter = function(v) {
        return  v === "";
    };
    isBlank = function(v) {
        return (v === null) || (v === undefined) || (v === '') || (Array.isArray(v) && v.length === 0);
    };


});