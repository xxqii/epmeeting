package com.epmeeting.dao.impl;


import com.epmeeting.dao.MeetingIssueDao;

import com.epmeeting.module.EpmMeetingIssue;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ptf on 2016/1/29.
 */
@Component("meetingIssueDao")
public class MeetingIssueDaoImpl implements MeetingIssueDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int add(EpmMeetingIssue meetingIssue) {
        return (Integer)sessionFactory.openSession().save(meetingIssue);
    }

    @Override
    public List<EpmMeetingIssue> get(int meetingid){
        Query query = sessionFactory.openSession().createQuery("from EpmMeetingIssue as f where f.MeetingId=:meetingid order by MeetingIssueId desc").setInteger("meetingid",meetingid);
        return query.list();
    }

    @Override
    public List<EpmMeetingIssue> list(int index, int limit) {
        Query query = sessionFactory.openSession().createQuery("from EpmMeetingIssue order by MeetingIssueId desc");
        query.setFirstResult((index-1)*limit).setMaxResults(limit);
        return query.list();
    }

    @Override
    public int delete(int meetingissueid) {
        Query query = sessionFactory.openSession().createQuery("delete from EpmMeetingIssue as f where f.MeetingIssueId=:meetingissueid").setInteger("meetingissueid",meetingissueid);
        return query.executeUpdate();
    }


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
