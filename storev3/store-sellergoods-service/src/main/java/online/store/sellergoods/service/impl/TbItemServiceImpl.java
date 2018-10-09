package online.store.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import entity.PageModel;
import online.store.mapper.TbItemMapper;
import online.store.pojo.TbItem;
import online.store.pojo.TbItemExample;
import online.store.sellergoods.service.TbItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * 商品表(TbItem)表服务实现类
 *
 * @author makejava
 * @since 2018-10-09 14:22:54
 */
@Service
public class TbItemServiceImpl implements TbItemService {
    @Autowired
    private TbItemMapper tbItemMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
     @Override
    public TbItem selectByPrimaryKey(Long id) {
        return this.tbItemMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
     @Override
    public PageModel<TbItem> queryAllByLimit(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        TbItemExample tbItemExample = new TbItemExample();
        Page<TbItem> pages = (Page<TbItem>) tbItemMapper.selectByExample(tbItemExample);
        return new PageModel(pages.getTotal(), pages.getResult());
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
     @Override
    public List<TbItem> queryAllByLimit(){ 
        TbItemExample tbItemExample = new TbItemExample();
       return tbItemMapper.selectByExample(tbItemExample);
    }

    /**
     * 新增数据
     *
     * @param tbItem 实例对象
     * @return 实例对象
     */
     @Override
    public TbItem insert(TbItem tbItem) {
        this.tbItemMapper.insert(tbItem);
        return tbItem;
    }

    /**
     * 修改数据
     *
     * @param tbItem 实例对象
     * @return 实例对象
     */
     @Override
    public TbItem update(TbItem tbItem) {
        this.tbItemMapper.updateByPrimaryKey(tbItem);
        return this.selectByPrimaryKey(tbItem.getId());
    }
    
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
     @Override
    public boolean deleteByPrimaryKey(Long id) {
        return this.tbItemMapper.deleteByPrimaryKey(id) > 0;
    }
    
     /**
     * 模糊查询并分页
     *
     * @param  tbItem 实例对象(封装有模糊查询的数据)
     * @return pageModel
     */
     @Override
    public PageModel<TbItem> queryAllByLimit(TbItem tbItem, int offset, int limit){
        PageHelper.startPage(offset, limit);
        TbItemExample tbItemExample = new TbItemExample();
        TbItemExample.Criteria criteria = tbItemExample.createCriteria();
        if (tbItem != null) {
            
            if (tbItem.getTitle() != null && tbItem.getTitle().trim().length() != 0) {
                criteria.andTitleLike("%" + tbItem.getTitle() + "%");
            }
            
            if (tbItem.getSellPoint() != null && tbItem.getSellPoint().trim().length() != 0) {
                criteria.andSellPointLike("%" + tbItem.getSellPoint() + "%");
            }
            
            
            
            
            if (tbItem.getBarcode() != null && tbItem.getBarcode().trim().length() != 0) {
                criteria.andBarcodeLike("%" + tbItem.getBarcode() + "%");
            }
            
            if (tbItem.getImage() != null && tbItem.getImage().trim().length() != 0) {
                criteria.andImageLike("%" + tbItem.getImage() + "%");
            }
            
            
            if (tbItem.getStatus() != null && tbItem.getStatus().trim().length() != 0) {
                criteria.andStatusLike("%" + tbItem.getStatus() + "%");
            }
            
            
            
            if (tbItem.getItemSn() != null && tbItem.getItemSn().trim().length() != 0) {
                criteria.andItemSnLike("%" + tbItem.getItemSn() + "%");
            }
            
            
            
            if (tbItem.getIsDefault() != null && tbItem.getIsDefault().trim().length() != 0) {
                criteria.andIsDefaultLike("%" + tbItem.getIsDefault() + "%");
            }
            
            
            if (tbItem.getSellerId() != null && tbItem.getSellerId().trim().length() != 0) {
                criteria.andSellerIdLike("%" + tbItem.getSellerId() + "%");
            }
            
            if (tbItem.getCartThumbnail() != null && tbItem.getCartThumbnail().trim().length() != 0) {
                criteria.andCartThumbnailLike("%" + tbItem.getCartThumbnail() + "%");
            }
            
            if (tbItem.getCategory() != null && tbItem.getCategory().trim().length() != 0) {
                criteria.andCategoryLike("%" + tbItem.getCategory() + "%");
            }
            
            if (tbItem.getBrand() != null && tbItem.getBrand().trim().length() != 0) {
                criteria.andBrandLike("%" + tbItem.getBrand() + "%");
            }
            
            if (tbItem.getSpec() != null && tbItem.getSpec().trim().length() != 0) {
                criteria.andSpecLike("%" + tbItem.getSpec() + "%");
            }
            
            if (tbItem.getSeller() != null && tbItem.getSeller().trim().length() != 0) {
                criteria.andSellerLike("%" + tbItem.getSeller() + "%");
            }
            
        }
        Page<TbItem> pages = (Page<TbItem>) tbItemMapper.selectByExample(tbItemExample);
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
        TbItemExample tbItemExample = new TbItemExample();
        TbItemExample.Criteria criteria = tbItemExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        return tbItemMapper.deleteByExample(tbItemExample)> 0;
        }
        
}