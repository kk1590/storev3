/*TbItemCatController 控制层代码*/
app.controller('tbItemCatController',function($scope,$controller,tbItemCatService){
    /*引入baseController*/
    $controller('baseController',{$scope:$scope});

    //查询品牌列表
    $scope.findAll=function(){
        tbItemCatService.findAll().success(
            function(response){
                $scope.list=response;
            }
        );
    }

    //分页
    $scope.findPage=function(page,size){
        tbItemCatService.findPage(page,size).success(
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
            object=tbItemCatService.update($scope.entity);
        }else {
            object=tbItemCatService.add($scope.entity);
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
        tbItemCatService.findOne(id).success(function (response) {
            $scope.entity=response;
        });
    };

    $scope.dele=function(){
        tbItemCatService.dele($scope.selectIds).success(
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
        tbItemCatService.search(page,size,$scope.searchEntity).success(
            function(response){
                $scope.list=response.rows;//显示当前页数据
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }

    $scope.selectByPrimaryParentId=function (parentId) {
        tbItemCatService.selectByPrimaryParentId(parentId).success(
            function (response) {
                $scope.list=response;
            }
        )
    }

    $scope.grade=1;

    $scope.setGrade=function(value){
        $scope.grade=value;
    }

    $scope.selectList=function (p_entity) {
        if ($scope.grade==1){
            $scope.entity_1=null;
            $scope.entity_2=null;
        } if ($scope.grade==2){
            $scope.entity_1=p_entity;
            $scope.entity_2=null;
        }if($scope.grade==3){
            $scope.entity_2=p_entity;
        }
        $scope.selectByPrimaryParentId(p_entity.id);
    }
});