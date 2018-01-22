package com.myprogram.dao;

import com.myprogram.entity.Stu;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@Transactional
@Repository("stuDao")
public class StuDao extends BaseDao {
    //添加学生
    public Boolean addStu(Stu stu){
        try {
            getSession().save(stu);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    //查询学生
    public List<Stu> findStuList(String hql){
        try {
            return getSession().createQuery(hql).list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    //获取学生id
    public Stu getStuById(int sno){
        try {
            return getSession().get(Stu.class,sno);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //修改学生
    public Boolean updateStu(Stu stu){
        try {
            getSession().update(stu);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    //删除学生
    public Boolean deleteStu(Stu stu){
        try {
            getSession().delete(stu);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
