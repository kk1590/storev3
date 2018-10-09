package online.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.Page;
import online.store.entity.TbFreightTemplateExample;
import online.store.entity.TbFreightTemplate;
import online.store.mapper.TbFreightTemplateMapper;
import online.store.service.TbFreightTemplateService;
import entity.PageModel;
import com.alibaba.dubbo.config.annotation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.List;

/**
 * (TbFreightTemplate)表服务实现类
 *
 * @author makejava
 * @since 2018-10-09 11:19:53
 */
@Service
public class TbFreightTemplateServiceImpl implements TbFreightTemplateService {
    @Autowired
    private TbFreightTemplateMapper tbFreightTemplateMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public TbFreightTemplate selectByPrimaryKey(Long id) {
        return this.tbFreightTemplateMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public PageModel<TbFreightTemplate> queryAllByLimit(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        TbFreightTemplateExample tbFreightTemplateExample = new TbFreightTemplateExample();
        Page<TbFreightTemplate> pages = (Page<TbFreightTemplate>) tbFreightTemplateMapper.selectByExample(tbFreightTemplateExample);
        return new PageModel(pages.getTotal(), pages.getResult());
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    public List<TbFreightTemplate> queryAllByLimit(){ 
        TbFreightTemplateExample tbFreightTemplateExample = new TbFreightTemplateExample();
       return tbFreightTemplateMapper.selectByExample(tbFreightTemplateExample);
    }

    /**
     * 新增数据
     *
     * @param tbFreightTemplate 实例对象
     * @return 实例对象
     */
    public TbFreightTemplate insert(TbFreightTemplate tbFreightTemplate) {
        this.tbFreightTemplateMapper.insert(tbFreightTemplate);
        return tbFreightTemplate;
    }

    /**
     * 修改数据
     *
     * @param tbFreightTemplate 实例对象
     * @return 实例对象
     */
    public TbFreightTemplate update(TbFreightTemplate tbFreightTemplate) {
        this.tbFreightTemplateMapper.updateByPrimaryKey(tbFreightTemplate);
        return this.selectByPrimaryKey(tbFreightTemplate.getId());
    }
    
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteByPrimaryKey(Long id) {
        return this.tbFreightTemplateMapper.deleteByPrimaryKey(id) > 0;
    }
    
     /**
     * 模糊查询并分页
     *
     * @param  tbFreightTemplate 实例对象(封装有模糊查询的数据)
     * @return pageModel
     */
    public PageModel<TbFreightTemplate> queryAllByLimit(TbFreightTemplate tbFreightTemplate, int offset, int limit){
        PageHelper.startPage(offset, limit);
        TbFreightTemplateExample tbFreightTemplateExample = new TbFreightTemplateExample();
        TbFreightTemplateExample.Criteria criteria = tbFreightTemplateExample.createCriteria();
        if (tbFreightTemplate != null) {
            
            if (tbFreightTemplate.getSellerId() != null && tbFreightTemplate.getSellerId().trim().length() != 0) {
                criteria.andSellerIdLike("%" + tbFreightTemplate.getSellerId() + "%");
            }
            
            if (tbFreightTemplate.getIsDefault() != null && tbFreightTemplate.getIsDefault().trim().length() != 0) {
                criteria.andIsDefaultLike("%" + tbFreightTemplate.getIsDefault() + "%");
            }
            
            if (tbFreightTemplate.getName() != null && tbFreightTemplate.getName().trim().length() != 0) {
                criteria.andNameLike("%" + tbFreightTemplate.getName() + "%");
            }
            
            if (tbFreightTemplate.getSendTimeType() != null && tbFreightTemplate.getSendTimeType().trim().length() != 0) {
                criteria.andSendTimeTypeLike("%" + tbFreightTemplate.getSendTimeType() + "%");
            }
            
            
            
        }
        Page<TbFreightTemplate> pages = (Page<TbFreightTemplate>) tbFreightTemplateMapper.selectByExample(tbFreightTemplateExample);
        return new PageModel(pages.getTotal(), pages.getResult());
        }
    /**
     * 通过主键列表删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
     public boolean deleteByPrimaryKeys(Long[]  ids){
        TbFreightTemplateExample tbFreightTemplateExample = new TbFreightTemplateExample();
        TbFreightTemplateExample.Criteria criteria = tbFreightTemplateExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        return tbFreightTemplateMapper.deleteByExample(tbFreightTemplateExample)> 0;
        }
        
}