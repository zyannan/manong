package com.manong.controller;

import com.manong.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.EasyUITree;
import pojo.ResponseJsonResult;

import java.util.List;

/**
 * Created by zyannan on 2020/8/25
 * 商品分类管理控制器
 */
@Controller
@RequestMapping("/product_category")
public class ProductCategoryController {

    @Autowired
    ProductCategoryService productCategoryService;

    /**
     * 根据parentid返回数据列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITree> getProductCategoryByParentId(@RequestParam(value = "id", defaultValue = "0") Short parentid) {

        List<EasyUITree> easyUITrees = productCategoryService.findProductCategoryListByParentId(parentid);
        return easyUITrees;
    }

    /**
     * 添加分类
     */
    @RequestMapping("/add")
    @ResponseBody
    public ResponseJsonResult addCategory(Short parentId,String name) {

        ResponseJsonResult responseJsonResult = productCategoryService.addCategory(parentId, name);

        return responseJsonResult;
    }

    /**
     * 添加分类
     */
    @RequestMapping("/update")
    @ResponseBody
    public ResponseJsonResult updateCategory(Short id,String name) {

        ResponseJsonResult responseJsonResult = productCategoryService.updateCategory(id, name);

        return responseJsonResult;
    }

    /**
     * 删除分类
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseJsonResult deleteCategory(Short id) {

        ResponseJsonResult responseJsonResult = productCategoryService.deleteCategory(id);

        return responseJsonResult;
    }


}
