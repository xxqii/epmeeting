package com.epmeeting.service.impl;

import com.epmeeting.dao.UserDao;
import com.epmeeting.module.EpmUser;
import com.epmeeting.service.UserService;
import com.epmeeting.utils.Page;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by chqi on 2016/1/26.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int add(EpmUser user) {
        try {
            return userDao.add(user);
        } catch (Exception e) {
            logger.error("UserServiceImpl.add error ,", e);
            return 0;
        }
    }

    @Override
    public EpmUser get(String email) {
        if(StringUtils.isBlank(email)) {
            return null;
        }
        try{
            return userDao.get(email);
        } catch(Exception e) {
            logger.error("UserServiceImpl.get error, ", e);
            return null;
        }
    }

    @Override
    public EpmUser get(int id) {
        if(id <= 0 ) {
            return null;
        }
        return userDao.get(id);
    }

    @Override
    public void update(EpmUser user) {
        if(user == null) {
            return;
        }
        userDao.update(user);
    }

    @Override
    public List<EpmUser> list(EpmUser user, Page page) {
        String email = null;
        String realName = null;
        int userType = -1;
        String creator = null;
        if(user != null) {
            email = user.getEmail();
            userType = user.getUserType();
            realName = user.getRealName();
            creator = user.getCreator();
        }
        try {
            int totalCount = userDao.count(email, realName, userType, creator);
            if(totalCount > 0) {
                page.setTotalCount(totalCount);
                int pageCount = totalCount/page.getPageSize();
                if(totalCount % page.getPageSize() != 0) {
                    ++pageCount;
                }
                page.setTotalPageCount(pageCount);
                return userDao.list(email, realName, userType, creator, page);
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.error("UserServiceImpl.list : error" , e);
            return null;
        }
    }

    @Override
    public int delete(int id) {
        return userDao.delete(id);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
