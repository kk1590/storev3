/*TbTypeTemplateService 服务层js*/
app.service("tbTypeTemplateService",function ($http) {
    this.findAll =function () {
      return $http.get('../tbTypeTemplate/findAll.do');
    };


    this.findPage=function (page,size) {
        return $http.get('../tbTypeTemplate/findPage.do?page='+page +'&size='+size);
    };

    this.add=function (entity) {
        return $http.post('../tbTypeTemplate/add.do',entity);
    };

    this.update=function (entity) {
        return $http.post('../tbTypeTemplate/update.do',entity);
    };

    this.findOne =function (id) {
        return $http.get('../tbTypeTemplate/selectOne.do?id='+id);
    };

    this.dele=function (selectIds) {
        return $http.get('../tbTypeTemplate/delete.do?ids='+selectIds);
    };


    this.search=function (page,size,searchEntity) {
        return $http.post('../tbTypeTemplate/search.do?page='+page +'&size='+size,searchEntity);
    };
});