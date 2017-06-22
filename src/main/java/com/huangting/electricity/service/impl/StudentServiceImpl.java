package com.huangting.electricity.service.impl;

import com.huangting.electricity.dto.Result;
import com.huangting.electricity.entity.Payment;
import com.huangting.electricity.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * Created by huangting on 2017/6/21.
 */
@Service
public class StudentServiceImpl implements StudentService{
    @Override
    public Result<String> palceAnOrder(Payment payment) {
        return null;
    }

    @Override
    public Result<String> buyElectricity(Payment payment) {
        return null;
    }
}
