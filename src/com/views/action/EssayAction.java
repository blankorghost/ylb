package com.views.action;

import com.views.entity.Essay;
import com.views.entity.User;
import com.views.service.EssayService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import sun.awt.AppContext;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/*把此Bean作为MVC中的一个C,数据封装成一个model*/
@Controller("essayAction")
@Scope("prototype")
@Namespace("/views")
public class EssayAction extends ActionSupport {
    @Resource
    public EssayService essayService;
    public Essay essay;
    public   String essayname;
    public   String text;
    public   int essayId;
    public String ename;
    public String etext;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEtext() {
        return etext;
    }

    public void setEtext(String etext) {
        this.etext = etext;
    }

    public int getEssayId() {
        return essayId;
    }
    public void setEssayId(int essayId) {
        this.essayId = essayId;
    }

    public String getEssayname() {
        return essayname;
    }

    public void setEssayname(String essayname) {
        this.essayname = essayname;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    //写入文章数据
    @Action(value = "w_writes",results = {@Result(name = "success", location = "/jump.jsp" ,type="redirect"),
            @Result(name = "error", location = "/error.jsp")})
    public String writes() {
            Essay essay = new Essay();
            Map sessions = ActionContext.getContext().getSession();
            User user = (User) sessions.get("user");

            essay.setUserId(user.getUserId());
            essay.setEssayname(ename);
            essay.setText(etext);
            essay.setTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));

            if(essayService.writes(essay)) {
                return SUCCESS;
            } else {
                return ERROR;
            }
        }

    /*查询文章*/
    @Action(value = "w_getEssayByEid",results = {@Result(name = "essaytxt", location = "/views/essay.jsp", type = "redirect")})
    public String getEssayByEid() {
        List<Essay> etxt = essayService.getEssayByEid(essayId);

        Map session = ActionContext.getContext().getSession();
        session.put("etxt",etxt);
        return "essaytxt";
    }
}

