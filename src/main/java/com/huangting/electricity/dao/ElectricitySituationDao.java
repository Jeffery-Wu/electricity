package com.huangting.electricity.dao;

import com.huangting.electricity.entity.ElectricitySituation;

/**
 * Created by huangting on 2017/6/22.
 */
public interface ElectricitySituationDao {
    /**
     * 向系统中添加一条用电情况
     * @param electricitySituation
     * @return
     */
    Integer addElectricitySituation(ElectricitySituation electricitySituation);
    
    /**
     * 根据id查找
     * @param id
     * @return
     */
    ElectricitySituation queryElectricitySituationById(Integer id);
    
    /**
     * 根据宿舍编号查找
     * @param dormitoryId
     * @return
     */
    ElectricitySituation queryElectricitySituationByDormitoryId(String dormitoryId);
}
