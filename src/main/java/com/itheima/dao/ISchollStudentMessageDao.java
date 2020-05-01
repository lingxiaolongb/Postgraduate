package com.itheima.dao;

import com.itheima.domian.SchollInfo;
import com.itheima.domian.SchollStudentMessage;
import com.itheima.domian.SchollVacancy;
import com.itheima.domian.StudentInfo;
import com.itheima.paging.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("schollStudentMessageDao")
public interface ISchollStudentMessageDao {
    int deleteByPrimaryKey(Long id);

    int insert(SchollStudentMessage record);

    SchollStudentMessage selectByPrimaryKey(Long id);

    List<SchollStudentMessage> selectAll();

    int updateByPrimaryKey(SchollStudentMessage record);

    List<Map<String,Object>> findReDataBySendFlag(@Param("id") String id,@Param("page") Page page);

    int findRowsBySendFlag(String id);

    List<StudentInfo> findSchNoticeNotSend(@Param("id") String id, @Param("page") Page page);

    Integer findSchNotSendRows(String id);

    List<StudentInfo> findSchNoticeSend(@Param("id") String id,@Param("page") Page page);

    Integer findSchSendRows(String id);

    Integer acceptStudent(@Param("map") Map<String,Object> map );

    Integer refuseStudent(@Param("stuId") String stuId,@Param("schId")String schId);

    Integer acceptSchool(@Param("stuId") String stuId,@Param("schId")String schId);

    Integer refuseSchool(@Param("stuId") String stuId,@Param("schId")String schId);

    List<StudentInfo> findParticipantStudent(String id);

    SchollStudentMessage findStudentWithSchool(@Param("map") Map<String,Object> map);



    List<SchollInfo>  findSuccessByStuId(String id);

    List<String> findToSubject(String stuId,String schId);
}