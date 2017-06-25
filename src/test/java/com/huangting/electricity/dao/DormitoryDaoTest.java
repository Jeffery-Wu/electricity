package com.huangting.electricity.dao;

import com.huangting.electricity.entity.Dormitory;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

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
    public void queryDormitoryById() throws Exception {
        Dormitory dormitory = dormitoryDao.queryDormitoryById(1);
        System.out.print(dormitory);
    }

}