package com.huangting.electricity.dao;

import com.huangting.electricity.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by huangting on 2017/6/20.
 */
@Mapper
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

    /**
     * 根据学生的ID号删除学生信息
     * @param id
     * @return
     */
    Integer deleteStudentById(Long id);

    /**
     * 根据宿舍的ID号查询出同一个宿舍的学生
     * @param dormitoryId
     * @return
     */
    List<Student> queryStudentByDormitoryId(Integer dormitoryId);

    /**
     * 根据的学生ID查询出学生的信息
     * @param id
     * @return
     */
    Student queryStudentById(Long id);
    
    /**
     * 根据学生学号查询学生信息
     * @param id
     * @return
     */
    Student queryStudentByStudentId(String id);

}
