package com.epmeeting.dao.impl;


import com.epmeeting.dao.MeetingIssueDao;
import com.epmeeting.dao.MeetingMaterialDao;
import com.epmeeting.module.EpmMeetingIssue;
import com.epmeeting.module.EpmMeetingMaterial;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ptf on 2016/1/29.
 */
@Component("meetingMaterialDao")
public class MeetingMaterialDaoImpl implements MeetingMaterialDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int add(EpmMeetingMaterial meetingMaterial) {
        return (Integer)sessionFactory.openSession().save(meetingMaterial);
    }

    @Override
    public List<EpmMeetingMaterial> get(int meetingid){
        Query query = sessionFactory.openSession().createQuery("from EpmMeetingMaterial as f where f.MeetingId=:meetingid order by MeetingMaterialId desc").setInteger("meetingid",meetingid);
        return query.list();
    }

    @Override
    public List<EpmMeetingMaterial> list(int index, int limit) {
        Query query = sessionFactory.openSession().createQuery("from EpmMeetingMaterial order by MeetingMaterialId desc");
        query.setFirstResult((index-1)*limit).setMaxResults(limit);
        return query.list();
    }

    @Override
    public int delete(int meetingmaterialid) {
        Query query = sessionFactory.openSession().createQuery("delete from EpmMeetingMaterial as f where f.MeetingMaterialId=:meetingmaterialid").setInteger("meetingmaterialid",meetingmaterialid);
        return query.executeUpdate();
    }


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
