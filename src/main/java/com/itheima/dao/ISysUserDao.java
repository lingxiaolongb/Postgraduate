package com.itheima.dao;

import com.itheima.domian.SysUser;
import com.itheima.domian.SysUserRole;
import com.itheima.paging.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("userDao")
public interface ISysUserDao {


    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);



    List<SysUser> findAll(@Param("page") Page page,@Param("user") SysUser user);

    int updateByPrimaryKey(SysUser record);

    @Select({"select * from sys_user where login_name=#{name} "})
    List<SysUser> findCheckUserName(String name);

    int findRows(@Param("user") SysUser user);

    SysUser findVerifyAccount(@Param("user")SysUser user,@Param("role") String roleName);



    List<Map<String,Object>> findByLoginName(String sourceName);

    int updateByLoginName(@Param("user") SysUser user,@Param("sourceName") String sourceName);

    @Delete({"delete  from sys_user where login_name=#{name}"})
    int deleteByloginName(String name);


}