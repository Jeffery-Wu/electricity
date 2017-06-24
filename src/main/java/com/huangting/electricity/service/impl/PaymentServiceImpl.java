package com.huangting.electricity.service.impl;

import com.huangting.electricity.dao.PaymentDao;
import com.huangting.electricity.dao.StudentDao;
import com.huangting.electricity.dto.Result;
import com.huangting.electricity.entity.Payment;
import com.huangting.electricity.service.PaymentService;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by huangting on 2017/6/22.
 */
@Service
public class PaymentServiceImpl implements PaymentService {

	@Resource
	private StudentDao studentDao;
	private PaymentDao paymentDao;
	
	@Transactional
	@Override
	public Result<Integer> addPayment(Payment payment) {
		Result result = null;
		try {
			if (payment.getPaymentCount() == 0 || payment.getDormitaryId() == null ||
					payment.getPassword() == null || payment.getStudentId() == null) {
				result = new Result<Integer>(false, "请完善订单信息", 0);
			} else if (!payment.getPassword().equals(studentDao.queryStudentByStudentId(payment.getStudentId()))){
				result = new Result<Integer>(false, "密码错误", 0);
			} else {
				Integer integer = paymentDao.addPayment(payment);
				if (integer == 1) {
					result = new Result<Integer>(true, "订单成功", 1);
				} else {
					result = new Result<Integer>(false, "订单失败", 0);
				}
			}
		} catch (Exception e) {
			result = new Result<Integer>(false, "系统出现异常", 0);
		}
		return result;
	}

	@Override
	public Result<Payment> queryById(Integer id) {
		// TODO Auto-generated method stub
		Payment payment = null;
		Result result = null;
		try {
			if(id == 0){
				result = new Result<Payment>(false, "订单id不能为空", null);
			} else {
				payment = paymentDao.queryById(id);
				result = new Result<Payment>(true, "成功", payment);
			}
		} catch (Exception e) {
			result = new Result<Payment>(false, "系统出现异常", null);
		}
		return result;
	}

	@Transactional
	@Override
	public Result<Integer> updatePayment(Payment payment) {
		// TODO Auto-generated method stub
		Result result = null;
		try {
			Integer integer = paymentDao.updatePayment(payment);
			if(integer == 1){
				result = new Result<Integer>(true, "成功", 1);
			} else {
				result = new Result<Integer>(false, "失败", 0);
			}
		} catch (Exception e) {
			result = new Result<Integer>(false, "系统出现异常", 0);
		}
		return result;
	}

	@Override
	public Result<Integer> deletePayment(Integer id) {
		// TODO Auto-generated method stub
		Result result = null;
		try {
			if(id == 0){
				result = new Result<Integer>(false, "通知id不可为空", 0);
			} else {
				if(paymentDao.deletePayment(id) == 1){
					result = new Result<Integer>(true, "成功", 1);
				} else {
					result = new Result<Integer>(false, "失败", 0);
				}	
			}
		} catch (Exception e) {
			result = new Result<Integer>(false, "系统出现异常", 0);
		}
		return result;
	}


}
