package online.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.Page;
import online.store.entity.TbCitiesExample;
import online.store.entity.TbCities;
import online.store.mapper.TbCitiesMapper;
import online.store.service.TbCitiesService;
import entity.PageModel;
import com.alibaba.dubbo.config.annotation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.List;

/**
 * 行政区域地州市信息表(TbCities)表服务实现类
 *
 * @author makejava
 * @since 2018-10-09 11:19:53
 */
@Service
public class TbCitiesServiceImpl implements TbCitiesService {
    @Autowired
    private TbCitiesMapper tbCitiesMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public TbCities selectByPrimaryKey(Integer id) {
        return this.tbCitiesMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public PageModel<TbCities> queryAllByLimit(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        TbCitiesExample tbCitiesExample = new TbCitiesExample();
        Page<TbCities> pages = (Page<TbCities>) tbCitiesMapper.selectByExample(tbCitiesExample);
        return new PageModel(pages.getTotal(), pages.getResult());
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    public List<TbCities> queryAllByLimit(){ 
        TbCitiesExample tbCitiesExample = new TbCitiesExample();
       return tbCitiesMapper.selectByExample(tbCitiesExample);
    }

    /**
     * 新增数据
     *
     * @param tbCities 实例对象
     * @return 实例对象
     */
    public TbCities insert(TbCities tbCities) {
        this.tbCitiesMapper.insert(tbCities);
        return tbCities;
    }

    /**
     * 修改数据
     *
     * @param tbCities 实例对象
     * @return 实例对象
     */
    public TbCities update(TbCities tbCities) {
        this.tbCitiesMapper.updateByPrimaryKey(tbCities);
        return this.selectByPrimaryKey(tbCities.getId());
    }
    
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteByPrimaryKey(Integer id) {
        return this.tbCitiesMapper.deleteByPrimaryKey(id) > 0;
    }
    
     /**
     * 模糊查询并分页
     *
     * @param  tbCities 实例对象(封装有模糊查询的数据)
     * @return pageModel
     */
    public PageModel<TbCities> queryAllByLimit(TbCities tbCities, int offset, int limit){
        PageHelper.startPage(offset, limit);
        TbCitiesExample tbCitiesExample = new TbCitiesExample();
        TbCitiesExample.Criteria criteria = tbCitiesExample.createCriteria();
        if (tbCities != null) {
            
            if (tbCities.getCityid() != null && tbCities.getCityid().trim().length() != 0) {
                criteria.andCityidLike("%" + tbCities.getCityid() + "%");
            }
            
            if (tbCities.getCity() != null && tbCities.getCity().trim().length() != 0) {
                criteria.andCityLike("%" + tbCities.getCity() + "%");
            }
            
            if (tbCities.getProvinceid() != null && tbCities.getProvinceid().trim().length() != 0) {
                criteria.andProvinceidLike("%" + tbCities.getProvinceid() + "%");
            }
            
        }
        Page<TbCities> pages = (Page<TbCities>) tbCitiesMapper.selectByExample(tbCitiesExample);
        return new PageModel(pages.getTotal(), pages.getResult());
        }
    /**
     * 通过主键列表删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
     public boolean deleteByPrimaryKeys(Integer[]  ids){
        TbCitiesExample tbCitiesExample = new TbCitiesExample();
        TbCitiesExample.Criteria criteria = tbCitiesExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        return tbCitiesMapper.deleteByExample(tbCitiesExample)> 0;
        }
        
}