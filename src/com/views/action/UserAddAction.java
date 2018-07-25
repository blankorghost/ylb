package com.views.action;


import com.opensymphony.xwork2.ActionSupport;
import com.views.entity.User;
import com.views.service.UserService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Namespace("/views")
public class UserAddAction extends ActionSupport{

    @Resource
    private UserService userService;
    public User user = new  User();

    public void setUser(User user) {
        this.user = user;
    }

    @Action(value = "user_add",results = {@Result(name = "register", location = "/views/login.jsp",type = "redirect")})
    public String add() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        if (userService.addUser(user)) {
            return "register";
        } else {
            return ERROR;
        }
    }

}
