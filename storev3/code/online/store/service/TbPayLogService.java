package online.store.service;

import online.store.entity.TbPayLog;
import java.util.Arrays;
import java.util.List;
import entity.PageModel;
import entity.Result;


/**
 * (TbPayLog)表服务接口
 *
 * @author makejava
 * @since 2018-10-09 11:19:53
 */
public interface TbPayLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param outTradeNo 主键
     * @return 实例对象
     */
    TbPayLog selectByPrimaryKey(String outTradeNo);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    PageModel<TbPayLog> queryAllByLimit(int offset, int limit);


     /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<TbPayLog> queryAllByLimit();


    /**
     * 新增数据
     *
     * @param tbPayLog 实例对象
     * @return 实例对象
     */
    TbPayLog insert(TbPayLog tbPayLog);

    /**
     * 修改数据
     *
     * @param tbPayLog 实例对象
     * @return 实例对象
     */
    TbPayLog update(TbPayLog tbPayLog);

    /**
     * 通过主键删除数据
     *
     * @param outTradeNo 主键
     * @return 是否成功
     */
    boolean deleteByPrimaryKey(String outTradeNo);

    /**
     * 模糊查询并分页
     *
     * @param  tbPayLog 实例对象
     * @return pageModel
     */
    PageModel<TbPayLog> queryAllByLimit(TbPayLog tbPayLog,int offset, int limit);
    
    /**
     * 通过主键列表删除数据
     *
     * @param outTradeNos 主键列表
     * @return 是否成功
     */
     boolean deleteByPrimaryKeys(String[]  outTradeNos);
}