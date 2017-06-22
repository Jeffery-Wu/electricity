package com.huangting.electricity.dao;

import com.huangting.electricity.entity.Manager;

/**
 * Created by huangting on 2017/6/20.
 */
public interface ManagerDao {

    /**
     * 添加一个管理员
     * @param manager
     * @return
     */
    Integer addManager(Manager manager);
}
