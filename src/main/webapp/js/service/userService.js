app.service('userService',function($http){
    //搜索
    this.findPage=function(page,rows){
        return $http.post('../user/findPage?page='+page+"&rows="+rows,config);
    };

    //查当前用户
    this.findCurrentUser=function(){
        return $http.post('../user/currentUser',config);
    };


    this.getCurrentUserMods=function( currentUser){
           var mods =  new Array();
        for (let i = 0; i < currentUser.roles.length; i++) {
            for (let j = 0; j < currentUser.roles[i].mods.length; j++) {
                var flag = true;
                //去重
                for (let k = 0; k < mods.length; k++) {
                    if(mods[k].id  === currentUser.roles[i].mods[j].id){
                        flag=false;
                        break;
                    }
                }
                flag ?  mods.push( currentUser.roles[i].mods[j]) : flag=true;
            }
        }
        return mods;
    };

    var config = {
        headers: { 'Content-Type': 'application/json' }
    };
});