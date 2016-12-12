/**
 * Created by 汪东兴 on 2016-12-11.
 * 自定义指令
 */

actionApp.directive('datePicker', function () {//定义一个datePicker
    return {
        restrict : 'AC', //限制为属性指令和样式指令
        link : function (scope, elem, attrs) { // 使用link方法类定义指令
            elem.datepicker(); //初始化jqueryui的datePicker
        }
    }
})
