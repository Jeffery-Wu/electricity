package com.huangting.electricity.dao;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;

import com.huangting.electricity.entity.Dormitory;

/**
 * Created by huangting on 2017/6/24.
 */
public class DormitoryDaoTest {
    @Resource
    private DormitoryDao dormitoryDao;
    @Test
    public void queryDormitoryByStudentId() throws Exception {
    }

    @Test
    public void queryDormitoryByDormitoryId() throws Exception {
    }

    @Test
    @Ignore
    public void queryDormitoryById() throws Exception {
        Dormitory dormitory = dormitoryDao.queryDormitoryById(1);
        System.out.print(dormitory);
    }

}