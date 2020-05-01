package com.itheima.service.impl;

import com.itheima.dao.ISchollInfoDao;
import com.itheima.dao.ISchollStudentMessageDao;
import com.itheima.dao.ISchollVacancyDao;
import com.itheima.dao.IStudentInfoDao;
import com.itheima.domian.SchollInfo;
import com.itheima.domian.SchollStudentMessage;
import com.itheima.domian.StudentInfo;
import com.itheima.paging.Page;
import com.itheima.service.IAssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("associationService")
public class AssociationServiceImpl implements IAssociationService {


    @Autowired
    private ISchollStudentMessageDao schollStudentMessageDao;

    @Autowired
    private ISchollVacancyDao schollVacancyDao;

    @Autowired
    private IStudentInfoDao studentInfoDao;

    @Autowired
    private ISchollInfoDao schollInfoDao;


    @Override
    public int insert(SchollStudentMessage record) {
        return schollStudentMessageDao.insert(record);
    }



    @Override
    public int updateByPrimaryKey(SchollStudentMessage record) {
        return schollStudentMessageDao.updateByPrimaryKey(record);
    }

    @Override
    public List<Map<String, Object>> findReDataBySendFlag(String id, Page page) {
        return schollStudentMessageDao.findReDataBySendFlag(id,page);
    }

    @Override
    public int findRowsBySendFlag(String id) {
        return schollStudentMessageDao.findRowsBySendFlag(id);
    }

    @Override
    public  List<StudentInfo>  findSchNoticeNotSend(String id, Page page) {
        return schollStudentMessageDao.findSchNoticeNotSend(id,page);
    }


    @Override
    public Integer findSchNotSendRows(String id) {

        return schollStudentMessageDao.findSchNotSendRows(id);
    }

    @Override
    public  List<StudentInfo>  findSchNoticeSend(String id, Page page) {
        return schollStudentMessageDao.findSchNoticeSend(id,page);
    }


    @Override
    public Integer findSchSendRows(String id) {
        return schollStudentMessageDao.findSchSendRows(id);
    }

    @Override
    public Integer completeAccpet(Map<String,Object> map) {
        schollStudentMessageDao.acceptStudent(map);
        return schollVacancyDao.subVNumber(map);
    }

    @Override
    public Integer acceptStudent(Map<String,Object> map) {
       SchollStudentMessage ssm= findStudentWithSchool(map);
       Integer a=null;
       if(ssm==null){
           System.out.println("当前没有这个人信息");
           StudentInfo studentInfo= studentInfoDao.selectByPrimaryKey(map.get("stuId").toString());
           SchollStudentMessage record=new SchollStudentMessage();
           record.setSchollId(map.get("schId").toString());
           record.setSubName(studentInfo.getFromSubject());
           record.setExamId(studentInfo.getExamId());
           record.setSendFlag("0");
           record.setAcceptFlag("1");
           record.setDelFlag("0");
           record.setToName(map.get("subName").toString());
           a=insert(record);
           System.out.println("信息插入成功");
       }else{
           System.out.println("信息存在并且已经修改");
           a=schollStudentMessageDao.acceptStudent(map);
       }
        return  a;
    }

    @Override
    public Integer refuseStudent(String stuId, String schId) {
        return schollStudentMessageDao.refuseStudent(stuId, schId);

    }

    @Override
    public Integer acceptSchool(String stuId, String schName) {
        String schId = schollInfoDao.findBySchoolName(schName);
        return schollStudentMessageDao.acceptSchool(stuId, schId);

    }

    @Override
    public Integer refuseSchool(String stuId, String schName) {
        String schId=schollInfoDao.findBySchoolName(schName);
        return schollStudentMessageDao.refuseSchool(stuId, schId);
    }

    @Override
    public List<StudentInfo> findParticipantStudent(String id) {
        return schollStudentMessageDao.findParticipantStudent(id);
    }

    @Override
    public List<SchollInfo> findSuccessByStuId(String id) {
        return schollStudentMessageDao.findSuccessByStuId(id);
    }

    @Override
    public SchollStudentMessage findStudentWithSchool(Map<String,Object> map) {
        return schollStudentMessageDao.findStudentWithSchool(map);
    }
}
