package com.manong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zyannan on 2020/9/1
 */
@Controller
public class FreemarkerTest {
    @RequestMapping("/hello")
    public String sayHello(Model model){
        model.addAttribute("name", "wistbean");
        return "hello";
    }
    @RequestMapping("/hi")
    public String sayHi(Model model){
        model.addAttribute("name", "wistbean");
        return "hi";
    }

}
