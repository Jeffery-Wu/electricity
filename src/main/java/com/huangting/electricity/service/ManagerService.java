package com.huangting.electricity.service;

import java.util.List;

import com.huangting.electricity.dto.Result;
import com.huangting.electricity.entity.Manager;

/**
 * Created by huangting on 2017/6/22.
 */
public interface ManagerService {

    /**
     * 添加一个管理员
     * @param manager
     * @return
     */
	Result<Integer> addManager(Manager manager);

    /**
     * 根据管理员的ID号删除管理员
     * @param id
     * @return
     */
	Result<Integer> deleteManagerById(Integer id);

    /**
     * 更新管理员的信息
     * @param manager
     * @return
     */
	Result<Integer> updateManager(Manager manager);

    /**
     * 根据管理员的权限查询管理员信息
     * @param permission
     * @return
     */
	Result<List<Manager>> queryManagerByPermission(Integer permission);

    /**
     * 根据管理员的ID号查询管理员的信息
     * @param id
     * @return
     */
    Result<Manager> queryManagerById(Integer id);
    
    /**
     * 根据管理员的name(账号)查询管理员信息
     * @param name
     * @return
     */
    Result<Manager> queryManagerByName(String name);
}
