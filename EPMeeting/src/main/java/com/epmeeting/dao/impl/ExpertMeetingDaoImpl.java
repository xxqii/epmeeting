package com.epmeeting.dao.impl;

import com.epmeeting.dao.ExpertMeetingDao;
import com.epmeeting.module.ExpertMeeting;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 张宏浩 on 2016/1/29.
 */
@Component("expertMeetingDao")
public class ExpertMeetingDaoImpl implements ExpertMeetingDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int add(ExpertMeeting expertMeeting) {
        return (Integer)sessionFactory.openSession().save(expertMeeting);
    }

    @Override
    public List<ExpertMeeting> get(String expertId) {
        Query query = sessionFactory.openSession().createQuery("from ExpertMeeting as em where em.expertId=:expertId order by id desc").setString("expertId", expertId);
        return query.list();
    }

    @Override
    public List<ExpertMeeting> list(int index, int limit) {
        Query query = sessionFactory.openSession().createQuery("from ExpertMeeting order by id desc");
        query.setFirstResult((index-1)*limit).setMaxResults(limit);
        return query.list();
    }

    @Override
    public int delete(int id) {
        Query query = sessionFactory.openSession().createQuery("delete from ExpertMeeting as em where em.id=:id").setInteger("id", id);
        return query.executeUpdate();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
