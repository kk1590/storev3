/*TbAreasService 服务层js*/
app.service("tbAreasService",function ($http) {
    this.findAll =function () {
      return $http.get('../tbAreas/findAll.do');
    };


    this.findPage=function (page,size) {
        return $http.get('../tbAreas/findPage.do?page='+page +'&size='+size);
    };

    this.add=function (entity) {
        return $http.post('../tbAreas/add.do',entity);
    };

    this.update=function (entity) {
        return $http.post('../tbAreas/update.do',entity);
    };

    this.findOne =function (id) {
        return $http.get('../tbAreas/selectOne.do?id='+id);
    };

    this.dele=function (selectIds) {
        return $http.get('../tbAreas/delete.do?ids='+selectIds);
    };


    this.search=function (page,size,searchEntity) {
        return $http.post('../tbAreas/search.do?page='+page +'&size='+size,searchEntity);
    };
});