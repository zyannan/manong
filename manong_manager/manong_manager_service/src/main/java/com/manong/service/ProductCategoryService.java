package com.manong.service;

import pojo.EasyUITree;
import pojo.ResponseJsonResult;

import java.util.List;

/**
 * Created by zyannan on 2020/8/25
 */
public interface ProductCategoryService {

    List<EasyUITree> findProductCategoryListByParentId(Short parentid);

    ResponseJsonResult addCategory(Short parentid, String name);

    ResponseJsonResult updateCategory(Short id, String name);

    ResponseJsonResult deleteCategory(Short id);
}
