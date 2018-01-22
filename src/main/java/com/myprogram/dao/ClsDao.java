package com.myprogram.dao;

import com.myprogram.entity.Cls;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@SuppressWarnings("ALL")
@Repository("clsDao")
@Transactional
public class ClsDao extends BaseDao{
    //添加班级
    public boolean addCls(Cls cls){
        try {
            getSession().save(cls);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }




    /**
     * 修改对象的方法
     *
     * @param obj 对象
     * @return true or false
     */
    public boolean updateCls(Cls cls) {
        try {
            getSession().update(cls);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除对象的方法
     *
     * @param obj 对象
     * @return true or false
     */
    public boolean deleteCls(Cls cls) {
        try {
            getSession().delete(cls);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 查询对象
     *
     * @param hql 查询语句
     * @return 对象集合
     */
    public List<Cls> findClsList(String hql) {
        try {
            return getSession().createQuery(hql).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过对象id获取对象
     *
     * @param cls 对象的原型
     * @param id  对象id
     * @return 对象
     */
    public Cls getClsById(int cno) {
        try {

            return getSession().get(Cls.class, cno);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
