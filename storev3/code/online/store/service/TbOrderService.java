package online.store.service;

import online.store.entity.TbOrder;
import java.util.Arrays;
import java.util.List;
import entity.PageModel;
import entity.Result;


/**
 * (TbOrder)表服务接口
 *
 * @author makejava
 * @since 2018-10-09 11:19:53
 */
public interface TbOrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    TbOrder selectByPrimaryKey(Long orderId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    PageModel<TbOrder> queryAllByLimit(int offset, int limit);


     /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<TbOrder> queryAllByLimit();


    /**
     * 新增数据
     *
     * @param tbOrder 实例对象
     * @return 实例对象
     */
    TbOrder insert(TbOrder tbOrder);

    /**
     * 修改数据
     *
     * @param tbOrder 实例对象
     * @return 实例对象
     */
    TbOrder update(TbOrder tbOrder);

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 是否成功
     */
    boolean deleteByPrimaryKey(Long orderId);

    /**
     * 模糊查询并分页
     *
     * @param  tbOrder 实例对象
     * @return pageModel
     */
    PageModel<TbOrder> queryAllByLimit(TbOrder tbOrder,int offset, int limit);
    
    /**
     * 通过主键列表删除数据
     *
     * @param orderIds 主键列表
     * @return 是否成功
     */
     boolean deleteByPrimaryKeys(Long[]  orderIds);
}