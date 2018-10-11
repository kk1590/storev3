/*TbSpecificationService 服务层js offset, int limit*/
app.service("tbSpecificationService",function ($http) {
    this.findAll =function () {
      return $http.get('../tbSpecification/findAll.do');
    };


    this.findPage=function (page,size) {
        return $http.get('../tbSpecification/findPage.do?offset='+page+'&limit='+size);
    };

    this.add=function (entity) {
        return $http.post('../tbSpecification/add.do',entity);
    };

    this.update=function (entity) {
        return $http.post('../tbSpecification/update.do',entity);
    };

    this.findOne =function (id) {
        return $http.get('../tbSpecification/selectOne.do?id='+id);
    };

    this.dele=function (selectIds) {
        return $http.get('../tbSpecification/delete.do?ids='+selectIds);
    };


    this.search=function (page,size,searchEntity) {
        return $http.post('../tbSpecification/search.do?offset='+page +'&limit='+size,searchEntity);
    };


    this.getSpecificationList=function () {
        alert("进入service");
        return $http.post('../tbSpecification/getSpecificationList.do');
    }
});