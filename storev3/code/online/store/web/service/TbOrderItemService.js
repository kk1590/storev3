/*TbOrderItemService 服务层js*/
app.service("tbOrderItemService",function ($http) {
    this.findAll =function () {
      return $http.get('../tbOrderItem/findAll.do');
    };


    this.findPage=function (page,size) {
        return $http.get('../tbOrderItem/findPage.do?page='+page +'&size='+size);
    };

    this.add=function (entity) {
        return $http.post('../tbOrderItem/add.do',entity);
    };

    this.update=function (entity) {
        return $http.post('../tbOrderItem/update.do',entity);
    };

    this.findOne =function (id) {
        return $http.get('../tbOrderItem/selectOne.do?id='+id);
    };

    this.dele=function (selectIds) {
        return $http.get('../tbOrderItem/delete.do?ids='+selectIds);
    };


    this.search=function (page,size,searchEntity) {
        return $http.post('../tbOrderItem/search.do?page='+page +'&size='+size,searchEntity);
    };
});