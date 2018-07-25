package com.views.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.views.entity.User;
import com.views.service.UserService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;


import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import static com.views.util.viewsUtils.messd;

@Scope("prototype")
@Namespace("/views")
public class UserAction extends ActionSupport {

    @Resource
    private UserService userService;
    public User user = new  User();

    public void setUser(User user) {
        this.user = user;
    }

    @Action(value = "user_login",results = {@Result(name = "success", location = "/index.jsp",type = "redirect"), @Result(name = "error", location = "/views/login.jsp",type = "redirect")})
    public String login() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        if (userService.login(user)) {
            Map session = ActionContext.getContext().getSession();
            List<User> cuser = userService.getUser(user.getEmail(), messd(user.getPassword()));
            for (User u : cuser) {
                session.put("user", u);
            }
            return SUCCESS;
        } else {
            return ERROR;
        }
    }




}
