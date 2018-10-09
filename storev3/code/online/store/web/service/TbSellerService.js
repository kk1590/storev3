/*TbSellerService 服务层js*/
app.service("tbSellerService",function ($http) {
    this.findAll =function () {
      return $http.get('../tbSeller/findAll.do');
    };


    this.findPage=function (page,size) {
        return $http.get('../tbSeller/findPage.do?page='+page +'&size='+size);
    };

    this.add=function (entity) {
        return $http.post('../tbSeller/add.do',entity);
    };

    this.update=function (entity) {
        return $http.post('../tbSeller/update.do',entity);
    };

    this.findOne =function (id) {
        return $http.get('../tbSeller/selectOne.do?id='+id);
    };

    this.dele=function (selectIds) {
        return $http.get('../tbSeller/delete.do?ids='+selectIds);
    };


    this.search=function (page,size,searchEntity) {
        return $http.post('../tbSeller/search.do?page='+page +'&size='+size,searchEntity);
    };
});