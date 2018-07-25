package com.views.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.views.entity.Comment;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.views.dao.CommentDao;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Calendar;
@Transactional(rollbackFor = Exception.class)
@Repository("CommentDao")
public class CommentDaoImpl implements CommentDao{
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;


    public void addComment(Comment comment) {
      /*  Session session = this.getSession(true);
        Transaction tc = (Transaction) session.beginTransaction();
        session.save(comment);
        try {
            tc.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        session.close();*/

        comment.setCdate(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        sessionFactory.getCurrentSession().save(comment);
    }


    public void delComment(int cid){
       /* Session session = this.getSession(true);
        Transaction tc = (Transaction) session.beginTransaction();
        Comment c = new Comment(cid);
        session.delete(c);
        try {
            tc.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();*/

        sessionFactory.getCurrentSession().delete(
                sessionFactory.getCurrentSession().get(Comment.class, cid));
    }

    public ArrayList<Comment> getAllCommentstoviews(){


        Session session = sessionFactory.getCurrentSession();
        Query que = session.createQuery("from Comment");

        List<Comment> user_allComment= que.list();

        ArrayList<Comment> user_commentList = (ArrayList<Comment>)user_allComment;

        return  user_commentList;
    }

    //通过文章id获取评论
    @Override
    public List<Comment> getCommentByEid(int ceid) {
        String hql = "from Comment where cessay_id= :ceid";
        Session session = sessionFactory.getCurrentSession();
        Query que = session.createQuery(hql);
        que.setParameter("ceid",ceid);
        return que.getResultList();
    }
}