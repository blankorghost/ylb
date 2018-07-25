package com.views.dao;


import com.views.entity.*;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：AdminUserDao
 * 类描述：用户控制dao实现数据库操作接口
 * 创建人：lp
 * 修改备注：
 * @version
 * */
public interface AdminUserDao {


    //添加管理员
    public void addAdmin(Admin admin);

    //显示所有管理员
    //
    public ArrayList<Admin> ShowallAdmin();

    //显示所有用户
    public ArrayList<User> getAll();

    //显示所有评论
    public ArrayList<Comment> getAllComments();

    //管理员修改信息
    //
    public void updataAdmin(Admin admin);

    /**
     * 通过用户id显示用户信息
     */
    public Admin getAdmininfo(int id);

    public boolean login(Admin admin);

    //写公告
    public void write(Notice notice);

}
