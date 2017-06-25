package com.huangting.electricity.dao;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.huangting.electricity.entity.Student;

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
    public void addStudent1() throws Exception {
    }

    @Test
    public void updateStudent1() throws Exception {
    }

    @Test
    public void deleteStudentById1() throws Exception {
    }

    @Test
    public void queryStudentByDormitoryId1() throws Exception {
    }

    @Test
    public void queryStudentById1() throws Exception {
    }

    @Test
    @Ignore
    public void queryStudentByStudentId() throws Exception {
        Student student = studentDao.queryStudentByStudentId("2014213451");
System.out.println(student);
    }

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
    @Ignore
    public void queryStudentById() throws Exception {
        Student student = studentDao.queryStudentById(1L);
        System.out.println(student);
    }

}