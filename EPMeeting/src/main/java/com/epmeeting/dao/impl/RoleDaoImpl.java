package com.epmeeting.dao.impl;

import com.epmeeting.dao.RoleDao;
import com.epmeeting.module.EpmRole;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 草帽boy on 2016/1/29.
 */
@Component("roleDao")
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int add(EpmRole role) {
        return (Integer)sessionFactory.openSession().save(role);
    }

    @Override
    public List<EpmRole> listRole(int index, int limit) {
        Query query = sessionFactory.openSession().createQuery("from EpmRole order by role_id desc");
        query.setFirstResult((index-1)*limit).setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<EpmRole> getlistRole(String rolenumber) {
        Query query = sessionFactory.openSession().createQuery("from EpmRole as r where r.role_no=:role_no order by role_id desc").setString("role_no", rolenumber);
        return query.list();
    }

    @Override
    public int del(int roleid) {
        Query query = sessionFactory.openSession().createQuery("delete from EpmRole as u where u.role_id=:id").setInteger("id", roleid);
        return query.executeUpdate();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
