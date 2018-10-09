package online.store.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import entity.PageModel;
import entity.Result;
import online.store.pojo.TbBrand;
import online.store.sellergoods.service.BrandService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/brand")
@RestController
public class BrandController {

    @Reference
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<TbBrand> findAll(){
        return brandService.findAll();
    }

    @RequestMapping("/findPage")
    public PageModel getBrandByPage(int page,int size){
        return brandService.getBrandByPage(page,size);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand brand){
        try {
            brandService.add(brand);
            return new Result(true,"增加成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"增加失败");
        }
    }

    @RequestMapping("/findOne")
    public TbBrand findOne(Long id){
            return brandService.findOne(id);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand brand){
        try {
        brandService.update(brand);
        return new Result(true,"更新成功");
        }catch (Exception e){
            return new Result(false,"更新失败");
        }
    }

    @RequestMapping("/delete")
    public Result deleteList(Long[] ids){
        try {
            brandService.deleteList(ids);
            return new Result(true,"删除成功");
        }catch (Exception e){
            return new Result(false,"删除失败");
        }
    }

    @RequestMapping("/search")
    public PageModel getBrandByPage(@RequestBody TbBrand brand,int page,int size){
        return brandService.search(brand,page,size);
    }

}
