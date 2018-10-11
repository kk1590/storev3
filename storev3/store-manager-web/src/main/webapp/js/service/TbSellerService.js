/*TbSellerService 服务层js offset, int limit*/
app.service("tbSellerService",function ($http) {
    this.findAll =function () {
      return $http.get('../tbSeller/findAll.do');
    };


    this.findPage=function (page,size) {
        return $http.get('../tbSeller/findPage.do?offset='+page+'&limit='+size);
    };

    this.add=function (entity) {
        return $http.post('../tbSeller/add.do',entity);
    };

    this.update=function (entity) {
        return $http.post('../tbSeller/update.do',entity);
    };

    this.findOne =function (id) {
        return $http.get('../tbSeller/selectOne.do?sellerId='+id);
    };

    this.dele=function (selectIds) {
        return $http.get('../tbSeller/delete.do?sellerIds='+selectIds);
    };


    this.search=function (page,size,searchEntity) {
        return $http.post('../tbSeller/search.do?offset='+page +'&limit='+size,searchEntity);
    };


    /**
     * 更新商家状态
     * @param sellerId
     * @param status
     * @returns {*}
     */
    this.updateStatus=function(sellerId,status){

        alert("成功进入service");
        return $http.get('../tbSeller/updateStatus.do?sellerId='+sellerId+'&status='+status);
    }
});