package com.views.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import org.springframework.context.annotation.Scope;

@Namespace("/views")
@ParentPackage("struts-default")
@Scope("prototype")
public class LogoutAction extends ActionSupport{


    @Action(value = "logout",results = {@Result(name = "logout",location = "/index.jsp",type = "redirect")})
    public String logout(){
        ActionContext.getContext().getSession().remove("user");
        ActionContext.getContext().getSession().remove("userinfo");
        return "logout";
    }
}
