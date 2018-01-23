package com.myprogram.service;

import com.myprogram.dao.GradeDao;
import com.myprogram.entity.Grade;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/1/19 0019.
 */
@Service("gradeService")
public class GradeService {
    @Resource(name="gradeDao")
    private GradeDao gradeDao;

    //添加成绩
    public Boolean addGrade(Grade grade){
        return gradeDao.addGrade(grade);
    }

    //查询成绩
    public List findGradeList(){
        String hql = "from Grade g left join g.stu s order by s.sname";
        return gradeDao.findGradeList(hql);
    }



    //获取成绩id
    public Grade getGradeById(int gno){
        return gradeDao.getGradeById(gno);
    }

    //修改成绩
    public boolean updateGrade(Grade grade){
        return gradeDao.updateGrade(grade);
    }

    //删除成绩
    public boolean deleteGrade(Grade grade){
        return gradeDao.deleteGrade(grade);
    }


    public void setGradeDao(GradeDao gradeDao) {
        this.gradeDao = gradeDao;
    }
}
