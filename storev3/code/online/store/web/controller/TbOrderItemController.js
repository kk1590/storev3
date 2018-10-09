/*TbOrderItemController 控制层代码*/
app.controller('tbOrderItemController',function($scope,$controller,tbOrderItemService){
    /*引入baseController*/
    $controller('baseController',{$scope:$scope});

    //查询品牌列表
    $scope.findAll=function(){
        tbOrderItemService.findAll().success(
            function(response){
                $scope.list=response;
            }
        );
    }

    //分页
    $scope.findPage=function(page,size){
        tbOrderItemService.findPage(page,size).success(
            function(response){
                $scope.list=response.rows;//显示当前页数据
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }

    //新增
    $scope.save=function(){
        var object;
        if($scope.entity.id!=null){
            object=tbOrderItemService.update($scope.entity);
        }else {
            object=tbOrderItemService.add($scope.entity);
        }
        object.success(function (response) {
            if(response.success){
                $scope.reloadList();
            }else {
                alert(response.message);
            }
        });
    };

    $scope.findOne=function(id){
        tbOrderItemService.findOne(id).success(function (response) {
            $scope.entity=response;
        });
    };

    $scope.dele=function(){
        tbOrderItemService.dele($scope.selectIds).success(
            function (response) {
                if(response.success){
                    $scope.reloadList();
                }else{
                    alert(response.message);
                }
            })
    }

    $scope.searchEntity={};
    //分页
    $scope.search=function(page,size){
        tbOrderItemService.search(page,size,$scope.searchEntity).success(
            function(response){
                $scope.list=response.rows;//显示当前页数据
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }
});