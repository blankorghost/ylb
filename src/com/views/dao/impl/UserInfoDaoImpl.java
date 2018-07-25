package com.views.dao.impl;

import com.views.dao.UserInfoDao;
import com.views.entity.Comment;
import com.views.entity.Essay;
import com.views.entity.Message;
import com.views.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/*失败则spring负责回滚操作，成功提交操作*/
@Transactional(rollbackFor = Exception.class)
@Repository("userinfoDao") //进行注入
public class UserInfoDaoImpl implements UserInfoDao {

    @Resource
    private SessionFactory sessionFactory;

    /**
     * 获取当前session
     * @return
     */
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    /**
     * 通过用id得到文章
     * @return
     */
    @Override
    public List<Essay> getUseressayByuserid(int id) {
        String hsql = "FROM Essay e where e.userId=:id";
        Query query = sessionFactory.getCurrentSession().createQuery(hsql);
        query.setParameter("id", id);
        System.out.println("wo "+id);
        return query.getResultList();

    }

    /**
     * 通过用户得到消息
     * @return
     */
    @Override
    public List<Message>getUsermessageByusername(String username) {
        String hsql = "from Message where username=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hsql);
        query.setParameter(0, username);
        return query.getResultList();
    }

    /**
     * 通过用户id得到评论
     * @return
     */
    @Override
    public List<Comment> getUsercommentByuserid(int id) {
        String hsql = "from Comment where userId=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hsql);
        query.setParameter(0, id);
        return query.getResultList();
    }

    /**
     * 通过用户id得到用户信息
     * @return
     */
    @Override
    public User showUserinfo(int id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);

    }

    /**
     * 用户修改信息
     * @param user
     */
    @Override
    public void updataUserinfo(User user){
       getSession().update(user);
    }
}
