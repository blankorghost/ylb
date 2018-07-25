package com.views.dao.impl;


import com.views.dao.AdminUserDao;
import com.views.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import static com.views.util.viewsUtils.messd;


/*失败则spring负责回滚操作，成功提交操作*/
@Transactional(rollbackFor = Exception.class)
@Repository("adminUserDao") //进行注入
public class AdminUserDaoImpl implements AdminUserDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * 获取当前session
     * @return
     */
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }


    @Override
    public void addAdmin(Admin admin) {
        getSession().save(admin);
    }

    @Override
    public ArrayList<Admin> ShowallAdmin() {
        Session session = sessionFactory.getCurrentSession();
        Query que = session.createQuery("from Admin");
        List<Admin> allAdmin = que.getResultList();
        ArrayList<Admin> adminList = (ArrayList<Admin>)allAdmin;
        return  adminList;
    }

    @Override
    /*得到所有用户*/
    public ArrayList<User> getAll(){
        Session session = sessionFactory.getCurrentSession();
        Query que = session.createQuery("from User");
        List<User> allUser = que.getResultList();
        ArrayList<User> userList = (ArrayList<User>)allUser;
        return  userList;
    }

    @Override
    /*得到所有评论*/
    public ArrayList<Comment> getAllComments(){
        Session session = sessionFactory.getCurrentSession();
        Query que = session.createQuery("from Comment ");
        List<Comment> allComment = que.getResultList();
        ArrayList<Comment> commentList = (ArrayList<Comment>)allComment;
        return  commentList;
    }

    @Override
    public void updataAdmin(Admin admin) {
        getSession().update(admin);
    }

    @Override
    public Admin getAdmininfo(int id) {
        return (Admin) getSession().createQuery("FROM Admin where adminId=id").list();
    }

    @Override
    public boolean login(Admin admin){
        try {
            String encodeStr = messd(admin.getPassword());
            Iterator<User> it;
            String hsql = "FROM Admin where adminName=? and password=?";
//            System.out.println(hsql);
            System.out.println();
            Query query = sessionFactory.getCurrentSession().createQuery(hsql);
            query.setParameter(0, admin.getAdminName());
            query.setParameter(1, admin.getPassword());
            it = query.iterate();
            if (it.hasNext()) {
//                System.out.println("true");
                return true;
            } else {
//                System.out.println("false");
                return false;
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /*根据ID得到用户名*/
    public  String getUnameById(int id){
        String uname;
        String hql = "from User where id = :id";
        Session session = sessionFactory.getCurrentSession();
        Query que = session.createQuery(hql);
        User user = (User) que;
        uname = user.getUsername();
        return uname;
    }

    //编写公告
    public void write(Notice notice){
        notice.setNtime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        sessionFactory.getCurrentSession().save(notice);
    }
}
