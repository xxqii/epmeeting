package com.epmeeting.dao.impl;

import com.epmeeting.dao.TextDao;
import com.epmeeting.module.EpmText;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 草帽boy on 2016/1/29.
 */
@Component("textDao")
public class TextDaoImpl implements TextDao {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public int addtest(EpmText text) {
        return (Integer)sessionFactory.openSession().save(text);
    }

    @Override
    public List<EpmText> listtest(int index, int limit) {
        Query query = sessionFactory.openSession().createQuery("from EpmText order by text_id desc");
        query.setFirstResult((index-1)*limit).setMaxResults(limit);
        return query.list();
    }

    @Override
    public int deltest(int textid) {
        Query query = sessionFactory.openSession().createQuery("delete from EpmText as u where u.text_id=:text_id").setInteger("text_id", textid);
        return query.executeUpdate();
    }

    @Override
    public List<EpmText> gettext(String textnumber) {
        Query query = sessionFactory.openSession().createQuery("from EpmText as ut where ut.text_number=:text_number order by text_id desc").setString("text_number", textnumber);
        return query.list();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
