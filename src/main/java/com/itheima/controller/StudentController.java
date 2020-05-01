package com.itheima.controller;

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
@SessionAttributes(value = {"examId", "studentName", "student", "loginName"})
public class StudentController {

    @Autowired
    private IStudentInfoService studentInfoService;

    @Autowired
    private ISchoolVacancyService schoolVacancyService;

    @Autowired
    private IStudentApplicationService studentApplicationService;

    @Autowired
    private IAssociationService associationService;


    @RequestMapping("/info")
    public String studentInfo(ModelMap model){

        StudentInfo studentInfo = studentInfoService.findStudentByLoginName(model.get("loginName").toString());
        if (studentInfo != null) {
            model.addAttribute("student", studentInfo);
            model.addAttribute("examId", studentInfo.getExamId());
            model.addAttribute("studentName", studentInfo.getSname());
        }
        return "studentInfo" ;
    }


    @RequestMapping("/policy")
    public String studentPolicy(){
        return "studentPolicy" ;
    }


    @RequestMapping("/application")
    public String studentApplication(ModelMap modelMap){

        StudentApplication sa = studentApplicationService.findByExamId(modelMap.get("examId").toString());
        if (sa != null) {
            modelMap.addAttribute("disable", "true");
            modelMap.addAttribute("app", sa);
        } else {
            List<String> schoolNames=schoolVacancyService.findSchoolNames();
            modelMap.addAttribute("schoolNames",schoolNames);
        }
        Page page=new Page();
        int rows=schoolVacancyService.findRows();
        page.setRows(rows);
        List<Map<String,Object>> maps=schoolVacancyService.findAllByMap(page);
        System.out.println(maps);
        modelMap.addAttribute("page",page);
        modelMap.addAttribute("schoolList",maps);
        return "studentApplication" ;
    }



    @RequestMapping("/notice")
    public String studentNotification(ModelMap modelMap){
        String id=modelMap.get("examId").toString();
        int row=associationService.findRowsBySendFlag(id);
        Page page=new Page();
        page.setRows(row);
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
        int rows=associationService.findRowsBySendFlag(id);
        page.setRows(rows);
        List<Map<String,Object>> list =  associationService.findReDataBySendFlag(id,page);
        VacancyPage vacancyPage=new VacancyPage();
        vacancyPage.setPage(page);
        vacancyPage.setMapList(list);
        return vacancyPage;
    }

    @RequestMapping("/save")
    @ResponseBody
    public String studentSave(StudentInfo info) {
        int a = studentInfoService.updateByPrimaryKey(info);
        if (a == 1) return "trued";
        return "false";
    }

    @RequestMapping(value = "/paging", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public VacancyPage studentPaging(Integer currentPage, String findSch, String findSub) {
        Map<String, String> map = new HashMap<>();
        map.put("findSch", findSch);
        map.put("findSub", findSub);
        Page page = new Page();
        page.setCurrentPage(currentPage);
        int rows = schoolVacancyService.findRowByAjax(map);
        page.setRows(rows);
        List<Map<String, Object>> list = schoolVacancyService.findAllByAjax(page, map);
        VacancyPage vacancyPage = new VacancyPage();
        vacancyPage.setPage(page);
        vacancyPage.setMapList(list);
        return vacancyPage;
    }


    @RequestMapping(value = "/app", method = RequestMethod.POST)
    @ResponseBody
    public String studentAddApplication(StudentApplication application, ModelMap modelMap) {
        if (modelMap.get("examId").toString() != null) {
            String id = modelMap.get("examId").toString();
            application.setExamId(id);
            studentApplicationService.insert(application);
        }
        return "success";
    }

    @RequestMapping("/accept.do")
    @ResponseBody
    public void studentAcceptSchool(String schName,ModelMap modelMap){
        String stuId=modelMap.get("examId").toString();
        associationService.acceptSchool(stuId, schName);
    }


    @RequestMapping("/refuse.do")
    @ResponseBody
    public void studentRefuseSchool(String schName,ModelMap modelMap){
        String stuId=modelMap.get("examId").toString();
        associationService.refuseSchool(stuId, schName);
    }

    @RequestMapping("/join.do")
    public String  studentJoinInterview(ModelMap modelMap){
        String id = (modelMap.get("examId").toString() == null) ? "" : modelMap.get("examId").toString();
        List<SchollInfo> schollInfos = associationService.findSuccessByStuId(id);
        modelMap.addAttribute("schoolList", schollInfos);

        return  "studentPart";
    }

}
