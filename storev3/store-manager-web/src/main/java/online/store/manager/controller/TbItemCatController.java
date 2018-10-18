package online.store.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import entity.PageModel;
import entity.Result;
import online.store.pojo.TbItemCat;
import online.store.sellergoods.service.TbItemCatService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品类目(TbItemCat)表控制层
 *
 * @author makejava
 * @since 2018-10-09 14:41:41
 */
@RestController
@RequestMapping("tbItemCat")
public class TbItemCatController {
    /**
     * 服务对象
     */
    @Reference
    private TbItemCatService tbItemCatService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public TbItemCat selectOne(Long id) {
        return this.tbItemCatService.selectByPrimaryKey(id);
    }
    
    /**
     * 查询出所有列表数据
     *
     * @return 列表数据
     */
    
    @RequestMapping("findAll")
    public List<TbItemCat> findAll(){
        return tbItemCatService.queryAllByLimit();
    }
    
    /**
     * 分页查询出所有列表数据
     *
     * @param offset 当前页码,int 每页显示数量
     * @param limit 每页显示数量
     * @return 列表数据
     */
    
    @RequestMapping("findPage")
    public PageModel<TbItemCat> getTbItemCatByPage(int offset, int limit){
        return tbItemCatService.queryAllByLimit(offset,limit);
    }
    
    /**
     * 将1条pojod对象添加到数据库
     *
     * @param tbItemCat 实例对象
     * @return Result对象
     */
    
    @RequestMapping("add")
    public Result add(@RequestBody TbItemCat tbItemCat){
        try {
            tbItemCatService.insert(tbItemCat);
            return new Result(true,"增加成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"增加失败");
        }
    }
    
     /**
     * 通过pojo修改数据
     *
     * @param tbItemCat 实例对象
     * @return result结果对象
     */
    @RequestMapping("update")
    public Result update(@RequestBody TbItemCat tbItemCat){
        try {
        tbItemCatService.update(tbItemCat);
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
            tbItemCatService.deleteByPrimaryKeys(ids);
            return new Result(true,"删除成功");
        }catch (Exception e){
            return new Result(false,"删除失败");
        }
    }

     /**
     * 分页查询按条件查询数据
     *
     * @param tbItemCat 实例对象(封装了查询的关键字)
     * @return 列表数据
     */
    @RequestMapping("search")
    public PageModel<TbItemCat> getTbItemCatByPage(@RequestBody TbItemCat tbItemCat,int offset, int limit){
        return tbItemCatService.queryAllByLimit(tbItemCat,offset,limit);
    }

    @RequestMapping("selectByPrimaryParentId")
    public List<TbItemCat> selectByPrimaryParentId(Long parentId){
        return tbItemCatService.selectByPrimaryParentId(parentId);
    }

}