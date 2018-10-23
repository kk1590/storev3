package online.store.shop.controller;

import online.store.pojo.Goods;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("JSON")
@RestController
public class ChangeJsonController {

    @RequestMapping("getSpec")
    public List<String> getSpec(@RequestBody List<Map> specificationItems) {
        return getJson(0,specificationItems);
    }


    private List<String> getJson(int i,List<Map> specificationItems) {


        return null;
    }






    /*getItems=function(i,list,item,items,flag){
        var attributeValue=list[i]['attributeValue'];
        var attributeName=list[i]['attributeName'];
        if(i<list.length-1){
            for(var j=0;j<attributeValue.length;j++){
                item['spec'][attributeName]=attributeValue[j];
                alert('1'+JSON.stringify(item));
                alert(items.length);
                i=i+1;
                if(j==attributeValue.length-1){
                    flag=true;
                }
                return getItems(i,list,item,items,flag);
            }
        } else{
            for(var j=0;j<attributeValue.length;j++){
                item['spec'][attributeName]=attributeValue[j];
                alert('2'+JSON.stringify(item));
                var item1=JSON.parse(JSON.stringify(item));
                items.push(item1);
                alert(flag);
                if(j==((attributeValue.length)-1)&&flag){
                    alert('-------'+JSON.stringify(items));
                    return items;
                }
            }
        }
    }*/
}
