/*TbItemService 服务层js offset, int limit*/
app.service("tbItemService",function ($http) {
    this.findAll =function () {
      return $http.get('../tbItem/findAll.do');
    };


    this.findPage=function (page,size) {
        return $http.get('../tbItem/findPage.do?offset='+page +'&limit='+size);
    };

    this.add=function (entity) {
        return $http.post('../tbItem/add.do',entity);
    };

    this.update=function (entity) {
        return $http.post('../tbItem/update.do',entity);
    };

    this.findOne =function (id) {
        return $http.get('../tbItem/selectOne.do?id='+id);
    };

    this.dele=function (selectIds) {
        return $http.get('../tbItem/delete.do?ids='+selectIds);
    };


    this.search=function (page,size,searchEntity) {
        return $http.post('../tbItem/search.do?offset='+page +'&limit='+size,searchEntity);
    };
});