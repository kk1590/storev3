/*TbBrandService 服务层js*/
app.service("tbBrandService",function ($http) {
    this.findAll =function () {
      return $http.get('../tbBrand/findAll.do');
    };


    this.findPage=function (page,size) {
        return $http.get('../tbBrand/findPage.do?page='+page +'&size='+size);
    };

    this.add=function (entity) {
        return $http.post('../tbBrand/add.do',entity);
    };

    this.update=function (entity) {
        return $http.post('../tbBrand/update.do',entity);
    };

    this.findOne =function (id) {
        return $http.get('../tbBrand/selectOne.do?id='+id);
    };

    this.dele=function (selectIds) {
        return $http.get('../tbBrand/delete.do?ids='+selectIds);
    };


    this.search=function (page,size,searchEntity) {
        return $http.post('../tbBrand/search.do?page='+page +'&size='+size,searchEntity);
    };
});