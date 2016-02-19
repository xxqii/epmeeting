package com.epmeeting.dao.impl;

import com.epmeeting.dao.BaseDao;
import com.epmeeting.dao.ExpertDao;
import com.epmeeting.module.EpmExpert;
import com.epmeeting.utils.Page;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 张宏浩 on 2016/1/29.
 */
@Component("expertDao")
public class ExpertDaoImpl extends BaseDao implements ExpertDao {

    @Override
    public EpmExpert get(int id) {
        Session session = this.getSessionFactory().openSession();
        EpmExpert expert =  (EpmExpert)session.get(EpmExpert.class, id);
        session.close();
        return  expert;
    }

    @Override
    public int add(EpmExpert expert) {
        Session session = getSessionFactory().openSession();
        int id = (Integer)session.save(expert);
        session.close();
        return id;
    }

    @Override
    public List<EpmExpert> get(String email) {
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery("from EpmExpert as e where e.email=:email order by id desc").setString("email", email);
        List<EpmExpert> experts = query.list();
        session.close();
        return experts;
    }

    @Override
    public List<EpmExpert> list(Page page, String keyword) {
        StringBuilder sb = new StringBuilder("from EpmExpert as e ");
        if(StringUtils.isNotBlank(keyword)) {
            sb.append(" where e.email like '%"+keyword+"%' or e.name like '%"+keyword+"%' or e.mobile like '%" + keyword + "%' or e.creator like '%"+keyword+"%'");
        }
        sb.append(" order by e.id desc");

        Session session = this.getSessionFactory().openSession();
        Query query = session.createQuery(sb.toString());
        query.setFirstResult((page.getPage()-1)*page.getPageSize()).setMaxResults(page.getPageSize());
        List<EpmExpert> experts = query.list();
        session.close();
        return experts;
    }

    @Override
    public int count(String keyword) {
        StringBuilder sb = new StringBuilder("select count(1) from EpmExpert as e ");
        if(StringUtils.isNotBlank(keyword)) {
            sb.append(" where e.email like '%"+keyword+"%' or e.name like '%"+keyword+"%' or e.mobile like '%" + keyword + "%' or e.creator like '%"+keyword+"%'");
        }
        Session session = this.getSessionFactory().openSession();
        Query query = session.createQuery(sb.toString());
        int count = Integer.valueOf(query.uniqueResult().toString());
        session.close();
        return count;
    }

    @Override
    public int delete(int id) {
        Session session = this.getSessionFactory().openSession();
        Query query = session.createQuery("delete from EpmExpert as e where e.id=:id").setInteger("id", id);
        int count = query.executeUpdate();
        session.close();
        return count;
    }

    @Override
    public void update(EpmExpert expert) {
        Session session = this.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(expert);
        tx.commit();
        session.close();
    }
}



