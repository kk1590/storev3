package online.store.content.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.Page;
import online.store.pojo.TbContentExample;
import online.store.pojo.TbContent;
import online.store.mapper.TbContentMapper;
import online.store.content.service.TbContentService;
import entity.PageModel;
import com.alibaba.dubbo.config.annotation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.List;

/**
 * (TbContent)表服务实现类
 *
 * @author makejava
 * @since 2018-10-09 11:19:53
 */
@Service
public class TbContentServiceImpl implements TbContentService {
    @Autowired
    private TbContentMapper tbContentMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbContent selectByPrimaryKey(Long id) {
        return this.tbContentMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public PageModel<TbContent> queryAllByLimit(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        TbContentExample tbContentExample = new TbContentExample();
        Page<TbContent> pages = (Page<TbContent>) tbContentMapper.selectByExample(tbContentExample);
        return new PageModel(pages.getTotal(), pages.getResult());
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<TbContent> queryAllByLimit(){ 
        TbContentExample tbContentExample = new TbContentExample();
       return tbContentMapper.selectByExample(tbContentExample);
    }

    /**
     * 新增数据
     *
     * @param tbContent 实例对象
     * @return 实例对象
     */
    @Override
    public TbContent insert(TbContent tbContent) {
        this.tbContentMapper.insert(tbContent);
        return tbContent;
    }

    /**
     * 修改数据
     *
     * @param tbContent 实例对象
     * @return 实例对象
     */
    @Override
    public TbContent update(TbContent tbContent) {
        this.tbContentMapper.updateByPrimaryKey(tbContent);
        return this.selectByPrimaryKey(tbContent.getId());
    }
    
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteByPrimaryKey(Long id) {
        return this.tbContentMapper.deleteByPrimaryKey(id) > 0;
    }
    
     /**
     * 模糊查询并分页
     *
     * @param  tbContent 实例对象(封装有模糊查询的数据)
     * @return pageModel
     */
     @Override
    public PageModel<TbContent> queryAllByLimit(TbContent tbContent, int offset, int limit){
        PageHelper.startPage(offset, limit);
        TbContentExample tbContentExample = new TbContentExample();
        TbContentExample.Criteria criteria = tbContentExample.createCriteria();
        if (tbContent != null) {
            
            
            if (tbContent.getTitle() != null && tbContent.getTitle().trim().length() != 0) {
                criteria.andTitleLike("%" + tbContent.getTitle() + "%");
            }
            
            if (tbContent.getUrl() != null && tbContent.getUrl().trim().length() != 0) {
                criteria.andUrlLike("%" + tbContent.getUrl() + "%");
            }
            
            if (tbContent.getPic() != null && tbContent.getPic().trim().length() != 0) {
                criteria.andPicLike("%" + tbContent.getPic() + "%");
            }
            
            if (tbContent.getStatus() != null && tbContent.getStatus().trim().length() != 0) {
                criteria.andStatusLike("%" + tbContent.getStatus() + "%");
            }
            
            
        }
        Page<TbContent> pages = (Page<TbContent>) tbContentMapper.selectByExample(tbContentExample);
        return new PageModel(pages.getTotal(), pages.getResult());
        }
    /**
     * 通过主键列表删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
    @Override
     public boolean deleteByPrimaryKeys(Long[]  ids){
        TbContentExample tbContentExample = new TbContentExample();
        TbContentExample.Criteria criteria = tbContentExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        return tbContentMapper.deleteByExample(tbContentExample)> 0;
        }
        
}