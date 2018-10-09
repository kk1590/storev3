package online.store.controller;

import online.store.entity.TbSpecificationOption;
import online.store.service.TbSpecificationOptionService;
import org.springframework.web.bind.annotation.*;
import entity.PageModel;
import entity.Result;
import com.alibaba.dubbo.config.annotation.*;

import java.util.List;

/**
 * (TbSpecificationOption)表控制层
 *
 * @author makejava
 * @since 2018-10-09 11:19:53
 */
@RestController
@RequestMapping("tbSpecificationOption")
public class TbSpecificationOptionController {
    /**
     * 服务对象
     */
    @Reference
    private TbSpecificationOptionService tbSpecificationOptionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public TbSpecificationOption selectOne(Long id) {
        return this.tbSpecificationOptionService.selectByPrimaryKey(id);
    }
    
    /**
     * 查询出所有列表数据
     *
     * @param 
     * @return 列表数据
     */
    
    @RequestMapping("findAll")
    public List<TbSpecificationOption> findAll(){
        return tbSpecificationOptionService.queryAllByLimit();
    }
    
    /**
     * 分页查询出所有列表数据
     *
     * @param page 当前页码,int 每页显示数量
     * @param size 每页显示数量
     * @return 列表数据
     */
    
    @RequestMapping("findPage")
    public PageModel<TbSpecificationOption> getTbSpecificationOptionByPage(int page,int size){
        return tbSpecificationOptionService.queryAllByLimit(page,size);
    }
    
    /**
     * 将1条pojod对象添加到数据库
     *
     * @param tbSpecificationOption 实例对象
     * @return Result对象
     */
    
    @RequestMapping("add")
    public Result add(@RequestBody TbSpecificationOption tbSpecificationOption){
        try {
            tbSpecificationOptionService.insert(tbSpecificationOption);
            return new Result(true,"增加成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"增加失败");
        }
    }
    
     /**
     * 通过pojo修改数据
     *
     * @param tbSpecificationOption 实例对象
     * @return result结果对象
     */
    @RequestMapping("update")
    public Result update(@RequestBody TbSpecificationOption tbSpecificationOption){
        try {
        tbSpecificationOptionService.update(tbSpecificationOption);
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
            tbSpecificationOptionService.deleteByPrimaryKeys(ids);
            return new Result(true,"删除成功");
        }catch (Exception e){
            return new Result(false,"删除失败");
        }
    }

     /**
     * 分页查询按条件查询数据
     *
     * @param tbSpecificationOption 实例对象(封装了查询的关键字)
     * @return 列表数据
     */
    @RequestMapping("search")
    public PageModel<TbSpecificationOption> getTbSpecificationOptionByPage(@RequestBody TbSpecificationOption tbSpecificationOption,int page,int size){
        return tbSpecificationOptionService.queryAllByLimit(tbSpecificationOption,page,size);
    }

}