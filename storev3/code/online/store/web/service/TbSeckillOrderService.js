/*TbSeckillOrderService 服务层js*/
app.service("tbSeckillOrderService",function ($http) {
    this.findAll =function () {
      return $http.get('../tbSeckillOrder/findAll.do');
    };


    this.findPage=function (page,size) {
        return $http.get('../tbSeckillOrder/findPage.do?page='+page +'&size='+size);
    };

    this.add=function (entity) {
        return $http.post('../tbSeckillOrder/add.do',entity);
    };

    this.update=function (entity) {
        return $http.post('../tbSeckillOrder/update.do',entity);
    };

    this.findOne =function (id) {
        return $http.get('../tbSeckillOrder/selectOne.do?id='+id);
    };

    this.dele=function (selectIds) {
        return $http.get('../tbSeckillOrder/delete.do?ids='+selectIds);
    };


    this.search=function (page,size,searchEntity) {
        return $http.post('../tbSeckillOrder/search.do?page='+page +'&size='+size,searchEntity);
    };
});