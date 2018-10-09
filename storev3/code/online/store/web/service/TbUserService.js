/*TbUserService 服务层js*/
app.service("tbUserService",function ($http) {
    this.findAll =function () {
      return $http.get('../tbUser/findAll.do');
    };


    this.findPage=function (page,size) {
        return $http.get('../tbUser/findPage.do?page='+page +'&size='+size);
    };

    this.add=function (entity) {
        return $http.post('../tbUser/add.do',entity);
    };

    this.update=function (entity) {
        return $http.post('../tbUser/update.do',entity);
    };

    this.findOne =function (id) {
        return $http.get('../tbUser/selectOne.do?id='+id);
    };

    this.dele=function (selectIds) {
        return $http.get('../tbUser/delete.do?ids='+selectIds);
    };


    this.search=function (page,size,searchEntity) {
        return $http.post('../tbUser/search.do?page='+page +'&size='+size,searchEntity);
    };
});