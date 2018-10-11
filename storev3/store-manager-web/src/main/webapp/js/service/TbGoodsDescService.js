/*TbGoodsDescService 服务层js offset, int limit*/
app.service("tbGoodsDescService",function ($http) {
    this.findAll =function () {
      return $http.get('../tbGoodsDesc/findAll.do');
    };


    this.findPage=function (page,size) {
        return $http.get('../tbGoodsDesc/findPage.do?offset='+page+'&limit='+size);
    };

    this.add=function (entity) {
        return $http.post('../tbGoodsDesc/add.do',entity);
    };

    this.update=function (entity) {
        return $http.post('../tbGoodsDesc/update.do',entity);
    };

    this.findOne =function (id) {
        return $http.get('../tbGoodsDesc/selectOne.do?goodsId='+id);
    };

    this.dele=function (selectIds) {
        return $http.get('../tbGoodsDesc/delete.do?goodsIds='+selectIds);
    };


    this.search=function (page,size,searchEntity) {
        return $http.post('../tbGoodsDesc/search.do?offset='+page +'&limit='+size,searchEntity);
    };
});