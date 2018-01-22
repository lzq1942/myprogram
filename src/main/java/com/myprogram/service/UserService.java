package com.myprogram.service;

import com.myprogram.dao.UserDao;
import com.myprogram.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hjk on 2017/11/8.
 */
@Service("userService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserService {

    @Resource(name = "userDao")
    private UserDao userDao;

    //登录
    public User doLogin(User users) {
        String hql = "from User u where u.uname='" + users.getUname() + "'";
        List<User> list = userDao.findUsersList(); //取出同名的所有 用户
        if (list != null && list.size() > 0) {
            for (User user : list) {
                if (user.getUname().equals(users.getUname()) && user.getUpwd().equals(users.getUpwd())) {
                    return user;
                }
            }
        }
        return null;
    }

    //添加用户
    public boolean addUser(User user){
        return userDao.addUser(user);
    }
}
