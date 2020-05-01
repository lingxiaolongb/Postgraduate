package com.itheima.service;

import com.itheima.domian.StudentInfo;
import com.itheima.paging.Page;


import java.util.List;

public interface IStudentInfoService {


    int deleteByPrimaryKey(String examId);

    int insert(StudentInfo record);

    StudentInfo selectByPrimaryKey(String examId);

    List<StudentInfo> selectAll();

    int updateByPrimaryKey(StudentInfo record);

    int saveStudent( String uno, String stuName);


    List<StudentInfo>  findAllByInfo(StudentInfo studentInfo, Page page,String id);
    Integer findRows(StudentInfo studentInfo,String id);

    StudentInfo  findStudentByLoginName(String LoginName);

    int updateInfoByAdmin(String id,String name);
}



