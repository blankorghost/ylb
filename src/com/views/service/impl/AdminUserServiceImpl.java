package com.views.service.impl;




import com.views.dao.AdminUserDao;
import com.views.entity.Admin;
import com.views.entity.Comment;
import com.views.entity.Notice;
import com.views.entity.User;
import com.views.service.AdminUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

//注入服务
@Service("adminUserService")
public class AdminUserServiceImpl implements AdminUserService {


    @Resource
    public AdminUserDao adminUserDao;

    @Override
    public void addadmin(Admin admin) {
        adminUserDao.addAdmin(admin);

    }

    @Override
    public ArrayList<User> getUsers() {
        return adminUserDao.getAll();
    }

    @Override
    public ArrayList<Comment> getComments(){return adminUserDao.getAllComments();}

    @Override
    public ArrayList<Admin> getAdmins() {
        return adminUserDao.ShowallAdmin();
    }

    @Override
    public Admin getAdmin(int id) {
        return adminUserDao.getAdmininfo(id);
    }

    @Override
    public void update(Admin admin) {
        adminUserDao.updataAdmin(admin);
    }

    @Override
    public boolean login(Admin admin){
        return this.adminUserDao.login(admin);
    }

    @Override
    public String getUnameById(int id) {
        return null;
    }

    @Override
    public boolean write(Notice notice) { this.adminUserDao.write(notice);return true; }

    /*根据ID得到用户名*/
//    public  String getUnameById(int id){
//        return  this.adminUserDao.getUnameById(id);
//    }
}
