package com.views.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.views.entity.*;
import com.views.service.*;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Namespace("/admin")
@ParentPackage("struts-default")
@Scope("prototype")
public class AdminAction extends ActionSupport {
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private EssayService essayService;
    @Resource
    private AdminUserService adminUserService;
    private Admin admin;
    private int adminId;
    private String adminName;
    private String password;
    @Resource
    private CommentService commentService;

    private Comment comment;

    private Notice notice = new Notice();
    private NoticeService noticeService;

    private String bbb;
    private int ccid;
    private   int essayId;

    public int getEssayId() {
        return essayId;
    }

    public void setEssayId(int essayId) {
        this.essayId = essayId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getName() {
        return adminName;
    }

    public void setName(String name) {
        this.adminName = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Notice getNotice() {
        return notice;
    }

    public void setNotice(Notice notice) {
        this.notice = notice;
    }

    public void setBbb(String bbb) {
        this.bbb = bbb;
    }

    public int getCcid() {
        return ccid;
    }

    public void setCcid(int ccid) {
        this.ccid = ccid;
    }

    /**
     * 用户列表
     *
     * @return
     */

    /*遍历得到用户*/
    @Action(value = "admin_getAll", results = {@Result(name = "getAll", location = "/admin/userinfo.jsp", type = "redirect")})
    public String getAll() {
        ArrayList<User> allUser = adminUserService.getUsers();
        Map session = ActionContext.getContext().getSession();
        session.put("allUser", allUser);
        return "getAll";
    }

    /*遍历得到评论*/
    @Action(value = "selectCommentAction", results = {@Result(name = "selectComment", location = "/admin/comment.jsp", type = "redirect")})
    public String getAllComments() {
        ArrayList<Comment> allComment = adminUserService.getComments();
        Map sessionMap = ActionContext.getContext().getSession();
        sessionMap.put("allComment", allComment);
        return "selectComment";
    }


    /**
     * 添加管理员
     */
    @Action(value = "admin_addAdmin", results = {@Result(name = "addAdmin", location = "admin_getAllAdmin", type = "redirectAction")})
    public String addAdmin() {
        adminUserService.addadmin(admin);
        return "addAdmin";
    }

    /**
     * 管理员列表
     *
     * @return
     */
     /*遍历得到用户*/
    @Action(value = "admin_getAllAdmin", results = {@Result(name = "getAllAdmin", location = "/admin/admininfo.jsp", type = "redirect")})
    public String getAllAdmin() {
        ArrayList<Admin> allAdmin = adminUserService.getAdmins();
        Map session = ActionContext.getContext().getSession();
        session.put("allAdmin", allAdmin);
        return "getAllAdmin";
    }

    @Action(value = "admin_login", results = {@Result(name = "success", location = "/admin/adminindex.jsp", type = "redirect"),@Result(name = "error", location = "/admin/login.jsp",type = "redirect")})
    public String login() {
        if (adminUserService.login(admin)) {
            Map session = ActionContext.getContext().getSession();
            //session.get("");
            session.put("admin", admin);
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    /**
     * 修改管理员的信息
     *
     * @return
     */
    public void updatainfo(Admin admin) {

        //1.从数据库中获取原对象
        admin = adminUserService.getAdmin(adminId);

        //2.设置要修改的属性
        admin.setAdminName(adminName);
        admin.setPassword(password);

        //3.更新到数据库
        adminUserService.update(admin);
    }

    //编写公告
    @Action(value = "writeNoticeAction", results = {@Result(name = "writeComment", location = "/admin/notice.jsp")})
    public String write() {
        Map session = ActionContext.getContext().getSession();
        notice.setNcontent(bbb);


        adminUserService.write(notice);


        return "writeComment";

    }

    //删除评论
    @Action(value = "delCommentAction", results = {@Result(name = "delComment", location = "selectCommentAction", type = "redirectAction")})
    public String del() {
        commentService.del(ccid);
        return "delComment";
    }

    /*遍历得到文章*/
    @Action(value = "w_getAll", results = {@Result(name = "getAllEssay", location = "/admin/all-essay.jsp", type = "redirect")})
    public String getAllEssay() {
        User uuser;
        ArrayList<Essay> allEssay = essayService.getAllEssay();
        uuser = userInfoService.getUserByuserid(allEssay.get(0).getUserId());
        Map session = ActionContext.getContext().getSession();
        session.put("allEssay", allEssay);
        session.put("uuser",uuser);

        return "getAllEssay";

    }
    /*删除文章*/
    @Action(value = "w_dele",results = {@Result(name = "deleok", location = "w_getAll", type = "redirectAction")})
    public String dele(){
        essayService.deleessay(essayId);
        return  "deleok";
    }

    /*看文章*/
    @Action(value = "w_getEssay",results = {@Result(name = "essaytxt", location = "/admin/blankessay.jsp", type = "redirect")})
    public String getEssay() {
        List<Essay> etxt = essayService.getEssayByEid(essayId);
        Map session = ActionContext.getContext().getSession();
        session.put("etxt",etxt);
        return "essaytxt";
    }
}
