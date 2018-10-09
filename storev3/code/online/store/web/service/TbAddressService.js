/*TbAddressService 服务层js*/
app.service("tbAddressService",function ($http) {
    this.findAll =function () {
      return $http.get('../tbAddress/findAll.do');
    };


    this.findPage=function (page,size) {
        return $http.get('../tbAddress/findPage.do?page='+page +'&size='+size);
    };

    this.add=function (entity) {
        return $http.post('../tbAddress/add.do',entity);
    };

    this.update=function (entity) {
        return $http.post('../tbAddress/update.do',entity);
    };

    this.findOne =function (id) {
        return $http.get('../tbAddress/selectOne.do?id='+id);
    };

    this.dele=function (selectIds) {
        return $http.get('../tbAddress/delete.do?ids='+selectIds);
    };


    this.search=function (page,size,searchEntity) {
        return $http.post('../tbAddress/search.do?page='+page +'&size='+size,searchEntity);
    };
});