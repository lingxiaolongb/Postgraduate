package com.itheima.advice;

import com.itheima.dao.ISysLoggerDao;
import com.itheima.domian.SysLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component("logger")
@Aspect
public class Logger {


    @Autowired
    private ISysLoggerDao loggerDao;
//
//    @Pointcut("execution(* com.itheima.service.impl.*.*(..))")
//   private void pt1(){};

    public SysLog getRequestInfo(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest req =((ServletRequestAttributes)requestAttributes).getRequest();
        SysLog log=new SysLog();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String time=dtf.format(LocalDateTime.now());
        String url=req.getRequestURL().toString();
        String ip=getIpAddr(req);
        String operation=getUser(url);
        log.setOperation(operation);
        log.setVisitTime(time);
        log.setMethod(req.getMethod());
        log.setRemoteAdd(ip);
        log.setRemoteAdd(req.getRemoteAddr());
        log.setUrl(url);
        return log;

    }



    public void afterReturningPrintLog(){
        SysLog log=getRequestInfo();
        System.out.println("增添正常日志");
        log.setException("正常运行");
        log.setType("接入日志");
        loggerDao.saveLog(log);

    }

    public void afterThrowingPrintLog(Exception ex){
        SysLog log=getRequestInfo();
        System.out.println("增添异常日志");
        log.setException("错误信息:"+ex.getMessage());
        log.setType("错误日志");
        loggerDao.saveLog(log);
    }

//    @Around("pt1()")
//    public Object aroundPrintLog(ProceedingJoinPoint pjp){
//        Object rtValue=null;
//        try {
//            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//            HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
//            Object[] arg = pjp.getArgs();
//            rtValue = pjp.proceed(arg);
//            System.out.println("日志加入执行了");
//            return  rtValue;
//        } catch (Throwable t) {
//            System.out.println(t.getMessage()+"异常");
//            throw  new RuntimeException(t);
//        }finally {
//            System.out.println("日志操作执行了");
//        }
//    }



    private String getUser(String url) {
      String  temp=url.substring(url.indexOf("/web/")+5);
      String  user=temp.substring(0,temp.indexOf("/"));
        if("student".equals(user)){
            return "考生";
        }else if("school".equals(user)){
            return "招生单位";
        }else if("admin".equals(user)){
            return "管理员";
        }else{
            return "其他";
        }
    }

    private String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;

    }
}
