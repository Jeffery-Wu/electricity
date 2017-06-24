package com.huangting.electricity.dao;

import com.ElectricityApplication;
import com.huangting.electricity.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by huangting on 2017/6/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class StudentDaoTest {
    @Resource
    private StudentDao studentDao;
    @Test
    public void addStudent() throws Exception {
    }

    @Test
    public void updateStudent() throws Exception {
    }

    @Test
    public void deleteStudentById() throws Exception {
    }

    @Test
    public void queryStudentByDormitoryId() throws Exception {
    }

    @Test
    public void queryStudentById() throws Exception {
        Student student = studentDao.queryStudentById(1L);
        System.out.println(student);
    }

}