package com.epmeeting.dao.impl;

import com.epmeeting.dao.IssueDao;
import com.epmeeting.module.EpmIssue;
import com.epmeeting.module.EpmUser;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("issueDao")
public class IssueDaoImpl implements IssueDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override                   //从父类继承的方法需要重写
    public int add(EpmIssue user) {
        return (Integer)sessionFactory.openSession().save(user);
    }

    @Override
    public List<EpmIssue> get(String username) {
        Query query = sessionFactory.openSession().createQuery("from EpmIssue as u where u.issue_name=:username order by id desc").setString("username", username);
        return query.list();
    }

    @Override
    public List<EpmIssue> list(int index, int limit) {
        Query query = sessionFactory.openSession().createQuery("from EpmIssue order by id desc");
        query.setFirstResult((index-1)*limit).setMaxResults(limit);
        return query.list();
    }

    @Override
    public int delete(int id) {
        Query query = sessionFactory.openSession().createQuery("delete from EpmIssue as u where u.id=:id").setInteger("id", id);
        return query.executeUpdate();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
