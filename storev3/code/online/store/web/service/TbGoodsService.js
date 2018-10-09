/*TbGoodsService 服务层js*/
app.service("tbGoodsService",function ($http) {
    this.findAll =function () {
      return $http.get('../tbGoods/findAll.do');
    };


    this.findPage=function (page,size) {
        return $http.get('../tbGoods/findPage.do?page='+page +'&size='+size);
    };

    this.add=function (entity) {
        return $http.post('../tbGoods/add.do',entity);
    };

    this.update=function (entity) {
        return $http.post('../tbGoods/update.do',entity);
    };

    this.findOne =function (id) {
        return $http.get('../tbGoods/selectOne.do?id='+id);
    };

    this.dele=function (selectIds) {
        return $http.get('../tbGoods/delete.do?ids='+selectIds);
    };


    this.search=function (page,size,searchEntity) {
        return $http.post('../tbGoods/search.do?page='+page +'&size='+size,searchEntity);
    };
});