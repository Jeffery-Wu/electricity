package com.huangting.electricity.service.impl;

import com.huangting.electricity.dao.DormitoryDao;
import com.huangting.electricity.dao.ElectricityAccountDao;
import com.huangting.electricity.dao.PaymentDao;
import com.huangting.electricity.dao.StudentDao;
import com.huangting.electricity.dto.Result;
import com.huangting.electricity.entity.Dormitory;
import com.huangting.electricity.entity.ElectricityAccount;
import com.huangting.electricity.entity.Payment;
import com.huangting.electricity.entity.Student;
import com.huangting.electricity.service.StudentService;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by huangting on 2017/6/21.
 */
@Service
public class StudentServiceImpl implements StudentService{
	@Resource
	private PaymentDao paymentDao;
	@Resource
	private DormitoryDao dormitoryDao;
	@Resource
	private ElectricityAccountDao electricityAccountDao;
	@Resource
	private StudentDao studentDao;
	
	/**
	 * 1.判断参数是否完整
	 * 2.存入数据库
	 * 3.存储失败——超时(5min)重新下订单/联系工作人员
	 * 4.存储成功返回
	 */
	@Override
    public Result<String> palceAnOrder(Payment payment) {
    	Result result = null;
    	try {
        	if(payment.getDormitoryId() == null || payment.getPaymentCount() == 0 || payment.getStudentId() == null) {
        		result = new Result<String>(false, "请完善订单信息", null);
        	} else {
        		if(paymentDao.addPayment(payment) == 1){
        			result = new Result<String>(true, "订单创建成功", null);
        		} else {
//        		    long nd = 1000 * 24 * 60 * 60;
//        		    long nh = 1000 * 60 * 60;
//        		    long nm = 1000 * 60;
//        			Date nowTime = new Date(System.currentTimeMillis());
//        			long timeSolt = nowTime.getTime()-payment.getBornTimeDate().getTime();
//        			if(timeSolt% nd/nh > 5){//超时5min
//            			result = new Result<String>(false, "请求超时，请重新创建订单", null);
//        			} else {
//        				result = new Result<String>(false, "请联系物业人员", null);
//        			}
					result = new Result<String>(false,"创建订单失败,请重试",null);
        		}
        	}
		} catch (Exception e) {
    		e.printStackTrace();
			result = new Result<String>(false, "系统出现异常", null);
			return result;
		}
        return result;
    }

    /**
     * 根据订单购电
     * 1.修改对应数据库
     * 2.修改失败——联系工作人员
     */
    @SuppressWarnings("rawtypes")
	@Transactional
    @Override
    public Result<String> buyElectricity(Long paymentId) {
    	Result result = null;
    	try {
    		Payment payment = paymentDao.queryById(paymentId);
System.out.println(payment);
			/**
			 * 检验订单的过期时间
			 */
			Long bornTime = payment.getBornTime().getTime();
			Long now = System.currentTimeMillis();
			Long offset = now - bornTime;
			/**
			 * 如果订单在一天时间内未支付，订单失效
			 */
			Long limit = 24 * 60 * 60 * 1000L;
			if (payment == null) {
    			result = new Result<String>(false,"订单不存在，请先下订单",null);
			} else if (offset > limit){
				result = new Result<String>(false,"订单已失效，请重新下订单",null);
			} else {
				ElectricityAccount electricityAccount = electricityAccountDao.queryElectricityAccountByDormitoryId(payment.getDormitoryId());
				if (electricityAccount == null) {
					result = new Result<String>(false,"账户不存在",null);
				} else {
					Double balance = electricityAccount.getBalance();
					Double remainingBatter = electricityAccount.getRemainingBattery();
					if (balance < payment.getPaymentCount()) {
						result = new Result<String>(false,"账户余额不足,请先充值",null);
					} else {
						//扣除金额
						electricityAccount.setBalance(balance - payment.getPaymentCount());
						//增加剩余电量
						electricityAccount.setRemainingBattery(remainingBatter + payment.getBatteryCount());
						Integer count = electricityAccountDao.updateElectricityAccount(electricityAccount);
						if (count == 1) {
							result = new Result<String>(false,"购电成功",null);
						} else {
							result = new Result<String>(false,"购电失败,请联系管理员",null);
						}
					}
				}
			}
		} catch (Exception e) {
    		e.printStackTrace();
			result = new Result<String>(false, "系统出现异常", null);
			return result;
		}
    	return result;
    }

    @Override
    public Result<Student> getStudentInfo (Long id) {
    	Result<Student> result = null;
    	try {
    		if (id == null) {
    			result = new Result<>(false, "参数为空", null);
			}
    		Student student = studentDao.queryStudentById(id);
    		if (student == null) {
    			result = new Result<>(false, "不存在该用户",null);
			} else {
    			result = new Result<>(true, "获取学生信息成功", student);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = new Result<>(false, "系统出现异常", null);
			return result;
		}
		return result;
	}

	@Override
	public Result<String> updateStudentInfo(Student student) {
    	Result<String> result = null;
		try {
			if (student == null) {
                result = new Result<>(false, "参数有误",null);
            }
			Integer count = studentDao.updateStudent(student);
			if (count == 1) {
                result = new Result<>(true,"更新成功",null);
            } else {
                result = new Result<>(false,"更新失败",null);
            }
		} catch (Exception e) {
			e.printStackTrace();
			result = new Result<>(false, "系统出现异常",null);
			return result;
		}
		return result;
	}
}


