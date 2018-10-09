/*TbFreightTemplateService 服务层js*/
app.service("tbFreightTemplateService",function ($http) {
    this.findAll =function () {
      return $http.get('../tbFreightTemplate/findAll.do');
    };


    this.findPage=function (page,size) {
        return $http.get('../tbFreightTemplate/findPage.do?page='+page +'&size='+size);
    };

    this.add=function (entity) {
        return $http.post('../tbFreightTemplate/add.do',entity);
    };

    this.update=function (entity) {
        return $http.post('../tbFreightTemplate/update.do',entity);
    };

    this.findOne =function (id) {
        return $http.get('../tbFreightTemplate/selectOne.do?id='+id);
    };

    this.dele=function (selectIds) {
        return $http.get('../tbFreightTemplate/delete.do?ids='+selectIds);
    };


    this.search=function (page,size,searchEntity) {
        return $http.post('../tbFreightTemplate/search.do?page='+page +'&size='+size,searchEntity);
    };
});