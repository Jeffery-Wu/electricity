package com.huangting.electricity.dao;

import com.huangting.electricity.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created by huangting on 2017/6/22.
 */
@Mapper
@Component
public interface PaymentDao {

    /**
     * 添加一条购电订单
     * @param payment
     * @return
     */
    Integer addPayment(@Param("payment") Payment payment);

    /**
     * 根据订单的ID号查询订单信息
     * @param id
     * @return
     */
    Payment queryById(@Param("id") Long id);

    /**
     * 修改订单的信息
     * @param payment
     * @return
     */
    Integer updatePayment(@Param("payment") Payment payment);
    
    /**
     * 根据id删除订单
     * @param id
     * @return
     */
    Integer deletePayment(@Param("id") Integer id);
}
