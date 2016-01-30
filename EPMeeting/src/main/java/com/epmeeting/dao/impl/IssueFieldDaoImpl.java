package com.epmeeting.dao.impl;

import com.epmeeting.dao.IssueFieldDao;
import com.epmeeting.module.IssueField;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2016/1/29.
 */
@Component("issueFieldDao")
public class IssueFieldDaoImpl implements IssueFieldDao {
    @Autowired      //自动注入
    private SessionFactory sessionFactory;
    @Override
    public int add(IssueField user) {
        return (Integer)sessionFactory.openSession().save(user);
    }

    @Override
    public List<IssueField> getbyissueid(int issue) {
        Query query = sessionFactory.openSession().createQuery("from IssueField as u where u.issue_id=:issue_id order by id desc").setInteger("issue_id", issue);
        return query.list();

    }

    @Override
    public List<IssueField> getbyfieldid(int fieldid) {
        Query query = sessionFactory.openSession().createQuery("from IssueField as u where u.field_id=:field_id order by id desc").setInteger("field_id", fieldid);
        return query.list();
    }



    @Override
    public List<IssueField> list(int index, int limit) {
        Query query = sessionFactory.openSession().createQuery("from IssueField order by id desc");
        query.setFirstResult((index-1)*limit).setMaxResults(limit);
        return query.list();
    }

    @Override
    public int delete(int id) {
        Query query = sessionFactory.openSession().createQuery("delete from IssueField as u where u.id=:id").setInteger("id", id);
        return query.executeUpdate();
    }
}
