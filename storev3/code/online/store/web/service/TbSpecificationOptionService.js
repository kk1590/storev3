/*TbSpecificationOptionService 服务层js*/
app.service("tbSpecificationOptionService",function ($http) {
    this.findAll =function () {
      return $http.get('../tbSpecificationOption/findAll.do');
    };


    this.findPage=function (page,size) {
        return $http.get('../tbSpecificationOption/findPage.do?page='+page +'&size='+size);
    };

    this.add=function (entity) {
        return $http.post('../tbSpecificationOption/add.do',entity);
    };

    this.update=function (entity) {
        return $http.post('../tbSpecificationOption/update.do',entity);
    };

    this.findOne =function (id) {
        return $http.get('../tbSpecificationOption/selectOne.do?id='+id);
    };

    this.dele=function (selectIds) {
        return $http.get('../tbSpecificationOption/delete.do?ids='+selectIds);
    };


    this.search=function (page,size,searchEntity) {
        return $http.post('../tbSpecificationOption/search.do?page='+page +'&size='+size,searchEntity);
    };
});