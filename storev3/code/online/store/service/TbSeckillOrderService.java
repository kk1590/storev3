package online.store.service;

import online.store.entity.TbSeckillOrder;
import java.util.Arrays;
import java.util.List;
import entity.PageModel;
import entity.Result;


/**
 * (TbSeckillOrder)表服务接口
 *
 * @author makejava
 * @since 2018-10-09 11:19:53
 */
public interface TbSeckillOrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbSeckillOrder selectByPrimaryKey(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    PageModel<TbSeckillOrder> queryAllByLimit(int offset, int limit);


     /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<TbSeckillOrder> queryAllByLimit();


    /**
     * 新增数据
     *
     * @param tbSeckillOrder 实例对象
     * @return 实例对象
     */
    TbSeckillOrder insert(TbSeckillOrder tbSeckillOrder);

    /**
     * 修改数据
     *
     * @param tbSeckillOrder 实例对象
     * @return 实例对象
     */
    TbSeckillOrder update(TbSeckillOrder tbSeckillOrder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteByPrimaryKey(Long id);

    /**
     * 模糊查询并分页
     *
     * @param  tbSeckillOrder 实例对象
     * @return pageModel
     */
    PageModel<TbSeckillOrder> queryAllByLimit(TbSeckillOrder tbSeckillOrder,int offset, int limit);
    
    /**
     * 通过主键列表删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
     boolean deleteByPrimaryKeys(Long[]  ids);
}