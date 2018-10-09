package online.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.Page;
import online.store.entity.TbSeckillGoodsExample;
import online.store.entity.TbSeckillGoods;
import online.store.mapper.TbSeckillGoodsMapper;
import online.store.service.TbSeckillGoodsService;
import entity.PageModel;
import com.alibaba.dubbo.config.annotation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.List;

/**
 * (TbSeckillGoods)表服务实现类
 *
 * @author makejava
 * @since 2018-10-09 11:19:53
 */
@Service
public class TbSeckillGoodsServiceImpl implements TbSeckillGoodsService {
    @Autowired
    private TbSeckillGoodsMapper tbSeckillGoodsMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public TbSeckillGoods selectByPrimaryKey(Long id) {
        return this.tbSeckillGoodsMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public PageModel<TbSeckillGoods> queryAllByLimit(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        TbSeckillGoodsExample tbSeckillGoodsExample = new TbSeckillGoodsExample();
        Page<TbSeckillGoods> pages = (Page<TbSeckillGoods>) tbSeckillGoodsMapper.selectByExample(tbSeckillGoodsExample);
        return new PageModel(pages.getTotal(), pages.getResult());
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    public List<TbSeckillGoods> queryAllByLimit(){ 
        TbSeckillGoodsExample tbSeckillGoodsExample = new TbSeckillGoodsExample();
       return tbSeckillGoodsMapper.selectByExample(tbSeckillGoodsExample);
    }

    /**
     * 新增数据
     *
     * @param tbSeckillGoods 实例对象
     * @return 实例对象
     */
    public TbSeckillGoods insert(TbSeckillGoods tbSeckillGoods) {
        this.tbSeckillGoodsMapper.insert(tbSeckillGoods);
        return tbSeckillGoods;
    }

    /**
     * 修改数据
     *
     * @param tbSeckillGoods 实例对象
     * @return 实例对象
     */
    public TbSeckillGoods update(TbSeckillGoods tbSeckillGoods) {
        this.tbSeckillGoodsMapper.updateByPrimaryKey(tbSeckillGoods);
        return this.selectByPrimaryKey(tbSeckillGoods.getId());
    }
    
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteByPrimaryKey(Long id) {
        return this.tbSeckillGoodsMapper.deleteByPrimaryKey(id) > 0;
    }
    
     /**
     * 模糊查询并分页
     *
     * @param  tbSeckillGoods 实例对象(封装有模糊查询的数据)
     * @return pageModel
     */
    public PageModel<TbSeckillGoods> queryAllByLimit(TbSeckillGoods tbSeckillGoods, int offset, int limit){
        PageHelper.startPage(offset, limit);
        TbSeckillGoodsExample tbSeckillGoodsExample = new TbSeckillGoodsExample();
        TbSeckillGoodsExample.Criteria criteria = tbSeckillGoodsExample.createCriteria();
        if (tbSeckillGoods != null) {
            
            
            
            if (tbSeckillGoods.getTitle() != null && tbSeckillGoods.getTitle().trim().length() != 0) {
                criteria.andTitleLike("%" + tbSeckillGoods.getTitle() + "%");
            }
            
            if (tbSeckillGoods.getSmallPic() != null && tbSeckillGoods.getSmallPic().trim().length() != 0) {
                criteria.andSmallPicLike("%" + tbSeckillGoods.getSmallPic() + "%");
            }
            
            
            
            if (tbSeckillGoods.getSellerId() != null && tbSeckillGoods.getSellerId().trim().length() != 0) {
                criteria.andSellerIdLike("%" + tbSeckillGoods.getSellerId() + "%");
            }
            
            
            
            if (tbSeckillGoods.getStatus() != null && tbSeckillGoods.getStatus().trim().length() != 0) {
                criteria.andStatusLike("%" + tbSeckillGoods.getStatus() + "%");
            }
            
            
            
            
            
            if (tbSeckillGoods.getIntroduction() != null && tbSeckillGoods.getIntroduction().trim().length() != 0) {
                criteria.andIntroductionLike("%" + tbSeckillGoods.getIntroduction() + "%");
            }
            
        }
        Page<TbSeckillGoods> pages = (Page<TbSeckillGoods>) tbSeckillGoodsMapper.selectByExample(tbSeckillGoodsExample);
        return new PageModel(pages.getTotal(), pages.getResult());
        }
    /**
     * 通过主键列表删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
     public boolean deleteByPrimaryKeys(Long[]  ids){
        TbSeckillGoodsExample tbSeckillGoodsExample = new TbSeckillGoodsExample();
        TbSeckillGoodsExample.Criteria criteria = tbSeckillGoodsExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        return tbSeckillGoodsMapper.deleteByExample(tbSeckillGoodsExample)> 0;
        }
        
}