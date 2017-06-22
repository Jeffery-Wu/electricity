package com.huangting.electricity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huangting on 2017/6/21.
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloTest() {
        return "hello";
    }

    @RequestMapping(value = "say", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello() {return "hello";}
}
