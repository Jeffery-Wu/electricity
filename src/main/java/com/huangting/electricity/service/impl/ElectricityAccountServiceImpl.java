package com.huangting.electricity.service.impl;

import com.huangting.electricity.dao.ElectricityAccountDao;
import com.huangting.electricity.dto.Result;
import com.huangting.electricity.entity.Dormitory;
import com.huangting.electricity.entity.ElectricityAccount;
import com.huangting.electricity.service.ElectricityAccountService;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by huangting on 2017/6/22.
 */
@Service
public class ElectricityAccountServiceImpl implements ElectricityAccountService {

	@Resource
	private ElectricityAccountDao electricityAccountDao;
	
	/**
	 * 通过宿舍编号查询用电账户
	 */
	@Override
	public Result<ElectricityAccountService> queryAccountServiceByDormitoryId(String dormitoryId) {
		// TODO Auto-generated method stub
		ElectricityAccount electricityAccount = null;
		Result result = null;
		try {
			if(dormitoryId.equals(null)){
				result = new Result<ElectricityAccount>(false, "寝室编码不可为空", null);
			} else if(electricityAccountDao.queryElectricityAccountByDormitoryId(dormitoryId) == null){
				result = new Result<ElectricityAccount>(false, "对应记录不存在", null);
			} else {
				electricityAccount = electricityAccountDao.queryElectricityAccountByDormitoryId(dormitoryId);
				result = new Result<ElectricityAccount>(true, "成功", electricityAccount);
			}
			
		} catch (Exception e) {
			result = new Result<ElectricityAccount>(false, "系统出现异常", null);
		}
		return result;
	}

	/**
	 * 通过账户id查询用电账户
	 */
	@Override
	public Result<ElectricityAccountService> queryAccountServiceById(Integer id) {
		// TODO Auto-generated method stub
		
		ElectricityAccount electricityAccount = null;
		Result result = null;
		try {
			if(id == 0){
				result = new Result<ElectricityAccount>(false, "账户id不可为空", null);
			} else if(electricityAccountDao.queryElectricityAccountById(id) == null){
				result = new Result<ElectricityAccount>(false, "对应记录不存在", null);
			} else {
				electricityAccount = electricityAccountDao.queryElectricityAccountById(id);
				result = new Result<ElectricityAccount>(true, "成功", electricityAccount);
			}
			
		} catch (Exception e) {
			result = new Result<ElectricityAccount>(false, "系统出现异常", null);
		}
		return result;
		
	}

	/**
	 * 修改用电账户（可为空）
	 */
	@Transactional
	@Override
	public Result<Integer> updateElectricityAccount(ElectricityAccount electricityAccount) {
		// TODO Auto-generated method stub
		Result result = null;
		try {
			Integer integer = electricityAccountDao.updateElectricityAccount(electricityAccount);
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

	/**
	 * 添加用电账户
	 * 
	 */
	@Transactional
	@Override
	public Result<Integer> addElectricityAccount(ElectricityAccount electricityAccount) {
		// TODO Auto-generated method stub
		Result result = null;
		try {
			Integer integer = electricityAccountDao.addElectricityAccount(electricityAccount);
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

}
