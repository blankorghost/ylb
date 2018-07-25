package com.views.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.views.entity.Comment;
import com.views.entity.Essay;
import com.views.entity.Notice;
import com.views.entity.User;
import com.views.service.CommentService;
import com.views.service.EssayService;
import com.views.service.NoticeService;
import com.views.service.UserInfoService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Scope("prototype")
@Namespace("/")
public class IndexAction extends ActionSupport{

    @Resource
    private EssayService essayService;
    @Resource
    private UserInfoService userInfoService;
    public   int essayId;
    private Notice notice = new Notice();
    @Resource
    private NoticeService noticeService;
    @Resource
    private CommentService commentService;
    private Comment comment = new Comment() ;



    public int getEssayId() {
        return essayId;
    }

    public void setEssayId(int essayId) {
        this.essayId = essayId;
    }


    /*遍历得到文章*/
    @Action(value = "w_getEassy",results = {@Result(name = "toindex", location = "/index.jsp", type = "redirect")})
    public String getEssay(){
        ArrayList<Essay> allEssay = essayService.getAllEssay();
        Map session = ActionContext.getContext().getSession();
        session.put("allEssay",allEssay);
        return "toindex";
    }
    /*查询文章*/
    @Action(value = "w_getEssayByid",results = {@Result(name = "essaytxt", location = "/views/essay.jsp", type = "redirect")})
    public String getEssayByid() {
        List<Essay> etxt = essayService.getEssayByEid(essayId);
        Map session = ActionContext.getContext().getSession();

        session.put("etxt",etxt);
        ArrayList<Comment> user_allComment = commentService.getCommentstoviews();
        Map sessionMap = ActionContext.getContext().getSession();
        sessionMap.put("user_allComment", user_allComment);
        return "essaytxt";
    }

    @Action(value="getNoticeAction",results={ @Result(name = "notice", location = "w_getEassy",type = "redirectAction")})
    public String showNotice(){
        String notice = noticeService.getNoticeById();
        Map sessionMap = ActionContext.getContext().getSession();
        sessionMap.put("notice", notice);
        return "notice";
    }
}
