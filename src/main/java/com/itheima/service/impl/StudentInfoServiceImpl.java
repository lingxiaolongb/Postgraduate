package com.itheima.service.impl;

import com.itheima.dao.IStudentInfoDao;
import com.itheima.domian.StudentInfo;
import com.itheima.paging.Page;
import com.itheima.service.IStudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("studentInfoService")
public class StudentInfoServiceImpl implements IStudentInfoService {

    @Autowired
    private IStudentInfoDao studentInfoDao;

    @Override
    public int deleteByPrimaryKey(String examId) {
        return studentInfoDao.deleteByPrimaryKey(examId);
    }

    @Override
    public int insert(StudentInfo record) {
        return studentInfoDao.insert(record);
    }

    @Override
    public StudentInfo selectByPrimaryKey(String examId) {
        return studentInfoDao.selectByPrimaryKey(examId);
    }

    @Override
    public List<StudentInfo> selectAll() {
        return studentInfoDao.selectAll();
    }

    @Override
    public int updateByPrimaryKey(StudentInfo record) {
        return studentInfoDao.updateByPrimaryKey(record);
    }

    @Override
    public int saveStudent(String uno, String stuName) {
        return studentInfoDao.saveStudent(uno,stuName);
    }

    @Override
    public List<StudentInfo> findAllByInfo(StudentInfo studentInfo, Page page,String id) {
        return studentInfoDao.findAllByInfo(studentInfo,page,id);
    }

    @Override
    public Integer findRows(StudentInfo studentInfo,String id) {
        return studentInfoDao.findRows(studentInfo,id);
    }


    @Override
    public StudentInfo findStudentByLoginName(String LoginName) {
        return studentInfoDao.findStudentByLoginName(LoginName);
    }
    public int updateInfoByAdmin(String id, String name) {
        return studentInfoDao.updateInfoByAdmin(id,name);
    }

}
