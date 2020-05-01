package com.itheima.controller;

import com.alibaba.fastjson.JSONArray;
import com.itheima.domian.SysLog;
import com.itheima.domian.SysUser;
import com.itheima.domian.SysUserRole;
import com.itheima.paging.LogPage;
import com.itheima.paging.Page;
import com.itheima.paging.RolePage;
import com.itheima.paging.UserPage;
import com.itheima.service.ISysLogService;
import com.itheima.service.IUserRoleService;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserRoleService userRoleService;

    @RequestMapping("/info")
    public String adminLogin(){
        return "admin-view-user" ;
    }

    @RequestMapping(value = "/info.do",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String adminFindUser(Integer page,Integer limit,SysUser user){
        Page p=new Page();
        p.setCurrentPage(page);
        p.setPageSize(limit);
        int row=userService.findRows(user);
        List<SysUser> users=userService.findAll(p,user);
        for(SysUser s:users){
            if(s.getLoginFlag().equals("0") )
                s.setLoginFlag("是");
            else
                s.setLoginFlag("否");
        }
        UserPage up=new UserPage();
        up.setData(users);
        up.setCount(row);
        Object obj= JSONArray.toJSON(up);
        if(obj!=null){
            return obj.toString();
        }
        return "failed" ;
    }


    @RequestMapping("/delete.do")
    @ResponseBody
    public void deleteUser(String loginName) {
        userService.deleteByloginName(loginName);
    }

    @RequestMapping("/update.do")
    @ResponseBody
    public void updateUser(SysUser user,String sourceName)  {
        System.out.println("user="+user);
        userService.updateByLoginName(user,sourceName);
    }


    @RequestMapping("/save.do")
    @ResponseBody
    public void saveUser(SysUser user,String rname){
        userService.insert(user,rname.toLowerCase());
    }

    @RequestMapping("/role.do")
    public String findRole(){
        return "admin-role";
    }

    @RequestMapping(value = "/role/find.do",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String findRole(Integer page, Integer limit, SysUserRole role){
        int row=userRoleService.findRowByName(role);
        Page p=new Page();
        p.setCurrentPage(page);
        p.setPageSize(limit);
        List<Map<String,String>> list=userRoleService.findAllByName(role,p);
        for (Map<String,String> t:list){
            String name= t.get("roleName").toLowerCase();
            if(name.equals("admin")){
                t.put("chName","管理员");
                t.put("operation","管理员权限");
            }else if(name.equals("school")){
                t.put("chName","高校招生");
                t.put("operation","仅自我操作");
            }else{
                t.put("chName","学生");
                t.put("operation","仅自我操作");
            }
        }
        RolePage rp=new RolePage();
        rp.setCount(row);
        rp.setData(list);
     return JSONArray.toJSON(rp).toString();
    }

    @RequestMapping(value = "/updateRole.do",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String updateRole(SysUserRole userRole,String sourceRole){

        return userRoleService.update(userRole,sourceRole);
    }

    @RequestMapping(value = "/insertRole.do",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String insertRole(SysUserRole userRole){

        return userRoleService.insert(userRole);
    }

    @RequestMapping("/delRole.do")
    @ResponseBody
    public void delRole(SysUserRole userRole){
            userRoleService.delete(userRole);
    }

    @RequestMapping("/log.do")
    public String ViewLogFile(Integer page, Integer limit){
        return "admin-log";
    }

    @RequestMapping(value = "/logPaging.do",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String LogPaging(Integer page, Integer limit){
        int row=logService.findRows();
        Page p=new Page();
        p.setCurrentPage(page);
        p.setPageSize(limit);
        List<SysLog> logs=logService.findByPaging(p);
        LogPage logPage=new LogPage();
        logPage.setData(logs);
        logPage.setCount(row);
        return JSONArray.toJSON(logPage).toString();
    }

    @Autowired
    private ISysLogService logService;

}
