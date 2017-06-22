package com.huangting.electricity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by huangting on 2017/6/21.
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @RequestMapping("/hello")
    public String helloTest() {
        return "hello";
    }

}
