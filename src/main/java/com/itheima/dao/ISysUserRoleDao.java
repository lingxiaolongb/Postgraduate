package com.itheima.dao;

import com.itheima.domian.SysUser;
import com.itheima.domian.SysUserRole;
import com.itheima.paging.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("userRoleDao")
public interface ISysUserRoleDao {




    List<SysUserRole> findAll();

    int updateByPrimaryKey(SysUserRole record);

    int deleteByPrimaryKey(Long id);




    @Delete({"delete  from sys_user_role where login_name=#{name}"})
    int deleteByloginName(String name);

   int  updateInfoByAdmin(@Param("loginName") String loginName,@Param("sourceName")String sourceName);


     List<Map<String,String>> findAllByName(@Param("role") SysUserRole role, @Param("page") Page page);

     int findRowByName(SysUserRole role);

    SysUserRole findWhetherRepeatData(SysUserRole role);

    int update(@Param("role") SysUserRole role,@Param("sourceRole") String sourceRole);
    int insert(SysUserRole record);

    int delete(SysUserRole role);
}
