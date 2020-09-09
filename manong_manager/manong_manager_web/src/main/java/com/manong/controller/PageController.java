package com.manong.controller;

import com.manong.pojo.User;
import com.manong.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.EasyUITree;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zyannan on 2020/8/25
 * 页面管理控制器
 */
@Controller
public class PageController {
    @Autowired
    ProductCategoryService productCategoryService;

    @RequestMapping("{page}")
    public String getUserById(@PathVariable String page) {
        return page;
    }

    @RequestMapping("/")
    public String requestIndex() { return "index"; }


//    @RequestMapping("/product_add")
//    public String requestProductAdd(HttpServletRequest request){
//        List<EasyUITree> categories = productCategoryService.findProductCategoryListByParentId((short) 0);
//        request.getSession().setAttribute("categories",categories);
//
//        return "product_add";
//    }
}
