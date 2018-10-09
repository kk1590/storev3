package online.store.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import entity.PageModel;
import online.store.mapper.TbBrandMapper;
import online.store.pojo.TbBrand;
import online.store.pojo.TbBrandExample;
import online.store.sellergoods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper brandMapper;

    @Override
    public List<TbBrand> findAll() {
        return brandMapper.findAll();
    }

    @Override
    public PageModel<TbBrand> getBrandByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(null);
        return new PageModel<TbBrand>(page.getTotal(), page.getResult());
    }

    @Override
    public void add(TbBrand brand) {
        brandMapper.insert(brand);
    }

    @Override
    public TbBrand findOne(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(TbBrand brand) {
        brandMapper.updateByPrimaryKey(brand);
    }

    @Override
    public void deleteList(Long[] ids) {
        TbBrandExample tbBrandExample = new TbBrandExample();
        TbBrandExample.Criteria criteria = tbBrandExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        brandMapper.deleteByExample(tbBrandExample);
    }

    @Override
    public PageModel search(TbBrand brand, int page, int size) {
        PageHelper.startPage(page, size);
        TbBrandExample brandExample = new TbBrandExample();
        TbBrandExample.Criteria criteria = brandExample.createCriteria();
        if (brand != null) {
            if (brand.getName() != null && brand.getName().trim().length() != 0) {
                criteria.andNameLike("%" + brand.getName() + "%");
            }
            if (brand.getFirstChar() != null && brand.getFirstChar().trim().length() != 0) {
                criteria.andFirstCharLike("%" + brand.getFirstChar().toUpperCase() + "%");
            }
        }
        Page<TbBrand> pages = (Page<TbBrand>) brandMapper.selectByExample(brandExample);
        return new PageModel(pages.getTotal(), pages.getResult());
    }

}
