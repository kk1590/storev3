package online.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.Page;
import online.store.entity.TbGoodsExample;
import online.store.entity.TbGoods;
import online.store.mapper.TbGoodsMapper;
import online.store.service.TbGoodsService;
import entity.PageModel;
import com.alibaba.dubbo.config.annotation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.List;

/**
 * (TbGoods)表服务实现类
 *
 * @author makejava
 * @since 2018-10-09 11:19:53
 */
@Service
public class TbGoodsServiceImpl implements TbGoodsService {
    @Autowired
    private TbGoodsMapper tbGoodsMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public TbGoods selectByPrimaryKey(Long id) {
        return this.tbGoodsMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public PageModel<TbGoods> queryAllByLimit(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        TbGoodsExample tbGoodsExample = new TbGoodsExample();
        Page<TbGoods> pages = (Page<TbGoods>) tbGoodsMapper.selectByExample(tbGoodsExample);
        return new PageModel(pages.getTotal(), pages.getResult());
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    public List<TbGoods> queryAllByLimit(){ 
        TbGoodsExample tbGoodsExample = new TbGoodsExample();
       return tbGoodsMapper.selectByExample(tbGoodsExample);
    }

    /**
     * 新增数据
     *
     * @param tbGoods 实例对象
     * @return 实例对象
     */
    public TbGoods insert(TbGoods tbGoods) {
        this.tbGoodsMapper.insert(tbGoods);
        return tbGoods;
    }

    /**
     * 修改数据
     *
     * @param tbGoods 实例对象
     * @return 实例对象
     */
    public TbGoods update(TbGoods tbGoods) {
        this.tbGoodsMapper.updateByPrimaryKey(tbGoods);
        return this.selectByPrimaryKey(tbGoods.getId());
    }
    
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteByPrimaryKey(Long id) {
        return this.tbGoodsMapper.deleteByPrimaryKey(id) > 0;
    }
    
     /**
     * 模糊查询并分页
     *
     * @param  tbGoods 实例对象(封装有模糊查询的数据)
     * @return pageModel
     */
    public PageModel<TbGoods> queryAllByLimit(TbGoods tbGoods, int offset, int limit){
        PageHelper.startPage(offset, limit);
        TbGoodsExample tbGoodsExample = new TbGoodsExample();
        TbGoodsExample.Criteria criteria = tbGoodsExample.createCriteria();
        if (tbGoods != null) {
            
            if (tbGoods.getSellerId() != null && tbGoods.getSellerId().trim().length() != 0) {
                criteria.andSellerIdLike("%" + tbGoods.getSellerId() + "%");
            }
            
            if (tbGoods.getGoodsName() != null && tbGoods.getGoodsName().trim().length() != 0) {
                criteria.andGoodsNameLike("%" + tbGoods.getGoodsName() + "%");
            }
            
            
            if (tbGoods.getAuditStatus() != null && tbGoods.getAuditStatus().trim().length() != 0) {
                criteria.andAuditStatusLike("%" + tbGoods.getAuditStatus() + "%");
            }
            
            if (tbGoods.getIsMarketable() != null && tbGoods.getIsMarketable().trim().length() != 0) {
                criteria.andIsMarketableLike("%" + tbGoods.getIsMarketable() + "%");
            }
            
            
            if (tbGoods.getCaption() != null && tbGoods.getCaption().trim().length() != 0) {
                criteria.andCaptionLike("%" + tbGoods.getCaption() + "%");
            }
            
            
            
            
            if (tbGoods.getSmallPic() != null && tbGoods.getSmallPic().trim().length() != 0) {
                criteria.andSmallPicLike("%" + tbGoods.getSmallPic() + "%");
            }
            
            
            
            if (tbGoods.getIsEnableSpec() != null && tbGoods.getIsEnableSpec().trim().length() != 0) {
                criteria.andIsEnableSpecLike("%" + tbGoods.getIsEnableSpec() + "%");
            }
            
            if (tbGoods.getIsDelete() != null && tbGoods.getIsDelete().trim().length() != 0) {
                criteria.andIsDeleteLike("%" + tbGoods.getIsDelete() + "%");
            }
            
        }
        Page<TbGoods> pages = (Page<TbGoods>) tbGoodsMapper.selectByExample(tbGoodsExample);
        return new PageModel(pages.getTotal(), pages.getResult());
        }
    /**
     * 通过主键列表删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
     public boolean deleteByPrimaryKeys(Long[]  ids){
        TbGoodsExample tbGoodsExample = new TbGoodsExample();
        TbGoodsExample.Criteria criteria = tbGoodsExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        return tbGoodsMapper.deleteByExample(tbGoodsExample)> 0;
        }
        
}