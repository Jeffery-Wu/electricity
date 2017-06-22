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
}
