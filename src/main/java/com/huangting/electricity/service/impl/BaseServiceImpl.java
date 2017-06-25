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
	@Resource
	private ManagerDao managerDao;

	@Override
    public Result<String> login(Class<?> memberType, Object object) {
    	Result result = null;
    	try {
			if (memberType == Student.class) {
				Student student = (Student)object;
System.out.println(student);
				Student student1 = studentDao.queryStudentByStudentId(student.getStudentID());
System.out.println(student1);
				if (student1 == null) {
					result = new Result<String>(false,"该账户不存在",null);
				} else {
					if (student1.getPassword().equals(student.getPassword())) {
						result = new Result<String>(true, "登录成功",null);
					} else {
						result = new Result<String>(false, "密码错误", null);
					}
				}
			} else if (memberType == Manager.class) {
				Manager manager = (Manager)object;
System.out.println(manager);
				Manager manager1 = managerDao.queryManagerByName(manager.getName());
				if (manager1 == null) {
					result = new Result<String>(false,"该账户不存在",null);
				} else {
					if (manager1.getPassword().equals(manager.getPassword())) {
						result = new Result<String>(true, "登录成功", null);
					} else {
						result = new Result<String>(false, "密码错误", null);
					}
				}
			} else {
				result = new Result<String>(false,"系统出现异常",null);
				System.out.print("aaaa");
			}
		} catch (Exception e) {
			result = new Result<String>(false, "系统出现异常", null);
			e.printStackTrace();
		}
    	return result;
    }
}
