/*TbBrandService 服务层js*/
app.service("loginService",function ($http) {
    this.login =function () {
      return $http.get('../login/getLoginUser.do');
    };
});