package com.views.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.views.entity.Comment;
import com.views.entity.Essay;
import com.views.entity.User;
import com.views.service.CommentService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;

import javax.annotation.Resource;
import javax.enterprise.inject.New;
import java.util.ArrayList;
import java.util.Map;


/**
 * Created by user on 2018/1/3.
 */
@Scope("prototype")
@Namespace("/views")
public class CommentAction extends ActionSupport {
    @Resource
    private CommentService commentService;
    private Comment comment = new Comment() ;
    private String aaa;
    private int ccid;

    public void setAaa(String aaa) {
        this.aaa = aaa;
    }

  /*  public int getCcid() {
        return ccid;
    }

    public void setCcid(int ccid) {
        this.ccid = ccid;
    }*/

    /*@Action(value = "delCommentAction", results = {@Result(name = "delComment", location = "/admin/comment.jsp",type = "redirect")})
    public String del() {
        commentService.del(ccid);
        return "delComment";
    }*/

    @Action(value = "addCommentAction", results = {@Result(name = "addComment", location = "/views/essay.jsp",type = "redirect")})
    public String addComment() {
        Map session = ActionContext.getContext().getSession();
        String essayname = "我暧昧成瘾，可非你不行";
        User user = (User) session.get("user");
        /*Essay essay = (Essay) session.get("etxt") ;

        comment.setCessay(essay.getEssayname());
        comment.setCessay_id();*/

        comment.setUserId(user.getUserId());
        comment.setUsername(user.getUsername());
        comment.setCessay(essayname);
        comment.setCcontent(aaa);
        System.out.println("######################"+aaa);

        commentService.addComment(comment);
        return "addComment";
    }

    @Action(value = "user_selectCommentAction", results = {@Result(name = "user_selectComment", location = "/views/essay.jsp",type = "redirect")})
    public String getAllCommentstoviews() {
        ArrayList<Comment> user_allComment = commentService.getCommentstoviews();
        Map sessionMap = ActionContext.getContext().getSession();
        sessionMap.put("user_allComment", user_allComment);
        return "user_selectComment";
    }
}