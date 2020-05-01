package com.itheima.untils;

import com.alibaba.fastjson.JSONArray;
import com.itheima.domian.SysUserRole;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("adminDeal")
public class AdminDeal {

    public String dealRole(SysUserRole role){
        Map<String,String> map=new HashMap<>();
        map.put("code","1");
        map.put("msg","信息增加成功");
        map.put("rname",role.getRname());
        map.put("username",role.getLoginName());
        if(role.getRname().equals("admin")){
            map.put("chName","管理员");
            map.put("operation","管理员权限");
        }else if(role.equals("school")){
            map.put("chName","高校招生");
            map.put("operation","仅自我操作");
        }else{
            map.put("chName","学生");
            map.put("operation","仅自我操作");
        }
        return  JSONArray.toJSON(map).toString();
    }



}
