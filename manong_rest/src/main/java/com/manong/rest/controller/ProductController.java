package com.manong.rest.controller;

import com.manong.rest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Res_Categories;
import pojo.ResponseJsonResult;

/**
 * Created by zyannan on 2020/9/9
 */
@Controller("ProductController")
@RequestMapping("/rest")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/product/list")
    @ResponseBody
    public ResponseJsonResult getProduct(){
        ResponseJsonResult responseJsonResult = productService.getProduct();
        return  responseJsonResult;
    }
}
