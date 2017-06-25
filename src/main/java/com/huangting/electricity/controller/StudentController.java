package com.huangting.electricity.controller;

import com.alibaba.fastjson.JSONObject;
import com.huangting.electricity.dao.StudentDao;
import com.huangting.electricity.dto.Result;
import com.huangting.electricity.entity.Student;
import com.huangting.electricity.service.BaseService;
import com.huangting.electricity.service.StudentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by huangting on 2017/6/21.
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @RequestMapping(value = "/{id}/infor", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取学生用户的详细信息", httpMethod = "GET", response = JSONObject.class, notes = "获取学用户的详细信息")
    public JSONObject getStudentInfor(
        @ApiParam(required = true) @PathVariable("id") Long id
        ){
        JSONObject json = new JSONObject();
        Result<Student> result = studentService.getStudentInfo(id);
        json.put("data",result);
        return json;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "更新学生用户的信息", httpMethod = "PUT", response = JSONObject.class, notes = "更新学生用户的信息")
    public JSONObject updateStudentInfo(
        @ApiParam(required = true) @RequestBody Student student
        ) {
        JSONObject json = new JSONObject();
        Result<String> result = studentService.updateStudentInfo(student);
        json.put("data",result);
        return json;
    }

    @RequestMapping(value = "/buyElectricity/{paymentId}", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "学生购电", httpMethod = "PUT", response = JSONObject.class, notes = "学生购电")
    public JSONObject buyElectricity(
        @ApiParam(required = true) @PathVariable("paymentId") Long paymentId
        ) {
        JSONObject json = new JSONObject();
        Result<String> result = studentService.buyElectricity(paymentId);
        json.put("data",result);
        return json;
    }
}












