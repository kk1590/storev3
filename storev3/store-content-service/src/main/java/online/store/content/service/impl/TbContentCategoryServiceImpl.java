package online.store.content.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.Page;
import online.store.pojo.TbContentCategoryExample;
import online.store.pojo.TbContentCategory;
import online.store.mapper.TbContentCategoryMapper;
import online.store.content.service.TbContentCategoryService;
import entity.PageModel;
import com.alibaba.dubbo.config.annotation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.List;

/**
 * 内容分类(TbContentCategory)表服务实现类
 *
 * @author makejava
 * @since 2018-10-09 11:19:53
 */
@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {
    @Autowired
    private TbContentCategoryMapper tbContentCategoryMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbContentCategory selectByPrimaryKey(Long id) {
        return this.tbContentCategoryMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public PageModel<TbContentCategory> queryAllByLimit(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        TbContentCategoryExample tbContentCategoryExample = new TbContentCategoryExample();
        Page<TbContentCategory> pages = (Page<TbContentCategory>) tbContentCategoryMapper.selectByExample(tbContentCategoryExample);
        return new PageModel(pages.getTotal(), pages.getResult());
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<TbContentCategory> queryAllByLimit(){ 
        TbContentCategoryExample tbContentCategoryExample = new TbContentCategoryExample();
       return tbContentCategoryMapper.selectByExample(tbContentCategoryExample);
    }

    /**
     * 新增数据
     *
     * @param tbContentCategory 实例对象
     * @return 实例对象
     */
    @Override
    public TbContentCategory insert(TbContentCategory tbContentCategory) {
        this.tbContentCategoryMapper.insert(tbContentCategory);
        return tbContentCategory;
    }

    /**
     * 修改数据
     *
     * @param tbContentCategory 实例对象
     * @return 实例对象
     */
    @Override
    public TbContentCategory update(TbContentCategory tbContentCategory) {
        this.tbContentCategoryMapper.updateByPrimaryKey(tbContentCategory);
        return this.selectByPrimaryKey(tbContentCategory.getId());
    }
    
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteByPrimaryKey(Long id) {
        return this.tbContentCategoryMapper.deleteByPrimaryKey(id) > 0;
    }
    
     /**
     * 模糊查询并分页
     *
     * @param  tbContentCategory 实例对象(封装有模糊查询的数据)
     * @return pageModel
     */
     @Override
    public PageModel<TbContentCategory> queryAllByLimit(TbContentCategory tbContentCategory, int offset, int limit){
        PageHelper.startPage(offset, limit);
        TbContentCategoryExample tbContentCategoryExample = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = tbContentCategoryExample.createCriteria();
        if (tbContentCategory != null) {
            
            if (tbContentCategory.getName() != null && tbContentCategory.getName().trim().length() != 0) {
                criteria.andNameLike("%" + tbContentCategory.getName() + "%");
            }
            
        }
        Page<TbContentCategory> pages = (Page<TbContentCategory>) tbContentCategoryMapper.selectByExample(tbContentCategoryExample);
        return new PageModel(pages.getTotal(), pages.getResult());
        }
    /**
     * 通过主键列表删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
    @Override
     public boolean deleteByPrimaryKeys(Long[]  ids){
        TbContentCategoryExample tbContentCategoryExample = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = tbContentCategoryExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        return tbContentCategoryMapper.deleteByExample(tbContentCategoryExample)> 0;
        }
        
}