package com.huangting.electricity.dao;

import com.huangting.electricity.entity.Student;

/**
 * Created by huangting on 2017/6/20.
 */
public interface StudentDao {

    /**
     * 添加一个学生
     * @param student
     * @return
     */
    Integer addStudent(Student student);

    /**
     * 更新学生的信息
     * @param student
     * @return
     */
    Integer updateStudent(Student student);
}
