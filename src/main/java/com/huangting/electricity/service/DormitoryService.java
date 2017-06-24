package com.huangting.electricity.service;

import com.huangting.electricity.dto.Result;
import com.huangting.electricity.entity.Dormitory;

/**
 * Created by huangting on 2017/6/22.
 */
public interface DormitoryService {
	
	/**
	 * 根据学生Id查找宿舍
	 * @param id
	 * @return
	 */
	Result<Dormitory> queryDormitoryByStudentId(String studentId);
	
	/**
	 * 根据宿舍编号查找宿舍
	 * @param dormitoryId
	 * @return
	 */
	Result<Dormitory> queryDormitoryByDormitoryId(String dormitoryId);
	
	/**
	 * 根据宿舍Id查找宿舍
	 * @param id
	 * @return
	 */
	Result<Dormitory> queryDormitoryById(Integer id);
	
}
