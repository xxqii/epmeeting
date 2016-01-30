package com.epmeeting.dao.impl;

import com.epmeeting.dao.FieldDao;
import com.epmeeting.module.EpmField;
import com.epmeeting.module.EpmUser;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.jboss.logging.annotations.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/29.
 */

@Component("fieldDao")
public class FieldDaoImpl implements FieldDao {

    @Autowired      //自动注入
    private SessionFactory sessionFactory;

    @Override                   //从父类继承的方法需要重写
    public void  add(EpmField field) {
        sessionFactory.openSession().save(field);

    }

    @Override
    public List<EpmField> get(String fieldname) {
        Query query = sessionFactory.openSession().createQuery("from EpmField as u where u.field_name=:fieldname order by id desc").setString("fieldname", fieldname);

        return query.list();


    }

    @Override
    public List<EpmField> list(int index, int limit) {
        Query query = sessionFactory.openSession().createQuery("from EpmField order by id desc");
        query.setFirstResult((index-1)*limit).setMaxResults(limit);
        return query.list();
    }

    @Override
    public int delete(int id) {
        Query query = sessionFactory.openSession().createQuery("delete from EpmField as u where u.id=:id").setInteger("id", id);
        return query.executeUpdate();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
