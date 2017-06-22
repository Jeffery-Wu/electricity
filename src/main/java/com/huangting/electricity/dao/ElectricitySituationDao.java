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
}
