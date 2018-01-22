package com.myprogram.dao;

import com.myprogram.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hjk on 2017/11/8.
 */
@Repository("userDao")
public class UserDao extends BaseDao{

    //查询所有用户
    public List findUsersList(){
        return getSession().createQuery("from User").list();
    }

    //添加用户
    public boolean addUser(User user){
        try {
            getSession().save(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
