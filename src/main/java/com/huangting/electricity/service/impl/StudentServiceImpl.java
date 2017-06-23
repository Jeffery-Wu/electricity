package com.huangting.electricity.service.impl;

import com.huangting.electricity.dao.DormitoryDao;
import com.huangting.electricity.dao.ElectricityAccountDao;
import com.huangting.electricity.dao.PaymentDao;
import com.huangting.electricity.dto.Result;
import com.huangting.electricity.entity.Dormitory;
import com.huangting.electricity.entity.ElectricityAccount;
import com.huangting.electricity.entity.Payment;
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
	private DormitoryDao dormitoryDao;
	private ElectricityAccountDao electricityAccountDao;
    @Override
    public Result<String> palceAnOrder(Payment payment) {
    	Result result = null;
    	/**
    	 * 1.判断参数是否完整
    	 * 2.存入数据库
    	 * 3.存储失败——超时(5min)重新下订单/联系工作人员
    	 * 4.存储成功返回
    	 */
    	if(payment.getDormitaryId() == null || 
    			payment.getPaymentCount() == 0 ||
    			payment.getPassword() == null) {
    		result = new Result<String>(false, "请完善订单信息", null);
    	} else {
    		if(paymentDao.addPayment(payment) == 1){
    			result = new Result<String>(true, "订单创建成功", null);
    		} else {
    		    long nd = 1000 * 24 * 60 * 60;
    		    long nh = 1000 * 60 * 60;
    		    long nm = 1000 * 60;
    			Date nowTime = new Date(System.currentTimeMillis());
    			long timeSolt = nowTime.getTime()-payment.getBornTimeDate().getTime();
    			if(timeSolt% nd/nh > 5){//超时5min
        			result = new Result<String>(false, "请求超时，请重新创建订单", null);
    			} else {
    				result = new Result<String>(false, "请联系物业人员", null);
    			}
    		}
    	}
        return result;
    }

    /**
     * 根据订单购电
     * 1.修改对应数据库
     * 2.修改失败——联系工作人员
     */
    @Transactional
    @Override
    public Result<String> buyElectricity(Payment payment) {
    	Result result = null;
    	Dormitory dormitory = dormitoryDao.queryDormitoryByStudentId(payment.getStudentId());
    	ElectricityAccount electricityAccount = electricityAccountDao.queryElectricityAccountByDormitoryId(dormitory.getDormitoryId());
        electricityAccount.setBalance(electricityAccount.getBalance() + payment.getPaymentCount());
        electricityAccount.setRemainingBattery(electricityAccount.getRemainingBattery() + payment.getPaymentCount()*1.8);
        if(electricityAccountDao.updateElectricityAccount(electricityAccount) == 1){
            result = new Result<String>(true, "充值完成，当前剩余电量为：", electricityAccount.getRemainingBattery() + "");
        } else {
        	result = new Result<String>(false, "充值操作失败，请联系物业人员，您的订单号为：", payment.getId() + "");
        }
    	return result;
    }
}
