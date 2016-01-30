package com.epmeeting.dao.impl;

import com.epmeeting.dao.LogDao;
import com.epmeeting.module.EpmLog;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2016/1/29.
 */
@Component("logDao")
public class LogDaoImpl implements LogDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int add(EpmLog log) {
        return (Integer)sessionFactory.openSession().save(log);
    }

    @Override
    public List<EpmLog> get(String logType) {
        Query query = sessionFactory.openSession().createQuery("from EpmLog as el where el.logType=:logType order by id desc").setString("logType", logType);
        return query.list();
    }

    @Override
    public List<EpmLog> list(int index, int limit) {
        Query query = sessionFactory.openSession().createQuery("from EpmLog order by id desc");
        query.setFirstResult((index-1)*limit).setMaxResults(limit);
        return query.list();
    }

    @Override
    public int delete(int id) {
        Query query = sessionFactory.openSession().createQuery("delete from EpmLog as el where el.id=:id").setInteger("id", id);
        return query.executeUpdate();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
