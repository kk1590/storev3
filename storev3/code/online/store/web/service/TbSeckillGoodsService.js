/*TbSeckillGoodsService 服务层js*/
app.service("tbSeckillGoodsService",function ($http) {
    this.findAll =function () {
      return $http.get('../tbSeckillGoods/findAll.do');
    };


    this.findPage=function (page,size) {
        return $http.get('../tbSeckillGoods/findPage.do?page='+page +'&size='+size);
    };

    this.add=function (entity) {
        return $http.post('../tbSeckillGoods/add.do',entity);
    };

    this.update=function (entity) {
        return $http.post('../tbSeckillGoods/update.do',entity);
    };

    this.findOne =function (id) {
        return $http.get('../tbSeckillGoods/selectOne.do?id='+id);
    };

    this.dele=function (selectIds) {
        return $http.get('../tbSeckillGoods/delete.do?ids='+selectIds);
    };


    this.search=function (page,size,searchEntity) {
        return $http.post('../tbSeckillGoods/search.do?page='+page +'&size='+size,searchEntity);
    };
});