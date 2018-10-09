/*TbSeckillOrderController 控制层代码*/
app.controller('tbSeckillOrderController',function($scope,$controller,tbSeckillOrderService){
    /*引入baseController*/
    $controller('baseController',{$scope:$scope});

    //查询品牌列表
    $scope.findAll=function(){
        tbSeckillOrderService.findAll().success(
            function(response){
                $scope.list=response;
            }
        );
    }

    //分页
    $scope.findPage=function(page,size){
        tbSeckillOrderService.findPage(page,size).success(
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
            object=tbSeckillOrderService.update($scope.entity);
        }else {
            object=tbSeckillOrderService.add($scope.entity);
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
        tbSeckillOrderService.findOne(id).success(function (response) {
            $scope.entity=response;
        });
    };

    $scope.dele=function(){
        tbSeckillOrderService.dele($scope.selectIds).success(
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
        tbSeckillOrderService.search(page,size,$scope.searchEntity).success(
            function(response){
                $scope.list=response.rows;//显示当前页数据
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }
});