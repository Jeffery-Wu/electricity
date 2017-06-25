package com.huangting.electricity.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.huangting.electricity.dto.Result;
import com.huangting.electricity.dto.StudentAndManagerLogin;
import com.huangting.electricity.entity.Manager;
import com.huangting.electricity.entity.Student;
import com.huangting.electricity.service.BaseService;

import io.swagger.annotations.ApiOperation;

/**
 * Created by huangting on 2017/6/24.
 */
@Controller
public class BaseController {

    @Resource
    private BaseService baseService;

    @RequestMapping(name = "/login", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "登录", httpMethod = "POST", response = JSONObject.class, notes = "系统成员的统一登录入口")
    public JSONObject login(
            @RequestBody StudentAndManagerLogin studentAndManagerLogin
            ) {
        Student student = studentAndManagerLogin.getStudent();
        Manager manager = studentAndManagerLogin.getManager();
        if (student != null) {
            /**
             * 学生登录
             */
            Result<String> result = baseService.login(Student.class, student);
            JSONObject json = new JSONObject();
            json.put("data",result);
            return json;
        } else {
            /**
             * 管理员登录
             */
            Result<String> result = baseService.login(Manager.class, manager);
            JSONObject json = new JSONObject();
            json.put("data", result);
            return json;
        }

    }

    @RequestMapping(value = "/")
    public String index() {
        return "/loginAndRegister";
    }

    @RequestMapping(value = "/home")
    public String home() {
        return "/home";
    }

    @RequestMapping(value = "/dataTable")
    public String dataTable() {
        return "/dataTable";
    }

    @RequestMapping(value = "/addStudent")
    public String addStudent() {
        return "/addStudent";
    }
}
