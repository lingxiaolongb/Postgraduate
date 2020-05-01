package com.itheima.controller;

import com.itheima.domian.*;

import com.itheima.paging.Page;
import com.itheima.paging.SsmPage;
import com.itheima.paging.StudentPage;
import com.itheima.service.IAssociationService;
import com.itheima.service.ISchoolInfoService;

import com.itheima.service.ISchoolVacancyService;
import com.itheima.service.IStudentInfoService;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/school")
@SessionAttributes({"school","schId","loginName"})
public class SchoolController {

    @Autowired
    private ISchoolInfoService schoolInfoService;

    @Autowired
    private ISchoolVacancyService schoolVacancyService;

    @Autowired
    private IStudentInfoService studentInfoService;

    @Autowired
    private IAssociationService associationService;




    @RequestMapping("/info")
    public String schoolLogin( ModelMap model){
        SchollInfo schollInfo = schoolInfoService.findSchoolByLoginName(model.get("loginName").toString());
        if (schollInfo != null) {
            model.addAttribute("school", schollInfo);
            model.addAttribute("school", schollInfo);
            model.addAttribute("schId", schollInfo.getSchollId());
        }

        return "schoolInfo" ;
    }


    @RequestMapping("/save")
    @ResponseBody
    public void schoolSaveInfo(SchollInfo schollInfo){
        schoolInfoService.updateByPrimaryKey(schollInfo);
    }


    @RequestMapping("/vacancy")
    public String schoolAddVacancy(){
        return "schoolVacancy";
    }



    @RequestMapping("/vacancy.do")
    @ResponseBody
    public void schoolSaveVacancyInfo(@RequestBody OtherVacancy vacancy,ModelMap modelMap){
        String str=modelMap.get("schId").toString();
        int a=0;
        SchollVacancy schollVacancy=new SchollVacancy();
        schollVacancy.setContacts(vacancy.getContacts());
        schollVacancy.setTelephone(vacancy.getTelephone());
        schollVacancy.setEmail(vacancy.getEmail());
        schollVacancy.setSchollId(str);
        for (Vacancy v : vacancy.getVacancies()) {
            schollVacancy.setSubName(v.getSpecialized());
            schollVacancy.setVnumber(v.getLack());
            SchollVacancy sch=  schoolVacancyService.findSameDataBySubName(schollVacancy);
            if(sch==null) {
               schoolVacancyService.insert(schollVacancy);
            } else if (sch != null) {
                schoolVacancyService.updateByPrimaryKey(sch);
            }

        }

    }

    @RequestMapping("/view.do")
    public String schoolViewMissing(ModelMap modelMap){
        String id = (modelMap.get("schId").toString() == null) ? "" : modelMap.get("schId").toString();
       List<SchollVacancy> vacancyList= schoolVacancyService.findAllBySchId(id);
       modelMap.addAttribute("vacancies",vacancyList);
        return "schoolViewMissing";
    }

    @RequestMapping("/choose")
    public String schoolChoose(ModelMap modelMap){
        String id=(modelMap.get("schId").toString()==null)?"":modelMap.get("schId").toString();
        Page page=new Page();
        int row=studentInfoService.findRows(null,id);
        page.setRows(row);
        List<StudentInfo> studentInfos= studentInfoService.findAllByInfo(null,page,id);
        modelMap.addAttribute("studentList",studentInfos);
        modelMap.addAttribute("page",page);
        return "schoolChoose";
    }
    @RequestMapping("/choose.do")
    @ResponseBody
    public StudentPage schoolChooseDo(StudentInfo studentInfo,Integer currentPage,ModelMap modelMap){
        String id=(modelMap.get("schId").toString()==null)?"":modelMap.get("schId").toString();
        Page page=new Page();
        int row=studentInfoService.findRows(studentInfo,id);
        page.setRows(row);
        page.setCurrentPage(currentPage);
        List<StudentInfo> studentInfos= studentInfoService.findAllByInfo(studentInfo,page,id);
        StudentPage student=new StudentPage();
        student.setPage(page);
        student.setStudentInfos(studentInfos);
        return student;
    }


    @RequestMapping("/notice")
    public String schoolSendNotice(ModelMap model){
        Assert.assertNotNull(model.get("schId").toString());
        String id=null;
       if(model.get("schId").toString()!=null){
           id=model.get("schId").toString();
       }
        Page page=new Page();
        Integer rows= associationService.findSchNotSendRows(id);
        page.setRows(rows);
        List<StudentInfo>  ssm=associationService.findSchNoticeNotSend(id,page);
        model.addAttribute("page1",page);
        model.addAttribute("ssm1",ssm);
        rows=associationService.findSchSendRows(id);
        page.setRows(rows);
        ssm=associationService.findSchNoticeSend(id,page);
        model.addAttribute("page2",page);
        model.addAttribute("ssm2",ssm);
        return "schoolNotice";
    }
    @RequestMapping("/notice.send")
    @ResponseBody
    public SsmPage schoolNoticeHasBeenSend(Integer currentPage, ModelMap model){
        String id=model.get("schId").toString();
        Page page=new Page();
        page.setCurrentPage(currentPage);
        Integer rows= associationService.findSchSendRows(id);
        page.setRows(rows);
        List<StudentInfo>  ssm=associationService.findSchNoticeSend(id,page);
        SsmPage ssmPage=new SsmPage();
        ssmPage.setInfos(ssm);
        ssmPage.setPage(page);
       return  ssmPage;
    }

    @RequestMapping("/notice.not")
    @ResponseBody
    public SsmPage schoolNoticeNotSend(Integer currentPage,ModelMap model){
        String id=model.get("schId").toString();
        Page page=new Page();
        page.setCurrentPage(currentPage);
        Integer rows= associationService.findSchNotSendRows(id);
        page.setRows(rows);
        List<StudentInfo>  ssm=associationService.findSchNoticeNotSend(id,page);
        SsmPage ssmPage=new SsmPage();
        ssmPage.setInfos(ssm);
        ssmPage.setPage(page);
        return  ssmPage;
    }

    @RequestMapping("/accept.do")
    @ResponseBody
    public void schoolAcceptStudent(String id,ModelMap modelMap,String subName){
        String schId=(modelMap.get("schId").toString()==null)?"":modelMap.get("schId").toString();
        Map<String,Object> maps =new HashMap<>();
        maps.put("stuId",id);
        maps.put("schId",schId);
        maps.put("subName",subName);
        associationService.acceptStudent(maps);
    }

    @RequestMapping("/acceptNotice.do")
    @ResponseBody
    public void schoolSureAccept(String id,ModelMap modelMap,String subName){
        String schId=(modelMap.get("schId").toString()==null)?"":modelMap.get("schId").toString();
        Map<String,Object> maps =new HashMap<>();
        maps.put("stuId",id);
        maps.put("schId",schId);
        maps.put("subName",subName);
        associationService.completeAccpet(maps);
    }



    @RequestMapping("/refuse.do")
    @ResponseBody
    public void schoolRefuseStudent(String id,ModelMap modelMap){
        String schId=modelMap.get("schId").toString();
        associationService.refuseStudent(id,schId);
    }

    @RequestMapping("/schoolSub.do")
    @ResponseBody
    public List<String> findSchoolSubjects(ModelMap modelMap){
        String id=(modelMap.get("schId").toString()==null)?"":modelMap.get("schId").toString();
       List<String> schSubs= schoolVacancyService.findAllById(id);
       return schSubs;
    }


    @RequestMapping("/condition.do")
    public String schoolCondition(ModelMap modelMap){
        String id=(modelMap.get("schId").toString()==null)?"":modelMap.get("schId").toString();
         List<StudentInfo> studentInfos= associationService.findParticipantStudent(id);
         List<String> tuSubject=new ArrayList<>();
         for(int i=0;i<studentInfos.size();i++){

         }
         modelMap.addAttribute("studentList",studentInfos);
        return "schoolCondition";
    }

}
