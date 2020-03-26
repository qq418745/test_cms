app.controller('roleController' ,function($scope,$controller,roleService,userService){

    $controller('baseController',{$scope:$scope});//继承



   /*
     role 和 index 公有部分
    */
    $scope.currentUser={}; //当前用户
    $scope.mods= new Array(); //当前用户mods

    //查询当前用户
    $scope.findCurrentUser=function(){
        userService.findCurrentUser().success(function (response) {
            if(response.success){
                $scope.currentUser=response.info;
                $scope.mods  =  userService.getCurrentUserMods( $scope.currentUser);
            }

        });
    };
    //mod
    $scope.idIsModParent= function (id , mods) {
        for (let i = 0; i <mods.length ; i++) {
            if(mods[i].parentId === id){
                return  true;
            }
        }
        return  false;
    }
    /*
   role 和 index 公有部分结束
  */


    $scope.roleList={}; //集合
    $scope.roleEntity={};
    $scope.roleEntity.mods=[];
    $scope.deptId='0'; //公司


    //分页查询
    $scope.search=function(page,rows){
        roleService.findPage(page,rows).success(function (response) {
            $scope.roleList=response.rows;
            $scope.paginationConf.totalItems=response.total;//更新总记录数
        });
    };

    $scope.save=function(){
        //获取所有选中的 modBox
        getChecked('modBox').split(',').forEach(v=>{
                let mod = {};
                mod.id=v;
                $scope.roleEntity.mods.push(mod);
            }
        );

        roleService.save($scope.roleEntity,$scope.deptId).success(function (response) {
            $scope.search(1,$scope.paginationConf.itemsPerPage);
        });
    }
        $scope.delete=function () {
            roleService.delete(deleteId).success(function (response) {
                $scope.search(1,$scope.paginationConf.itemsPerPage);
            });
        }



 /*
   角色修改  3层复选框部分 开始
  */
    function seleteCheckbox(flag,id){
        var inputs = document.getElementById('mod'+id).getElementsByTagName("input");

        for (var i=0; i < inputs.length; i++) {
            if (inputs[i].type === "checkbox" ) {
                    inputs[i].checked = flag;
            }
        }
    }

    //flag 层级标志 1 2 3 层
    function setCheckbox(flag,id){
        document.getElementById('input'+id).checked = flag;
    }
    function updateModBox(id){
        if($("input:checkbox[name="+'modBox'+ id+"]:checked").length === 0  ){
            setCheckbox(false,id);
        }else{
            setCheckbox(true,id);
        }
    }
    $scope.disposeMods= function(event,id,flag,modId,modId2){
    if(flag === 1 ){
        seleteCheckbox(event.target.checked,id);
    }
    if(flag ===2){
        seleteCheckbox(event.target.checked,id);
        //父类也勾选
        updateModBox(modId);


    }
    if(flag ===3){
        if($("input:checkbox[name="+'modBox'+ modId+"]:checked").length === 0  ){
            setCheckbox(false,modId);
            setCheckbox(false,modId2);
        }else{
            setCheckbox(true,modId);
            setCheckbox(true,modId2);

        }
    }
        var thee =  event.target.checked;

        //刷新复选框
        setTimeout(function(){
            event.target.checked =thee;
        },50);　　　　//延时0.35秒  设置复选框值 解决复选框bug
    }



    $scope.getModNames = function(mods){
        var modNames = '';
        for (let i = 0; i < mods.length; i++) {

            modNames += mods[i].name+' '
        }
        return modNames;
    }


    /**获取 id sidebar 内 checkbox 被选中的值*/
    function getChecked(){
        var ids = "";
        let inputs = document.getElementById('sidebar').getElementsByTagName("input");
        let flag = 0;
        for (var i=0; i < inputs.length; i++) {
            if (inputs[i].type === "checkbox"  && inputs[i].checked) {
                    flag > 0 ? ids += ","+ inputs[i].value : ids =  inputs[i].value;
                    flag++;
            }
        }
        return ids;
    }


    //修改按钮 初始化 复选框
    $scope.updateRoleEntity = function(role){
        $scope.roleEntity=role;
        var mods = role.mods;
        mods.forEach(mod=>{
        document.getElementById('input'+mod.id).checked = true;
        });
    }


    /*
      角色修改  3层复选框部分 结束
     */

});