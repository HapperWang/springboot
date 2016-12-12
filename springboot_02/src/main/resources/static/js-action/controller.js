/**
 * Created by 汪东兴 on 2016-12-11.
 * 控制器定义
 */


//定义控制器，并注入'$rootScope', '$scope', '$http'
actionApp.controller('View1Controller', ['$rootScope', '$scope', '$http',
    function ($rootScope, $scope, $http) {
        //使用$scope.$on监听$viewContentLoaded事件，可以在页面内容加载完成后进行一些操作
        $scope.$on('$viewContentLoaded', function () {
            console.log('页面加载完成');
        });

        $scope.search = function () {//定义search 方法，在页面上通过ng-click调用
            personName = $scope.personName; //通过$scope获取页面定义的ng-model属性值
            $http.get('search', {//使用$http.get向服务器发送请求
                params:{personName : personName}// 使用params增加参数
            }).success(function (data) {//请求成功后回掉
                $scope.person = data;
                $('.dataResouce').css('display','');
            });
        };
}]);

actionApp.controller('View2Controller', ['$rootScope', '$scope',
    function ($rootScope, $scope) {
        $scope.$on('$viewContentLoaded', function () {
            console.log('页面加载完成');
        });
}]);