package com.huangting.electricity.service;

import com.huangting.electricity.dto.Result;
import com.huangting.electricity.entity.ElectricityAccount;
import com.huangting.electricity.entity.ElectricitySituation;

/**
 * Created by huangting on 2017/6/22.
 */
public interface ElectricityAccountService {
	
	/**
	 * 根据宿舍编号查看用电账户
	 * @param dormitoryId
	 * @return
	 */
	Result<ElectricityAccountService> queryAccountServiceByDormitoryId(String dormitoryId);
	
	/**
	 * 根据宿舍Id查看用电账户
	 * @param id
	 * @return
	 */
	Result<ElectricityAccountService> queryAccountServiceById(Integer id);
	
	/**
	 * 修改用电账户详情
	 * @param electricityAccount
	 * @return
	 */
	Result<Integer> updateElectricityAccount(ElectricityAccount electricityAccount);
	
    /**
     * 添加一个用电账户
     * @param electricityAccount
     * @return
     */
	Result<Integer> addElectricityAccount(ElectricityAccount electricityAccount);

}
