package com.itheima.controller;

import com.itheima.constant.StudentConst;
import com.itheima.domian.SchollInfo;
import com.itheima.domian.StudentApplication;
import com.itheima.domian.StudentInfo;
import com.itheima.paging.Page;
import com.itheima.paging.VacancyPage;
import com.itheima.service.IAssociationService;
import com.itheima.service.ISchoolVacancyService;
import com.itheima.service.IStudentApplicationService;
import com.itheima.service.IStudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
@SessionAttributes(value = {
        StudentConst.EXAM_ID,
        StudentConst.STUDENT_NAME,
        StudentConst.STUDENT,
        StudentConst.LOGIN_NAME})
public class StudentController {

    @Autowired
    IStudentInfoService studentInfoService;

    @Autowired
     ISchoolVacancyService schoolVacancyService;

    @Autowired
    IStudentApplicationService studentApplicationService;

    @Autowired
    IAssociationService associationService;

    /**
     * 学生信息界面
     * @return
     */

    @RequestMapping("/info")
    public String studentInfo(ModelMap model){
        Object o = model.get("examId");
        StudentInfo  studentInfo=null;
        if(o==null){
            studentInfo = studentInfoService.findStudentByLoginName(model.get("loginName").toString());
            model.remove("schId");
            model.remove("school");
            model.addAttribute("examId", studentInfo.getExamId());
        }else{
            studentInfo=studentInfoService.selectByPrimaryKey(o.toString());//已用缓存student
        }
        model.addAttribute("student", studentInfo);
        model.addAttribute("studentName", studentInfo.getSname());
        return "studentInfo" ;
    }

    @RequestMapping("/save")
    @ResponseBody
    public String studentSave(StudentInfo info){
        int a= studentInfoService.updateByPrimaryKey(info);//已用清除缓存student
        if(a==1) return "trued";
        return "false" ;
    }


    @RequestMapping("/policy")
    public String studentPolicy(){
        return "studentPolicy" ;
    }

    /**
     * 学生查询缺额信息以及填报志愿
     * @return
     */


    @RequestMapping("/application")
    public String studentApplication(ModelMap modelMap){
        String examId=modelMap.get("examId").toString();
        StudentApplication sp=studentApplicationService.findByExamId(examId);//已用缓存school
        if(sp==null) {
            List<String> schoolNames=schoolVacancyService.findSchoolNames();
            modelMap.addAttribute("schoolNames",schoolNames);
        }else {
            modelMap.addAttribute("disable", "true");
            modelMap.addAttribute("app", sp);
        }
        Page page=new Page();
        int rows=schoolVacancyService.findRows();
        page.setRows(rows);
        List<Map<String,Object>> maps=schoolVacancyService.findAllByMap(page);
        modelMap.addAttribute("page",page);
        modelMap.addAttribute("schoolList",maps);
        return "studentApplication" ;
    }


    /**
     *  志愿界面筛选信息分页
     * @return
     */
    @RequestMapping(value = "/paging",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public VacancyPage studentPaging(Integer  currentPage,String findSch,String findSub){
        Map<String,String> map=new HashMap<>();
        map.put("findSch",findSch);//学生筛选界面按学校查询的内容
        map.put("findSub",findSub);//学生筛选界面按专业查询的内容
        //由于这两个参数,导致缓存命中率低
        Page page=new Page();
        page.setCurrentPage(currentPage);
        int rows=schoolVacancyService.findRowByAjax(map);//这里与上面不同时可能多条件
        page.setRows(rows);
        List<Map<String,Object>> list =  schoolVacancyService.findAllByAjax(page,map);
        VacancyPage vacancyPage=new VacancyPage();
        vacancyPage.setPage(page);
        vacancyPage.setMapList(list);
        return vacancyPage;
    }



    /**
     *  提交申请志愿按钮
     * @param application
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/app",method = RequestMethod.POST)
    @ResponseBody
    public String studentAddApplication(StudentApplication application,ModelMap modelMap){
            String id=modelMap.get("examId").toString();
            application.setExamId(id);
            studentApplicationService.insert(application);//已用清除缓存student
        return "success";
    }


    /**
     * 学生复试通知
     * @return
     */

    @RequestMapping("/notice")
    public String studentNotification(ModelMap modelMap){
        String id=modelMap.get("examId").toString();
        //已做了缓存stu_sch
        int row=associationService.findRowsBySendFlag(id);
        Page page=new Page();
        page.setRows(row);
       //已做了缓存stu_sch
        List<Map<String,Object>> maps=associationService.findReDataBySendFlag(id,page);
        modelMap.addAttribute("page",page);
        modelMap.addAttribute("maps",maps);
        return "studentNotification" ;
    }



    @RequestMapping(value = "/noticePaging",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public VacancyPage studentNoticePaging(Integer currentPage,ModelMap modelMap){
        Page page=new Page();
        page.setCurrentPage(currentPage);
        String id=modelMap.get("examId").toString();
        //已做了缓存stu_sch
        int rows=associationService.findRowsBySendFlag(id);
        page.setRows(rows);
        //已做了缓存stu_sch
        List<Map<String,Object>> list =  associationService.findReDataBySendFlag(id,page);
        VacancyPage vacancyPage=new VacancyPage();
        vacancyPage.setPage(page);
        vacancyPage.setMapList(list);
        return vacancyPage;
    }







    /**
     * 学生拒绝复试
     * @return
     */

    @RequestMapping("/accept.do")
    @ResponseBody
    public void studentAcceptSchool(String schName,ModelMap modelMap){
        String stuId=modelMap.get("examId").toString();
        associationService.acceptSchool(stuId,schName);//清除缓存stu_sch
    }

    /**
     * 学生参加复试
     * @return
     */
    @RequestMapping("/refuse.do")
    @ResponseBody
    public void studentRefuseSchool(String schName,ModelMap modelMap){
        String stuId=modelMap.get("examId").toString();
        associationService.refuseSchool(stuId,schName);//清除缓存stu_sch
}


    /**
     * 学生同意参加面试邀请
     * @return
     */
    @RequestMapping("/join.do")
    public String  studentJoinInterview(ModelMap modelMap){
        String id=modelMap.get("examId").toString();
        //做了缓存stu_sch
        List<SchollInfo> schoolInfos=associationService.findSuccessByStuId(id);
        modelMap.addAttribute("schoolList",schoolInfos);
        return  "studentPart";
    }

}
