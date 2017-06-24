package com.huangting.electricity.service.impl;

import com.huangting.electricity.dao.NoticeDao;
import com.huangting.electricity.dto.Result;
import com.huangting.electricity.entity.Manager;
import com.huangting.electricity.entity.Notice;
import com.huangting.electricity.service.NoticeService;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by huangting on 2017/6/22.
 */
@Service
public class NoticeServiceImpl implements NoticeService {

	@Resource
	private NoticeDao noticeDao;
	
	@Transactional
	@Override
	public Result<Integer> addNotice(Notice notice) {
		// TODO Auto-generated method stub
		Result result = null;
		try {
			if (notice.getTitle() == null || notice.getContent() == null) {
				result = new Result<Integer>(false, "通知标题或内容不能为空", 0);
			} else {
				Integer integer = noticeDao.addNotice(notice);
				if (integer == 1) {
					result = new Result<Integer>(true, "发布成功", 1);
				} else {
					result = new Result<Integer>(false, "发布失败", 0);
				}
			}
		} catch (Exception e) {
			result = new Result<Integer>(false, "系统出现异常", 0);
		}
		return result;
	}

	@Override
	public Result<List<Notice>> queryAll(Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		Result result = null;
		List<Notice> notices;
		try {
			notices = noticeDao.queryAll(offset, limit);
			result = new Result<List<Notice>>(true, "成功", notices);
		} catch (Exception e) {
			result = new Result<List<Notice>>(false, "系统出现异常", null);
		}
		return result;
	}

	@Override
	public Result<Notice> queryByIdWithContent(Integer id) {
		// TODO Auto-generated method stub
		Notice notice = null;
		Result result = null;
		try {
			if(id == 0){
				result = new Result<Notice>(false, "id不可为空", null);
			} else if(noticeDao.queryByIdWithContent(id) == null){
				result = new Result<Notice>(false, "对应记录不存在", null);
			} else {
				notice = noticeDao.queryByIdWithContent(id);
				result = new Result<Notice>(true, "成功", notice);
			}
			
		} catch (Exception e) {
			result = new Result<Notice>(false, "系统出现异常", null);
		}
		return result;
	}

	@Override
	public Result<List<Notice>> queryNoticeByMnagerId(Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		List<Notice> notices = null;
		Result result = null;
		try {
			notices = noticeDao.queryNoticeByMnagerId(offset, limit);
			result = new Result<List<Notice>>(true, "成功", notices);
		} catch (Exception e) {
			result = new Result<List<Notice>>(false, "系统出现异常", null);
		}
		return result;
	}

	@Transactional
	@Override
	public Result<Integer> deleteNoticeById(Integer id) {
		// TODO Auto-generated method stub
		Result result = null;
		try {
			if(id == 0){
				result = new Result<Integer>(false, "通知id不可为空", 0);
			} else {
				noticeDao.deleteNoticeById(id);
				result = new Result<Integer>(true, "成功", 1);
			}
		} catch (Exception e) {
			result = new Result<Integer>(false, "系统出现异常", 0);
		}
		return result;
	}

}
