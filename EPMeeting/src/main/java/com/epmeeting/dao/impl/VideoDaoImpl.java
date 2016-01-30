package com.epmeeting.dao.impl;

import com.epmeeting.dao.VideoDao;
import com.epmeeting.module.EpmVideo;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 张宏浩 on 2016/1/29.
 */
@Component("videoDao")
public class VideoDaoImpl implements VideoDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int add(EpmVideo video) {
        return (Integer)sessionFactory.openSession().save(video);
    }

    @Override
    public List<EpmVideo> get(int  videoNumber) {
        Query query = sessionFactory.openSession().createQuery("from EpmVideo ev  where ev.videoNumber=:videoNumber order by id desc").setInteger("videoNumber", videoNumber);
        return query.list();
    }

    @Override
    public List<EpmVideo> list(int index, int limit) {
        Query query = sessionFactory.openSession().createQuery("from EpmVideo order by id desc");
        query.setFirstResult((index-1)*limit).setMaxResults(limit);
        return query.list();
    }

    @Override
    public int delete(int id) {
        Query query = sessionFactory.openSession().createQuery("delete from EpmVideo as ev where ev.id=:id").setInteger("id", id);
        return query.executeUpdate();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
