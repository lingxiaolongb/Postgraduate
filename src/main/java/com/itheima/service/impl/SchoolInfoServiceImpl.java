package com.itheima.service.impl;

import com.itheima.dao.ISchollInfoDao;
import com.itheima.domian.SchollInfo;
import com.itheima.service.ISchoolInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("schoolInfoService")
public class SchoolInfoServiceImpl implements ISchoolInfoService {

    @Autowired
    private ISchollInfoDao schollInfoDao;


    @Override
    public int updateInfoByAdmin(String id, String name) {
        return schollInfoDao.updateInfoByAdmin(id,name);
    }

    @Override
    public int deleteByPrimaryKey(String schollId) {
        return schollInfoDao.deleteByPrimaryKey(schollId);
    }

    @Override
    public int insert(SchollInfo record) {
        return schollInfoDao.insert(record);
    }

    @Override
    public SchollInfo selectByPrimaryKey(String schollId) {
        return schollInfoDao.selectByPrimaryKey(schollId);
    }

    @Override
    public List<SchollInfo> selectAll() {
        return schollInfoDao.selectAll();
    }

    @Override
    public int updateByPrimaryKey(SchollInfo record) {
        return schollInfoDao.updateByPrimaryKey(record);
    }

    @Override
    public String findBySchoolName(String schoolName) {
        return schollInfoDao.findBySchoolName(schoolName);
    }

    @Override
    public int saveSchool(String uno, String schName) {
        return schollInfoDao.saveSchool(uno, schName);
    }

    @Override
    public SchollInfo findSchoolByLoginName(String loginName) {
        return schollInfoDao.findSchoolByLoginName(loginName);
    }
}
