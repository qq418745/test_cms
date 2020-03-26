app.controller('indexController' ,function($scope,$controller,userService){

    $controller('baseController',{$scope:$scope});//继承




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


    $scope.idIsModParent= function (id , mods) {
        for (let i = 0; i <mods.length ; i++) {
            if(mods[i].parentId === id){
                return  true;
            }
        }
         return  false;
    }


});
