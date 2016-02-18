package com.epmeeting.dao.impl;

import com.epmeeting.dao.BaseDao;
import com.epmeeting.dao.UserDao;
import com.epmeeting.module.EpmUser;
import com.epmeeting.utils.Page;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by chqi on 2016/1/27.
 */
@Service("userDao")
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public int add(EpmUser user) {
        Session session = this.getSessionFactory().openSession();
        int id = (Integer)session.save(user);
        session.close();
        return id;
    }

    @Override
    @Transactional
    public EpmUser get(String email) {
        Session session = this.getSessionFactory().openSession();
        Query query = session.createQuery("from EpmUser as u where u.email=:email order by id desc").setString("email", email);
        EpmUser user = (EpmUser)query.uniqueResult();
        session.close();
        return user;
    }

    @Override
    public EpmUser get(int id) {
        Session session = this.getSessionFactory().openSession();
        EpmUser user =  (EpmUser)session.get(EpmUser.class, id);
        session.close();
        return  user;
    }

    @Override
    public void update(EpmUser user) {
        Session session = this.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        logger.info("" + user.getBirthday().toLocaleString());
        tx.commit();
        session.close();
    }

    @Override
    public List<EpmUser> list(Page page, String keyword) {
        StringBuilder sb = new StringBuilder("from EpmUser as u ");
        if(StringUtils.isNotBlank(keyword)) {
            sb.append(" where u.email like '%"+keyword+"%' or u.realName like '%"+keyword+"%' or u.mobile like '%" + keyword + "%' or u.creator like '%"+keyword+"%'");
        }
        sb.append(" order by u.id desc");

        Session session = this.getSessionFactory().openSession();
        Query query = session.createQuery(sb.toString());
        query.setFirstResult((page.getPage()-1)*page.getPageSize()).setMaxResults(page.getPageSize());
        List<EpmUser> users = query.list();
        session.close();
        return users;
    }

    @Override
    public int count(String keyword) {
        StringBuilder sb = new StringBuilder("select count(1) from EpmUser as u ");
        if(StringUtils.isNotBlank(keyword)) {
            sb.append(" where u.email like '%"+keyword+"%' or u.realName like '%"+keyword+"%' or u.mobile like '%" + keyword + "%' or u.creator like '%"+keyword+"%'");
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
        Query query = session.createQuery("delete from EpmUser as u where u.id=:id").setInteger("id", id);
        int count = query.executeUpdate();
        session.close();
        return count;
    }
}
