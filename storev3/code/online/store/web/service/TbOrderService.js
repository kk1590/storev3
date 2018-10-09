/*TbOrderService 服务层js*/
app.service("tbOrderService",function ($http) {
    this.findAll =function () {
      return $http.get('../tbOrder/findAll.do');
    };


    this.findPage=function (page,size) {
        return $http.get('../tbOrder/findPage.do?page='+page +'&size='+size);
    };

    this.add=function (entity) {
        return $http.post('../tbOrder/add.do',entity);
    };

    this.update=function (entity) {
        return $http.post('../tbOrder/update.do',entity);
    };

    this.findOne =function (id) {
        return $http.get('../tbOrder/selectOne.do?id='+id);
    };

    this.dele=function (selectIds) {
        return $http.get('../tbOrder/delete.do?ids='+selectIds);
    };


    this.search=function (page,size,searchEntity) {
        return $http.post('../tbOrder/search.do?page='+page +'&size='+size,searchEntity);
    };
});