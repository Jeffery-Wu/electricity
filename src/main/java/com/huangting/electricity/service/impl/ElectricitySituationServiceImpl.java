package com.huangting.electricity.service.impl;

import com.huangting.electricity.dao.ElectricitySituationDao;
import com.huangting.electricity.dto.Result;
import com.huangting.electricity.entity.ElectricityAccount;
import com.huangting.electricity.entity.ElectricitySituation;
import com.huangting.electricity.service.ElectricityAccountService;
import com.huangting.electricity.service.ElectricitySituationService;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by huangting on 2017/6/22.
 */
@Service
public class ElectricitySituationServiceImpl implements ElectricitySituationService{

	@Resource
	private ElectricitySituationDao electricitySituationDao;
	
	/**
	 * 添加
	 */
	@Transactional
	@Override
	public Result<Integer> addElectricitySituation(ElectricitySituation electricitySituation) {
		// TODO Auto-generated method stub
		Result result = null;
		try {
			Integer integer = electricitySituationDao.addElectricitySituation(electricitySituation);
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
	 * 根据宿舍编号查找
	 */
	@Override
	public Result<ElectricitySituation> queryElectricitySituationByDormitoryId(String dormitoryId) {
		// TODO Auto-generated method stub
		ElectricitySituation electricitySituation = null;
		Result result = null;
		try {
			if(dormitoryId.equals(null)){
				result = new Result<ElectricitySituation>(false, "宿舍编号不可为空", null);
			} else if(electricitySituationDao.queryElectricitySituationByDormitoryId(dormitoryId) == null){
				result = new Result<ElectricitySituation>(false, "对应记录不存在", null);
			} else {
				electricitySituation = electricitySituationDao.queryElectricitySituationByDormitoryId(dormitoryId);
				result = new Result<ElectricitySituation>(true, "成功", electricitySituation);
			}
			
		} catch (Exception e) {
			result = new Result<ElectricitySituation>(false, "系统出现异常", null);
		}
		return result;
	}

	/**
	 * 根据id查找
	 */
	@Override
	public Result<ElectricitySituation> queryElectricitySituationById(Integer id) {
		// TODO Auto-generated method stub
		ElectricitySituation electricitySituation = null;
		Result result = null;
		try {
			if(id == 0){
				result = new Result<ElectricitySituation>(false, "id不可为空", null);
			} else if(electricitySituationDao.queryElectricitySituationById(id) == null){
				result = new Result<ElectricitySituation>(false, "对应记录不存在", null);
			} else {
				electricitySituation = electricitySituationDao.queryElectricitySituationById(id);
				result = new Result<ElectricitySituation>(true, "成功", electricitySituation);
			}
			
		} catch (Exception e) {
			result = new Result<ElectricitySituation>(false, "系统出现异常", null);
		}
		return result;
	}


}
