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
public class UserNameCheckAction extends ActionSupport {

    @Resource
    private UserService userService;

    private  String username;
    private  int checkUserName;

    public void setUsername(String username) {
        this.username = username;
    }

@Action(value = "checkUserName",results = {@Result(name = "success",type = "json"), @Result(name = "error", type="json")})
    public String checkUserEmail() {
        User user = userService.getUserByName(username);
        if ("".equals(username)){
            checkUserName = 1;
            return ERROR;
        }else if(user == null){
            checkUserName = 2;
            return SUCCESS;
        }else {
            checkUserName = 3;
        }

        return ERROR;
    }

    public int getCheckUserName() {
        return checkUserName;
    }
}
