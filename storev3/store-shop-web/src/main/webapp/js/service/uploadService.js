/*文件上传服务层js*/
app.service("uploadService",function ($http) {
    this.fileUpload =function () {
        var formDate=new FormData();
        formDate.append("file",file.files[0]);
        return $http({
            url:'../fileUpload.do',
            method:'post',
            data:formDate,
            headers:{'Content-Type':undefined},
            transformRequest: angular.identity
        });
    };
});