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
	
	/**
	 * 根据宿舍编号查找宿舍
	 * @param dormitoryId
	 * @return
	 */
	Dormitory queryDormitoryByDormitoryId(String dormitoryId);
	
	/**
	 * 根据宿舍Id查找宿舍
	 * @param id
	 * @return
	 */
	Dormitory queryDormitoryById(Integer id);
	
}
