package com.myprogram.service;

import com.myprogram.dao.ClsDao;
import com.myprogram.entity.Cls;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("clsService")
public class ClsService {

    @Resource(name = "clsDao")
    private ClsDao clsDao;

    /**
     * 添加班级
     *
     * @param cls 班级对象
     * @return true or false
     */
    public boolean addCls(Cls cls) {
        return clsDao.addCls(cls);
    }

    /**
     * 修改班级
     *
     * @param cls 班级对象
     * @return true or false
     */
    public boolean updateCls(Cls cls) {
        return clsDao.updateCls(cls);
    }

    /**
     * 删除班级
     *
     * @param cls 班级对象
     * @return true or false
     */
    public boolean deleteCls(Cls cls) {
        return clsDao.deleteCls(cls);
    }

    /**
     * 查询班级信息
     *
     * @return 班级信息集合
     */
    public List findClsList() {
        String hql = "from Cls c order by c.cname";
        return clsDao.findClsList(hql);
    }


    /**
     * 班级详细信息
     *
     * @return 班级详细信息集合
     */
    public List findClsInfo(){
        String hql = "select c.cno,c.cname,count(s.sno) from Cls c left join Stu s on c.cno = s.cls.cno group by c.cno,c.cname order by c.cname";
        return clsDao.findClsList(hql);
    }

    /**
     * 通过id获取班级信息
     *
     * @return 班级对象
     * @param cno
     */
    public Cls getClsById(int cno) {
        return clsDao.getClsById(cno);
    }

    public void setClsDao(ClsDao clsDao) {
        this.clsDao = clsDao;
    }
}
