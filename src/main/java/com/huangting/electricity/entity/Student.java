package com.huangting.electricity.entity;

import java.util.Date;

/**
 * Created by huangting on 2017/6/20.
 */
public class Student {
    /**
     * 唯一标识一名学生的ID号
     */
    private Long id;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 学生的专业班级
     */
    private String className;

    /**
     * 学生所在的学院
     */
    private String department;

    /**
     * 学生的性别
     */
    private String Sex;

    /**
     * 学生的手机号
     */
    private String mobilePhone;

    /**
     * 学生的邮箱
     */
    private String mail;

    /**
     * 学生的系统密码
     */
    private String password;

    /**
     * 学生被创建的时间
     */
    private Date bornTime;

    /**
     * 学生信息最后一次被修改的时间
     */
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", department='" + department + '\'' +
                ", Sex='" + Sex + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", bornTime=" + bornTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
