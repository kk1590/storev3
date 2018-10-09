package online.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.Page;
import online.store.entity.TbBrandExample;
import online.store.entity.TbBrand;
import online.store.mapper.TbBrandMapper;
import online.store.service.TbBrandService;
import entity.PageModel;
import com.alibaba.dubbo.config.annotation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.List;

/**
 * (TbBrand)表服务实现类
 *
 * @author makejava
 * @since 2018-10-09 11:19:53
 */
@Service
public class TbBrandServiceImpl implements TbBrandService {
    @Autowired
    private TbBrandMapper tbBrandMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public TbBrand selectByPrimaryKey(Long id) {
        return this.tbBrandMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public PageModel<TbBrand> queryAllByLimit(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        TbBrandExample tbBrandExample = new TbBrandExample();
        Page<TbBrand> pages = (Page<TbBrand>) tbBrandMapper.selectByExample(tbBrandExample);
        return new PageModel(pages.getTotal(), pages.getResult());
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    public List<TbBrand> queryAllByLimit(){ 
        TbBrandExample tbBrandExample = new TbBrandExample();
       return tbBrandMapper.selectByExample(tbBrandExample);
    }

    /**
     * 新增数据
     *
     * @param tbBrand 实例对象
     * @return 实例对象
     */
    public TbBrand insert(TbBrand tbBrand) {
        this.tbBrandMapper.insert(tbBrand);
        return tbBrand;
    }

    /**
     * 修改数据
     *
     * @param tbBrand 实例对象
     * @return 实例对象
     */
    public TbBrand update(TbBrand tbBrand) {
        this.tbBrandMapper.updateByPrimaryKey(tbBrand);
        return this.selectByPrimaryKey(tbBrand.getId());
    }
    
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteByPrimaryKey(Long id) {
        return this.tbBrandMapper.deleteByPrimaryKey(id) > 0;
    }
    
     /**
     * 模糊查询并分页
     *
     * @param  tbBrand 实例对象(封装有模糊查询的数据)
     * @return pageModel
     */
    public PageModel<TbBrand> queryAllByLimit(TbBrand tbBrand, int offset, int limit){
        PageHelper.startPage(offset, limit);
        TbBrandExample tbBrandExample = new TbBrandExample();
        TbBrandExample.Criteria criteria = tbBrandExample.createCriteria();
        if (tbBrand != null) {
            
            if (tbBrand.getName() != null && tbBrand.getName().trim().length() != 0) {
                criteria.andNameLike("%" + tbBrand.getName() + "%");
            }
            
            if (tbBrand.getFirstChar() != null && tbBrand.getFirstChar().trim().length() != 0) {
                criteria.andFirstCharLike("%" + tbBrand.getFirstChar() + "%");
            }
            
        }
        Page<TbBrand> pages = (Page<TbBrand>) tbBrandMapper.selectByExample(tbBrandExample);
        return new PageModel(pages.getTotal(), pages.getResult());
        }
    /**
     * 通过主键列表删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
     public boolean deleteByPrimaryKeys(Long[]  ids){
        TbBrandExample tbBrandExample = new TbBrandExample();
        TbBrandExample.Criteria criteria = tbBrandExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        return tbBrandMapper.deleteByExample(tbBrandExample)> 0;
        }
        
}