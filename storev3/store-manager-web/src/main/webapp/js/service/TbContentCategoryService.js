/*TbContentCategoryService 服务层js*/
app.service("tbContentCategoryService",function ($http) {
    this.findAll =function () {
      return $http.get('../tbContentCategory/findAll.do');
    };


    this.findPage=function (page,size) {
        return $http.get('../tbContentCategory/findPage.do?page='+page +'&size='+size);
    };

    this.add=function (entity) {
        return $http.post('../tbContentCategory/add.do',entity);
    };

    this.update=function (entity) {
        return $http.post('../tbContentCategory/update.do',entity);
    };

    this.findOne =function (id) {
        return $http.get('../tbContentCategory/selectOne.do?id='+id);
    };

    this.dele=function (selectIds) {
        return $http.get('../tbContentCategory/delete.do?ids='+selectIds);
    };


    this.search=function (page,size,searchEntity) {
        return $http.post('../tbContentCategory/search.do?page='+page +'&size='+size,searchEntity);
    };
});