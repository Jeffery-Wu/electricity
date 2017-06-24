package com.huangting.electricity.service.impl;

import com.huangting.electricity.dao.ManagerDao;
import com.huangting.electricity.dao.StudentDao;
import com.huangting.electricity.dto.Result;
import com.huangting.electricity.entity.Manager;
import com.huangting.electricity.entity.Student;
import com.huangting.electricity.service.BaseService;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * Created by huangting on 2017/6/20.
 */
@Service
public class BaseServiceImpl implements BaseService {

	@Resource
	private StudentDao studentDao;
	private ManagerDao managerDao;

	@SuppressWarnings("rawtypes")
	@Override
    public Result<String> login(Class<?> memberType, Object object) {
    	Result result = null;
    	try {
			Student studentLogin = (Student)object;
			Manager managerLogin = (Manager)object;
			/*
			 * 判断是否为空
			 */
    		if(studentLogin.getStudentID().equals(null)||managerLogin.getName().equals(null)) {
    			result = new Result<String>(false, "账号为空", null);
    		}
			/*
			 * 判断是否存在
			 */
			if(studentDao.queryStudentByStudentId(studentLogin.getStudentID()) == null || 
					managerDao.queryManagerByName(managerLogin.getName()) == null){
				result = new Result<String>(false, "该用户不存在", null);
			}
			/*
			 * 判断密码是否正确
			 */
			if(memberType == Student.class) {
				if(studentLogin.getPassword().equals(studentDao.queryStudentById(studentLogin.getId()).getPassword())) {
					result = new Result<String>(true, "登陆成功", null);
				} else {
					result = new Result<String>(false, "密码错误", null);
				}
			} else if (memberType == Manager.class){
				if(managerLogin.getPassword().equals(managerDao.queryManagerById(managerLogin.getId()).getPassword())) {
					result = new Result<String>(true, "登陆成功", null);
				} else {
					result = new Result<String>(false, "密码错误", null);
				}
			}
		} catch (Exception e) {
			result = new Result<String>(false, "系统出现异常", null);
		}
    	return result;
    }
}
