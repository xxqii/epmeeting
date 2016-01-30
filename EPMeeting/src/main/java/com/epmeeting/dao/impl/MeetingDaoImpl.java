package com.epmeeting.dao.impl;

import com.epmeeting.dao.MeetingDao;
import com.epmeeting.module.EpmMeeting;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zhy on 2016/1/29.
 */
@Component("meetingDao")
public class MeetingDaoImpl  implements MeetingDao {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public int add(EpmMeeting meeting) {
        return (Integer)sessionFactory.openSession().save(meeting);
    }

    @Override
    public List<EpmMeeting> get(String meetingName) {
        Query query = sessionFactory.openSession().createQuery("from EpmMeeting as em where em.meetingName=:meetingName order by id desc").setString("meetingName", meetingName);
        return query.list();
    }

    @Override
    public List<EpmMeeting> list(int index, int limit) {
        Query query = sessionFactory.openSession().createQuery("from EpmMeeting order by id desc");
        query.setFirstResult((index-1)*limit).setMaxResults(limit);
        return query.list();
    }

    @Override
    public int delete(int id) {
        Query query = sessionFactory.openSession().createQuery("delete from EpmMeeting as em where em.id=:id").setInteger("id", id);
        return query.executeUpdate();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
