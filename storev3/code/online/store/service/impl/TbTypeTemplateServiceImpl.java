package online.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.Page;
import online.store.entity.TbTypeTemplateExample;
import online.store.entity.TbTypeTemplate;
import online.store.mapper.TbTypeTemplateMapper;
import online.store.service.TbTypeTemplateService;
import entity.PageModel;
import com.alibaba.dubbo.config.annotation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.List;

/**
 * (TbTypeTemplate)表服务实现类
 *
 * @author makejava
 * @since 2018-10-09 11:19:53
 */
@Service
public class TbTypeTemplateServiceImpl implements TbTypeTemplateService {
    @Autowired
    private TbTypeTemplateMapper tbTypeTemplateMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public TbTypeTemplate selectByPrimaryKey(Long id) {
        return this.tbTypeTemplateMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public PageModel<TbTypeTemplate> queryAllByLimit(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        TbTypeTemplateExample tbTypeTemplateExample = new TbTypeTemplateExample();
        Page<TbTypeTemplate> pages = (Page<TbTypeTemplate>) tbTypeTemplateMapper.selectByExample(tbTypeTemplateExample);
        return new PageModel(pages.getTotal(), pages.getResult());
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    public List<TbTypeTemplate> queryAllByLimit(){ 
        TbTypeTemplateExample tbTypeTemplateExample = new TbTypeTemplateExample();
       return tbTypeTemplateMapper.selectByExample(tbTypeTemplateExample);
    }

    /**
     * 新增数据
     *
     * @param tbTypeTemplate 实例对象
     * @return 实例对象
     */
    public TbTypeTemplate insert(TbTypeTemplate tbTypeTemplate) {
        this.tbTypeTemplateMapper.insert(tbTypeTemplate);
        return tbTypeTemplate;
    }

    /**
     * 修改数据
     *
     * @param tbTypeTemplate 实例对象
     * @return 实例对象
     */
    public TbTypeTemplate update(TbTypeTemplate tbTypeTemplate) {
        this.tbTypeTemplateMapper.updateByPrimaryKey(tbTypeTemplate);
        return this.selectByPrimaryKey(tbTypeTemplate.getId());
    }
    
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteByPrimaryKey(Long id) {
        return this.tbTypeTemplateMapper.deleteByPrimaryKey(id) > 0;
    }
    
     /**
     * 模糊查询并分页
     *
     * @param  tbTypeTemplate 实例对象(封装有模糊查询的数据)
     * @return pageModel
     */
    public PageModel<TbTypeTemplate> queryAllByLimit(TbTypeTemplate tbTypeTemplate, int offset, int limit){
        PageHelper.startPage(offset, limit);
        TbTypeTemplateExample tbTypeTemplateExample = new TbTypeTemplateExample();
        TbTypeTemplateExample.Criteria criteria = tbTypeTemplateExample.createCriteria();
        if (tbTypeTemplate != null) {
            
            if (tbTypeTemplate.getName() != null && tbTypeTemplate.getName().trim().length() != 0) {
                criteria.andNameLike("%" + tbTypeTemplate.getName() + "%");
            }
            
            if (tbTypeTemplate.getSpecIds() != null && tbTypeTemplate.getSpecIds().trim().length() != 0) {
                criteria.andSpecIdsLike("%" + tbTypeTemplate.getSpecIds() + "%");
            }
            
            if (tbTypeTemplate.getBrandIds() != null && tbTypeTemplate.getBrandIds().trim().length() != 0) {
                criteria.andBrandIdsLike("%" + tbTypeTemplate.getBrandIds() + "%");
            }
            
            if (tbTypeTemplate.getCustomAttributeItems() != null && tbTypeTemplate.getCustomAttributeItems().trim().length() != 0) {
                criteria.andCustomAttributeItemsLike("%" + tbTypeTemplate.getCustomAttributeItems() + "%");
            }
            
        }
        Page<TbTypeTemplate> pages = (Page<TbTypeTemplate>) tbTypeTemplateMapper.selectByExample(tbTypeTemplateExample);
        return new PageModel(pages.getTotal(), pages.getResult());
        }
    /**
     * 通过主键列表删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
     public boolean deleteByPrimaryKeys(Long[]  ids){
        TbTypeTemplateExample tbTypeTemplateExample = new TbTypeTemplateExample();
        TbTypeTemplateExample.Criteria criteria = tbTypeTemplateExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        return tbTypeTemplateMapper.deleteByExample(tbTypeTemplateExample)> 0;
        }
        
}