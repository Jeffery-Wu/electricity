package com.huangting.electricity.service;

import java.util.List;

import com.huangting.electricity.dto.Result;
import com.huangting.electricity.entity.Notice;

/**
 * Created by huangting on 2017/6/22.
 */
public interface NoticeService {
    /**
     * 添加一条通知
     * @param notice
     * @return
     */
	Result<Integer> addNotice(Notice notice);

    /**
     * 分页查询所有的通知
     * @param offset 开始的索引
     * @param limit 偏移量
     * @return
     */
	Result<List<Notice>> queryAll(Integer offset, Integer limit);

    /**
     * 根据ID号查询出通知的信息，包括内容
     * @param id
     * @return
     */
    Result<Notice> queryByIdWithContent(Integer id);

    /**
     * 根据管理员的ID号查询出该管理员发布的所有的通知
     * @param offset
     * @param limit
     * @return
     */
    Result<List<Notice>> queryNoticeByMnagerId(Integer offset, Integer limit);
    
    Result<Integer> deleteNoticeById(Integer id);
}
