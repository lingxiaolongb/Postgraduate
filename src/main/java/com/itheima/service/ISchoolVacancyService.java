package com.itheima.service;

import com.itheima.domian.SchollVacancy;
import com.itheima.paging.Page;



import java.util.List;
import java.util.Map;

public interface ISchoolVacancyService {





    int insert(SchollVacancy record);



    int updateByPrimaryKey(SchollVacancy record);


    SchollVacancy findSameDataBySubName(SchollVacancy record);
    List<String> findSchoolNames();

    int findRows();

    int findRowByAjax( Map<String,String> map);

    List<Map<String,Object>> findAllByMap(Page page);

    List<Map<String,Object>> findAllByAjax( Page page,Map<String,String> map);

    List<String> findAllById(String id);

    Integer subVNumber(Map<String,Object> map);

    List<SchollVacancy> findAllBySchId(String id);
}
