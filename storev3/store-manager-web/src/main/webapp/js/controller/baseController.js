/*通用 控制层代码*/
app.controller('baseController', function ($scope){
//分页控件配置currentPage:当前页   totalItems :总记录数  itemsPerPage:每页记录数  perPageOptions :分页选项  onChange:当页码变更后自动触发的方法
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            $scope.reloadList();
        }
    };
    //刷新列表
    $scope.reloadList = function () {
        $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    };
    $scope.selectIds = [];
    //复选框列表
    $scope.updateSelection = function ($event, id) {
        if ($event.target.checked) {
            $scope.selectIds.push(id);
        }
        else {
            var index = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(index, 1);
        }
        alert($scope.selectIds);
    };

    $scope.jsonToString=function (str,key) {
        var jsonObject=JSON.parse(str);
        var value="";
        for (var i=0;i<jsonObject.length;i++){
            if(i>0){
                value+=",";}
            value+=jsonObject[i][key];
        }
        return value;
    }
})