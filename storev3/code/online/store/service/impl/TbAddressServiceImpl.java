package online.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.Page;
import online.store.entity.TbAddressExample;
import online.store.entity.TbAddress;
import online.store.mapper.TbAddressMapper;
import online.store.service.TbAddressService;
import entity.PageModel;
import com.alibaba.dubbo.config.annotation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.List;

/**
 * (TbAddress)表服务实现类
 *
 * @author makejava
 * @since 2018-10-09 11:19:53
 */
@Service
public class TbAddressServiceImpl implements TbAddressService {
    @Autowired
    private TbAddressMapper tbAddressMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public TbAddress selectByPrimaryKey(Long id) {
        return this.tbAddressMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public PageModel<TbAddress> queryAllByLimit(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        TbAddressExample tbAddressExample = new TbAddressExample();
        Page<TbAddress> pages = (Page<TbAddress>) tbAddressMapper.selectByExample(tbAddressExample);
        return new PageModel(pages.getTotal(), pages.getResult());
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    public List<TbAddress> queryAllByLimit(){ 
        TbAddressExample tbAddressExample = new TbAddressExample();
       return tbAddressMapper.selectByExample(tbAddressExample);
    }

    /**
     * 新增数据
     *
     * @param tbAddress 实例对象
     * @return 实例对象
     */
    public TbAddress insert(TbAddress tbAddress) {
        this.tbAddressMapper.insert(tbAddress);
        return tbAddress;
    }

    /**
     * 修改数据
     *
     * @param tbAddress 实例对象
     * @return 实例对象
     */
    public TbAddress update(TbAddress tbAddress) {
        this.tbAddressMapper.updateByPrimaryKey(tbAddress);
        return this.selectByPrimaryKey(tbAddress.getId());
    }
    
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteByPrimaryKey(Long id) {
        return this.tbAddressMapper.deleteByPrimaryKey(id) > 0;
    }
    
     /**
     * 模糊查询并分页
     *
     * @param  tbAddress 实例对象(封装有模糊查询的数据)
     * @return pageModel
     */
    public PageModel<TbAddress> queryAllByLimit(TbAddress tbAddress, int offset, int limit){
        PageHelper.startPage(offset, limit);
        TbAddressExample tbAddressExample = new TbAddressExample();
        TbAddressExample.Criteria criteria = tbAddressExample.createCriteria();
        if (tbAddress != null) {
            
            if (tbAddress.getUserId() != null && tbAddress.getUserId().trim().length() != 0) {
                criteria.andUserIdLike("%" + tbAddress.getUserId() + "%");
            }
            
            if (tbAddress.getProvinceId() != null && tbAddress.getProvinceId().trim().length() != 0) {
                criteria.andProvinceIdLike("%" + tbAddress.getProvinceId() + "%");
            }
            
            if (tbAddress.getCityId() != null && tbAddress.getCityId().trim().length() != 0) {
                criteria.andCityIdLike("%" + tbAddress.getCityId() + "%");
            }
            
            if (tbAddress.getTownId() != null && tbAddress.getTownId().trim().length() != 0) {
                criteria.andTownIdLike("%" + tbAddress.getTownId() + "%");
            }
            
            if (tbAddress.getMobile() != null && tbAddress.getMobile().trim().length() != 0) {
                criteria.andMobileLike("%" + tbAddress.getMobile() + "%");
            }
            
            if (tbAddress.getAddress() != null && tbAddress.getAddress().trim().length() != 0) {
                criteria.andAddressLike("%" + tbAddress.getAddress() + "%");
            }
            
            if (tbAddress.getContact() != null && tbAddress.getContact().trim().length() != 0) {
                criteria.andContactLike("%" + tbAddress.getContact() + "%");
            }
            
            if (tbAddress.getIsDefault() != null && tbAddress.getIsDefault().trim().length() != 0) {
                criteria.andIsDefaultLike("%" + tbAddress.getIsDefault() + "%");
            }
            
            if (tbAddress.getNotes() != null && tbAddress.getNotes().trim().length() != 0) {
                criteria.andNotesLike("%" + tbAddress.getNotes() + "%");
            }
            
            
            if (tbAddress.getAlias() != null && tbAddress.getAlias().trim().length() != 0) {
                criteria.andAliasLike("%" + tbAddress.getAlias() + "%");
            }
            
        }
        Page<TbAddress> pages = (Page<TbAddress>) tbAddressMapper.selectByExample(tbAddressExample);
        return new PageModel(pages.getTotal(), pages.getResult());
        }
    /**
     * 通过主键列表删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
     public boolean deleteByPrimaryKeys(Long[]  ids){
        TbAddressExample tbAddressExample = new TbAddressExample();
        TbAddressExample.Criteria criteria = tbAddressExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        return tbAddressMapper.deleteByExample(tbAddressExample)> 0;
        }
        
}