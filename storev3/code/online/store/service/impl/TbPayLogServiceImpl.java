package online.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.Page;
import online.store.entity.TbPayLogExample;
import online.store.entity.TbPayLog;
import online.store.mapper.TbPayLogMapper;
import online.store.service.TbPayLogService;
import entity.PageModel;
import com.alibaba.dubbo.config.annotation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.List;

/**
 * (TbPayLog)表服务实现类
 *
 * @author makejava
 * @since 2018-10-09 11:19:53
 */
@Service
public class TbPayLogServiceImpl implements TbPayLogService {
    @Autowired
    private TbPayLogMapper tbPayLogMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param outTradeNo 主键
     * @return 实例对象
     */
    public TbPayLog selectByPrimaryKey(String outTradeNo) {
        return this.tbPayLogMapper.selectByPrimaryKey(outTradeNo);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public PageModel<TbPayLog> queryAllByLimit(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        TbPayLogExample tbPayLogExample = new TbPayLogExample();
        Page<TbPayLog> pages = (Page<TbPayLog>) tbPayLogMapper.selectByExample(tbPayLogExample);
        return new PageModel(pages.getTotal(), pages.getResult());
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    public List<TbPayLog> queryAllByLimit(){ 
        TbPayLogExample tbPayLogExample = new TbPayLogExample();
       return tbPayLogMapper.selectByExample(tbPayLogExample);
    }

    /**
     * 新增数据
     *
     * @param tbPayLog 实例对象
     * @return 实例对象
     */
    public TbPayLog insert(TbPayLog tbPayLog) {
        this.tbPayLogMapper.insert(tbPayLog);
        return tbPayLog;
    }

    /**
     * 修改数据
     *
     * @param tbPayLog 实例对象
     * @return 实例对象
     */
    public TbPayLog update(TbPayLog tbPayLog) {
        this.tbPayLogMapper.updateByPrimaryKey(tbPayLog);
        return this.selectByPrimaryKey(tbPayLog.getOutTradeNo());
    }
    
    
    /**
     * 通过主键删除数据
     *
     * @param outTradeNo 主键
     * @return 是否成功
     */
    public boolean deleteByPrimaryKey(String outTradeNo) {
        return this.tbPayLogMapper.deleteByPrimaryKey(outTradeNo) > 0;
    }
    
     /**
     * 模糊查询并分页
     *
     * @param  tbPayLog 实例对象(封装有模糊查询的数据)
     * @return pageModel
     */
    public PageModel<TbPayLog> queryAllByLimit(TbPayLog tbPayLog, int offset, int limit){
        PageHelper.startPage(offset, limit);
        TbPayLogExample tbPayLogExample = new TbPayLogExample();
        TbPayLogExample.Criteria criteria = tbPayLogExample.createCriteria();
        if (tbPayLog != null) {
            if (tbPayLog.getOutTradeNo() != null && tbPayLog.getOutTradeNo().trim().length() != 0) {
                criteria.andOutTradeNoLike("%" + tbPayLog.getOutTradeNo() + "%");
            }
            
            
            
            
            if (tbPayLog.getUserId() != null && tbPayLog.getUserId().trim().length() != 0) {
                criteria.andUserIdLike("%" + tbPayLog.getUserId() + "%");
            }
            
            if (tbPayLog.getTransactionId() != null && tbPayLog.getTransactionId().trim().length() != 0) {
                criteria.andTransactionIdLike("%" + tbPayLog.getTransactionId() + "%");
            }
            
            if (tbPayLog.getTradeState() != null && tbPayLog.getTradeState().trim().length() != 0) {
                criteria.andTradeStateLike("%" + tbPayLog.getTradeState() + "%");
            }
            
            if (tbPayLog.getOrderList() != null && tbPayLog.getOrderList().trim().length() != 0) {
                criteria.andOrderListLike("%" + tbPayLog.getOrderList() + "%");
            }
            
            if (tbPayLog.getPayType() != null && tbPayLog.getPayType().trim().length() != 0) {
                criteria.andPayTypeLike("%" + tbPayLog.getPayType() + "%");
            }
            
        }
        Page<TbPayLog> pages = (Page<TbPayLog>) tbPayLogMapper.selectByExample(tbPayLogExample);
        return new PageModel(pages.getTotal(), pages.getResult());
        }
    /**
     * 通过主键列表删除数据
     *
     * @param outTradeNos 主键列表
     * @return 是否成功
     */
     public boolean deleteByPrimaryKeys(String[]  outTradeNos){
        TbPayLogExample tbPayLogExample = new TbPayLogExample();
        TbPayLogExample.Criteria criteria = tbPayLogExample.createCriteria();
        criteria.andIdIn(Arrays.asList(outTradeNos));
        return tbPayLogMapper.deleteByExample(tbPayLogExample)> 0;
        }
        
}