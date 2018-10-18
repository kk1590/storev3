/*TbGoodsController 控制层代码*/
app.controller('tbGoodsController', function ($scope, $controller, $location, tbGoodsService, uploadService, tbItemCatService, tbTypeTemplateService) {
        /*引入baseController*/
        $controller('baseController', {$scope: $scope});


        //查询品牌列表
        $scope.findAll = function () {
            tbGoodsService.findAll().success(
                function (response) {
                    $scope.list = response;
                }
            );
        }

        $scope.status = ["未审核", "申请通过", "申请未通过", "已关闭"];


        $scope.itemCates = [];

        $scope.getItemList = function () {
            tbItemCatService.findAll().success(
                function (reponse) {
                    for (var i = 0; i < reponse.length; i++) {
                        $scope.itemCates[reponse[i].id] = reponse[i].name;
                    }
                }
            )
        }

        //分页
        $scope.findPage = function (page, size) {
            tbGoodsService.findPage(page, size).success(
                function (response) {
                    $scope.list = response.rows;//显示当前页数据
                    $scope.paginationConf.totalItems = response.total;//更新总记录数
                }
            );
        }

        //新增
        $scope.save = function () {
            $scope.entity.tbGoodsDesc.introduction = editor.html();
            var goodObjece;
            alert($scope.entity.tbGoods.id);
            if ($scope.entity.tbGoods.id != null) {
                goodObjece = tbGoodsService.update($scope.entity);
            } else {
                goodObjece = tbGoodsService.add($scope.entity);
            }
            goodObjece.success(function (response) {
                if (response.success) {
                    $scope.entity = {};
                    editor.html('');//清空富文本编辑器
                    location.href="goods.html";
                } else {
                    alert(response.message);
                }
            });
        }

        $scope.findOne = function () {
            var id=$location.search()['id'];
            tbGoodsService.findOne(id).success(function (response) {
                $scope.entity = response;
                editor.html(response.tbGoodsDesc.introduction);
/*                alert($scope.entity.tbGoodsDesc.itemImages);
                alert($scope.entity.tbGoodsDesc.customAttributeItems);
                alert($scope.entity.tbGoodsDesc.specificationItems);*/
                $scope.entity.tbGoodsDesc.itemImages = JSON.parse(response.tbGoodsDesc.itemImages);
                $scope.entity.tbGoodsDesc.customAttributeItems = JSON.parse(response.tbGoodsDesc.customAttributeItems);
                $scope.entity.tbGoodsDesc.specificationItems = JSON.parse(response.tbGoodsDesc.specificationItems);
                $scope.entity.tbItems=response.tbItems;
                var tbItemList=$scope.entity.tbItems;
                for (var i = 0; i < tbItemList.length; i++) {
                    alert(tbItemList[1]);
                    tbItemList[i].spec = JSON.parse(tbItemList[i].spec);
                }
            });
        };

        $scope.dele = function () {
            tbGoodsService.dele($scope.selectIds).success(
                function (response) {
                    if (response.success) {
                        $scope.reloadList();
                    } else {
                        alert(response.message);
                    }
                })
        }

        $scope.searchEntity = {};
//分页
        $scope.search = function (page, size) {
            tbGoodsService.search(page, size, $scope.searchEntity).success(
                function (response) {
                    $scope.list = response.rows;//显示当前页数据
                    $scope.paginationConf.totalItems = response.total;//更新总记录数
                }
            );
        }

        $scope.entity = {tbGoods: {}, tbGoodsDesc: {itemImages: [],specificationItems:[]}};

        $scope.upload = function () {
            uploadService.fileUpload().success(
                function (response) {
                    if (response.success) {
                        $scope.image_entity.url = response.message;
                    }
                }
            )
        }

        $scope.addImageEntity = function () {
            $scope.entity.tbGoodsDesc.itemImages.push($scope.image_entity);
        }

        $scope.deleImageEntity = function (index) {
            $scope.entity.tbGoodsDesc.itemImages.splice(index, 1);
        }

        $scope.selectItemCate1List = function () {
            tbItemCatService.selectByPrimaryParentId(0).success(
                function (response) {
                    $scope.itemCate1List = response;
                    $scope.entity.tbGoods.typeTemplateId = '';
                }
            )
        }

        $scope.$watch('entity.tbGoods.category1Id', function (newValue, oldValue) {
            tbItemCatService.selectByPrimaryParentId(newValue).success(
                function (response) {
                    $scope.itemCate2List = response;
                    $scope.entity.tbGoods.typeTemplateId = '';
                }
            )
        })

        $scope.$watch('entity.tbGoods.category2Id', function (newValue, oldValue) {
            tbItemCatService.selectByPrimaryParentId(newValue).success(
                function (response) {
                    $scope.itemCate3List = response;
                    $scope.entity.tbGoods.typeTemplateId = '';
                }
            )
        })

        $scope.$watch('entity.tbGoods.category3Id', function (newValue, oldValue) {
            tbItemCatService.findOne(newValue).success(
                function (response) {
                    $scope.entity.tbGoods.typeTemplateId = response.typeId;
                }
            )
        })

        $scope.$watch('entity.tbGoods.typeTemplateId', function (newValue, oldValue) {
            if (newValue != '') {
                tbTypeTemplateService.findOne(newValue).success(
                    function (response) {
                        $scope.typeTemplate = response;
                        $scope.typeTemplate.brandIds = JSON.parse($scope.typeTemplate.brandIds);
                        if ($location.search()['id'] == null) {
                            $scope.entity.tbGoodsDesc.customAttributeItems = JSON.parse($scope.typeTemplate.customAttributeItems);
                        }
                    }
                )
                tbTypeTemplateService.getSpecIdsMapList(newValue).success(
                    function (response) {
                        $scope.spectList = response;
                    }
                )
            } else {
                if ($location.search()['id'] == null) {
                    $scope.entity.tbGoodsDesc.customAttributeItems = [];
                }
            }
        })

        $scope.updateOptionSelect = function ($event, specificationItemName, optionName) {
            var object = $scope.searchObjdectByKey($scope.entity.tbGoodsDesc.specificationItems,'attributeName',specificationItemName);
            if (object != null) {
                if ($event.target.checked) {
                    object.attributeValue.push(optionName);
                } else {
                    if (object.attributeValue.length > 1) {
                        object.attributeValue.splice(object.attributeValue.indexOf(optionName), 1);
                    } else {
                        $scope.entity.tbGoodsDesc.specificationItems.splice($scope.entity.tbGoodsDesc.specificationItems.indexOf(object), 1);
                    }
                }
            } else {
                $scope.entity.tbGoodsDesc.specificationItems.push({
                    "attributeName": specificationItemName,
                    "attributeValue": [optionName]
                });
            }
        }

        $scope.entity={ tbGoodsDesc:{itemImages:[],specificationItems:[]}  };
//创建SKU列表
        $scope.createItemList = function () {

            $scope.entity.tbItems = [{spec: {}, price: 0, num: 99999, status: '0', isDefault: '0'}];//列表初始化

            var items = $scope.entity.tbGoodsDesc.specificationItems;

            for (var i = 0; i < items.length; i++) {
                $scope.entity.tbItems = addColumn($scope.entity.tbItems, items[i].attributeName, items[i].attributeValue);
            }
        }

        addColumn = function (list, columnName, columnValues) {
            var newList = [];
            for (var i = 0; i < list.length; i++) {
                var oldRow = list[i];
                for (var j = 0; j < columnValues.length; j++) {
                    var newRow = JSON.parse(JSON.stringify(oldRow));//深克隆
                    newRow.spec[columnName] = columnValues[j];
                    newList.push(newRow);
                }
            }
            return newList;
        }

        $scope.checkAttributeValue = function (specName, specValue) {
            var specificationItemList = $scope.entity.tbGoodsDesc.specificationItems;
            var object = $scope.searchObjdectByKey($scope.entity.tbGoodsDesc.specificationItems, 'attributeName', specName);
            if (object != null) {
                if (object.attributeValue.indexOf(specValue) >= 0) {
                    return true;
                } else {
                    return false
                }
            } else {
                return false
            }
        }
    }
)
;