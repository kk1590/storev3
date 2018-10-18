package online.store.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import entity.PageModel;
import entity.Result;
import online.store.pojo.Goods;
import online.store.pojo.TbGoods;
import online.store.sellergoods.service.TbGoodsService;
import online.store.sellergoods.service.TbTypeTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * (TbGoods)表控制层
 *
 * @author makejava
 * @since 2018-10-09 14:41:41
 */
@RestController
@RequestMapping("tbGoods")
public class TbGoodsController {
    /**
     * 服务对象
     */
    @Reference
    private TbGoodsService tbGoodsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public Goods selectOne(Long id) {
        Goods goods = this.tbGoodsService.selectByPrimaryKey(id);
        System.out.println(goods.getTbItems());
        return goods;
    }

    /**
     * 查询出所有列表数据
     *
     * @return 列表数据
     */

    @RequestMapping("findAll")
    public List<TbGoods> findAll() {
        return tbGoodsService.queryAllByLimit();
    }

    /**
     * 分页查询出所有列表数据
     *
     * @param offset 当前页码,int 每页显示数量
     * @param limit  每页显示数量
     * @return 列表数据
     */

    @RequestMapping("findPage")
    public PageModel<TbGoods> getTbGoodsByPage(int offset, int limit) {
        return tbGoodsService.queryAllByLimit(offset, limit);
    }

    /**
     * 将1条pojod对象添加到数据库
     *
     * @param goods 实例对象
     * @return Result对象
     */

    @RequestMapping("add")
    public Result add(@RequestBody Goods goods) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        goods.getTbGoods().setSellerId(sellerId);
        try {
            tbGoodsService.insert(goods);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 通过pojo修改数据
     *
     * @param goods 实例对象
     * @return result结果对象
     */
    @RequestMapping("update")
    public Result update(@RequestBody Goods goods) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!sellerId.equals(goods.getTbGoods().getSellerId())) {
            return new Result(false, "非法请求");
        } else {
            try {
                tbGoodsService.update(goods);
                return new Result(true, "保存成功");
            } catch (Exception e) {
                e.printStackTrace();
                return new Result(false, "保存失败");
            }
        }
    }

    /**
     * 通过主键列表删除数据
     *
     * @param ids 主键列表
     * @return result结果对象
     */
    @RequestMapping("delete")
    public Result deleteByIds(Long[] ids) {
        try {
            tbGoodsService.deleteByPrimaryKeys(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            return new Result(false, "删除失败");
        }
    }

    /**
     * 分页查询按条件查询数据
     * @param tbGoods 实例对象(封装了查询的关键字)
     * @return 列表数据
     */
    @RequestMapping("search")
    public PageModel<TbGoods> getTbGoodsByPage(@RequestBody TbGoods tbGoods, int offset, int limit) {
        if (tbGoods == null) {
            tbGoods = new TbGoods();
        }
        tbGoods.setSellerId(SecurityContextHolder.getContext().getAuthentication().getName());
        return tbGoodsService.queryAllByLimit(tbGoods, offset, limit);
    }


}