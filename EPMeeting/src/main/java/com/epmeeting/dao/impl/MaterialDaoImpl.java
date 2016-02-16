package com.epmeeting.dao.impl;

import com.epmeeting.dao.MaterialDao;
import com.epmeeting.module.EpmMaterial;
import com.epmeeting.utils.Page;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zhy on 2016/1/29.
 */
@Component("materialDao")
public class MaterialDaoImpl implements MaterialDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int add(EpmMaterial material) {
        return (Integer)sessionFactory.openSession().save(material);
    }

    @Override
    public List<EpmMaterial> list(Page page) {
        StringBuilder sb = new StringBuilder("from EpmMaterial as m ");
        sb.append(" order by m.id desc");

        Query query = this.getSessionFactory().openSession().createQuery(sb.toString());
        query.setFirstResult((page.getPage()-1)*page.getPageSize()).setMaxResults(page.getPageSize());
        return query.list();
    }

    @Override
    public int count() {
        StringBuilder sb = new StringBuilder("select count(1) from EpmMaterial as m ");
        Query query = this.getSessionFactory().openSession().createQuery(sb.toString());
        return Integer.valueOf(query.uniqueResult().toString());
    }

    @Override
    public int delete(int id) {
        Query query = sessionFactory.openSession().createQuery("delete from EpmMaterial as em where em.id=:id").setInteger("id", id);
        return query.executeUpdate();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
