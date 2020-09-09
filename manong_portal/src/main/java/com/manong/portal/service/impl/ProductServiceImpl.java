package com.manong.portal.service.impl;

import com.manong.portal.service.ProductService;
import com.manong.portal.util.GsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pojo.Res_Categories;
import pojo.Res_Product;
import pojo.ResponseJsonResult;
import utils.HttpClientUtil;

import java.io.IOException;
import java.util.List;

/**
 * Created by zyannan on 2020/9/9
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Value("${REST_URL}")
    private String REST_URL;

    @Value("${REST_PRODUCT_LIST}")
    private String REST_PRODUCT_LIST;

    @Override
    public List<Res_Product> getProducts() {
        try {
            String resultJson = HttpClientUtil.httpGet(REST_URL + REST_PRODUCT_LIST);
            ResponseJsonResult responseJsonResult = GsonUtils.fromJson(ResponseJsonResult.class, resultJson);
            List<Res_Product> list = (List<Res_Product>) responseJsonResult.getList();
            return  list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
