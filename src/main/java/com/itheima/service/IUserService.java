package com.itheima.service;

import com.itheima.domian.SysUser;
import com.itheima.domian.SysUserRole;
import com.itheima.paging.Page;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

public interface IUserService {



    int insert(SysUser record,String roleName);


    List<SysUser> findAll( Page page, SysUser user);

    int findRows(SysUser user);

   SysUser findCheckUserName(String name);

    SysUser findVerifyAccount(SysUser user, String roleName);


    int deleteByloginName(String name);

    int updateByLoginName(SysUser user,String sourceName);

    List<Map<String,Object>> findByLoginName(String sourceName);

}
