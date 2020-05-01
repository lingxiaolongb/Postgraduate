package com.itheima.service.impl;


import com.itheima.dao.ISysUserDao;
import com.itheima.dao.ISysUserRoleDao;
import com.itheima.domian.SysUser;
import com.itheima.domian.SysUserRole;

import com.itheima.paging.Page;
import com.itheima.service.ISchoolInfoService;
import com.itheima.service.IStudentInfoService;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl  implements IUserService {

    @Autowired
    ISysUserDao userDao;

    @Autowired
    ISysUserRoleDao userRoleDao;

    @Autowired
    IStudentInfoService studentInfoService;

    @Autowired
    ISchoolInfoService schoolInfoService;

    @Override
    public int insert(SysUser record,String roleName) {

        record.setLoginFlag("0");
        userDao.insert(record);
        SysUserRole userRole=new SysUserRole();
        if(roleName.equals("student")){
            studentInfoService.saveStudent(record.getUno(),record.getUname());
        }else{
            schoolInfoService.saveSchool(record.getUno(),record.getUname());
        }
        userRole.setLoginName(record.getLoginName());
        userRole.setRname(roleName);
        return  userRoleDao.insert(userRole);
    }

    @Override
    public List<SysUser> findAll(Page page, SysUser user) {
         return userDao.findAll(page,user);
    }

    @Override
    public int findRows(SysUser user) {
        return userDao.findRows(user);
    }



    @Override
    public SysUser findCheckUserName(String name) {
        List<SysUser> users=userDao.findCheckUserName(name);
        if(users.isEmpty() || users.size()==0)
            return null;
        else if(users.size()>1)
            throw new RuntimeException("用户名不唯一");

        return users.get(0);
    }

    @Override
    public SysUser findVerifyAccount(SysUser user, String roleName) {
        return userDao.findVerifyAccount(user,roleName);
    }

    @Override
    public int deleteByloginName(String name) {
        userRoleDao.deleteByloginName(name);
        return userDao.deleteByloginName(name);
    }

    @Override
    public int updateByLoginName(SysUser user,String sourceName) {

        List<Map<String,Object>> obj= findByLoginName(sourceName);
        for(Map<String,Object> u:obj){
            if(u.get("roleName").toString().equals("student")){
                studentInfoService.updateInfoByAdmin(u.get("id").toString(),user.getUname());
            }else if(u.get("roleName").toString().equals("school")){
                schoolInfoService.updateInfoByAdmin(u.get("id").toString(),user.getUname());
            }
        }
        userRoleDao.updateInfoByAdmin(user.getLoginName(),sourceName);
        return userDao.updateByLoginName(user,sourceName);

    }

    @Override
    public    List<Map<String,Object>>findByLoginName(String sourceName) {
        return userDao.findByLoginName(sourceName);
    }


}
