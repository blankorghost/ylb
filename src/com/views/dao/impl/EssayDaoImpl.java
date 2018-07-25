package com.views.dao.impl;

import com.opensymphony.xwork2.ActionContext;
import com.views.dao.EssayDao;
import com.views.entity.Essay;
import com.views.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/*失败则spring负责回滚操作，成功提交操作*/
@Transactional(rollbackFor = Exception.class)
@Repository("essayDao") //进行注入
public class EssayDaoImpl implements EssayDao{
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /*写入文章*/
    public void writes(Essay essay){
        sessionFactory.getCurrentSession().save(essay);
    }

    /*删除文章*/
    public void deleess(int eid){
        sessionFactory.getCurrentSession().delete(
                sessionFactory.getCurrentSession().get(Essay.class, eid));
    }

    /*得到所有文章*/
    public ArrayList<Essay> getAll(){
        Session session = sessionFactory.getCurrentSession();
        Query que = session.createQuery("from Essay");
        List<Essay> allEssay = que.getResultList();
        ArrayList<Essay> essayList = (ArrayList<Essay>)allEssay;
        return  essayList;
    }
    /*通过文章名查询文章*/
    public List<Essay> getEssayByEid(int eid)
    {
        System.out.println(eid);
        String hql = "from Essay where essayId= :eid";
        Session session = sessionFactory.getCurrentSession();
        Query que = session.createQuery(hql);
        que.setParameter("eid",eid);

        System.out.println(que.getResultList());

        return que.getResultList();
    }
}
