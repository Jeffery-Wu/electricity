package com.huangting.electricity.service.impl;

import com.huangting.electricity.dao.DormitoryDao;
import com.huangting.electricity.dto.Result;
import com.huangting.electricity.entity.Dormitory;
import com.huangting.electricity.service.DormitoryService;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * Created by huangting on 2017/6/22.
 */
@Service
public class DormitoryServiceImpl implements DormitoryService{

	@Resource
	private DormitoryDao dormitoryDao;
	@SuppressWarnings("rawtypes")
	@Override
	public Result<Dormitory> queryDormitoryByStudentId(String studentId) {
		// TODO Auto-generated method stub
		Dormitory dormitory = null;
		Result result = null;
		try {
			if(studentId.equals(null)){
				result = new Result<Dormitory>(false, "学生Id不可为空", null);
			} else if(dormitoryDao.queryDormitoryByStudentId(studentId) == null){
				result = new Result<Dormitory>(false, "不存在该学生用户", null);
			} else {
				dormitory = dormitoryDao.queryDormitoryByStudentId(studentId);
				result = new Result<Dormitory>(true, "成功", dormitory);
			}
			
		} catch (Exception e) {
			result = new Result<Dormitory>(false, "系统出现异常", null);
		}
		return result;
	}

	@Override
	public Result<Dormitory> queryDormitoryByDormitoryId(String dormitoryId) {
		// TODO Auto-generated method stub
		Dormitory dormitory = null;
		Result result = null;
		try {
			if(dormitoryId.equals(null)){
				result = new Result<Dormitory>(false, "寝室编号不可为空", null);
			} else if(dormitoryDao.queryDormitoryByDormitoryId(dormitoryId) == null){
				result = new Result<Dormitory>(false, "不存在该寝室", null);
			} else {
				dormitory = dormitoryDao.queryDormitoryByDormitoryId(dormitoryId);
				result = new Result<Dormitory>(true, "成功", dormitory);
			}
		} catch (Exception e) {
			result = new Result<Dormitory>(false, "系统出现异常", null);
		}
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Result<Dormitory> queryDormitoryById(Integer id) {
		// TODO Auto-generated method stub
		Dormitory dormitory = null;
		Result result = null;
		try {
			if(id == 0){
				result = new Result<Dormitory>(false, "寝室Id不可为空", null);
			} else if(dormitoryDao.queryDormitoryById(id) == null){
				result = new Result<Dormitory>(false, "不存在该寝室", null);
			} else {
				dormitory = dormitoryDao.queryDormitoryById(id);
				result = new Result<Dormitory>(true, "成功", dormitory);
			}
		} catch (Exception e) {
			result = new Result<Dormitory>(false, "系统出现异常", null);
		}
		return result;
	}

}
