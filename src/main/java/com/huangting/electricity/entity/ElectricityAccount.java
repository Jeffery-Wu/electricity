package com.huangting.electricity.entity;

import java.util.Date;

/**
 * Created by huangting on 2017/6/20.
 */
public class ElectricityAccount {

    /**
     * 唯一标识一个用电账户的ID号
     */
    private Integer id;

    /**
     * 用电账户被创建的时间
     */
    private Date bornTime;

    /**
     * 用电账户信息最后一次被修改的时间
     */
    private Date updateTime;

    /**
     * 账户剩余金额
     */
    private Double balance;

    /**
     * 账户剩余电量
     */
    private Double remainingBattery;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBornTime() {
        return bornTime;
    }

    public void setBornTime(Date bornTime) {
        this.bornTime = bornTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getRemainingBattery() {
        return remainingBattery;
    }

    public void setRemainingBattery(Double remainingBattery) {
        this.remainingBattery = remainingBattery;
    }

    @Override
    public String toString() {
        return "ElectricityAccount{" +
                "id=" + id +
                ", bornTime=" + bornTime +
                ", updateTime=" + updateTime +
                ", balance=" + balance +
                ", remainingBattery=" + remainingBattery +
                '}';
    }
}
