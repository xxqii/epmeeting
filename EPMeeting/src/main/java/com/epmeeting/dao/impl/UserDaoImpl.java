package com.epmeeting.dao.impl;

import com.epmeeting.dao.BaseDao;
import com.epmeeting.dao.UserDao;
import com.epmeeting.module.EpmUser;
import com.epmeeting.utils.Page;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chqi on 2016/1/27.
 */
@Service("userDao")
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public int add(EpmUser user) {
        return (Integer)this.getSessionFactory().openSession().save(user);
    }

    @Override
    public EpmUser get(String email) {
        Query query = this.getSessionFactory().openSession().createQuery("from EpmUser as u where u.email=:email order by id desc").setString("email", email);
        return (EpmUser)query.uniqueResult();
    }

    @Override
    public List<EpmUser> list(String emial, String realName, int userType, String creator, Page page) {
        StringBuilder sb = new StringBuilder("from EpmUser as u ");
        if(StringUtils.isNotBlank(emial)) {
            sb.append(" where u.email like '%"+emial+"%'");
        } else if(StringUtils.isNotBlank(realName)) {
            sb.append(" where u.realName like '%"+realName+"%'");
        } else if(userType >= 0 && userType < 6) {
            sb.append(" where u.userType="+userType);
        } else if(StringUtils.isNotBlank(creator)) {
            sb.append(" where u.creator like '%"+creator+"%'");
        }
        sb.append(" order by u.id desc");

        Query query = this.getSessionFactory().openSession().createQuery(sb.toString());
        query.setFirstResult((page.getPage()-1)*page.getPageSize()).setMaxResults(page.getPageSize());
        return query.list();
    }

    @Override
    public int count(String emial, String realName, int userType, String creator) {
        StringBuilder sb = new StringBuilder("select count(1) from EpmUser as u ");
        if(StringUtils.isNotBlank(emial)) {
            sb.append(" where u.email like '%"+emial+"%'");
        } else if(StringUtils.isNotBlank(realName)) {
            sb.append(" where u.realName like '%"+realName+"%'");
        } else if(userType >= 0 && userType < 6) {
            sb.append(" where u.userType="+userType);
        } else if(StringUtils.isNotBlank(creator)) {
            sb.append(" where u.creator like '%"+creator+"%'");
        }
        Query query = this.getSessionFactory().openSession().createQuery(sb.toString());
        return Integer.valueOf(query.uniqueResult().toString());
    }

    @Override
    public int delete(int id) {
        Query query = getSessionFactory().openSession().createQuery("delete from EpmUser as u where u.id=:id").setInteger("id", id);
        return query.executeUpdate();
    }
}
