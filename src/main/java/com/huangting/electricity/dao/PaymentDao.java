package com.huangting.electricity.dao;

import com.huangting.electricity.entity.Payment;

/**
 * Created by huangting on 2017/6/22.
 */
public interface PaymentDao {

    /**
     * 添加一条购电订单
     * @param payment
     * @return
     */
    Integer addPayment(Payment payment);

    /**
     * 根据订单的ID号查询订单信息
     * @param id
     * @return
     */
    Payment queryById(Integer id);

    /**
     * 修改订单的信息
     * @param payment
     * @return
     */
    Integer updatePayment(Payment payment);
    
    /**
     * 根据id删除订单
     * @param id
     * @return
     */
    Integer deletePayment(Integer id);
}
