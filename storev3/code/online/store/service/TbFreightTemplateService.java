package online.store.service;

import online.store.entity.TbFreightTemplate;
import java.util.Arrays;
import java.util.List;
import entity.PageModel;
import entity.Result;


/**
 * (TbFreightTemplate)表服务接口
 *
 * @author makejava
 * @since 2018-10-09 11:19:53
 */
public interface TbFreightTemplateService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbFreightTemplate selectByPrimaryKey(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    PageModel<TbFreightTemplate> queryAllByLimit(int offset, int limit);


     /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<TbFreightTemplate> queryAllByLimit();


    /**
     * 新增数据
     *
     * @param tbFreightTemplate 实例对象
     * @return 实例对象
     */
    TbFreightTemplate insert(TbFreightTemplate tbFreightTemplate);

    /**
     * 修改数据
     *
     * @param tbFreightTemplate 实例对象
     * @return 实例对象
     */
    TbFreightTemplate update(TbFreightTemplate tbFreightTemplate);

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
     * @param  tbFreightTemplate 实例对象
     * @return pageModel
     */
    PageModel<TbFreightTemplate> queryAllByLimit(TbFreightTemplate tbFreightTemplate,int offset, int limit);
    
    /**
     * 通过主键列表删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
     boolean deleteByPrimaryKeys(Long[]  ids);
}