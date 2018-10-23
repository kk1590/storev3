package online.store.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import entity.PageModel;
import online.store.mapper.*;
import online.store.pojo.*;
import online.store.sellergoods.service.TbGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * (TbGoods)表服务实现类
 *
 * @author makejava
 * @since 2018-10-09 14:22:54
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbGoodsServiceImpl implements TbGoodsService {
    @Autowired
    private TbGoodsMapper tbGoodsMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Goods selectByPrimaryKey(Long id) {
        Goods goods = new Goods();
        goods.setTbGoods(this.tbGoodsMapper.selectByPrimaryKey(id));
        goods.setTbGoodsDesc(this.tbGoodsDescMapper.selectByPrimaryKey(id));
        TbItemExample exmaple=new TbItemExample();
        TbItemExample.Criteria criteria = exmaple.createCriteria();
        criteria.andGoodsIdEqualTo(id);
        goods.setTbItems(this.tbItemMapper.selectByExample(exmaple));
        return goods;
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public PageModel<TbGoods> queryAllByLimit(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        TbGoodsExample tbGoodsExample = new TbGoodsExample();
        Page<TbGoods> pages = (Page<TbGoods>) tbGoodsMapper.selectByExample(tbGoodsExample);
        return new PageModel(pages.getTotal(), pages.getResult());
    }

    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<TbGoods> queryAllByLimit() {
        TbGoodsExample tbGoodsExample = new TbGoodsExample();
        return tbGoodsMapper.selectByExample(tbGoodsExample);
    }

    @Autowired
    private TbGoodsDescMapper tbGoodsDescMapper;

    @Autowired
    private TbSellerMapper tbSellerMapper;

    @Autowired
    private TbBrandMapper tbBrandMapper;

    @Autowired
    private TbItemMapper tbItemMapper;

    @Resource
    private TbItemCatMapper tbItemCatMapper;


    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(Goods goods) {

        /*将商品存入到数据库,并返回商品id*/
        TbGoods tbGoods = goods.getTbGoods();
        tbGoods.setAuditStatus("1");
        tbGoods.setIsMarketable("1");
        tbGoods.setIsDelete("1");
        int insert = this.tbGoodsMapper.insert(tbGoods);
        /*将查询的商品id赋值到goodsDesc*/
        TbGoodsDesc tbGoodsDesc = goods.getTbGoodsDesc();
        tbGoodsDesc.setGoodsId(tbGoods.getId());
        if (insert > 0) {
            insert = 0;
            insert = this.tbGoodsDescMapper.insert(tbGoodsDesc);
        } else {
        }
        insertGoods(goods,tbGoods,tbGoodsDesc);
    }

    private void insertGoods(Goods goods,TbGoods tbGoods,TbGoodsDesc tbGoodsDesc) {
        /*循环将tbItems插入到数据库*/
        List<TbItem> tbItems = goods.getTbItems();
        if ("1".equals(tbGoods.getIsEnableSpec())) {
            for (TbItem tbItem : tbItems) {
                setTbItemProterties(tbGoods,tbGoodsDesc,tbItem);
                int insert1 = tbItemMapper.insert(tbItem);
                tbGoods.setDefaultItemId(tbItems.get(0).getId());
            }
        }else {
            TbItem tbItem = new TbItem();
            setTbItemProterties(tbGoods,tbGoodsDesc,tbItem);
            tbItem.setNum(9999);
            tbItem.setPrice(tbGoods.getPrice());
            tbItemMapper.insert(tbItem);
            tbGoods.setDefaultItemId(tbItem.getId());
        }

        this.tbGoodsMapper.updateByPrimaryKey(tbGoods);
    }


    private TbItem setTbItemProterties(TbGoods tbGoods, TbGoodsDesc tbGoodsDesc,TbItem tbItem){
        tbItem.setTitle(tbGoods.getGoodsName());
        tbItem.setSellPoint(tbGoods.getCaption());
        String url = (String) JSONArray.parseArray(tbGoodsDesc.getItemImages(), Map.class).get(0).get("url");
        tbItem.setImage(url);
        tbItem.setCategoryid(tbGoods.getCategory3Id());
        Date now = new Date();
        tbItem.setCategory(tbItemCatMapper.selectByPrimaryKey(tbGoods.getCategory1Id()).getName());
        tbItem.setCreateTime(now);
        tbItem.setUpdateTime(now);
        tbItem.setCostPirce(tbGoods.getPrice());
        tbItem.setGoodsId(tbGoods.getId());
        tbItem.setSellerId(tbGoods.getSellerId());
        TbSeller tbSeller = tbSellerMapper.selectByPrimaryKey(tbGoods.getSellerId());
        tbItem.setSeller(tbSeller.getNickName());
        TbBrand tbBrand = tbBrandMapper.selectByPrimaryKey(tbGoods.getBrandId());
        tbItem.setBrand(tbBrand.getName());
        return tbItem;
    }

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(Goods goods) {
        this.tbGoodsDescMapper.updateByPrimaryKey(goods.getTbGoodsDesc());
        int update = this.tbGoodsMapper.updateByPrimaryKey(goods.getTbGoods());
        TbItemExample example=new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsIdEqualTo(goods.getTbGoods().getId());
        this.tbItemMapper.deleteByExample(example);
        insertGoods(goods,goods.getTbGoods(),goods.getTbGoodsDesc());
        return update>0;
    }


    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteByPrimaryKey(Long id) {
        return this.tbGoodsMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 模糊查询并分页
     *
     * @param tbGoods 实例对象(封装有模糊查询的数据)
     * @return pageModel
     */
    @Override
    public PageModel<TbGoods> queryAllByLimit(TbGoods tbGoods, int offset, int limit) {
        PageHelper.startPage(offset, limit);
        TbGoodsExample tbGoodsExample = new TbGoodsExample();
        TbGoodsExample.Criteria criteria = tbGoodsExample.createCriteria();
        if (tbGoods != null) {
            if (tbGoods.getSellerId() != null && tbGoods.getSellerId().trim().length() != 0) {
                criteria.andSellerIdLike("%" + tbGoods.getSellerId() + "%");
            }

            if (tbGoods.getGoodsName() != null && tbGoods.getGoodsName().trim().length() != 0) {
                criteria.andGoodsNameLike("%" + tbGoods.getGoodsName() + "%");
            }


            if (tbGoods.getAuditStatus() != null && tbGoods.getAuditStatus().trim().length() != 0) {
                criteria.andAuditStatusLike("%" + tbGoods.getAuditStatus() + "%");
            }

            if (tbGoods.getIsMarketable() != null && tbGoods.getIsMarketable().trim().length() != 0) {
                criteria.andIsMarketableLike("%" + tbGoods.getIsMarketable() + "%");
            }

            if (tbGoods.getCaption() != null && tbGoods.getCaption().trim().length() != 0) {
                criteria.andCaptionLike("%" + tbGoods.getCaption() + "%");
            }


            if (tbGoods.getSmallPic() != null && tbGoods.getSmallPic().trim().length() != 0) {
                criteria.andSmallPicLike("%" + tbGoods.getSmallPic() + "%");
            }

            if (tbGoods.getIsEnableSpec() != null && tbGoods.getIsEnableSpec().trim().length() != 0) {
                criteria.andIsEnableSpecLike("%" + tbGoods.getIsEnableSpec() + "%");
            }

            if (tbGoods.getIsDelete() != null && tbGoods.getIsDelete().trim().length() != 0) {
                criteria.andIsDeleteLike("%" + tbGoods.getIsDelete() + "%");
            }

        }
        Page<TbGoods> pages = (Page<TbGoods>) tbGoodsMapper.selectByExample(tbGoodsExample);
        return new PageModel(pages.getTotal(), pages.getResult());
    }

    /**
     * 通过主键列表删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
    @Override
    public boolean deleteByPrimaryKeys(Long[] ids) {
        TbGoodsExample tbGoodsExample = new TbGoodsExample();
        TbGoodsExample.Criteria criteria = tbGoodsExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        return tbGoodsMapper.deleteByExample(tbGoodsExample) > 0;
    }

}