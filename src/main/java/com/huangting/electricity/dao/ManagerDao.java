package com.huangting.electricity.dao;

import com.huangting.electricity.entity.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by huangting on 2017/6/20.
 */
@Mapper
@Component
public interface ManagerDao {

    /**
     * 添加一个管理员
     * @param manager
     * @return
     */
    Integer addManager(@Param("manager") Manager manager);

    /**
     * 根据管理员的ID号删除管理员
     * @param id
     * @return
     */
    Integer deleteManagerById(@Param("id") Integer id);

    /**
     * 更新管理员的信息
     * @param manager
     * @return
     */
    Integer updateManager(@Param("manager") Manager manager);

    /**
     * 根据管理员的权限查询管理员信息
     * @param permission
     * @return
     */
    List<Manager> queryManagerByPermission(@Param("permission") Integer permission);

    /**
     * 根据管理员的ID号查询管理员的信息
     * @param id
     * @return
     */
    Manager queryManagerById(@Param("id") Integer id);
    
    /**
     * 根据管理员的name查询管理员信息
     * @param name
     * @return
     */
    Manager queryManagerByName(@Param("name") String name);
}
