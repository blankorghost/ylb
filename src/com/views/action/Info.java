package com.views.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.views.entity.Essay;
import com.views.service.UserInfoService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Namespace("/")
@ParentPackage("struts-default")
@Scope("prototype")
public class Info extends ActionSupport{

    @Resource
    private UserInfoService userInfoService;

    private Map<String, Object> session = ActionContext.getContext().getSession();
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //我的文章列表

    @Action(value = "userinfo_getEssay",results = {@Result(name = "essay",location = "/views/user.jsp",type = "redirect")})
    public String getEssay(){
        List<Essay> essayList = userInfoService.getEssayByuserid(id);
        session.put("essayList",essayList);
        return "essay";
    }
}
