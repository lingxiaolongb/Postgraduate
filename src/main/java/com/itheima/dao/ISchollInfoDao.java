package com.itheima.dao;

import com.itheima.domian.SchollInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("schollInfoDao")
public interface ISchollInfoDao {
    int deleteByPrimaryKey(String schollId);

    int insert(SchollInfo record);

    SchollInfo selectByPrimaryKey(String schollId);

    List<SchollInfo> selectAll();

    @Select({"SELECT scholl_id FROM scholl_info WHERE scholl_name=#{schoolName} "})
    String  findBySchoolName(String schoolName);

    SchollInfo findSchoolByLoginName(String loginName);

    int updateByPrimaryKey(SchollInfo record);

    @Insert({"INSERT INTO scholl_info(scholl_id,contacts) VALUES (#{uno},#{contacts})"})
    int saveSchool(@Param("uno") String uno, @Param("contacts")String schName);


    @Update({"update  scholl_info set " +
            "contacts = #{name}" +
            "where scholl_id = #{id}"})
    int updateInfoByAdmin(@Param("id") String id,@Param("name")String name);
}