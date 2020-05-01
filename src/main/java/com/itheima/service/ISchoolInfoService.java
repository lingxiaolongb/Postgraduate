package com.itheima.service;

import com.itheima.domian.SchollInfo;


import java.util.List;

public interface ISchoolInfoService {

    int updateInfoByAdmin(String id,String name);

    int deleteByPrimaryKey(String schollId);

    int insert(SchollInfo record);

    SchollInfo selectByPrimaryKey(String schollId);

    List<SchollInfo> selectAll();

    int updateByPrimaryKey(SchollInfo record);

    String  findBySchoolName(String schoolName);

    int saveSchool( String uno, String schName);

    SchollInfo findSchoolByLoginName(String loginName);
}
