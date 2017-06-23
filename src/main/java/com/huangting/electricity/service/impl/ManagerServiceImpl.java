package com.huangting.electricity.service.impl;

import com.huangting.electricity.dao.ManagerDao;
import com.huangting.electricity.dto.Result;
import com.huangting.electricity.entity.ElectricityAccount;
import com.huangting.electricity.entity.Manager;
import com.huangting.electricity.service.ManagerService;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by huangting on 2017/6/22.
 */
@Service
public class ManagerServiceImpl implements ManagerService {

	@Resource
	private ManagerDao managerDao;
	
	@Transactional
	@Override
	public Result<Integer> addManager(Manager manager) {
		// TODO Auto-generated method stub
		Result result = null;
		try {
			if (manager.getName() == null || manager.getPassword() == null) {
				result = new Result<Integer>(false, "用户账号或密码不能为空", 0);
			} else if (managerDao.queryManagerById(manager.getId()) != null){
				result = new Result<Integer>(false, "该账号已存在", 0);
			} else {
				Integer integer = managerDao.addManager(manager);
				if (integer == 1) {
					result = new Result<Integer>(true, "添加成功", 1);
				} else {
					result = new Result<Integer>(false, "添加失败", 0);
				}
			}
		} catch (Exception e) {
			result = new Result<Integer>(false, "系统出现异常", 0);
		}
		return result;
	}

	@Transactional
	@Override
	public Result<Integer> deleteManagerById(Integer id) {
		// TODO Auto-generated method stub
		Result result = null;
		try {
			if (managerDao.queryManagerById(id) == null){
				result = new Result<Integer>(false, "该账号不存在", 0);
			} else {
				if(managerDao.deleteManagerById(id) == 1){
					result = new Result<Integer>(true, "删除成功", 1);
				} else {
					result = new Result<Integer>(false, "删除失败", 0);
				}
			}
		} catch (Exception e) {
			result = new Result<Integer>(false, "系统出现异常", 0);
		}
		return result;
	}

	@Transactional
	@Override
	public Result<Integer> updateManager(Manager manager) {
		// TODO Auto-generated method stub
		Result result = null;
		try {
			if(managerDao.updateManager(manager) == 1){
				result = new Result<Integer>(true, "成功", 1);
			} else {
				result = new Result<Integer>(false, "失败", 0);
			}
		} catch (Exception e) {
			result = new Result<Integer>(false, "系统出现异常", 0);
		}
		return result;
	}

	@Override
	public Result<List<Manager>> queryManagerByPermission(Integer permission) {
		// TODO Auto-generated method stub
		List<Manager> managers = null;
		Result result = null;
		try {
			if(permission != 1 || permission != 0){
				result = new Result<List<Manager>>(false, "对应权限不存在", null);
			}  else {
				managers = managerDao.queryManagerByPermission(permission);
				result = new Result<List<Manager>>(true, "成功", managers);
			}
			
		} catch (Exception e) {
			result = new Result<List<Manager>>(false, "系统出现异常", null);
		}
		return result;
	}

	@Override
	public Result<Manager> queryManagerById(Integer id) {
		// TODO Auto-generated method stub
		Manager manager = null;
		Result result = null;
		try {
			if(id == 0){
				result = new Result<Manager>(false, "id不可为空", null);
			} else if(managerDao.queryManagerById(id) == null){
				result = new Result<Manager>(false, "对应记录不存在", null);
			} else {
				manager = managerDao.queryManagerById(id);
				result = new Result<Manager>(true, "成功", manager);
			}
			
		} catch (Exception e) {
			result = new Result<Manager>(false, "系统出现异常", null);
		}
		return result;
	}

	@Override
	public Result<Manager> queryManagerByName(String name) {
		// TODO Auto-generated method stub
		Manager manager = null;
		Result result = null;
		try {
			if(name.equals(null)){
				result = new Result<Manager>(false, "账号不可为空", null);
			} else if(managerDao.queryManagerByName(name) == null){
				result = new Result<Manager>(false, "对应记录不存在", null);
			} else {
				manager = managerDao.queryManagerByName(name);
				result = new Result<Manager>(true, "成功", manager);
			}
			
		} catch (Exception e) {
			result = new Result<Manager>(false, "系统出现异常", null);
		}
		return result;
	}

}
