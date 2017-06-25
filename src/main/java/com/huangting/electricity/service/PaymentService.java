package com.huangting.electricity.service;

import com.huangting.electricity.dto.Result;
import com.huangting.electricity.entity.Payment;

/**
 * Created by huangting on 2017/6/22.
 */
public interface PaymentService {
    /**
     * 添加一条购电订单
     * @param payment
     * @return
     */
	Result<Integer> addPayment(Payment payment);

    /**
     * 根据订单的ID号查询订单信息
     * @param id
     * @return
     */
	Result<Payment> queryById(Long id);

    /**
     * 修改订单的信息
     * @param payment
     * @return
     */
	Result<Integer> updatePayment(Payment payment);

	/**
	 * 取消订单
	 * @param id
	 * @return
	 */
	Result<Integer> deletePayment(Integer id);
}
