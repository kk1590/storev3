/*TbItemCatService 服务层js offset, int limit*/
app.service("tbItemCatService",function ($http) {
    this.findAll =function () {
      return $http.get('../tbItemCat/findAll.do');
    };


    this.findPage=function (page,size) {
        return $http.get('../tbItemCat/findPage.do?offset='+page+'&limit='+size);
    };

    this.add=function (entity) {
        return $http.post('../tbItemCat/add.do',entity);
    };

    this.update=function (entity) {
        return $http.post('../tbItemCat/update.do',entity);
    };

    this.findOne =function (id) {
        return $http.get('../tbItemCat/selectOne.do?id='+id);
    };

    this.dele=function (selectIds) {
        return $http.get('../tbItemCat/delete.do?ids='+selectIds);
    };


    this.search=function (page,size,searchEntity) {
        return $http.post('../tbItemCat/search.do?offset='+page +'&limit='+size,searchEntity);
    };
});