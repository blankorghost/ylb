package com.views.dao.impl;

import com.views.dao.UserDao;
import com.views.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import static com.views.util.viewsUtils.messd;

@Transactional(rollbackFor = Exception.class)
@Repository("userDao") //进行注入
public class UserDaoImpl implements UserDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        try {
            String encodeStr = messd(user.getPassword());
            user.setPassword(encodeStr);
            user.setUserPhoto("user_photo.jpg");
            user.setRegistTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
            sessionFactory.getCurrentSession().save(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean login(User user) {
        try {
            String encodeStr = messd(user.getPassword());
            System.out.println(encodeStr);
            Iterator<User> it;
            String hsql = "FROM User where email=? and password=?";
//            System.out.println(hsql);
            Query query = sessionFactory.getCurrentSession().createQuery(hsql);
            query.setParameter(0, user.getEmail());
            query.setParameter(1, encodeStr);
            System.out.println("1");
            System.out.println(user.getEmail());
            System.out.println("1");
            it = query.iterate();
            if (it.hasNext()) {
                System.out.println("true");
                return true;
            } else {
                System.out.println("false");
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List getUser() {
        return sessionFactory.getCurrentSession().createQuery("FROM User").getResultList();
    }

    @Override
    public User getUser(int id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public List<User> getUser(String email, String password) {
        Query q = sessionFactory.getCurrentSession().createQuery("FROM User u where u.email = ? and u.password = ?");
        q.setParameter(0, email);
        q.setParameter(1, password);
        q.setMaxResults(1);

        return q.getResultList();
    }

    @Override
    public User getUserByName(String name) {
        System.out.println(name);
        Query q = sessionFactory.getCurrentSession().createQuery("FROM User u where u.username = ?");
        q.setParameter(0,name);
        List<User> list = q.list();
        if (list.size() > 0){
            return  list.get(0);
        }

        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        Query q = sessionFactory.getCurrentSession().createQuery("FROM User u where u.email = ?");
        q.setParameter(0,email);
        System.out.println(email);
        List<User> list = q.list();
        if (list.size() > 0){
            return  list.get(0);
        }

        return null;
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession().delete(
                sessionFactory.getCurrentSession().get(User.class, id)
        );
    }
}
