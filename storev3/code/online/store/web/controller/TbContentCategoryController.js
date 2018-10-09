/*TbContentCategoryController 控制层代码*/
app.controller('tbContentCategoryController',function($scope,$controller,tbContentCategoryService){
    /*引入baseController*/
    $controller('baseController',{$scope:$scope});

    //查询品牌列表
    $scope.findAll=function(){
        tbContentCategoryService.findAll().success(
            function(response){
                $scope.list=response;
            }
        );
    }

    //分页
    $scope.findPage=function(page,size){
        tbContentCategoryService.findPage(page,size).success(
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
            object=tbContentCategoryService.update($scope.entity);
        }else {
            object=tbContentCategoryService.add($scope.entity);
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
        tbContentCategoryService.findOne(id).success(function (response) {
            $scope.entity=response;
        });
    };

    $scope.dele=function(){
        tbContentCategoryService.dele($scope.selectIds).success(
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
        tbContentCategoryService.search(page,size,$scope.searchEntity).success(
            function(response){
                $scope.list=response.rows;//显示当前页数据
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }
});