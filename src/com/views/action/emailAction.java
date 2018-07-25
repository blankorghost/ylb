package com.views.action;

import com.opensymphony.xwork2.ActionSupport;
import com.views.entity.User;
import com.views.service.UserService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import javax.annotation.Resource;


@Namespace("/")
@ParentPackage("json-default")
public class emailAction extends ActionSupport {

    @Resource
    private UserService userService;

    private  String email;
    private  int emailFlag;

    public void setEmail(String email) {
        this.email = email;
    }

@Action(value = "checkUserEmail",results = {@Result(name = "success",type = "json"), @Result(name = "error", type="json")})
    public String checkUserEmail() {
        User user = userService.getUserByEmail(email);
        if ("".equals(email)){
            emailFlag = 1;
            return ERROR;
        }else if(user == null){
            emailFlag = 2;
            return SUCCESS;
        }else {
            emailFlag = 3;
        }

        return ERROR;
    }

    public int getEmailFlag() {
        return emailFlag;
    }
}
