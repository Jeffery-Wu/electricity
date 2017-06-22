package com.huangting.electricity.entity;

import java.util.Date;

/**
 * Created by huangting on 2017/6/20.
 */
public class Manager {
    /**
     * 唯一标识一个管理员的ID号
     */
    private Integer id;

    /**
     * 管理员的名字（账号）
     */
    private String name;

    /**
     * 管理员登录系统的密码
     */
    private String password;

    /**
     * 管理员被创建的时间
     */
    private Date bornTime;

    /**
     * 管理员信息最后一次被修改的时间
     */
    private Date uodateTime;

    /**
     * 管理员的权限标识：0表示超级管理员，1表示普通管理员
     */
    private Integer permission;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBornTime() {
        return bornTime;
    }

    public void setBornTime(Date bornTime) {
        this.bornTime = bornTime;
    }

    public Date getUodateTime() {
        return uodateTime;
    }

    public void setUodateTime(Date uodateTime) {
        this.uodateTime = uodateTime;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", bornTime=" + bornTime +
                ", uodateTime=" + uodateTime +
                ", permission=" + permission +
                '}';
    }
}
