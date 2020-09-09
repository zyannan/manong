package com.manong.service;

import com.manong.pojo.Product;
import pojo.EasyGrid;
import pojo.ResponseJsonResult;

/**
 * Created by zyannan on 2020/9/2
 */
public interface ProductService {
    ResponseJsonResult saveProduct(Product product);

    EasyGrid listProduct(int pages, int rows);
}
