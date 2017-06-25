package com.huangting.electricity.entity;

import java.sql.Date;

/**
 * Created by huangting on 2017/6/22.
 */
public class Payment {
	/**
	 * 订单ID
	 */
	private Long id;
	
	/**
	 * 宿舍编号
	 */
	private Integer dormitoryId;
	
	/**
	 * 充值金额
	 */
	private double paymentCount;

	
	/**
	 * 学生Id
	 */
	private Integer studentId;


	/**
	 * 充值电量
	 */
	private Double batteryCount;

	/**
	 * 充值单价
	 */
	private Double price;

	/**
	 * 订单创建的时间
	 */
	private Date bornTime;

	public Double getBatteryCount() { return batteryCount; }

	public void setBatteryCount(Double batteryCount) { this.batteryCount = batteryCount; }
	public Double getPrice() { return price; }

	public void setPrice(Double price) { this.price = price; }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDormitoryId() {
		return dormitoryId;
	}

	public void setDormitoryId(Integer dormitaryId) {
		this.dormitoryId = dormitaryId;
	}

	public double getPaymentCount() {
		return paymentCount;
	}

	public void setPaymentCount(double paymentCount) {
		this.paymentCount = paymentCount;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Date getBornTime() { return bornTime; }

	public void setBornTime(Date bornTime) { this.bornTime = bornTime; }

	@Override
	public String toString() {
		return "Payment{" +
				"id=" + id +
				", dormitoryId=" + dormitoryId +
				", paymentCount=" + paymentCount +
				", studentId=" + studentId +
				", batteryCount=" + batteryCount +
				", price=" + price +
				", bornTime=" + bornTime +
				'}';
	}
}
