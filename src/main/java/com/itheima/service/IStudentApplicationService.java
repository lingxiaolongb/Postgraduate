package com.itheima.service;

import com.itheima.domian.StudentApplication;

import java.util.List;


public interface IStudentApplicationService {

    int insert( StudentApplication record);


    List<StudentApplication> selectAll();


    StudentApplication findByExamId(String id);

}
