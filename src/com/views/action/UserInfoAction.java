package com.views.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.views.entity.Comment;
import com.views.entity.Essay;
import com.views.entity.Message;
import com.views.entity.User;
import com.views.service.UserInfoService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import static com.views.util.viewsUtils.messd;

@Namespace("/views")
@ParentPackage("struts-default")
@Scope("prototype")
public class UserInfoAction extends ActionSupport{

    @Resource
    private UserInfoService userInfoService;

    private Map<String, Object> session = ActionContext.getContext().getSession();



    private int id;
    private String username;
    User user = new User();
    private String password;
    private String email;



    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }





    //我的评论列表
    @Action(value = "userinfo_getComment",results = {@Result(name = "comment",location = "/views/othercom.jsp",type = "redirect")})
    public String getComment(){
        List<Comment> commentList = userInfoService.getCommentByuserid(id);
        session.put("commentList",commentList);
        return "comment";
    }

    //我的消息列表

//    @Action(value = "userinfo_getMessage",results = {@Result(name = "message",location = "/views/email.jsp",type = "redirect")})
//    public String getMessage(){
//        List<Message> messageList = userInfoService.getMessageByusername(username);
//        session.put("messageList",messageList);
//        System.out.println("用户"+username);
//        return "message";
//    }
    //我的信息
    @Action(value = "userinfo_getMyinfo",results = {@Result(name = "info",location = "/views/myinfo.jsp",type = "redirect")})
    public String getMyinfo(){
        User userinfo = userInfoService.getUserByuserid(id);
        session.put("userinfo",userinfo);
        return "info";
    }
    //其他用户的信息
    @Action(value = "otheruser",results = {@Result(name = "other",location = "/views/otheruser.jsp",type = "redirect")})
    public String getOtherinfo(){
        User otheruser = userInfoService.getUserByuserid(id);
        session.put("otheruser",otheruser);
        List<Essay> oessayList = userInfoService.getEssayByuserid(id);
        session.put("oessayList",oessayList);
        System.out.println("wod wenz"+oessayList);
        return "other";
    }

    //修改我的信息
    @Action(value = "userinfo_updata",results = {@Result(name = "success",location = "userinfo_getMyinfo",type = "redirectAction")})
    public String  updatainfo() throws UnsupportedEncodingException, NoSuchAlgorithmException {

        user.setUserId(id);
        user.setUsername(username);
        user.setPassword(messd(password));
        user.setEmail(email);
        userInfoService.updatauserinfo(user);
        return SUCCESS;
    }


}
