package com.epmeeting.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;

/**
 * Created by chqi on 2016/1/26.
 */
public class BaseDao {
    @Resource
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;//返回session工厂
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public Session getSession(){
        Session session=sessionFactory.getCurrentSession();
        return session;
    }
}
