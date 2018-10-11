package online.store.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import entity.PageModel;
import entity.Result;
import online.store.pojo.TbBrand;
import online.store.sellergoods.service.TbBrandService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * (TbBrand)表控制层
 *
 * @author makejava
 * @since 2018-10-09 10:27:01
 */
@RestController
@RequestMapping("/tbBrand")
public class TbBrandController {
    /**
     * 服务对象
     */
    @Reference
    private TbBrandService tbBrandService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public TbBrand selectOne(Long id) {
        return this.tbBrandService.selectByPrimaryKey(id);
    }
    
    /**
     * 查询出所有列表数据
     *
     * @param 
     * @return 列表数据
     */
    @RequestMapping("findAll")
    public List<TbBrand> findAll(){
        return tbBrandService.queryAllByLimit();
    }
    
    /**
     * 分页查询出所有列表数据
     *
     * @param page 当前页码,int 每页显示数量
     * @param size 每页显示数量
     * @return 列表数据
     */
    
    @RequestMapping("findPage")
    public PageModel<TbBrand> getTbBrandByPage(int page,int size){
        return tbBrandService.queryAllByLimit(page,size);
    }
    
    /**
     * 将1条pojod对象添加到数据库
     *
     * @param tbBrand 实例对象
     * @return Result对象
     */
    
    @RequestMapping("add")
    public Result add(@RequestBody TbBrand tbBrand){
        try {
            tbBrandService.insert(tbBrand);
            return new Result(true,"增加成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"增加失败");
        }
    }
    
     /**
     * 通过pojo修改数据
     *
     * @param tbBrand 实例对象
     * @return result结果对象
     */
    @RequestMapping("update")
    public Result update(@RequestBody TbBrand tbBrand){
        try {
        tbBrandService.update(tbBrand);
        return new Result(true,"更新成功");
        }catch (Exception e){
            return new Result(false,"更新失败");
        }
    }

    /**
     * 通过主键列表删除数据
     *
     * @param ids 主键列表
     * @return result结果对象
     */
    @RequestMapping("delete")
    public Result deleteByIds(Long[] ids){
        try {
            tbBrandService.deleteByPrimaryKeys(ids);
            return new Result(true,"删除成功");
        }catch (Exception e){
            return new Result(false,"删除失败");
        }
    }

     /**
     * 分页查询按条件查询数据
     *
     * @param tbBrand 实例对象(封装了查询的关键字)
     * @return 列表数据
     */
    @RequestMapping("search")
    public PageModel<TbBrand> getTbBrandByPage(@RequestBody TbBrand tbBrand,int page,int size){
        return tbBrandService.queryAllByLimit(tbBrand,page,size);
    }

    @RequestMapping("selectByExampleAsMap")
    public List<Map> selectByExampleAsMap(){
        System.out.println("进入controller");
        return tbBrandService.selectByExampleAsMap();
    }


}