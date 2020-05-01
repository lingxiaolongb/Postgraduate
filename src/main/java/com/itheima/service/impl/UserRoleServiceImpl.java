package com.itheima.service.impl;

import com.itheima.dao.ISysUserRoleDao;

import com.itheima.untils.AdminDeal;
import com.itheima.domian.SysUserRole;
import com.itheima.paging.Page;
import com.itheima.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("userRoleService")
public class UserRoleServiceImpl implements IUserRoleService {

    @Autowired
    ISysUserRoleDao userRoleDao;

    @Autowired AdminDeal adminDeal;


    @Override
    public List<SysUserRole> findAll() {
        return userRoleDao.findAll();
    }



    @Override
    public int updateByPrimaryKey(SysUserRole record) {
        return userRoleDao.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userRoleDao.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByloginName(String name) {
        return userRoleDao.deleteByloginName(name);
    }

    @Override
    public SysUserRole findWhetherRepeatData(SysUserRole role) {
        return userRoleDao.findWhetherRepeatData(role);
    }

    @Override
    public String update(SysUserRole role, String sourceRole) {
        SysUserRole sur=findWhetherRepeatData(role);
        if(sur!=null){
            return "{\"code\":\"0\",\n" +
                    "\"msg\":\"信息已存在\"\n" +
                    "}";
        }else{
            userRoleDao.update(role,sourceRole);
            return adminDeal.dealRole(role);
        }

    }

    @Override
    public String insert(SysUserRole record) {
        SysUserRole sur=findWhetherRepeatData(record);
        if(sur!=null){
            return "{\"code\":\"0\",\n" +
                    "\"msg\":\"信息已存在\"\n" +
                    "}";
        }else{
            userRoleDao.insert(record);
            return adminDeal.dealRole(record);
        }

    }

    @Override
    public List<Map<String, String>> findAllByName(SysUserRole role, Page page) {
        return userRoleDao.findAllByName(role,page);
    }

    @Override
    public int findRowByName(SysUserRole role) {
        return userRoleDao.findRowByName(role);
    }

    @Override
    public int delete(SysUserRole role) {
        return userRoleDao.delete(role);
    }
}
