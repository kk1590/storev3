package online.store.pojoGroup;

import online.store.pojo.TbSpecification;
import online.store.pojo.TbSpecificationOption;

import java.io.Serializable;
import java.util.List;

/**
 *封装了提交数据
 * @author BigData
 */
public class Specification implements Serializable {

    private TbSpecification tbSpecification;

    private List<TbSpecificationOption> specificationOptionList;

    public TbSpecification getTbSpecification() {
        return tbSpecification;
    }

    public void setTbSpecification(TbSpecification tbSpecification) {
        this.tbSpecification = tbSpecification;
    }

    public List<TbSpecificationOption> getSpecificationOptionList() {
        return specificationOptionList;
    }

    public void setSpecificationOptionList(List<TbSpecificationOption> specificationOptionList) {
        this.specificationOptionList = specificationOptionList;
    }
}
