package com.huangting.electricity.service;

import java.util.List;

import com.huangting.electricity.dto.Result;
import com.huangting.electricity.entity.ElectricitySituation;
import com.huangting.electricity.entity.Manager;

/**
 * Created by huangting on 2017/6/22.
 */
public interface ElectricitySituationService {

	/**
	 * 添加用电情况
	 * @param electricitySituation
	 * @return
	 */
	Result<Integer> addElectricitySituation(ElectricitySituation electricitySituation);

	/**
	 * 根据宿舍号查询用电情况
	 * @param dormitoryId
	 * @return
	 */
	Result<ElectricitySituation> queryElectricitySituationByDormitoryId(String dormitoryId);
	
	/**
	 * 根据id查询用电情况
	 * @param id
	 * @return
	 */
	Result<ElectricitySituation> queryElectricitySituationById(Integer id);
}
