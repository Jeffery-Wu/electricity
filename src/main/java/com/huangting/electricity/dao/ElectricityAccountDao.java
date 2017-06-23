package com.huangting.electricity.dao;

import com.huangting.electricity.entity.ElectricityAccount;

/**
 * Created by huangting on 2017/6/22.
 */
public interface ElectricityAccountDao {

    /**
     * 添加一个用电账户
     * @param electricityAccount
     * @return
     */
    Integer addElectricityAccount(ElectricityAccount electricityAccount);

    /**
     * 修改用电账户
     * @param electricityAccount
     * @return
     */
    Integer updateElectricityAccount(ElectricityAccount electricityAccount);
    
    /**
     * 通过宿舍编号查找宿舍用电账户
     * @param id
     * @return
     */
    ElectricityAccount queryElectricityAccountByDormitoryId(String id);
}
