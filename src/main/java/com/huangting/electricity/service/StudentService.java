package com.huangting.electricity.service;

import com.huangting.electricity.dto.Result;
import com.huangting.electricity.entity.Payment;
import com.huangting.electricity.entity.Student;

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
     * @param paymentId
     * @return
     */
    Result<String> buyElectricity(Long paymentId);

    /**
     * 根据学生的ID号获取学生的详细信息系统
     * @param id
     * @return
     */
    Result<Student> getStudentInfo(Long id);

    /**
     * 更新学生信息
     * @param student
     * @return
     */
    Result<String> updateStudentInfo(Student student);


}
