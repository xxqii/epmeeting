package com.epmeeting.dao.impl;

import com.epmeeting.dao.UserInfoDao;
import com.epmeeting.module.EpmUserInfo;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.hibernate.Query;
import java.util.List;

/**
 * Created by 草帽boy on 2016/1/29.
 */
@Component("userInfoDao") //这句什么意思呢？？
public class UserInfoDaoImpl implements UserInfoDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int addUserInfo(EpmUserInfo userInfo) {
        return (Integer)  sessionFactory.openSession().save(userInfo);
    }

    @Override
    public List<EpmUserInfo> showuserinfolist(int index, int limit) {
        Query query = sessionFactory.openSession().createQuery("from EpmUserInfo order by userinfo_id desc");
        query.setFirstResult((index-1)*limit).setMaxResults(limit);
        return query.list();
    }

    @Override
    public int del(int id) {
        Query query = sessionFactory.openSession().createQuery("delete from EpmUserInfo as ui where ui.userinfo_id=:id").setInteger("id", id);
        return query.executeUpdate();
    }

    @Override
    public List<EpmUserInfo> getuserinfo(String name) {
        String hql="from EpmUserInfo as ui where ui.user_name=? order by userinfo_id desc";
        Query query = sessionFactory.openSession().createQuery(hql).setString(0,name);
        return query.list();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
