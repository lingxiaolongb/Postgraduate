package com.itheima.controller;
import com.itheima.domian.SysUser;

import com.itheima.service.IUserService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
@RequestMapping("/user")
@SessionAttributes(value = {"loginName"})
public class UserController {

    @Autowired
    private IUserService userService;


    @RequestMapping(value = "/save",produces = "text/html;charset=UTF-8",method = RequestMethod.POST)
    @ResponseBody
    public String saveUser(SysUser user, String role) {
        if(userService.insert(user,role.toLowerCase())==1) {
            return "trued";
        }
        return "falsed" ;
    }



    @RequestMapping(value="/check",method = RequestMethod.GET)
    @ResponseBody
    public String checkUserName(String name){
      SysUser user= userService.findCheckUserName(name);
      if(user==null) return "trued";
      return "falsed" ;
    }


    @RequestMapping(value="/verify",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String verifyAccount(String name, String pwd, String role, ModelMap model){
        SysUser user=new SysUser();
        user.setLoginName(name);
        user.setPassword(pwd);
        user= userService.findVerifyAccount(user,role.toLowerCase());
        if(user!=null){
            if(user.getLoginFlag().equals("1")) {
                return "{\"flag\":\"error\",\"msg\":\"你已经被封号\"}";
            }
            model.addAttribute("loginName",user.getLoginName());
            return  "{\"flag\":\"trued\"}";
        }else{
            return "{\"flag\":\"error\",\"msg\":\"账户密码错误\"}";
        }


    }


    @RequestMapping("/noLogin.do")
    public String  NotLoginIn(HttpSession session) throws IOException {
        return "failed";
    }

    @RequestMapping("/login.do")
    public void LoginIn(HttpServletResponse res, HttpSession session, HttpServletRequest req) throws IOException {
        session.invalidate();
        res.sendRedirect(req.getContextPath()+"/index.jsp");
    }





}
