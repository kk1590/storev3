package online.store.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import entity.PageModel;
import online.store.mapper.TbSellerMapper;
import online.store.pojo.TbSeller;
import online.store.pojo.TbSellerExample;
import online.store.sellergoods.service.TbSellerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * (TbSeller)表服务实现类
 *
 * @author makejava
 * @since 2018-10-09 14:22:54
 */
@Service
public class TbSellerServiceImpl implements TbSellerService {
    @Autowired
    private TbSellerMapper tbSellerMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param sellerId 主键
     * @return 实例对象
     */
     @Override
    public TbSeller selectByPrimaryKey(String sellerId) {
        return this.tbSellerMapper.selectByPrimaryKey(sellerId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
     @Override
    public PageModel<TbSeller> queryAllByLimit(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        TbSellerExample tbSellerExample = new TbSellerExample();
        Page<TbSeller> pages = (Page<TbSeller>) tbSellerMapper.selectByExample(tbSellerExample);
        return new PageModel(pages.getTotal(), pages.getResult());
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
     @Override
    public List<TbSeller> queryAllByLimit(){ 
        TbSellerExample tbSellerExample = new TbSellerExample();
       return tbSellerMapper.selectByExample(tbSellerExample);
    }

    /**
     * 新增数据
     *
     * @param tbSeller 实例对象
     * @return 实例对象
     */
     @Override
    public TbSeller insert(TbSeller tbSeller) {
         tbSeller.setStatus("0");
         tbSeller.setCreateTime(new Date());
         this.tbSellerMapper.insert(tbSeller);
         return tbSeller;
    }

    /**
     * 修改数据
     *
     * @param tbSeller 实例对象
     * @return 实例对象
     */
     @Override
    public TbSeller update(TbSeller tbSeller) {
        this.tbSellerMapper.updateByPrimaryKey(tbSeller);
        return this.selectByPrimaryKey(tbSeller.getSellerId());
    }
    
    
    /**
     * 通过主键删除数据
     *
     * @param sellerId 主键
     * @return 是否成功
     */
     @Override
    public boolean deleteByPrimaryKey(String sellerId) {
        return this.tbSellerMapper.deleteByPrimaryKey(sellerId) > 0;
    }
    
     /**
     * 模糊查询并分页
     *
     * @param  tbSeller 实例对象(封装有模糊查询的数据)
     * @return pageModel
     */
     @Override
    public PageModel<TbSeller> queryAllByLimit(TbSeller tbSeller, int offset, int limit){
        PageHelper.startPage(offset, limit);
        TbSellerExample tbSellerExample = new TbSellerExample();
        TbSellerExample.Criteria criteria = tbSellerExample.createCriteria();
        if (tbSeller != null) {
            if (tbSeller.getSellerId() != null && tbSeller.getSellerId().trim().length() != 0) {
                criteria.andSellerIdLike("%" + tbSeller.getSellerId() + "%");
            }
            
            if (tbSeller.getName() != null && tbSeller.getName().trim().length() != 0) {
                criteria.andNameLike("%" + tbSeller.getName() + "%");
            }
            
            if (tbSeller.getNickName() != null && tbSeller.getNickName().trim().length() != 0) {
                criteria.andNickNameLike("%" + tbSeller.getNickName() + "%");
            }
            
            if (tbSeller.getPassword() != null && tbSeller.getPassword().trim().length() != 0) {
                criteria.andPasswordLike("%" + tbSeller.getPassword() + "%");
            }
            
            if (tbSeller.getEmail() != null && tbSeller.getEmail().trim().length() != 0) {
                criteria.andEmailLike("%" + tbSeller.getEmail() + "%");
            }
            
            if (tbSeller.getMobile() != null && tbSeller.getMobile().trim().length() != 0) {
                criteria.andMobileLike("%" + tbSeller.getMobile() + "%");
            }
            
            if (tbSeller.getTelephone() != null && tbSeller.getTelephone().trim().length() != 0) {
                criteria.andTelephoneLike("%" + tbSeller.getTelephone() + "%");
            }
            
            if (tbSeller.getStatus() != null && tbSeller.getStatus().trim().length() != 0) {
                criteria.andStatusLike("%" + tbSeller.getStatus() + "%");
            }
            
            if (tbSeller.getAddressDetail() != null && tbSeller.getAddressDetail().trim().length() != 0) {
                criteria.andAddressDetailLike("%" + tbSeller.getAddressDetail() + "%");
            }
            
            if (tbSeller.getLinkmanName() != null && tbSeller.getLinkmanName().trim().length() != 0) {
                criteria.andLinkmanNameLike("%" + tbSeller.getLinkmanName() + "%");
            }
            
            if (tbSeller.getLinkmanQq() != null && tbSeller.getLinkmanQq().trim().length() != 0) {
                criteria.andLinkmanQqLike("%" + tbSeller.getLinkmanQq() + "%");
            }
            
            if (tbSeller.getLinkmanMobile() != null && tbSeller.getLinkmanMobile().trim().length() != 0) {
                criteria.andLinkmanMobileLike("%" + tbSeller.getLinkmanMobile() + "%");
            }
            
            if (tbSeller.getLinkmanEmail() != null && tbSeller.getLinkmanEmail().trim().length() != 0) {
                criteria.andLinkmanEmailLike("%" + tbSeller.getLinkmanEmail() + "%");
            }
            
            if (tbSeller.getLicenseNumber() != null && tbSeller.getLicenseNumber().trim().length() != 0) {
                criteria.andLicenseNumberLike("%" + tbSeller.getLicenseNumber() + "%");
            }
            
            if (tbSeller.getTaxNumber() != null && tbSeller.getTaxNumber().trim().length() != 0) {
                criteria.andTaxNumberLike("%" + tbSeller.getTaxNumber() + "%");
            }
            
            if (tbSeller.getOrgNumber() != null && tbSeller.getOrgNumber().trim().length() != 0) {
                criteria.andOrgNumberLike("%" + tbSeller.getOrgNumber() + "%");
            }
            
            
            if (tbSeller.getLogoPic() != null && tbSeller.getLogoPic().trim().length() != 0) {
                criteria.andLogoPicLike("%" + tbSeller.getLogoPic() + "%");
            }
            
            if (tbSeller.getBrief() != null && tbSeller.getBrief().trim().length() != 0) {
                criteria.andBriefLike("%" + tbSeller.getBrief() + "%");
            }
            
            
            if (tbSeller.getLegalPerson() != null && tbSeller.getLegalPerson().trim().length() != 0) {
                criteria.andLegalPersonLike("%" + tbSeller.getLegalPerson() + "%");
            }
            
            if (tbSeller.getLegalPersonCardId() != null && tbSeller.getLegalPersonCardId().trim().length() != 0) {
                criteria.andLegalPersonCardIdLike("%" + tbSeller.getLegalPersonCardId() + "%");
            }
            
            if (tbSeller.getBankUser() != null && tbSeller.getBankUser().trim().length() != 0) {
                criteria.andBankUserLike("%" + tbSeller.getBankUser() + "%");
            }
            
            if (tbSeller.getBankName() != null && tbSeller.getBankName().trim().length() != 0) {
                criteria.andBankNameLike("%" + tbSeller.getBankName() + "%");
            }
            
        }
        Page<TbSeller> pages = (Page<TbSeller>) tbSellerMapper.selectByExample(tbSellerExample);
        return new PageModel(pages.getTotal(), pages.getResult());
        }
    /**
     * 通过主键列表删除数据
     *
     * @param sellerIds 主键列表
     * @return 是否成功
     */
     @Override
     public boolean deleteByPrimaryKeys(String[]  sellerIds){
        TbSellerExample tbSellerExample = new TbSellerExample();
        TbSellerExample.Criteria criteria = tbSellerExample.createCriteria();
        criteria.andSellerIdIn(Arrays.asList(sellerIds));
        return tbSellerMapper.deleteByExample(tbSellerExample)> 0;
     }

    /**
     * 更新商家审核状态
     * @param sellerId
     * @param status
     */
    @Override
     public void updateStatus(String sellerId,String status){
        System.out.println("成功进入service");
         TbSeller tbSeller = tbSellerMapper.selectByPrimaryKey(sellerId);
         tbSeller.setStatus(status);
         tbSellerMapper.updateByPrimaryKey(tbSeller);
     }

}