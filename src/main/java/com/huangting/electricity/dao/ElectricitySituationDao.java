package com.huangting.electricity.dao;

import com.huangting.electricity.entity.ElectricitySituation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created by huangting on 2017/6/22.
 */
@Mapper
@Component
public interface ElectricitySituationDao {
    /**
     * 向系统中添加一条用电情况
     * @param electricitySituation
     * @return
     */
    Integer addElectricitySituation(@Param("electricitySituation") ElectricitySituation electricitySituation);
    
    /**
     * 根据id查找
     * @param id
     * @return
     */
    ElectricitySituation queryElectricitySituationById(@Param("id") Integer id);
    
    /**
     * 根据宿舍编号查找
     * @param dormitoryId
     * @return
     */
    ElectricitySituation queryElectricitySituationByDormitoryId(@Param("dormitoryId") String dormitoryId);
}
