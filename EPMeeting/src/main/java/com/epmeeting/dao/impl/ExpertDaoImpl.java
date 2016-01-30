package com.epmeeting.dao.impl;

import com.epmeeting.dao.ExpertDao;
import com.epmeeting.module.EpmExpert;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 张宏浩 on 2016/1/29.
 */
@Component("expertDao")
public class ExpertDaoImpl implements ExpertDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int add(EpmExpert expert) {return (Integer)sessionFactory.openSession().save(expert);}

    @Override
    public List<EpmExpert> get(String expertname) {
        Query query = sessionFactory.openSession().createQuery("from EpmExpert as e where e.expertName=:expertname order by id desc").setString("expertname", expertname);
        return query.list();
    }

    @Override
    public List<EpmExpert> list(int index, int limit) {
        Query query = sessionFactory.openSession().createQuery("from EpmExpert order by id desc");
        query.setFirstResult((index-1)*limit).setMaxResults(limit);
        return query.list();
    }

    @Override
    public int delete(int id) {
        Query query = sessionFactory.openSession().createQuery("delete from EpmExpert as e where e.id=:id").setInteger("id", id);
        return query.executeUpdate();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}



