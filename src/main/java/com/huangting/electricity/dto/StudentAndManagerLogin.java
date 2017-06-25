package com.huangting.electricity.dto;

import com.huangting.electricity.entity.Manager;
import com.huangting.electricity.entity.Student;

/**
 * Created by huangting on 2017/6/25.
 */
public class StudentAndManagerLogin {
    /**
     * 登录时候的学生账户
     */
    private Student student;

    /**
     * 登录时候的管理员账户
     */
    private Manager manager;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
