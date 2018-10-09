package online.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.Page;
import online.store.entity.TbItemCatExample;
import online.store.entity.TbItemCat;
import online.store.mapper.TbItemCatMapper;
import online.store.service.TbItemCatService;
import entity.PageModel;
import com.alibaba.dubbo.config.annotation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.List;

/**
 * 商品类目(TbItemCat)表服务实现类
 *
 * @author makejava
 * @since 2018-10-09 11:19:53
 */
@Service
public class TbItemCatServiceImpl implements TbItemCatService {
    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public TbItemCat selectByPrimaryKey(Long id) {
        return this.tbItemCatMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public PageModel<TbItemCat> queryAllByLimit(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        TbItemCatExample tbItemCatExample = new TbItemCatExample();
        Page<TbItemCat> pages = (Page<TbItemCat>) tbItemCatMapper.selectByExample(tbItemCatExample);
        return new PageModel(pages.getTotal(), pages.getResult());
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    public List<TbItemCat> queryAllByLimit(){ 
        TbItemCatExample tbItemCatExample = new TbItemCatExample();
       return tbItemCatMapper.selectByExample(tbItemCatExample);
    }

    /**
     * 新增数据
     *
     * @param tbItemCat 实例对象
     * @return 实例对象
     */
    public TbItemCat insert(TbItemCat tbItemCat) {
        this.tbItemCatMapper.insert(tbItemCat);
        return tbItemCat;
    }

    /**
     * 修改数据
     *
     * @param tbItemCat 实例对象
     * @return 实例对象
     */
    public TbItemCat update(TbItemCat tbItemCat) {
        this.tbItemCatMapper.updateByPrimaryKey(tbItemCat);
        return this.selectByPrimaryKey(tbItemCat.getId());
    }
    
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteByPrimaryKey(Long id) {
        return this.tbItemCatMapper.deleteByPrimaryKey(id) > 0;
    }
    
     /**
     * 模糊查询并分页
     *
     * @param  tbItemCat 实例对象(封装有模糊查询的数据)
     * @return pageModel
     */
    public PageModel<TbItemCat> queryAllByLimit(TbItemCat tbItemCat, int offset, int limit){
        PageHelper.startPage(offset, limit);
        TbItemCatExample tbItemCatExample = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = tbItemCatExample.createCriteria();
        if (tbItemCat != null) {
            
            
            if (tbItemCat.getName() != null && tbItemCat.getName().trim().length() != 0) {
                criteria.andNameLike("%" + tbItemCat.getName() + "%");
            }
            
            
        }
        Page<TbItemCat> pages = (Page<TbItemCat>) tbItemCatMapper.selectByExample(tbItemCatExample);
        return new PageModel(pages.getTotal(), pages.getResult());
        }
    /**
     * 通过主键列表删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
     public boolean deleteByPrimaryKeys(Long[]  ids){
        TbItemCatExample tbItemCatExample = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = tbItemCatExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        return tbItemCatMapper.deleteByExample(tbItemCatExample)> 0;
        }
        
}