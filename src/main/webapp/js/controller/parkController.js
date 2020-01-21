//控制层
app.controller('parkController' ,function($scope,$controller,parkService){

    $controller('baseController',{$scope:$scope});//继承

    $scope.searchEntity={};//定义搜索对象

    $scope.parkList={}; //停车场数据
    //搜索
    $scope.search=function(page,rows){
        parkService.search(page,rows,$scope.searchEntity).success(
            function(response){
                $scope.parkList=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }
    $scope.proxyStatus = function(park) {
        if (new Date() - new Date(park.lastUpdate) < 2 * 60 * 1000
            && park.proxyState === 1) {
            return trustHtml('<span style="color: green;">正常</span>');
        }
        return trustHtml('<span style="color: red;">断开</span>');
    };

    $scope.proxyType = function(park) {
        return {HJC: '汇九川', GM: '世茂', CK: '立方' ,GD: '光大',JBT: '九比特',RCB: '农商行'}[park.parkConfig && park.parkConfig.proxyType ? park.parkConfig.proxyType : 'HJC'];
    };
    //广告
    $scope.advType = function(park) {
        return {0: trustHtml(close), 1: trustHtml('<span style="color: green;">银联广告</span>')}[park.parkConfig && park.parkConfig.advSwitch ? park.parkConfig.advSwitch  : 0];
    };
    //默认城市
    $scope.cityType = function(park) {
         return park.parkConfig && park.parkConfig.city ? park.parkConfig.city  : '苏Ａ';
    };

    //强制关注公众号
    $scope.weiXinType = function(park) {
        return {0: trustHtml(close),1: trustHtml('<span style="color: green;">汇九川</span>')}[park.parkConfig && park.parkConfig.followSwitch ? park.parkConfig.followSwitch  : 0];
    };
    trustHtml('<span style="color: red;">退款失败</span>');
    $scope.invoiceType = function(park) {
        return {'NO': '不开具','YL': '银联','HT': '航天'}[park.parkConfig && park.parkConfig.invoiceType ? park.parkConfig.invoiceType  : 'NO'];
    };
    $scope.ylIndustryCodeType = function(park) {
        return park.parkConfig && park.parkConfig.ylIndustryCode ? trustHtml(open) : trustHtml(close);
    };

    var open = '<span style="color: green;">开启</span>';
    var close = '<span style="color: red;">关闭</span>';
});
