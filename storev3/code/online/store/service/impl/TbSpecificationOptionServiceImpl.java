package online.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.Page;
import online.store.entity.TbSpecificationOptionExample;
import online.store.entity.TbSpecificationOption;
import online.store.mapper.TbSpecificationOptionMapper;
import online.store.service.TbSpecificationOptionService;
import entity.PageModel;
import com.alibaba.dubbo.config.annotation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.List;

/**
 * (TbSpecificationOption)表服务实现类
 *
 * @author makejava
 * @since 2018-10-09 11:19:53
 */
@Service
public class TbSpecificationOptionServiceImpl implements TbSpecificationOptionService {
    @Autowired
    private TbSpecificationOptionMapper tbSpecificationOptionMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public TbSpecificationOption selectByPrimaryKey(Long id) {
        return this.tbSpecificationOptionMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public PageModel<TbSpecificationOption> queryAllByLimit(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        TbSpecificationOptionExample tbSpecificationOptionExample = new TbSpecificationOptionExample();
        Page<TbSpecificationOption> pages = (Page<TbSpecificationOption>) tbSpecificationOptionMapper.selectByExample(tbSpecificationOptionExample);
        return new PageModel(pages.getTotal(), pages.getResult());
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    public List<TbSpecificationOption> queryAllByLimit(){ 
        TbSpecificationOptionExample tbSpecificationOptionExample = new TbSpecificationOptionExample();
       return tbSpecificationOptionMapper.selectByExample(tbSpecificationOptionExample);
    }

    /**
     * 新增数据
     *
     * @param tbSpecificationOption 实例对象
     * @return 实例对象
     */
    public TbSpecificationOption insert(TbSpecificationOption tbSpecificationOption) {
        this.tbSpecificationOptionMapper.insert(tbSpecificationOption);
        return tbSpecificationOption;
    }

    /**
     * 修改数据
     *
     * @param tbSpecificationOption 实例对象
     * @return 实例对象
     */
    public TbSpecificationOption update(TbSpecificationOption tbSpecificationOption) {
        this.tbSpecificationOptionMapper.updateByPrimaryKey(tbSpecificationOption);
        return this.selectByPrimaryKey(tbSpecificationOption.getId());
    }
    
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteByPrimaryKey(Long id) {
        return this.tbSpecificationOptionMapper.deleteByPrimaryKey(id) > 0;
    }
    
     /**
     * 模糊查询并分页
     *
     * @param  tbSpecificationOption 实例对象(封装有模糊查询的数据)
     * @return pageModel
     */
    public PageModel<TbSpecificationOption> queryAllByLimit(TbSpecificationOption tbSpecificationOption, int offset, int limit){
        PageHelper.startPage(offset, limit);
        TbSpecificationOptionExample tbSpecificationOptionExample = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = tbSpecificationOptionExample.createCriteria();
        if (tbSpecificationOption != null) {
            
            if (tbSpecificationOption.getOptionName() != null && tbSpecificationOption.getOptionName().trim().length() != 0) {
                criteria.andOptionNameLike("%" + tbSpecificationOption.getOptionName() + "%");
            }
            
            
            
        }
        Page<TbSpecificationOption> pages = (Page<TbSpecificationOption>) tbSpecificationOptionMapper.selectByExample(tbSpecificationOptionExample);
        return new PageModel(pages.getTotal(), pages.getResult());
        }
    /**
     * 通过主键列表删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
     public boolean deleteByPrimaryKeys(Long[]  ids){
        TbSpecificationOptionExample tbSpecificationOptionExample = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = tbSpecificationOptionExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        return tbSpecificationOptionMapper.deleteByExample(tbSpecificationOptionExample)> 0;
        }
        
}