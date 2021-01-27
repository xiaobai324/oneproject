package com.bh.oneproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:JL
 * @Date:2021/1/26
 */
@Controller
public class Test {
    @RequestMapping("/index")
    public String index(){
        return "frame";
    }
}
