package online.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.Page;
import online.store.entity.TbUserExample;
import online.store.entity.TbUser;
import online.store.mapper.TbUserMapper;
import online.store.service.TbUserService;
import entity.PageModel;
import com.alibaba.dubbo.config.annotation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.List;

/**
 * 用户表(TbUser)表服务实现类
 *
 * @author makejava
 * @since 2018-10-09 11:19:53
 */
@Service
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    private TbUserMapper tbUserMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public TbUser selectByPrimaryKey(Long id) {
        return this.tbUserMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public PageModel<TbUser> queryAllByLimit(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        TbUserExample tbUserExample = new TbUserExample();
        Page<TbUser> pages = (Page<TbUser>) tbUserMapper.selectByExample(tbUserExample);
        return new PageModel(pages.getTotal(), pages.getResult());
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    public List<TbUser> queryAllByLimit(){ 
        TbUserExample tbUserExample = new TbUserExample();
       return tbUserMapper.selectByExample(tbUserExample);
    }

    /**
     * 新增数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    public TbUser insert(TbUser tbUser) {
        this.tbUserMapper.insert(tbUser);
        return tbUser;
    }

    /**
     * 修改数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    public TbUser update(TbUser tbUser) {
        this.tbUserMapper.updateByPrimaryKey(tbUser);
        return this.selectByPrimaryKey(tbUser.getId());
    }
    
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteByPrimaryKey(Long id) {
        return this.tbUserMapper.deleteByPrimaryKey(id) > 0;
    }
    
     /**
     * 模糊查询并分页
     *
     * @param  tbUser 实例对象(封装有模糊查询的数据)
     * @return pageModel
     */
    public PageModel<TbUser> queryAllByLimit(TbUser tbUser, int offset, int limit){
        PageHelper.startPage(offset, limit);
        TbUserExample tbUserExample = new TbUserExample();
        TbUserExample.Criteria criteria = tbUserExample.createCriteria();
        if (tbUser != null) {
            
            if (tbUser.getUsername() != null && tbUser.getUsername().trim().length() != 0) {
                criteria.andUsernameLike("%" + tbUser.getUsername() + "%");
            }
            
            if (tbUser.getPassword() != null && tbUser.getPassword().trim().length() != 0) {
                criteria.andPasswordLike("%" + tbUser.getPassword() + "%");
            }
            
            if (tbUser.getPhone() != null && tbUser.getPhone().trim().length() != 0) {
                criteria.andPhoneLike("%" + tbUser.getPhone() + "%");
            }
            
            if (tbUser.getEmail() != null && tbUser.getEmail().trim().length() != 0) {
                criteria.andEmailLike("%" + tbUser.getEmail() + "%");
            }
            
            
            
            if (tbUser.getSourceType() != null && tbUser.getSourceType().trim().length() != 0) {
                criteria.andSourceTypeLike("%" + tbUser.getSourceType() + "%");
            }
            
            if (tbUser.getNickName() != null && tbUser.getNickName().trim().length() != 0) {
                criteria.andNickNameLike("%" + tbUser.getNickName() + "%");
            }
            
            if (tbUser.getName() != null && tbUser.getName().trim().length() != 0) {
                criteria.andNameLike("%" + tbUser.getName() + "%");
            }
            
            if (tbUser.getStatus() != null && tbUser.getStatus().trim().length() != 0) {
                criteria.andStatusLike("%" + tbUser.getStatus() + "%");
            }
            
            if (tbUser.getHeadPic() != null && tbUser.getHeadPic().trim().length() != 0) {
                criteria.andHeadPicLike("%" + tbUser.getHeadPic() + "%");
            }
            
            if (tbUser.getQq() != null && tbUser.getQq().trim().length() != 0) {
                criteria.andQqLike("%" + tbUser.getQq() + "%");
            }
            
            
            if (tbUser.getIsMobileCheck() != null && tbUser.getIsMobileCheck().trim().length() != 0) {
                criteria.andIsMobileCheckLike("%" + tbUser.getIsMobileCheck() + "%");
            }
            
            if (tbUser.getIsEmailCheck() != null && tbUser.getIsEmailCheck().trim().length() != 0) {
                criteria.andIsEmailCheckLike("%" + tbUser.getIsEmailCheck() + "%");
            }
            
            if (tbUser.getSex() != null && tbUser.getSex().trim().length() != 0) {
                criteria.andSexLike("%" + tbUser.getSex() + "%");
            }
            
            
            
            
            
            
        }
        Page<TbUser> pages = (Page<TbUser>) tbUserMapper.selectByExample(tbUserExample);
        return new PageModel(pages.getTotal(), pages.getResult());
        }
    /**
     * 通过主键列表删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
     public boolean deleteByPrimaryKeys(Long[]  ids){
        TbUserExample tbUserExample = new TbUserExample();
        TbUserExample.Criteria criteria = tbUserExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        return tbUserMapper.deleteByExample(tbUserExample)> 0;
        }
        
}