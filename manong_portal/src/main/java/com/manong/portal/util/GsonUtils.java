package com.manong.portal.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by zyannan on 2020/9/9
 */
public class GsonUtils {

    private static Gson gson = null;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson =  gsonBuilder.create();
    }

    public static String toJson(Object object){
        return gson.toJson(object);
    }

    public static <T> T fromJson(Class<T> clazz, String json){
        return gson.fromJson(json, clazz);
    }
}
