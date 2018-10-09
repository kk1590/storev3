package online.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.Page;
import online.store.entity.TbProvincesExample;
import online.store.entity.TbProvinces;
import online.store.mapper.TbProvincesMapper;
import online.store.service.TbProvincesService;
import entity.PageModel;
import com.alibaba.dubbo.config.annotation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.List;

/**
 * 省份信息表(TbProvinces)表服务实现类
 *
 * @author makejava
 * @since 2018-10-09 11:19:53
 */
@Service
public class TbProvincesServiceImpl implements TbProvincesService {
    @Autowired
    private TbProvincesMapper tbProvincesMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public TbProvinces selectByPrimaryKey(Integer id) {
        return this.tbProvincesMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public PageModel<TbProvinces> queryAllByLimit(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        TbProvincesExample tbProvincesExample = new TbProvincesExample();
        Page<TbProvinces> pages = (Page<TbProvinces>) tbProvincesMapper.selectByExample(tbProvincesExample);
        return new PageModel(pages.getTotal(), pages.getResult());
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    public List<TbProvinces> queryAllByLimit(){ 
        TbProvincesExample tbProvincesExample = new TbProvincesExample();
       return tbProvincesMapper.selectByExample(tbProvincesExample);
    }

    /**
     * 新增数据
     *
     * @param tbProvinces 实例对象
     * @return 实例对象
     */
    public TbProvinces insert(TbProvinces tbProvinces) {
        this.tbProvincesMapper.insert(tbProvinces);
        return tbProvinces;
    }

    /**
     * 修改数据
     *
     * @param tbProvinces 实例对象
     * @return 实例对象
     */
    public TbProvinces update(TbProvinces tbProvinces) {
        this.tbProvincesMapper.updateByPrimaryKey(tbProvinces);
        return this.selectByPrimaryKey(tbProvinces.getId());
    }
    
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteByPrimaryKey(Integer id) {
        return this.tbProvincesMapper.deleteByPrimaryKey(id) > 0;
    }
    
     /**
     * 模糊查询并分页
     *
     * @param  tbProvinces 实例对象(封装有模糊查询的数据)
     * @return pageModel
     */
    public PageModel<TbProvinces> queryAllByLimit(TbProvinces tbProvinces, int offset, int limit){
        PageHelper.startPage(offset, limit);
        TbProvincesExample tbProvincesExample = new TbProvincesExample();
        TbProvincesExample.Criteria criteria = tbProvincesExample.createCriteria();
        if (tbProvinces != null) {
            
            if (tbProvinces.getProvinceid() != null && tbProvinces.getProvinceid().trim().length() != 0) {
                criteria.andProvinceidLike("%" + tbProvinces.getProvinceid() + "%");
            }
            
            if (tbProvinces.getProvince() != null && tbProvinces.getProvince().trim().length() != 0) {
                criteria.andProvinceLike("%" + tbProvinces.getProvince() + "%");
            }
            
        }
        Page<TbProvinces> pages = (Page<TbProvinces>) tbProvincesMapper.selectByExample(tbProvincesExample);
        return new PageModel(pages.getTotal(), pages.getResult());
        }
    /**
     * 通过主键列表删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
     public boolean deleteByPrimaryKeys(Integer[]  ids){
        TbProvincesExample tbProvincesExample = new TbProvincesExample();
        TbProvincesExample.Criteria criteria = tbProvincesExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        return tbProvincesMapper.deleteByExample(tbProvincesExample)> 0;
        }
        
}