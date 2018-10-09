package online.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.Page;
import online.store.entity.TbOrderItemExample;
import online.store.entity.TbOrderItem;
import online.store.mapper.TbOrderItemMapper;
import online.store.service.TbOrderItemService;
import entity.PageModel;
import com.alibaba.dubbo.config.annotation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.List;

/**
 * (TbOrderItem)表服务实现类
 *
 * @author makejava
 * @since 2018-10-09 11:19:53
 */
@Service
public class TbOrderItemServiceImpl implements TbOrderItemService {
    @Autowired
    private TbOrderItemMapper tbOrderItemMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public TbOrderItem selectByPrimaryKey(Long id) {
        return this.tbOrderItemMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public PageModel<TbOrderItem> queryAllByLimit(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        TbOrderItemExample tbOrderItemExample = new TbOrderItemExample();
        Page<TbOrderItem> pages = (Page<TbOrderItem>) tbOrderItemMapper.selectByExample(tbOrderItemExample);
        return new PageModel(pages.getTotal(), pages.getResult());
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    public List<TbOrderItem> queryAllByLimit(){ 
        TbOrderItemExample tbOrderItemExample = new TbOrderItemExample();
       return tbOrderItemMapper.selectByExample(tbOrderItemExample);
    }

    /**
     * 新增数据
     *
     * @param tbOrderItem 实例对象
     * @return 实例对象
     */
    public TbOrderItem insert(TbOrderItem tbOrderItem) {
        this.tbOrderItemMapper.insert(tbOrderItem);
        return tbOrderItem;
    }

    /**
     * 修改数据
     *
     * @param tbOrderItem 实例对象
     * @return 实例对象
     */
    public TbOrderItem update(TbOrderItem tbOrderItem) {
        this.tbOrderItemMapper.updateByPrimaryKey(tbOrderItem);
        return this.selectByPrimaryKey(tbOrderItem.getId());
    }
    
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteByPrimaryKey(Long id) {
        return this.tbOrderItemMapper.deleteByPrimaryKey(id) > 0;
    }
    
     /**
     * 模糊查询并分页
     *
     * @param  tbOrderItem 实例对象(封装有模糊查询的数据)
     * @return pageModel
     */
    public PageModel<TbOrderItem> queryAllByLimit(TbOrderItem tbOrderItem, int offset, int limit){
        PageHelper.startPage(offset, limit);
        TbOrderItemExample tbOrderItemExample = new TbOrderItemExample();
        TbOrderItemExample.Criteria criteria = tbOrderItemExample.createCriteria();
        if (tbOrderItem != null) {
            
            
            
            
            if (tbOrderItem.getTitle() != null && tbOrderItem.getTitle().trim().length() != 0) {
                criteria.andTitleLike("%" + tbOrderItem.getTitle() + "%");
            }
            
            
            
            
            if (tbOrderItem.getPicPath() != null && tbOrderItem.getPicPath().trim().length() != 0) {
                criteria.andPicPathLike("%" + tbOrderItem.getPicPath() + "%");
            }
            
            if (tbOrderItem.getSellerId() != null && tbOrderItem.getSellerId().trim().length() != 0) {
                criteria.andSellerIdLike("%" + tbOrderItem.getSellerId() + "%");
            }
            
        }
        Page<TbOrderItem> pages = (Page<TbOrderItem>) tbOrderItemMapper.selectByExample(tbOrderItemExample);
        return new PageModel(pages.getTotal(), pages.getResult());
        }
    /**
     * 通过主键列表删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
     public boolean deleteByPrimaryKeys(Long[]  ids){
        TbOrderItemExample tbOrderItemExample = new TbOrderItemExample();
        TbOrderItemExample.Criteria criteria = tbOrderItemExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        return tbOrderItemMapper.deleteByExample(tbOrderItemExample)> 0;
        }
        
}