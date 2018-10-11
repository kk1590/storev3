package online.store.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import entity.PageModel;
import online.store.mapper.TbSpecificationMapper;
import online.store.mapper.TbSpecificationOptionMapper;
import online.store.pojo.TbSpecification;
import online.store.pojo.TbSpecificationExample;
import online.store.pojo.TbSpecificationOption;
import online.store.pojo.TbSpecificationOptionExample;
import online.store.pojoGroup.Specification;
import online.store.sellergoods.service.TbSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * (TbSpecification)表服务实现类
 *
 * @author makejava
 * @since 2018-10-09 14:22:54
 */
@Service
public class TbSpecificationServiceImpl implements TbSpecificationService {
    @Autowired
    private TbSpecificationMapper tbSpecificationMapper;

    @Autowired
    private TbSpecificationOptionMapper tbSpecificationOptionMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
     @Override
    public Specification selectByPrimaryKey(Long id) {
         /*通过id查询到TbSpecification*/
         TbSpecification tbSpecification = this.tbSpecificationMapper.selectByPrimaryKey(id);
         Specification specification=new Specification();
         specification.setTbSpecification(tbSpecification);

         /*通过id查询TbSpecificationOption列表*/
         TbSpecificationOptionExample tbSpecificationOptionExample = new TbSpecificationOptionExample();
         TbSpecificationOptionExample.Criteria criteria = tbSpecificationOptionExample.createCriteria();
         criteria.andSpecIdEqualTo(id);
         List<TbSpecificationOption> tbSpecificationOptions = tbSpecificationOptionMapper.selectByExample(tbSpecificationOptionExample);
         specification.setSpecificationOptionList(tbSpecificationOptions);
         return specification;
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
     @Override
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
     @Override
    public List<TbSpecification> queryAllByLimit(){ 
        TbSpecificationExample tbSpecificationExample = new TbSpecificationExample();
       return tbSpecificationMapper.selectByExample(tbSpecificationExample);
    }

    /**
     * 新增数据
     *
     * @param specification 实例对象
     * @return 实例对象
     */
     @Override
    public TbSpecification insert(Specification specification) {
         TbSpecification tbSpecification=specification.getTbSpecification();
         this.tbSpecificationMapper.insert(tbSpecification);
         List<TbSpecificationOption> specificationOptionList = specification.getSpecificationOptionList();
         for (TbSpecificationOption option:specificationOptionList){
             option.setSpecId(tbSpecification.getId());
             tbSpecificationOptionMapper.insert(option);
         }
         return tbSpecification;
    }

    /**
     * 修改数据
     *
     * @param specification 实例对象
     * @return 实例对象
     */
     @Override
    public TbSpecification update(Specification specification) {
         /*将TbSpecification更新到数据库*/
         TbSpecification tbSpecification=specification.getTbSpecification();
         this.tbSpecificationMapper.updateByPrimaryKey(tbSpecification);

         /*将原来TbSpecificationOption数据删除*/
         TbSpecificationOptionExample tbSpecificationOptionExample = new TbSpecificationOptionExample();
         TbSpecificationOptionExample.Criteria criteria = tbSpecificationOptionExample.createCriteria();
         criteria.andSpecIdEqualTo(specification.getTbSpecification().getId());
         tbSpecificationOptionMapper.deleteByExample(tbSpecificationOptionExample);

         /*将新数据插入到表中*/
         List<TbSpecificationOption> specificationOptionList = specification.getSpecificationOptionList();
         for (TbSpecificationOption option:specificationOptionList){
             option.setSpecId(tbSpecification.getId());
             tbSpecificationOptionMapper.insert(option);
         }
         return tbSpecification;
    }

    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
     @Override
    public boolean deleteByPrimaryKey(Long id) {
        return this.tbSpecificationMapper.deleteByPrimaryKey(id) > 0;
    }
    
     /**
     * 模糊查询并分页
     *
     * @param  tbSpecification 实例对象(封装有模糊查询的数据)
     * @return pageModel
     */
     @Override
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
     @Override
     public boolean deleteByPrimaryKeys(Long[]  ids){

         /*删除规格表中数据*/
        TbSpecificationExample tbSpecificationExample = new TbSpecificationExample();
        TbSpecificationExample.Criteria criteria = tbSpecificationExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));

        /*删除规格表选项数据*/
         TbSpecificationOptionExample tbSpecificationOptionExample=new TbSpecificationOptionExample();
         TbSpecificationOptionExample.Criteria criteria1 = tbSpecificationOptionExample.createCriteria();
         criteria1.andSpecIdIn(Arrays.asList(ids));

         return (tbSpecificationMapper.deleteByExample(tbSpecificationExample)> 0&&
                 tbSpecificationOptionMapper.deleteByExample(tbSpecificationOptionExample)>0);
        }

    @Override
    public List<Map> getSpecificationList() {
        return tbSpecificationMapper.getSpecificationList();
    }

}