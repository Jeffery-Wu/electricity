package com.huangting.electricity.entity;

import java.util.Date;

/**
 * Created by huangting on 2017/6/22.
 */
public class Notice {
	/**
	 * 通知id
	 */
	private Integer id;
	
	/**
	 * 通知创建时间
	 */
	private Date bornTime;
	
	/**
	 * 通知标题
	 */
	private String title;
	
	/**
	 * 通知内容
	 */
	private String content;
	
	/**
	 * 通知发布者id
	 */
	private Integer managerId;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
}
