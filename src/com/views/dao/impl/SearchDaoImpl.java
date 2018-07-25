package com.views.dao.impl;

import com.views.dao.SearchDao;
import com.views.entity.Essay;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Repository("searchDao") //进行注入
public class SearchDaoImpl implements SearchDao {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;


    @Override
    public List<Essay> search(String keyword) {
        try {
            String hsql = "FROM Essay where essayname like :key";
            Query query = sessionFactory.getCurrentSession().createQuery(hsql);
            query.setParameter("key", "%" + keyword + "%");

//            SQLQuery sql = sessionFactory.createSQLQuery("select * from user").addEntity(Essay.class);
//            List list2 = sql.list();

            return query.getResultList();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
