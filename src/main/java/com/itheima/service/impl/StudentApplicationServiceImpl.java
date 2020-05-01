package com.itheima.service.impl;


import com.itheima.dao.ISchollInfoDao;
import com.itheima.dao.ISchollStudentMessageDao;
import com.itheima.dao.IStudentApplicationDao;
import com.itheima.dao.IStudentInfoDao;
import com.itheima.domian.SchollStudentMessage;
import com.itheima.domian.StudentApplication;
import com.itheima.domian.StudentInfo;

import com.itheima.service.IStudentApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("studentApplicationService")
public class StudentApplicationServiceImpl implements IStudentApplicationService {

    @Autowired
    private IStudentApplicationDao studentApplicationDao;

    @Autowired
    private ISchollInfoDao schollInfoDao;

    @Autowired
    private IStudentInfoDao studentInfoDao;

    @Autowired
    private ISchollStudentMessageDao schollStudentMessageDao;


    @Override
    public int insert(StudentApplication record) {
        String id=null;
        record.setFlag1("0");
        record.setFlag2("0");
        record.setFlag3("0");
        record.setFlag4("0");
        List<String> apps=new ArrayList<>();
        apps.add(record.getApplication1());
        apps.add(record.getApplication2());
        apps.add(record.getApplication3());
        apps.add(record.getApplication4());
        SchollStudentMessage msg=new SchollStudentMessage();
        studentApplicationDao.insert(record);
        StudentInfo studentInfo=studentInfoDao.selectByPrimaryKey(record.getExamId());
        for(String s:apps){
            if(s!=null){
                id=schollInfoDao.findBySchoolName(s);
                msg.setSendFlag("1");
                msg.setAcceptFlag("0");
                msg.setDelFlag("0");
                msg.setExamId(studentInfo.getExamId());
                msg.setSchollId(id);
                msg.setSubName(studentInfo.getToSubject());
                schollStudentMessageDao.insert(msg);
            }
        }
        return 1;
    }


    @Override
    public List<StudentApplication> selectAll() {
        return null;
    }

    @Override
    public StudentApplication findByExamId(String id) {
        return studentApplicationDao.findByExamId(id);
    }


}
