package com.myprogram.web;

import com.myprogram.entity.Grade;
import com.myprogram.service.GradeService;
import com.myprogram.service.StuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/1/21 0021.
 */
@Controller
@RequestMapping("/gradeAction")
public class GradeAction {
    @Resource(name="gradeService")
    private GradeService gradeService;


    @Resource(name="stuService")
    private StuService stuService;

    //查询学生和班级信息并转到天加成绩页面
    @RequestMapping("/findStuList")
    public String findClsList(@ModelAttribute(name = "addMessage") String message, ModelMap modelMap) {
        modelMap.addAttribute("stuList",stuService.findStuList());
        if (message != null) {
            modelMap.addAttribute("addMessage", message);
        }
        return "pages/addGrade";
    }

    //添加成绩
    @RequestMapping("/addGrade")
    public String addGrade(Grade grade, RedirectAttributes attr){
        if(gradeService.addGrade(grade)){
            attr.addAttribute("gtype","1");
        }else{
            attr.addAttribute("gtype","2");
        }
        return "redirect:/pages/addGrade.jsp";
    }

    //查询学生成绩的方法
    @RequestMapping("/findGradeList")
    public String findGradeList(Model mod){
        mod.addAttribute("gradeList",gradeService.findGradeList());
        mod.addAttribute("stuList",stuService.findStuList());
        return "pages/Grade";
    }

    //根据学生id查询学生，跳转到修改学生页面
    @RequestMapping("/getGradeById/{gno}")
    public String getClsById(@PathVariable(name="gno") int gno, ModelMap modelMap){
        modelMap.addAttribute("grade",gradeService.getGradeById(gno));
        modelMap.addAttribute("stuList",stuService.findStuList());
        return "pages/updateGrade";
    }

    //修改成绩
    @RequestMapping("/updateGrade")
    public boolean updateGrade(Grade grade){
        return gradeService.updateGrade(grade);
    }

    //删除成绩
    public boolean deleteGrade(Grade grade){
        return gradeService.deleteGrade(grade);
    }

    public void setStuService(StuService stuService) {
        this.stuService = stuService;
    }

    public void setGradeService(GradeService gradeService) {
        this.gradeService = gradeService;
    }


}
