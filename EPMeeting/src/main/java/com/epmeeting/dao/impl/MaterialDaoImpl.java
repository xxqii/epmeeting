package com.epmeeting.dao.impl;

import com.epmeeting.dao.MaterialDao;
import com.epmeeting.module.EpmMaterial;
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
    public List<EpmMaterial> get(String materialId) {
        Query query = sessionFactory.openSession().createQuery("from EpmMaterial as em where em.materialId=:materialId order by id desc").setString("materialId", materialId);
        return query.list();
    }

    @Override
    public List<EpmMaterial> list(int index, int limit) {
        Query query = sessionFactory.openSession().createQuery("from EpmMaterial order by id desc");
        query.setFirstResult((index-1)*limit).setMaxResults(limit);
        return query.list();
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
