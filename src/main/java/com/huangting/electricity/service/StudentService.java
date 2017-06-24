package com.huangting.electricity.service;

import com.huangting.electricity.dto.Result;
import com.huangting.electricity.entity.Payment;

/**
 * Created by huangting on 2017/6/21.
 */
public interface StudentService {

    /**
     * 下订单
     * 
     * 1.判断参数是否完整
     * 2.存入数据库
     * 3.存储失败——超时重新下订单/联系工作人员
     * 4.存储成功返回
     * @param payment
     * @return
     */
    Result<String> palceAnOrder(Payment payment);

    /**
     * 根据订单购电
     * 1.修改对应数据库
     * 2.修改失败——联系工作人员
     * @param payment
     * @return
     */
    Result<String> buyElectricity(Payment payment);


}
