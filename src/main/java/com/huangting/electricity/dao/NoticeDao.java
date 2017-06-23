package com.huangting.electricity.dao;

import com.huangting.electricity.entity.Notice;

import java.util.List;

/**
 * Created by huangting on 2017/6/22.
 */
public interface NoticeDao {

    /**
     * 添加一条通知
     * @param notice
     * @return
     */
    Integer addNotice(Notice notice);

    /**
     * 分页查询所有的通知
     * @param offset 开始的索引
     * @param limit 偏移量
     * @return
     */
    List<Notice> queryAll(Integer offset, Integer limit);

    /**
     * 根据ID号查询出通知的信息，包括内容
     * @param id
     * @return
     */
    Notice queryByIdWithContent(Integer id);

    /**
     * 根据管理员的ID号查询出该管理员发布的所有的通知
     * @param offset
     * @param limit
     * @return
     */
    List<Notice> queryNoticeByMnagerId(Integer offset, Integer limit);
    
    /**
     * 根据id删除通知
     * @param id
     * @return
     */
    Integer deleteNoticeById(Integer id);
}
