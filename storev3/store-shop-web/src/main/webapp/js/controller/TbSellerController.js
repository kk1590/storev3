/*TbSellerController 控制层代码*/
app.controller('tbSellerController', function ($scope, $controller, tbSellerService) {
    /*引入baseController*/
    $controller('baseController', {$scope: $scope});

    //查询品牌列表
    $scope.findAll = function () {
        tbSellerService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        );
    }

    //分页
    $scope.findPage = function (page, size) {
        tbSellerService.findPage(page, size).success(
            function (response) {
                $scope.list = response.rows;//显示当前页数据
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    }

    //新增
    $scope.add = function () {
        tbSellerService.add($scope.entity).success(function (response) {
                if(response.success){
                    location.href="/shoplogin.html";
                }else {
                    alert(response.message);
                }

        });
    };

    $scope.findOne = function (id) {
        tbSellerService.findOne(id).success(function (response) {
            $scope.entity = response;
        });
    };

    $scope.dele = function () {
        tbSellerService.dele($scope.selectIds).success(
            function (response) {
                if (response.success) {
                    $scope.reloadList();
                } else {
                    alert(response.message);
                }
            })
    }

    $scope.searchEntity = {};
    //分页
    $scope.search = function (page, size) {
        tbSellerService.search(page, size, $scope.searchEntity).success(
            function (response) {
                $scope.list = response.rows;//显示当前页数据
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    }
});