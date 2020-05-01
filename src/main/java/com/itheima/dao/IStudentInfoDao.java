package com.itheima.dao;

import com.itheima.domian.StudentInfo;
import com.itheima.paging.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("studentInfoDao")
public interface IStudentInfoDao {
    int deleteByPrimaryKey(String examId);

    int insert(StudentInfo record);

    StudentInfo selectByPrimaryKey(String examId);

    StudentInfo  findStudentByLoginName(String LoginName);

    List<StudentInfo> selectAll();

    int updateByPrimaryKey(StudentInfo record);

    @Insert({"INSERT INTO student_info(exam_id,sname) VALUES (#{uno},#{stuName})"})
    int saveStudent(@Param("uno") String uno, @Param("stuName")String stuName);


    List<StudentInfo>  findAllByInfo(@Param("info") StudentInfo studentInfo, @Param("page") Page page,@Param("id") String id);

    Integer findRows( @Param("info")StudentInfo studentInfo,@Param("id") String id);

    @Update({"update student_info set " +
            "sname = #{name}" +
            "where exam_id = #{id}"})
    int updateInfoByAdmin(@Param("id") String id,@Param("name")String name);
}