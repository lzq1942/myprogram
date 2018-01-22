package com.myprogram.dao;

import com.myprogram.entity.Grade;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/1/19 0019.
 */
@Repository("gradeDao")
public class GradeDao extends BaseDao {
    //添加成绩
    public Boolean addGrade(Grade grade){
        try {
            getSession().save(grade);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    //查询成绩
    public List<Grade> findGradeList(String hql){
        try {
            return getSession().createQuery(hql).list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    //获取成绩id
    public Grade getGradeById(int gno){
        try {
            return getSession().get(Grade.class,gno);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //修改成绩
    public Boolean updateGrade(Grade grade){
        try {
            getSession().update(grade);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    //删除成绩
    public Boolean deleteGrade(Grade grade){
        try {
            getSession().delete(grade);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
