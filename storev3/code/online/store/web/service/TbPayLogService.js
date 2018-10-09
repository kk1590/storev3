/*TbPayLogService 服务层js*/
app.service("tbPayLogService",function ($http) {
    this.findAll =function () {
      return $http.get('../tbPayLog/findAll.do');
    };


    this.findPage=function (page,size) {
        return $http.get('../tbPayLog/findPage.do?page='+page +'&size='+size);
    };

    this.add=function (entity) {
        return $http.post('../tbPayLog/add.do',entity);
    };

    this.update=function (entity) {
        return $http.post('../tbPayLog/update.do',entity);
    };

    this.findOne =function (id) {
        return $http.get('../tbPayLog/selectOne.do?id='+id);
    };

    this.dele=function (selectIds) {
        return $http.get('../tbPayLog/delete.do?ids='+selectIds);
    };


    this.search=function (page,size,searchEntity) {
        return $http.post('../tbPayLog/search.do?page='+page +'&size='+size,searchEntity);
    };
});