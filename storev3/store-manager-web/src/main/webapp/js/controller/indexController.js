/*TbBrandController 控制层代码*/
app.controller('indexController',function($scope,loginService){
    //查询品牌列表
    $scope.login=function(){
        loginService.login().success(
            function(response){
                $scope.username=response.loginUserName;
            }
        );
    }

});