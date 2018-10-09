package online.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.Page;
import online.store.entity.TbAreasExample;
import online.store.entity.TbAreas;
import online.store.mapper.TbAreasMapper;
import online.store.service.TbAreasService;
import entity.PageModel;
import com.alibaba.dubbo.config.annotation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.List;

/**
 * 行政区域县区信息表(TbAreas)表服务实现类
 *
 * @author makejava
 * @since 2018-10-09 11:19:53
 */
@Service
public class TbAreasServiceImpl implements TbAreasService {
    @Autowired
    private TbAreasMapper tbAreasMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public TbAreas selectByPrimaryKey(Integer id) {
        return this.tbAreasMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public PageModel<TbAreas> queryAllByLimit(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        TbAreasExample tbAreasExample = new TbAreasExample();
        Page<TbAreas> pages = (Page<TbAreas>) tbAreasMapper.selectByExample(tbAreasExample);
        return new PageModel(pages.getTotal(), pages.getResult());
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    public List<TbAreas> queryAllByLimit(){ 
        TbAreasExample tbAreasExample = new TbAreasExample();
       return tbAreasMapper.selectByExample(tbAreasExample);
    }

    /**
     * 新增数据
     *
     * @param tbAreas 实例对象
     * @return 实例对象
     */
    public TbAreas insert(TbAreas tbAreas) {
        this.tbAreasMapper.insert(tbAreas);
        return tbAreas;
    }

    /**
     * 修改数据
     *
     * @param tbAreas 实例对象
     * @return 实例对象
     */
    public TbAreas update(TbAreas tbAreas) {
        this.tbAreasMapper.updateByPrimaryKey(tbAreas);
        return this.selectByPrimaryKey(tbAreas.getId());
    }
    
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteByPrimaryKey(Integer id) {
        return this.tbAreasMapper.deleteByPrimaryKey(id) > 0;
    }
    
     /**
     * 模糊查询并分页
     *
     * @param  tbAreas 实例对象(封装有模糊查询的数据)
     * @return pageModel
     */
    public PageModel<TbAreas> queryAllByLimit(TbAreas tbAreas, int offset, int limit){
        PageHelper.startPage(offset, limit);
        TbAreasExample tbAreasExample = new TbAreasExample();
        TbAreasExample.Criteria criteria = tbAreasExample.createCriteria();
        if (tbAreas != null) {
            
            if (tbAreas.getAreaid() != null && tbAreas.getAreaid().trim().length() != 0) {
                criteria.andAreaidLike("%" + tbAreas.getAreaid() + "%");
            }
            
            if (tbAreas.getArea() != null && tbAreas.getArea().trim().length() != 0) {
                criteria.andAreaLike("%" + tbAreas.getArea() + "%");
            }
            
            if (tbAreas.getCityid() != null && tbAreas.getCityid().trim().length() != 0) {
                criteria.andCityidLike("%" + tbAreas.getCityid() + "%");
            }
            
        }
        Page<TbAreas> pages = (Page<TbAreas>) tbAreasMapper.selectByExample(tbAreasExample);
        return new PageModel(pages.getTotal(), pages.getResult());
        }
    /**
     * 通过主键列表删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
     public boolean deleteByPrimaryKeys(Integer[]  ids){
        TbAreasExample tbAreasExample = new TbAreasExample();
        TbAreasExample.Criteria criteria = tbAreasExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        return tbAreasMapper.deleteByExample(tbAreasExample)> 0;
        }
        
}