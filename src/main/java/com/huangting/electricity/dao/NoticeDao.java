package com.huangting.electricity.dao;

import com.huangting.electricity.entity.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by huangting on 2017/6/22.
 */
@Mapper
@Component
public interface NoticeDao {

    /**
     * 添加一条通知
     * @param notice
     * @return
     */
    Integer addNotice(@Param("notice") Notice notice);

    /**
     * 分页查询所有的通知
     * @param offset 开始的索引
     * @param limit 偏移量
     * @return
     */
    List<Notice> queryAll(@Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 根据ID号查询出通知的信息，包括内容
     * @param id
     * @return
     */
    Notice queryByIdWithContent(@Param("id") Integer id);

    /**
     * 根据管理员的ID号查询出该管理员发布的所有的通知
     * @param offset
     * @param limit
     * @return
     */
    List<Notice> queryNoticeByMnagerId(@Param("offset") Integer offset, @Param("limit") Integer limit);
    
    /**
     * 根据id删除通知
     * @param id
     * @return
     */
    Integer deleteNoticeById(@Param("id") Integer id);
}
