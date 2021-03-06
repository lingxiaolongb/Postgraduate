package com.itheima.service.impl;

import com.itheima.dao.ISchollVacancyDao;
import com.itheima.domian.SchollVacancy;
import com.itheima.paging.Page;
import com.itheima.paging.VacancyPage;
import com.itheima.service.ISchoolVacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("schoolVacancyService")
public class SchoolVacancyServiceImpl implements ISchoolVacancyService {

    @Autowired
    private ISchollVacancyDao schollVacancyDao;


    @Override
    public int insert(SchollVacancy record) {
        return schollVacancyDao.insert(record);
    }


    @Override
    public int updateByPrimaryKey(SchollVacancy record) {
        return schollVacancyDao.updateByPrimaryKey(record);
    }

    @Override
    public SchollVacancy findSameDataBySubName(SchollVacancy record) {
        return schollVacancyDao.findSameDataBySubName(record);
    }

    @Override
    public List<String> findSchoolNames() {
        return schollVacancyDao.findSchoolNames();
    }

    @Override
    public int findRows() {
        return schollVacancyDao.findRows();
    }

    @Override
    public int findRowByAjax(Map<String, String> map) {
        return schollVacancyDao.findRowByAjax(map);
    }


    @Override
    public List<Map<String, Object>> findAllByMap(Page page) {
        return schollVacancyDao.findAllByMap(page);
    }

    @Override
    public List<Map<String, Object>> findAllByAjax(Page page, Map<String, String> map) {
        return schollVacancyDao.findAllByAjax(page,map);
    }

    @Override
    public List<String> findAllById(String id) {
        return schollVacancyDao.findAllById(id);
    }

    @Override
    public Integer subVNumber(Map<String, Object> map) {
        return schollVacancyDao.subVNumber(map);
    }

    @Override
    public List<SchollVacancy> findAllBySchId(String id) {
        return schollVacancyDao.findAllBySchId(id);
    }


}
