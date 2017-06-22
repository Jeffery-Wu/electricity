package com.huangting.electricity.service;

import com.huangting.electricity.dto.Result;
import com.huangting.electricity.entity.Payment;

/**
 * Created by huangting on 2017/6/21.
 */
public interface StudentService {

    /**
     * 下订单
     * @param payment
     * @return
     */
    Result<String> palceAnOrder(Payment payment);

    /**
     * 根据订单购电
     * @param payment
     * @return
     */
    Result<String> buyElectricity(Payment payment);


}
