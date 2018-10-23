package online.store.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import entity.PageModel;
import online.store.mapper.TbGoodsDescMapper;
import online.store.pojo.TbGoodsDesc;
import online.store.pojo.TbGoodsDescExample;
import online.store.sellergoods.service.TbGoodsDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * (TbGoodsDesc)表服务实现类
 *
 * @author makejava
 * @since 2018-10-09 14:22:54
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbGoodsDescServiceImpl implements TbGoodsDescService {
    @Autowired
    private TbGoodsDescMapper tbGoodsDescMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param goodsId 主键
     * @return 实例对象
     */
     @Override
    public TbGoodsDesc selectByPrimaryKey(Long goodsId) {
        return this.tbGoodsDescMapper.selectByPrimaryKey(goodsId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
     @Override
    public PageModel<TbGoodsDesc> queryAllByLimit(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        TbGoodsDescExample tbGoodsDescExample = new TbGoodsDescExample();
        Page<TbGoodsDesc> pages = (Page<TbGoodsDesc>) tbGoodsDescMapper.selectByExample(tbGoodsDescExample);
        return new PageModel(pages.getTotal(), pages.getResult());
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
     @Override
    public List<TbGoodsDesc> queryAllByLimit(){ 
        TbGoodsDescExample tbGoodsDescExample = new TbGoodsDescExample();
       return tbGoodsDescMapper.selectByExample(tbGoodsDescExample);
    }

    /**
     * 新增数据
     *
     * @param tbGoodsDesc 实例对象
     * @return 实例对象
     */
     @Override
    public TbGoodsDesc insert(TbGoodsDesc tbGoodsDesc) {
        this.tbGoodsDescMapper.insert(tbGoodsDesc);
        return tbGoodsDesc;
    }

    /**
     * 修改数据
     *
     * @param tbGoodsDesc 实例对象
     * @return 实例对象
     */
     @Override
    public TbGoodsDesc update(TbGoodsDesc tbGoodsDesc) {
        this.tbGoodsDescMapper.updateByPrimaryKey(tbGoodsDesc);
        return this.selectByPrimaryKey(tbGoodsDesc.getGoodsId());
    }
    
    
    /**
     * 通过主键删除数据
     *
     * @param goodsId 主键
     * @return 是否成功
     */
     @Override
    public boolean deleteByPrimaryKey(Long goodsId) {
        return this.tbGoodsDescMapper.deleteByPrimaryKey(goodsId) > 0;
    }
    
     /**
     * 模糊查询并分页
     *
     * @param  tbGoodsDesc 实例对象(封装有模糊查询的数据)
     * @return pageModel
     */
     @Override
    public PageModel<TbGoodsDesc> queryAllByLimit(TbGoodsDesc tbGoodsDesc, int offset, int limit){
        PageHelper.startPage(offset, limit);
        TbGoodsDescExample tbGoodsDescExample = new TbGoodsDescExample();
        TbGoodsDescExample.Criteria criteria = tbGoodsDescExample.createCriteria();
        if (tbGoodsDesc != null) {
            
            if (tbGoodsDesc.getIntroduction() != null && tbGoodsDesc.getIntroduction().trim().length() != 0) {
                criteria.andIntroductionLike("%" + tbGoodsDesc.getIntroduction() + "%");
            }
            
            if (tbGoodsDesc.getSpecificationItems() != null && tbGoodsDesc.getSpecificationItems().trim().length() != 0) {
                criteria.andSpecificationItemsLike("%" + tbGoodsDesc.getSpecificationItems() + "%");
            }
            
            if (tbGoodsDesc.getCustomAttributeItems() != null && tbGoodsDesc.getCustomAttributeItems().trim().length() != 0) {
                criteria.andCustomAttributeItemsLike("%" + tbGoodsDesc.getCustomAttributeItems() + "%");
            }
            
            if (tbGoodsDesc.getItemImages() != null && tbGoodsDesc.getItemImages().trim().length() != 0) {
                criteria.andItemImagesLike("%" + tbGoodsDesc.getItemImages() + "%");
            }
            
            if (tbGoodsDesc.getPackageList() != null && tbGoodsDesc.getPackageList().trim().length() != 0) {
                criteria.andPackageListLike("%" + tbGoodsDesc.getPackageList() + "%");
            }
            
            if (tbGoodsDesc.getSaleService() != null && tbGoodsDesc.getSaleService().trim().length() != 0) {
                criteria.andSaleServiceLike("%" + tbGoodsDesc.getSaleService() + "%");
            }
            
        }
        Page<TbGoodsDesc> pages = (Page<TbGoodsDesc>) tbGoodsDescMapper.selectByExample(tbGoodsDescExample);
        return new PageModel(pages.getTotal(), pages.getResult());
        }
    /**
     * 通过主键列表删除数据
     *
     * @param goodsIds 主键列表
     * @return 是否成功
     */
     @Override
     public boolean deleteByPrimaryKeys(Long[]  goodsIds){
        TbGoodsDescExample tbGoodsDescExample = new TbGoodsDescExample();
        TbGoodsDescExample.Criteria criteria = tbGoodsDescExample.createCriteria();
        criteria.andGoodsIdIn(Arrays.asList(goodsIds));
        return tbGoodsDescMapper.deleteByExample(tbGoodsDescExample)> 0;
        }
        
}