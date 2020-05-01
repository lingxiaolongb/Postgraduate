package com.itheima.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
         Object loginName = session.getAttribute("loginName");
        if(loginName!=null && loginName.toString()!=null){
            return true;
        }else{
            response.sendRedirect(request.getContextPath()+"/user/noLogin.do");
            return false;
        }

    }

}
