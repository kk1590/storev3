package online.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.Page;
import online.store.entity.TbOrderExample;
import online.store.entity.TbOrder;
import online.store.mapper.TbOrderMapper;
import online.store.service.TbOrderService;
import entity.PageModel;
import com.alibaba.dubbo.config.annotation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.List;

/**
 * (TbOrder)表服务实现类
 *
 * @author makejava
 * @since 2018-10-09 11:19:53
 */
@Service
public class TbOrderServiceImpl implements TbOrderService {
    @Autowired
    private TbOrderMapper tbOrderMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    public TbOrder selectByPrimaryKey(Long orderId) {
        return this.tbOrderMapper.selectByPrimaryKey(orderId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public PageModel<TbOrder> queryAllByLimit(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        TbOrderExample tbOrderExample = new TbOrderExample();
        Page<TbOrder> pages = (Page<TbOrder>) tbOrderMapper.selectByExample(tbOrderExample);
        return new PageModel(pages.getTotal(), pages.getResult());
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    public List<TbOrder> queryAllByLimit(){ 
        TbOrderExample tbOrderExample = new TbOrderExample();
       return tbOrderMapper.selectByExample(tbOrderExample);
    }

    /**
     * 新增数据
     *
     * @param tbOrder 实例对象
     * @return 实例对象
     */
    public TbOrder insert(TbOrder tbOrder) {
        this.tbOrderMapper.insert(tbOrder);
        return tbOrder;
    }

    /**
     * 修改数据
     *
     * @param tbOrder 实例对象
     * @return 实例对象
     */
    public TbOrder update(TbOrder tbOrder) {
        this.tbOrderMapper.updateByPrimaryKey(tbOrder);
        return this.selectByPrimaryKey(tbOrder.getOrderId());
    }
    
    
    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 是否成功
     */
    public boolean deleteByPrimaryKey(Long orderId) {
        return this.tbOrderMapper.deleteByPrimaryKey(orderId) > 0;
    }
    
     /**
     * 模糊查询并分页
     *
     * @param  tbOrder 实例对象(封装有模糊查询的数据)
     * @return pageModel
     */
    public PageModel<TbOrder> queryAllByLimit(TbOrder tbOrder, int offset, int limit){
        PageHelper.startPage(offset, limit);
        TbOrderExample tbOrderExample = new TbOrderExample();
        TbOrderExample.Criteria criteria = tbOrderExample.createCriteria();
        if (tbOrder != null) {
            
            
            if (tbOrder.getPaymentType() != null && tbOrder.getPaymentType().trim().length() != 0) {
                criteria.andPaymentTypeLike("%" + tbOrder.getPaymentType() + "%");
            }
            
            if (tbOrder.getPostFee() != null && tbOrder.getPostFee().trim().length() != 0) {
                criteria.andPostFeeLike("%" + tbOrder.getPostFee() + "%");
            }
            
            if (tbOrder.getStatus() != null && tbOrder.getStatus().trim().length() != 0) {
                criteria.andStatusLike("%" + tbOrder.getStatus() + "%");
            }
            
            
            
            
            
            
            
            if (tbOrder.getShippingName() != null && tbOrder.getShippingName().trim().length() != 0) {
                criteria.andShippingNameLike("%" + tbOrder.getShippingName() + "%");
            }
            
            if (tbOrder.getShippingCode() != null && tbOrder.getShippingCode().trim().length() != 0) {
                criteria.andShippingCodeLike("%" + tbOrder.getShippingCode() + "%");
            }
            
            if (tbOrder.getUserId() != null && tbOrder.getUserId().trim().length() != 0) {
                criteria.andUserIdLike("%" + tbOrder.getUserId() + "%");
            }
            
            if (tbOrder.getBuyerMessage() != null && tbOrder.getBuyerMessage().trim().length() != 0) {
                criteria.andBuyerMessageLike("%" + tbOrder.getBuyerMessage() + "%");
            }
            
            if (tbOrder.getBuyerNick() != null && tbOrder.getBuyerNick().trim().length() != 0) {
                criteria.andBuyerNickLike("%" + tbOrder.getBuyerNick() + "%");
            }
            
            if (tbOrder.getBuyerRate() != null && tbOrder.getBuyerRate().trim().length() != 0) {
                criteria.andBuyerRateLike("%" + tbOrder.getBuyerRate() + "%");
            }
            
            if (tbOrder.getReceiverAreaName() != null && tbOrder.getReceiverAreaName().trim().length() != 0) {
                criteria.andReceiverAreaNameLike("%" + tbOrder.getReceiverAreaName() + "%");
            }
            
            if (tbOrder.getReceiverMobile() != null && tbOrder.getReceiverMobile().trim().length() != 0) {
                criteria.andReceiverMobileLike("%" + tbOrder.getReceiverMobile() + "%");
            }
            
            if (tbOrder.getReceiverZipCode() != null && tbOrder.getReceiverZipCode().trim().length() != 0) {
                criteria.andReceiverZipCodeLike("%" + tbOrder.getReceiverZipCode() + "%");
            }
            
            if (tbOrder.getReceiver() != null && tbOrder.getReceiver().trim().length() != 0) {
                criteria.andReceiverLike("%" + tbOrder.getReceiver() + "%");
            }
            
            
            if (tbOrder.getInvoiceType() != null && tbOrder.getInvoiceType().trim().length() != 0) {
                criteria.andInvoiceTypeLike("%" + tbOrder.getInvoiceType() + "%");
            }
            
            if (tbOrder.getSourceType() != null && tbOrder.getSourceType().trim().length() != 0) {
                criteria.andSourceTypeLike("%" + tbOrder.getSourceType() + "%");
            }
            
            if (tbOrder.getSellerId() != null && tbOrder.getSellerId().trim().length() != 0) {
                criteria.andSellerIdLike("%" + tbOrder.getSellerId() + "%");
            }
            
        }
        Page<TbOrder> pages = (Page<TbOrder>) tbOrderMapper.selectByExample(tbOrderExample);
        return new PageModel(pages.getTotal(), pages.getResult());
        }
    /**
     * 通过主键列表删除数据
     *
     * @param orderIds 主键列表
     * @return 是否成功
     */
     public boolean deleteByPrimaryKeys(Long[]  orderIds){
        TbOrderExample tbOrderExample = new TbOrderExample();
        TbOrderExample.Criteria criteria = tbOrderExample.createCriteria();
        criteria.andIdIn(Arrays.asList(orderIds));
        return tbOrderMapper.deleteByExample(tbOrderExample)> 0;
        }
        
}