package com.myprogram.web;

import com.myprogram.entity.Stu;
import com.myprogram.service.ClsService;
import com.myprogram.service.StuService;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by hjk on 2017/12/24.
 */
@Controller
@RequestMapping("/stuAction")
public class StuAction {
    @Resource(name="stuService")
    private StuService stuService;

    @Resource(name="clsService")
    private ClsService clsService;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");


    /**
     * 查询班级信息
     *
     * @param message  添加的消息
     * @param modelMap 将班级信息和添加消息带到前台
     * @return 前台页面
     */
    @RequestMapping("/findClsList")
    public String findClsList(@ModelAttribute(name = "addMessage") String message, ModelMap modelMap) {
        modelMap.addAttribute("clsList", clsService.findClsList());
        if (message != null) {
            modelMap.addAttribute("addMessage", message);
        }
        return "pages/AddStu";
    }

    //添加学生
    @RequestMapping("/addStu")
    public String addStu(MultipartFile sfile, Stu stu, Model model, HttpSession session){
        //上传文件
        if(!sfile.isEmpty()){
            //获取服务器路径
            String basePath=session.getServletContext().getRealPath("/images");
            String realName=sfile.getOriginalFilename();//真实上传的文件名
            System.out.println("要上传的文件名是:"+realName);
            //执行上传操作
            try {
                sfile.transferTo(new File(basePath+"/"+realName));
                System.out.println("上传路径:"+basePath+"/"+realName);
                stu.setSimage(realName);
                model.addAttribute("fileName",realName);
                if (stuService.addStu(stu)){
                    model.addAttribute("stype","1");
                }else{
                    model.addAttribute("stype","2");
                }
            } catch (IOException e) {
                e.printStackTrace();
                return "error";
            }
        }
        return "redirect:/pages/AddStu.jsp";
    }


    //文件下载
    @RequestMapping("/downloadFile")
    public ResponseEntity<byte[]> downloadFile(String fileName, HttpSession session) throws Exception {
        if(fileName!=null){
            //获取要下载的文件路径
            String basePath=session.getServletContext().getRealPath("/images");
            String filePath=basePath+"/"+fileName;
            File outFile=new File(filePath);
            if(outFile.exists()){//要下载的文件是存在的
                HttpHeaders headers=new HttpHeaders();//构建一个头文件对象
                //设置文件以下载方式打开
                headers.setContentDispositionFormData("attachment", new String(fileName.getBytes("UTF-8"),"iso-8859-1"));
                //设置文件类型
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(filePath)),headers, HttpStatus.OK);
            }
        }
        return null;
    }

    //查询学生
    @RequestMapping("/findStuList")
    @ResponseBody
    public List findStuList(){
        return stuService.findStuList();
    }

    //根据学生id查询学生，跳转到修改学生页面
    @RequestMapping("/getStuById/{sno}")
    public String getClsById(@PathVariable(name="sno") int sno, ModelMap modelMap){
        modelMap.addAttribute("stu",stuService.getStuById(sno));
        modelMap.addAttribute("clsList", clsService.findClsList());
        return "pages/updateStu";
    }

    //修改学生
    @RequestMapping("/updateStu")
    @ResponseBody
    public Boolean updateStu( Stu stu) {
        return stuService.updateStu(stu);
    }

    //删除学生
    @RequestMapping("/deleteStu")
    @ResponseBody
    public boolean deleteStu(Stu stu){
        return stuService.deleteStu(stu);
    }



    public void setClsService(ClsService clsService) {
        this.clsService = clsService;
    }

    public void setStuService(StuService stuService) {
        this.stuService = stuService;
    }
}
