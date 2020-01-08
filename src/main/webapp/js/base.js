
<!--
        * author: Mr.liuchengming
        * create: 2020-01-03 10:35
       -->

// 定义模块:
var app = angular.module("cms",['pagination' , 'ngSanitize']);




// //$sce是angularJS自带的安全处理模块，$sce.trustAsHtml(input)方法便是将数据内容以html的形式进行解析并返回。
// // app.filter('trustHtml', function ($sce) {
// //     return function (input) {
// //         return $sce.trustAsHtml(input);
// //     }
// // });