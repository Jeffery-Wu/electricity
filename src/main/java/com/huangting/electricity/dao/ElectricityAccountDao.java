package com.huangting.electricity.dao;

import com.huangting.electricity.entity.ElectricityAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created by huangting on 2017/6/22.
 */
@Mapper
@Component
public interface ElectricityAccountDao {

    /**
     * 添加一个用电账户
     * @param electricityAccount
     * @return
     */
    Integer addElectricityAccount(@Param("electricityAccount") ElectricityAccount electricityAccount);

    /**
     * 修改用电账户
     * @param electricityAccount
     * @return
     */
    Integer updateElectricityAccount(@Param("electricityAccount") ElectricityAccount electricityAccount);
    
    /**
     * 通过宿舍编号查找宿舍用电账户
     * @param id
     * @return
     */
    ElectricityAccount queryElectricityAccountByDormitoryId(@Param("id") Integer id);
    
    /**
     * 通过账户id查询用电账户
     * @param id
     * @return
     */
    ElectricityAccount queryElectricityAccountById(@Param("id") Integer id);
}
