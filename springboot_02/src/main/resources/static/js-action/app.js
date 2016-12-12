/**
 * Created by 汪东兴 on 2016-12-11.
 * 模块和路由定义
 */
var actionApp = angular.module('actionApp',['ngRoute']);//定义模块actionApp,并依赖与路由模块ngRoute

actionApp.config(['$routeProvider', function ($routeProvider) {//配置路由，并注入$routeProvitder来配置
    $routeProvider.when('/oper', {//   /oper为路由名称
        controller : 'View1Controller',//controller定义控制器名称
        templateUrl : 'views/view1.html', //templateUrl定义视图真正地址
    }).when('/directive', {
        controller : 'View2Controller',
        templateUrl : 'views/view2.html',
    })
}])