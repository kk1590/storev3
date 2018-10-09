package online.store.sellergoods.service;

import entity.PageModel;
import entity.Result;
import online.store.pojo.TbBrand;

import java.util.List;

public interface BrandService {

    public List<TbBrand> findAll();

    public PageModel<TbBrand> getBrandByPage(int pageNum,int pageSize);

    public void add(TbBrand brand);

    public TbBrand findOne(Long id);

    void update(TbBrand brand);

    void deleteList(Long[] ids);

    PageModel search(TbBrand brand, int page, int size);
}
