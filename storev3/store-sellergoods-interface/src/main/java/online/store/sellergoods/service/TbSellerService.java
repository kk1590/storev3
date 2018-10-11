package online.store.sellergoods.service;

import entity.PageModel;
import online.store.pojo.TbSeller;

import java.util.List;


/**
 * (TbSeller)表服务接口
 *
 * @author makejava
 * @since 2018-10-09 11:19:53
 */
public interface TbSellerService {

    /**
     * 通过ID查询单条数据
     *
     * @param sellerId 主键
     * @return 实例对象
     */
    TbSeller selectByPrimaryKey(String sellerId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    PageModel<TbSeller> queryAllByLimit(int offset, int limit);


     /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<TbSeller> queryAllByLimit();


    /**
     * 新增数据
     *
     * @param tbSeller 实例对象
     * @return 实例对象
     */
    TbSeller insert(TbSeller tbSeller);

    /**
     * 修改数据
     *
     * @param tbSeller 实例对象
     * @return 实例对象
     */
    TbSeller update(TbSeller tbSeller);

    /**
     * 通过主键删除数据
     *
     * @param sellerId 主键
     * @return 是否成功
     */
    boolean deleteByPrimaryKey(String sellerId);

    /**
     * 模糊查询并分页
     *
     * @param  tbSeller 实例对象
     * @return pageModel
     */
    PageModel<TbSeller> queryAllByLimit(TbSeller tbSeller, int offset, int limit);
    
    /**
     * 通过主键列表删除数据
     *
     * @param sellerIds 主键列表
     * @return 是否成功
     */
     boolean deleteByPrimaryKeys(String[] sellerIds);

    /**
     * 更新商家状态
     * @param sellerId 商家id
     * @param status 要更新的状态
     */
    public void updateStatus(String sellerId,String status);
}