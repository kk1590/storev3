/*TbGoodsDescService 服务层js*/
app.service("tbGoodsDescService",function ($http) {
    this.findAll =function () {
      return $http.get('../tbGoodsDesc/findAll.do');
    };


    this.findPage=function (page,size) {
        return $http.get('../tbGoodsDesc/findPage.do?page='+page +'&size='+size);
    };

    this.add=function (entity) {
        return $http.post('../tbGoodsDesc/add.do',entity);
    };

    this.update=function (entity) {
        return $http.post('../tbGoodsDesc/update.do',entity);
    };

    this.findOne =function (id) {
        return $http.get('../tbGoodsDesc/selectOne.do?id='+id);
    };

    this.dele=function (selectIds) {
        return $http.get('../tbGoodsDesc/delete.do?ids='+selectIds);
    };


    this.search=function (page,size,searchEntity) {
        return $http.post('../tbGoodsDesc/search.do?page='+page +'&size='+size,searchEntity);
    };
});