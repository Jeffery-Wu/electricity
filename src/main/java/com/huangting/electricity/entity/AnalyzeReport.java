package com.huangting.electricity.entity;

import java.util.List;

public class AnalyzeReport {

	//数据库未创建
	
	/**
	 * 报表编号
	 */
	private Integer id;
	
	/**
	 * 平均电量
	 */
	private Integer averageElectricity;
	
	/**
	 * 内容
	 */
	private String content;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 管理员Id
	 */
	private Integer managerId;
	
	/**
	 * 用电情况数组
	 */
	private List<ElectricitySituation> electricitySituations;

}
