package com.views.action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.views.entity.Notice;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import com.views.service.NoticeService;
import org.springframework.context.annotation.Scope;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by user on 2018/1/3.
 */
@Scope("prototype")
@Namespace("/views")
public class WriteNoticeAction extends ActionSupport {
    @Resource
    private Notice notice = new Notice();
    private NoticeService noticeService;
    private String bbb;

    public void setBbb(String bbb) { this.bbb = bbb; }

    public Notice getNotice() {
        return notice;
    }

    public void setNotice(Notice notice) {
        this.notice = notice;
    }
    /*@Action(value="writeNoticeAction",results={ @Result(name = "writeComment", location = "/views/essay.jsp")})
    public String write() {
        Map session = ActionContext.getContext().getSession();
        notice.setNcontent(bbb);

        noticeService.write(notice);


        return "writeComment";

    }*/

    @Action(value="getNoticeAction",results={ @Result(name = "getNotice", location = "/index.jsp")})
    public String showNotice(){
        String notice = noticeService.getNoticeById();
        Map sessionMap = ActionContext.getContext().getSession();
        sessionMap.put("notice", notice);
        return notice;
    }

}
