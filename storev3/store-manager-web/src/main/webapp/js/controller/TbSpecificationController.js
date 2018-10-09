/*TbSpecificationController 控制层代码*/
app.controller('tbSpecificationController',function($scope,$controller,tbSpecificationService){
    /*引入baseController*/
    $controller('baseController',{$scope:$scope});

    //查询品牌列表
    $scope.findAll=function(){
        tbSpecificationService.findAll().success(
            function(response){
                $scope.list=response;
            }
        );
    }

    //分页
    $scope.findPage=function(page,size){
        tbSpecificationService.findPage(page,size).success(
            function(response){
                $scope.list=response.rows;//显示当前页数据
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }

    //新增
    $scope.save=function(){
        var object;
        if($scope.entity.tbSpecification.id!=null){
            object=tbSpecificationService.update($scope.entity);
        }else {
            object=tbSpecificationService.add($scope.entity);
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
        tbSpecificationService.findOne(id).success(function (response) {
            $scope.entity=response;
        });
    };

    $scope.dele=function(){
        tbSpecificationService.dele($scope.selectIds).success(
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
        tbSpecificationService.search(page,size,$scope.searchEntity).success(
            function(response){
                $scope.list=response.rows;//显示当前页数据
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }

    $scope.addTableRow=function () {
        $scope.entity.specificationOptionList.push({});
    }
    $scope.deleteTableRow=function (index) {
        $scope.entity.specificationOptionList.splice(index,1);
    }


});