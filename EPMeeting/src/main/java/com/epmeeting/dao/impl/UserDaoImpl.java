package com.epmeeting.dao.impl;

import com.epmeeting.dao.UserDao;
import com.epmeeting.module.EpmUser;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chqi on 2016/1/27.
 */
@Service("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int add(EpmUser user) {
        return (Integer)sessionFactory.openSession().save(user);
    }

    @Override
    public List<EpmUser> get(String username) {
        Query query = sessionFactory.openSession().createQuery("from EpmUser as u where u.userName=:username order by id desc").setString("username", username);
        return query.list();
    }

    @Override
    public List<EpmUser> list(int index, int limit) {
        Query query = sessionFactory.openSession().createQuery("from EpmUser order by id desc");
        query.setFirstResult((index-1)*limit).setMaxResults(limit);
        return query.list();
    }

    @Override
    public int delete(int id) {
        Query query = sessionFactory.openSession().createQuery("delete from EpmUser as u where u.id=:id").setInteger("id", id);
        return query.executeUpdate();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
