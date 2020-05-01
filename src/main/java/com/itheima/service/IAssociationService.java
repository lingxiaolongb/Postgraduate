package com.itheima.service;

import com.itheima.domian.SchollInfo;
import com.itheima.domian.SchollStudentMessage;
import com.itheima.domian.SchollVacancy;
import com.itheima.domian.StudentInfo;
import com.itheima.paging.Page;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;


public interface IAssociationService {



    int insert(SchollStudentMessage record);


    int updateByPrimaryKey(SchollStudentMessage record);

    List<Map<String,Object>> findReDataBySendFlag(String id, Page page);

    int findRowsBySendFlag(String id);

    List<StudentInfo>  findSchNoticeNotSend(String id, Page page);

    Integer findSchNotSendRows(String id);

    List<StudentInfo>  findSchNoticeSend(String id, Page page);

    Integer findSchSendRows(String id);

    Integer completeAccpet(Map<String,Object> map);

    Integer acceptStudent(Map<String,Object> map );

    Integer refuseStudent( String stuId,String schId);

    Integer acceptSchool(String stuId,String schId);

    Integer refuseSchool(String stuId,String schId);

    List<StudentInfo> findParticipantStudent(String id);

    List<SchollInfo>  findSuccessByStuId(String id);

    SchollStudentMessage findStudentWithSchool( Map<String,Object> map);


}
