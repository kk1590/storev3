package online.store.service;

import online.store.entity.TbCities;
import java.util.Arrays;
import java.util.List;
import entity.PageModel;
import entity.Result;


/**
 * 行政区域地州市信息表(TbCities)表服务接口
 *
 * @author makejava
 * @since 2018-10-09 11:19:53
 */
public interface TbCitiesService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbCities selectByPrimaryKey(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    PageModel<TbCities> queryAllByLimit(int offset, int limit);


     /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<TbCities> queryAllByLimit();


    /**
     * 新增数据
     *
     * @param tbCities 实例对象
     * @return 实例对象
     */
    TbCities insert(TbCities tbCities);

    /**
     * 修改数据
     *
     * @param tbCities 实例对象
     * @return 实例对象
     */
    TbCities update(TbCities tbCities);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteByPrimaryKey(Integer id);

    /**
     * 模糊查询并分页
     *
     * @param  tbCities 实例对象
     * @return pageModel
     */
    PageModel<TbCities> queryAllByLimit(TbCities tbCities,int offset, int limit);
    
    /**
     * 通过主键列表删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
     boolean deleteByPrimaryKeys(Integer[]  ids);
}