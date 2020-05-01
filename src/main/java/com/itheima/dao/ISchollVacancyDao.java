package com.itheima.dao;

import com.itheima.domian.SchollVacancy;
import com.itheima.paging.Page;
import com.itheima.paging.VacancyPage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("schollVacancyDao")
public interface ISchollVacancyDao {


    int insert(SchollVacancy record);


    int updateByPrimaryKey(SchollVacancy record);


    List<String> findSchoolNames();

    List<String> findAllById(String id);

    Integer subVNumber(@Param("map") Map<String,Object> map);

    @Select({"select count(*) FROM scholl_vacancy WHERE vnumber>0"})
    int findRows();

    int findRowByAjax(@Param("map") Map<String,String> map);


    List<Map<String,Object>> findAllByMap( Page page);

    List<Map<String,Object>> findAllByAjax(@Param("page") Page page, @Param("map")Map<String,String> map);


    SchollVacancy findSameDataBySubName(SchollVacancy record);

    List<SchollVacancy> findAllBySchId(String id);
}