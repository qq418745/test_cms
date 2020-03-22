//控制层
app.controller('parkController' ,function($scope,$controller,parkService){

    $controller('baseController',{$scope:$scope});//继承

    $scope.searchEntity={};//定义搜索对象

    $scope.parkList={}; //停车场数据
    $scope.parkEntity={};
    $scope.ylIndustryCodeTypeSwitch= false; //无感支付
    $scope.payType = 2; //1微信支付宝 2银联
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

    $scope.proxyTypeArr = {HJC: '汇九川', GM: '世茂', CK: '立方' ,GD: '光大',JBT: '九比特',RCB: '农商行'};
    $scope.proxyType = function(park) {
        return $scope.proxyTypeArr[park.parkConfig && park.parkConfig.proxyType ? park.parkConfig.proxyType : 'HJC'];
    };

    //广告
    $scope.advTypeArr = {0:'关闭', 1:'银联广告'};
    $scope.advType = function(park) {
        return {0: trustHtml(close), 1: trustHtml('<span style="color: green;">银联广告</span>')}[park.parkConfig && park.parkConfig.advSwitch ? park.parkConfig.advSwitch  : 0];
    };
    //默认城市
    $scope.cityType = function(park) {
         return park.parkConfig && park.parkConfig.city ? park.parkConfig.city  : '苏Ａ';
    };

    //关注公众号类型
    $scope.weiXinTypeArr = {0:'关闭', 1:'汇九川'};
    $scope.weiXinType = function(park) {
        return {0: trustHtml(close),1: trustHtml('<span style="color: green;">汇九川</span>')}[park.parkConfig && park.parkConfig.followSwitch ? park.parkConfig.followSwitch  : 0];
    };


    //发票类型
    $scope.invoiceTypeArr =  {'NO': '不开具','YL': '银联','HT': '航天'};
    $scope.invoiceType = function(park) {
        return $scope.invoiceTypeArr[park.parkConfig && park.parkConfig.invoiceType ? park.parkConfig.invoiceType  : 'NO'];
    };
    $scope.ylIndustryCodeType = function(park) {
        return park.parkConfig && park.parkConfig.ylIndustryCode ? trustHtml(open) : trustHtml(close);
    };

    $scope.frontVersionArr =  [{n: '老版', v: 1}, {n: '新版', v: 2}];
    $scope.payTypeArr =   [{n: '公司微信，支付宝', v: 1}, {n: '银联', v: 2}];

    var open = '<span style="color: green;">开启</span>';
    var close = '<span style="color: red;">关闭</span>';

    $scope.parkEntiryUpdate =function (park) {

        if(! park.parkConfig){
            park.parkConfig={}
        }

        park.parkConfig.followSwitch ? park.parkConfig.followSwitch += '' : park.parkConfig.followSwitch = "0";
        park.parkConfig.proxyType  =  park.parkConfig.proxyType ? park.parkConfig.proxyType : 'HJC';
        park.parkConfig.invoiceType = park.parkConfig.invoiceType ? park.parkConfig.invoiceType  : 'NO';
        park.parkConfig.city =  $scope.cityType(park);
        park.parkConfig.advSwitch ? park.parkConfig.advSwitch  += '':  park.parkConfig.advSwitch ="0";
        $scope.ylIndustryCodeTypeSwitch  =     ! isBlank(park.parkConfig.ylIndustryCode);
        $scope.parkEntity = JSON.parse(JSON.stringify(park))  ;
    }

    $scope.ylIndustryCodeHandle =function(){
        if($scope.ylIndustryCodeTypeSwitch){
            //打开
            $('#inputModal') .modal('show');
            $scope.ylIndustryCodeTypeSwitch =false;
        }else{
            //关闭
            $('#exampleModalCenter').modal('show');
            $scope.ylIndustryCodeTypeSwitch =true;

        }
    }


    $scope.save=function(){

        if (! $scope.payType === 2) {
            $scope.parkEntity.ylConfig.id=null;
            $scope.parkEntity.ylConfig.mid=null;
            $scope.parkEntity.ylConfig.tid=null;
            $scope.parkEntity.aliConfig.id=1;
            $scope.parkEntity.wxConfig.id=1;
        }

         $scope.parkEntity.parkConfig.parkId =$scope.parkEntity.parkId;

        parkService.save( $scope.parkEntity).success(function (response) {
            $scope.search(1,$scope.paginationConf.itemsPerPage);
        });
    }
    $scope.tt=function () {

        alert(JSON.stringify($scope.parkEntity.parkConfig) );
    }




  // 弹出框效果
    $(function(){
        $(".wrap li").click(function() {
            $(this).siblings('li').removeClass('active');  // 删除其兄弟元素的样式
            $(this).addClass('active');                    // 为点击元素添加类名
        })});


    $scope.newParkDefault= function(){

        var park = {};
        park.parkConfig = {};
        //微信关注默认关闭 0
        park.parkConfig.followSwitch ? park.parkConfig.followSwitch += '' : park.parkConfig.followSwitch = "0";
        //默认停车场类型
        park.parkConfig.proxyType  =  park.parkConfig.proxyType ? park.parkConfig.proxyType : 'HJC';
        //默认发票关闭
        park.parkConfig.invoiceType = park.parkConfig.invoiceType ? park.parkConfig.invoiceType  : 'NO';
        park.parkConfig.city =  $scope.cityType(park);
        //广告默认关闭 0
        park.parkConfig.advSwitch ? park.parkConfig.advSwitch  += '':  park.parkConfig.advSwitch ="0";
        //超时时间
        park.parkConfig.duration = 15;
        park.parkConfig.ylAppId = 'JSYSTCH';
        $scope.payType = 2;
        park.parkConfig.frontVersion = 1;
        $scope.parkEntity =  park;

    }





});
