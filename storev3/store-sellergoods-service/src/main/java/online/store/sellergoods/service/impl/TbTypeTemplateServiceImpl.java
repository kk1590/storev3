package online.store.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import entity.PageModel;
import online.store.mapper.TbSpecificationOptionMapper;
import online.store.mapper.TbTypeTemplateMapper;
import online.store.pojo.TbSpecificationOption;
import online.store.pojo.TbSpecificationOptionExample;
import online.store.pojo.TbTypeTemplate;
import online.store.pojo.TbTypeTemplateExample;
import online.store.sellergoods.service.TbTypeTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * (TbTypeTemplate)表服务实现类
 *
 * @author makejava
 * @since 2018-10-09 14:22:54
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbTypeTemplateServiceImpl implements TbTypeTemplateService {
    @Autowired
    private TbTypeTemplateMapper tbTypeTemplateMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
     @Override
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
     @Override
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
     @Override
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
     @Override
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
     @Override
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
     @Override
    public boolean deleteByPrimaryKey(Long id) {
        return this.tbTypeTemplateMapper.deleteByPrimaryKey(id) > 0;
    }
    
     /**
     * 模糊查询并分页
     *
     * @param  tbTypeTemplate 实例对象(封装有模糊查询的数据)
     * @return pageModel
     */
     @Override
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
     @Override
     public boolean deleteByPrimaryKeys(Long[]  ids){
        TbTypeTemplateExample tbTypeTemplateExample = new TbTypeTemplateExample();
        TbTypeTemplateExample.Criteria criteria = tbTypeTemplateExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        return tbTypeTemplateMapper.deleteByExample(tbTypeTemplateExample)> 0;
     }

     @Autowired
     private TbSpecificationOptionMapper tbSpecificationOptionMapper;


    @Override
    public List<Map> getSpecIdsMapList(Long id) {
        TbTypeTemplate tbTypeTemplate = tbTypeTemplateMapper.selectByPrimaryKey(id);
        List<Map> maps = JSON.parseArray(tbTypeTemplate.getSpecIds(), Map.class);
        for (Map specId:maps){
            TbSpecificationOptionExample example=new TbSpecificationOptionExample();
            TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
            criteria.andSpecIdEqualTo(new Long((Integer)specId.get("id")));
            List<TbSpecificationOption> options = tbSpecificationOptionMapper.selectByExample(example);
            specId.put("options",options);
        }
        return maps;
    }


}