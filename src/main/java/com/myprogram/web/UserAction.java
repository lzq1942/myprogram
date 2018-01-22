package com.myprogram.web;

import com.myprogram.entity.User;
import com.myprogram.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by hjk on 2017/11/8.
 */
@Controller
@RequestMapping("/userAction")
public class UserAction {

    @Resource(name = "userService")
    private UserService userService;

    //登录
    @RequestMapping("/doLogin")
    @ResponseBody
    public User doLogin(User user, HttpSession session, RedirectAttributes attr) { //用户登录
        if (user!= null) {
            user = userService.doLogin(user);
            if (user != null) {
                session.setAttribute("loginUser", user);
                return user;
            } else {
                attr.addAttribute("rtype", "-1");
            }
        }
        return user;
    }

    //注册
    @RequestMapping("/RegisterUser")
    public String  RegisterUser(User user, RedirectAttributes attr){
        if (userService.addUser(user)){
            attr.addAttribute("rtype","1");
            return "redirect:/index.jsp";
        }else {
            attr.addAttribute("rtype","-1");
            return "redirect:/pages/register.jsp";
        }
    }
}
