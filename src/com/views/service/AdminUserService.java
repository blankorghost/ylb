package com.views.service;


import com.views.entity.Admin;
import com.views.entity.Comment;
import com.views.entity.Notice;
import com.views.entity.User;

import java.util.ArrayList;
import java.util.List;

public interface AdminUserService {


    /**
     * 添加用户
     * @param admin
     * @return boolean
     * @
     * */
    public void addadmin(Admin admin) ;

    /**
     * 查询所有用户
     * @param
     * @
     * */
    ArrayList<User> getUsers();
    /**
     * 查询所有评论
     * @param
     * @
     * */
    ArrayList<Comment> getComments();
    /**
     * 查询所有管理员
     * @param
     * @
     * */
    public ArrayList<Admin> getAdmins() ;

    /**
     * 通过id得到管理员信息
     */
    public Admin getAdmin(int id);

    /**
     * 修改用户
     * @return
     * @
     * */
    public void update(Admin admin) ;

    public boolean login(Admin admin);

    /*根据ID得到用户名*/
    public  String getUnameById(int id);

    //写公告
    public boolean write(Notice notice);
}
