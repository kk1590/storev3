/*TbProvincesService 服务层js*/
app.service("tbProvincesService",function ($http) {
    this.findAll =function () {
      return $http.get('../tbProvinces/findAll.do');
    };


    this.findPage=function (page,size) {
        return $http.get('../tbProvinces/findPage.do?page='+page +'&size='+size);
    };

    this.add=function (entity) {
        return $http.post('../tbProvinces/add.do',entity);
    };

    this.update=function (entity) {
        return $http.post('../tbProvinces/update.do',entity);
    };

    this.findOne =function (id) {
        return $http.get('../tbProvinces/selectOne.do?id='+id);
    };

    this.dele=function (selectIds) {
        return $http.get('../tbProvinces/delete.do?ids='+selectIds);
    };


    this.search=function (page,size,searchEntity) {
        return $http.post('../tbProvinces/search.do?page='+page +'&size='+size,searchEntity);
    };
});