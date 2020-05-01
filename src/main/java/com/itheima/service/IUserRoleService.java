package com.itheima.service;


import com.itheima.domian.SysUserRole;
import com.itheima.paging.Page;


import java.util.List;
import java.util.Map;

public interface IUserRoleService {

    List<SysUserRole> findAll();



    int updateByPrimaryKey(SysUserRole record);

    int deleteByPrimaryKey(Long id);

    int deleteByloginName(String name);


    SysUserRole findWhetherRepeatData(SysUserRole role);

    String update(SysUserRole role,String sourceRole);
    String insert(SysUserRole record);

    List<Map<String,String>> findAllByName(SysUserRole role,Page page);

    int findRowByName(SysUserRole role);
    int delete(SysUserRole role);
}
