package com.epmeeting.dao.impl;

import com.epmeeting.dao.ExpertFieldDao;
import com.epmeeting.module.EpmUser;
import com.epmeeting.module.ExpertField;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 张宏浩 on 2016/1/29.
 */
@Component("expertFieldDao")
public class ExpertFieldDaoImpl implements ExpertFieldDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int add(ExpertField expertField) {
        return (Integer)sessionFactory.openSession().save(expertField);
    }

    @Override
    public List<ExpertField> get(String expertId ) {
        Query query = sessionFactory.openSession().createQuery("from ExpertField as ef where ef.expertId=:expertId order by id desc").setString("expertId", expertId);
        return query.list();
    }

    @Override
    public List<ExpertField> list(int index, int limit) {
        Query query = sessionFactory.openSession().createQuery("from ExpertField order by id desc");
        query.setFirstResult((index-1)*limit).setMaxResults(limit);
        return query.list();
    }

    @Override
    public int delete(int id) {
        Query query = sessionFactory.openSession().createQuery("delete from ExpertField as ef where ef.id=:id").setInteger("id", id);
        return query.executeUpdate();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
