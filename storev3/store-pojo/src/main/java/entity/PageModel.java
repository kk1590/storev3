package entity;

import online.store.pojo.TbBrand;

import java.io.Serializable;
import java.util.List;

/**
 *存放分页数据的pojo类
 * @author User
 */
public class PageModel<E> implements Serializable {

    private long total;
    private List<E> rows;

    public PageModel(long total, List<E> rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<E> getRows() {
        return rows;
    }

    public void setRows(List<E> rows) {
        this.rows = rows;
    }
}
