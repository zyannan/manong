package com.manong.service.impl;

import com.manong.mapper.ProductCategoryMapper;
import com.manong.pojo.ProductCategory;
import com.manong.pojo.ProductCategoryExample;
import com.manong.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.EasyUITree;
import pojo.ResponseJsonResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyannan on 2020/8/25
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<EasyUITree> findProductCategoryListByParentId(Short parentid) {
        ProductCategoryExample productCategoryExample = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = productCategoryExample.createCriteria();
        criteria.andParentIdEqualTo(parentid);
        List<ProductCategory> productCategoryList = productCategoryMapper.selectByExample(productCategoryExample);
        List<EasyUITree> easyUITrees = new ArrayList<>(productCategoryList.size());
        for (ProductCategory productCategory :
                productCategoryList) {
            EasyUITree easyUITree = new EasyUITree();
            easyUITree.setId(productCategory.getId());
            easyUITree.setText(productCategory.getName());

            ProductCategoryExample productCategoryExample1 = new ProductCategoryExample();
            ProductCategoryExample.Criteria criteria1 = productCategoryExample1.createCriteria();
            criteria1.andParentIdEqualTo(productCategory.getId());
            List<ProductCategory> productCategoryList1 = productCategoryMapper.selectByExample(productCategoryExample1);
            if(productCategoryList1.size()>0){
                easyUITree.setState("closed");
            }else{
                easyUITree.setState("open");
            }

            easyUITrees.add(easyUITree);
        }
        return easyUITrees;
    }

    @Override
    public ResponseJsonResult addCategory(Short parentid, String name) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setParentId(parentid);
        productCategory.setName(name);

        int affectedRowCount = productCategoryMapper.insert(productCategory);
        ResponseJsonResult responseJsonResult = new ResponseJsonResult();
        responseJsonResult.setMsg(productCategory.getId() + "");

        return responseJsonResult;
    }

    @Override
    public ResponseJsonResult updateCategory(Short id, String name) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(id);
        productCategory.setName(name);

        int affectedRowCount = productCategoryMapper.updateByPrimaryKeySelective(productCategory);
        ResponseJsonResult responseJsonResult = new ResponseJsonResult();
        return responseJsonResult;
    }

    @Override
    public ResponseJsonResult deleteCategory(Short id) {

        deleteAllChildById(id);
        ResponseJsonResult responseJsonResult = new ResponseJsonResult();
        return responseJsonResult;
    }

    public void deleteAllChildById(Short id){
        productCategoryMapper.deleteByPrimaryKey(id);
        ProductCategoryExample productCategoryExample = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = productCategoryExample.createCriteria();
        criteria.andParentIdEqualTo(id);
        List<ProductCategory> productCategoryList = productCategoryMapper.selectByExample(productCategoryExample);

        for (ProductCategory productCategory :
                productCategoryList) {
            deleteAllChildById(productCategory.getId());
        }

    }
}
