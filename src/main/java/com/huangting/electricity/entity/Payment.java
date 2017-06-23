package com.huangting.electricity.entity;

import java.sql.Date;

/**
 * Created by huangting on 2017/6/22.
 */
public class Payment {
	/**
	 * 订单ID
	 */
	private Integer id;
	
	/**
	 * 宿舍编号
	 */
	private Integer dormitaryId;
	
	/**
	 * 充值金额
	 */
	private double paymentCount;
	
	/**
	 * 订单创建时间
	 */
	private Date bornTimeDate;
	
	/**
	 * 学生Id
	 */
	private String studentId;
	
	/**
	 * 密码
	 */
	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDormitaryId() {
		return dormitaryId;
	}

	public void setDormitaryId(Integer dormitaryId) {
		this.dormitaryId = dormitaryId;
	}

	public double getPaymentCount() {
		return paymentCount;
	}

	public void setPaymentCount(double paymentCount) {
		this.paymentCount = paymentCount;
	}

	public Date getBornTimeDate() {
		return bornTimeDate;
	}

	public void setBornTimeDate(Date bornTimeDate) {
		this.bornTimeDate = bornTimeDate;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
