package com.ml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ZWL
 * @Version: 1.0
 * @create: 2020/2/17 21:30
 */
@Controller
public class MainController {
    /**
     * 转发到主页
     */
    @RequestMapping(value = "/index")
    public String toIndexPage(){
        //获取主页信息

        //转发到主页
        return "main";
    }
}
