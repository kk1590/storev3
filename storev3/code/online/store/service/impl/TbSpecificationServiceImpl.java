package online.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.Page;
import online.store.entity.TbSpecificationExample;
import online.store.entity.TbSpecification;
import online.store.mapper.TbSpecificationMapper;
import online.store.service.TbSpecificationService;
import entity.PageModel;
import com.alibaba.dubbo.config.annotation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.List;

/**
 * (TbSpecification)表服务实现类
 *
 * @author makejava
 * @since 2018-10-09 11:19:53
 */
@Service
public class TbSpecificationServiceImpl implements TbSpecificationService {
    @Autowired
    private TbSpecificationMapper tbSpecificationMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public TbSpecification selectByPrimaryKey(Long id) {
        return this.tbSpecificationMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public PageModel<TbSpecification> queryAllByLimit(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        TbSpecificationExample tbSpecificationExample = new TbSpecificationExample();
        Page<TbSpecification> pages = (Page<TbSpecification>) tbSpecificationMapper.selectByExample(tbSpecificationExample);
        return new PageModel(pages.getTotal(), pages.getResult());
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    public List<TbSpecification> queryAllByLimit(){ 
        TbSpecificationExample tbSpecificationExample = new TbSpecificationExample();
       return tbSpecificationMapper.selectByExample(tbSpecificationExample);
    }

    /**
     * 新增数据
     *
     * @param tbSpecification 实例对象
     * @return 实例对象
     */
    public TbSpecification insert(TbSpecification tbSpecification) {
        this.tbSpecificationMapper.insert(tbSpecification);
        return tbSpecification;
    }

    /**
     * 修改数据
     *
     * @param tbSpecification 实例对象
     * @return 实例对象
     */
    public TbSpecification update(TbSpecification tbSpecification) {
        this.tbSpecificationMapper.updateByPrimaryKey(tbSpecification);
        return this.selectByPrimaryKey(tbSpecification.getId());
    }
    
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteByPrimaryKey(Long id) {
        return this.tbSpecificationMapper.deleteByPrimaryKey(id) > 0;
    }
    
     /**
     * 模糊查询并分页
     *
     * @param  tbSpecification 实例对象(封装有模糊查询的数据)
     * @return pageModel
     */
    public PageModel<TbSpecification> queryAllByLimit(TbSpecification tbSpecification, int offset, int limit){
        PageHelper.startPage(offset, limit);
        TbSpecificationExample tbSpecificationExample = new TbSpecificationExample();
        TbSpecificationExample.Criteria criteria = tbSpecificationExample.createCriteria();
        if (tbSpecification != null) {
            
            if (tbSpecification.getSpecName() != null && tbSpecification.getSpecName().trim().length() != 0) {
                criteria.andSpecNameLike("%" + tbSpecification.getSpecName() + "%");
            }
            
        }
        Page<TbSpecification> pages = (Page<TbSpecification>) tbSpecificationMapper.selectByExample(tbSpecificationExample);
        return new PageModel(pages.getTotal(), pages.getResult());
        }
    /**
     * 通过主键列表删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
     public boolean deleteByPrimaryKeys(Long[]  ids){
        TbSpecificationExample tbSpecificationExample = new TbSpecificationExample();
        TbSpecificationExample.Criteria criteria = tbSpecificationExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        return tbSpecificationMapper.deleteByExample(tbSpecificationExample)> 0;
        }
        
}