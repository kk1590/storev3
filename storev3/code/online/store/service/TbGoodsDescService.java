package online.store.service;

import online.store.entity.TbGoodsDesc;
import java.util.Arrays;
import java.util.List;
import entity.PageModel;
import entity.Result;


/**
 * (TbGoodsDesc)表服务接口
 *
 * @author makejava
 * @since 2018-10-09 11:19:53
 */
public interface TbGoodsDescService {

    /**
     * 通过ID查询单条数据
     *
     * @param goodsId 主键
     * @return 实例对象
     */
    TbGoodsDesc selectByPrimaryKey(Long goodsId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    PageModel<TbGoodsDesc> queryAllByLimit(int offset, int limit);


     /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<TbGoodsDesc> queryAllByLimit();


    /**
     * 新增数据
     *
     * @param tbGoodsDesc 实例对象
     * @return 实例对象
     */
    TbGoodsDesc insert(TbGoodsDesc tbGoodsDesc);

    /**
     * 修改数据
     *
     * @param tbGoodsDesc 实例对象
     * @return 实例对象
     */
    TbGoodsDesc update(TbGoodsDesc tbGoodsDesc);

    /**
     * 通过主键删除数据
     *
     * @param goodsId 主键
     * @return 是否成功
     */
    boolean deleteByPrimaryKey(Long goodsId);

    /**
     * 模糊查询并分页
     *
     * @param  tbGoodsDesc 实例对象
     * @return pageModel
     */
    PageModel<TbGoodsDesc> queryAllByLimit(TbGoodsDesc tbGoodsDesc,int offset, int limit);
    
    /**
     * 通过主键列表删除数据
     *
     * @param goodsIds 主键列表
     * @return 是否成功
     */
     boolean deleteByPrimaryKeys(Long[]  goodsIds);
}