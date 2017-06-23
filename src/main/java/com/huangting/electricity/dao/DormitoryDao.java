package com.huangting.electricity.dao;

import org.apache.ibatis.annotations.Mapper;

import com.huangting.electricity.entity.Dormitory;

/**
 * Created by huangting on 2017/6/22.
 */
@Mapper
public interface DormitoryDao {
	/**
	 * 通过学生用户id查找宿舍
	 * @param id
	 * @return
	 */
	Dormitory queryDormitoryByStudentId(String id);
}
