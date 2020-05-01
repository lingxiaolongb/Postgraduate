package com.itheima.dao;

import com.itheima.domian.StudentApplication;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("studentApplicationDao")
public interface IStudentApplicationDao {


    int insert(StudentApplication record);


    List<StudentApplication> selectAll();

    StudentApplication findByExamId(String id);


}