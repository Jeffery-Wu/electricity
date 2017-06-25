package com.huangting.electricity.controller;

import com.alibaba.fastjson.JSONObject;
import com.huangting.electricity.dto.Result;
import com.huangting.electricity.dto.StudentAndManagerLogin;
import com.huangting.electricity.entity.Manager;
import com.huangting.electricity.entity.Student;
import com.huangting.electricity.service.BaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by huangting on 2017/6/24.
 */
@Controller
@RequestMapping("/login")
public class BaseController {

    @Resource
    private BaseService baseService;

    @RequestMapping(name = "/", method = RequestMethod.POST)
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
}
