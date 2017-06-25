package com.huangting.electricity.controller;

import com.alibaba.fastjson.JSONObject;
import com.huangting.electricity.dto.Result;
import com.huangting.electricity.entity.Payment;
import com.huangting.electricity.service.StudentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by huangting on 2017/6/22.
 */
@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private StudentService studentService;

    @ResponseBody
    @RequestMapping(value = "/place" , method = RequestMethod.POST)
    @ApiOperation(value = "下订单", httpMethod = "POST", response = JSONObject.class, notes = "下订单")
    public JSONObject orderAPayment(
            @RequestBody Payment payment
            ) {
        JSONObject json = new JSONObject();
        Result<String> result = studentService.palceAnOrder(payment);
        json.put("data",result);
        return json;
    }
}
