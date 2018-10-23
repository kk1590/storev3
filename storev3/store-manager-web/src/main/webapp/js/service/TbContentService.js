/*TbContentService 服务层js*/
app.service("tbContentService",function ($http) {
    this.findAll =function () {
      return $http.get('../tbContent/findAll.do');
    };


    this.findPage=function (page,size) {
        return $http.get('../tbContent/findPage.do?page='+page +'&size='+size);
    };

    this.add=function (entity) {
        return $http.post('../tbContent/add.do',entity);
    };

    this.update=function (entity) {
        return $http.post('../tbContent/update.do',entity);
    };

    this.findOne =function (id) {
        return $http.get('../tbContent/selectOne.do?id='+id);
    };

    this.dele=function (selectIds) {
        return $http.get('../tbContent/delete.do?ids='+selectIds);
    };


    this.search=function (page,size,searchEntity) {
        return $http.post('../tbContent/search.do?page='+page +'&size='+size,searchEntity);
    };
});