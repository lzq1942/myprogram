package com.myprogram.service;

import com.myprogram.dao.StuDao;
import com.myprogram.entity.Cls;
import com.myprogram.entity.Stu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@Service("stuService")
public class StuService {

    @Resource(name = "stuDao")
    private StuDao stuDao;

    //添加学生
    public boolean addStu(Stu stu){
        return stuDao.addStu(stu);
    }

    //查询学生
    public List findStuList(){
        String hql = "from Stu s left join s.cls c order by c.cname";
        return stuDao.findStuList(hql);
    }

    /**
     * 根据班级查询学生
     * @param cls
     * @return
     */
    public List findStuList(Cls cls) {
        String hql = "from Stu s where s.cls.cno="+cls.getCno();
        return stuDao.findStuList(hql);
    }

    //获取学生id
    public Stu getStuById(int sno){
        return stuDao.getStuById(sno);
    }

    //修改学生
    public Boolean updateStu(Stu stu){
        return stuDao.updateStu(stu);
    }

    //删除学生
    public boolean deleteStu(Stu stu){
        return stuDao.deleteStu(stu);
    }

    public void setStuDao(StuDao stuDao) {
        this.stuDao = stuDao;
    }
}

