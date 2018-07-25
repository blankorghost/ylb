package com.views.dao.impl;
import com.views.dao.NoticeDao;
import com.views.entity.Notice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

/**
 * Created by user on 2018/1/3.
 */
@Transactional(rollbackFor = Exception.class)
@Repository("NoticeDao")
public class NoticeDaoImpl implements NoticeDao{
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;


    /*public void write(Notice notice){
        notice.setNtime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        sessionFactory.getCurrentSession().save(notice);
    }*/

    @Override
    public String getInfo() {
        String info;
        Query q = sessionFactory.getCurrentSession().createQuery("from Notice n order by n.nid desc");
        List<Notice> notice = q.list();
        info = notice.get(0).getNcontent();

        return info;
    }
}
