package com.huangting.electricity.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by huangting on 2017/6/22.
 */
public class ElectricitySituation {
	private Long id;
	private Integer dormitoryId;
	private Date bornTime;
	private Integer timeSoltId;
	private Double usedCount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDormitoryId() {
		return dormitoryId;
	}

	public void setDormitoryId(Integer dormitoryId) {
		this.dormitoryId = dormitoryId;
	}

	public Date getBornTime() {
		return bornTime;
	}

	public void setBornTime(Date bornTime) {
		this.bornTime = bornTime;
	}

	public Integer getTimeSoltId() {
		return timeSoltId;
	}

	public void setTimeSoltId(Integer timeSoltId) {
		this.timeSoltId = timeSoltId;
	}

	public Double getUsedCount() {
		return usedCount;
	}

	public void setUsedCount(Double usedCount) {
		this.usedCount = usedCount;
	}

	@Override
	public String toString() {
		return "ElectricitySituation{" +
				"id=" + id +
				", dormitoryId=" + dormitoryId +
				", bornTime=" + bornTime +
				", timeSoltId=" + timeSoltId +
				", usedCount=" + usedCount +
				'}';
	}
}
