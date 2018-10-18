package online.store.pojo;

import java.io.Serializable;
import java.util.List;

public class Goods implements Serializable {

    private TbGoods tbGoods;
    private TbGoodsDesc tbGoodsDesc;
    private List<TbItem> tbItems;


    public Goods(TbGoods tbGoods, TbGoodsDesc tbGoodsDesc, List<TbItem> tbItems) {
        this.tbGoods = tbGoods;
        this.tbGoodsDesc = tbGoodsDesc;
        this.tbItems = tbItems;
    }

    public Goods() {

    }

    public TbGoods getTbGoods() {
        return tbGoods;
    }

    public void setTbGoods(TbGoods tbGoods) {
        this.tbGoods = tbGoods;
    }

    public TbGoodsDesc getTbGoodsDesc() {
        return tbGoodsDesc;
    }

    public void setTbGoodsDesc(TbGoodsDesc tbGoodsDesc) {
        this.tbGoodsDesc = tbGoodsDesc;
    }

    public List<TbItem> getTbItems() {
        return tbItems;
    }

    public void setTbItems(List<TbItem> tbItems) {
        this.tbItems = tbItems;
    }
}
