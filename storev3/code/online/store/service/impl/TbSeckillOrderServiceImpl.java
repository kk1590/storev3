package online.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.Page;
import online.store.entity.TbSeckillOrderExample;
import online.store.entity.TbSeckillOrder;
import online.store.mapper.TbSeckillOrderMapper;
import online.store.service.TbSeckillOrderService;
import entity.PageModel;
import com.alibaba.dubbo.config.annotation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.List;

/**
 * (TbSeckillOrder)表服务实现类
 *
 * @author makejava
 * @since 2018-10-09 11:19:53
 */
@Service
public class TbSeckillOrderServiceImpl implements TbSeckillOrderService {
    @Autowired
    private TbSeckillOrderMapper tbSeckillOrderMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public TbSeckillOrder selectByPrimaryKey(Long id) {
        return this.tbSeckillOrderMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public PageModel<TbSeckillOrder> queryAllByLimit(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        TbSeckillOrderExample tbSeckillOrderExample = new TbSeckillOrderExample();
        Page<TbSeckillOrder> pages = (Page<TbSeckillOrder>) tbSeckillOrderMapper.selectByExample(tbSeckillOrderExample);
        return new PageModel(pages.getTotal(), pages.getResult());
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    public List<TbSeckillOrder> queryAllByLimit(){ 
        TbSeckillOrderExample tbSeckillOrderExample = new TbSeckillOrderExample();
       return tbSeckillOrderMapper.selectByExample(tbSeckillOrderExample);
    }

    /**
     * 新增数据
     *
     * @param tbSeckillOrder 实例对象
     * @return 实例对象
     */
    public TbSeckillOrder insert(TbSeckillOrder tbSeckillOrder) {
        this.tbSeckillOrderMapper.insert(tbSeckillOrder);
        return tbSeckillOrder;
    }

    /**
     * 修改数据
     *
     * @param tbSeckillOrder 实例对象
     * @return 实例对象
     */
    public TbSeckillOrder update(TbSeckillOrder tbSeckillOrder) {
        this.tbSeckillOrderMapper.updateByPrimaryKey(tbSeckillOrder);
        return this.selectByPrimaryKey(tbSeckillOrder.getId());
    }
    
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteByPrimaryKey(Long id) {
        return this.tbSeckillOrderMapper.deleteByPrimaryKey(id) > 0;
    }
    
     /**
     * 模糊查询并分页
     *
     * @param  tbSeckillOrder 实例对象(封装有模糊查询的数据)
     * @return pageModel
     */
    public PageModel<TbSeckillOrder> queryAllByLimit(TbSeckillOrder tbSeckillOrder, int offset, int limit){
        PageHelper.startPage(offset, limit);
        TbSeckillOrderExample tbSeckillOrderExample = new TbSeckillOrderExample();
        TbSeckillOrderExample.Criteria criteria = tbSeckillOrderExample.createCriteria();
        if (tbSeckillOrder != null) {
            
            
            
            if (tbSeckillOrder.getUserId() != null && tbSeckillOrder.getUserId().trim().length() != 0) {
                criteria.andUserIdLike("%" + tbSeckillOrder.getUserId() + "%");
            }
            
            if (tbSeckillOrder.getSellerId() != null && tbSeckillOrder.getSellerId().trim().length() != 0) {
                criteria.andSellerIdLike("%" + tbSeckillOrder.getSellerId() + "%");
            }
            
            
            
            if (tbSeckillOrder.getStatus() != null && tbSeckillOrder.getStatus().trim().length() != 0) {
                criteria.andStatusLike("%" + tbSeckillOrder.getStatus() + "%");
            }
            
            if (tbSeckillOrder.getReceiverAddress() != null && tbSeckillOrder.getReceiverAddress().trim().length() != 0) {
                criteria.andReceiverAddressLike("%" + tbSeckillOrder.getReceiverAddress() + "%");
            }
            
            if (tbSeckillOrder.getReceiverMobile() != null && tbSeckillOrder.getReceiverMobile().trim().length() != 0) {
                criteria.andReceiverMobileLike("%" + tbSeckillOrder.getReceiverMobile() + "%");
            }
            
            if (tbSeckillOrder.getReceiver() != null && tbSeckillOrder.getReceiver().trim().length() != 0) {
                criteria.andReceiverLike("%" + tbSeckillOrder.getReceiver() + "%");
            }
            
            if (tbSeckillOrder.getTransactionId() != null && tbSeckillOrder.getTransactionId().trim().length() != 0) {
                criteria.andTransactionIdLike("%" + tbSeckillOrder.getTransactionId() + "%");
            }
            
        }
        Page<TbSeckillOrder> pages = (Page<TbSeckillOrder>) tbSeckillOrderMapper.selectByExample(tbSeckillOrderExample);
        return new PageModel(pages.getTotal(), pages.getResult());
        }
    /**
     * 通过主键列表删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
     public boolean deleteByPrimaryKeys(Long[]  ids){
        TbSeckillOrderExample tbSeckillOrderExample = new TbSeckillOrderExample();
        TbSeckillOrderExample.Criteria criteria = tbSeckillOrderExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        return tbSeckillOrderMapper.deleteByExample(tbSeckillOrderExample)> 0;
        }
        
}