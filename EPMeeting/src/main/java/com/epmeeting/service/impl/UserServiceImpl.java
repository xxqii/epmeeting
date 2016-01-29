package com.epmeeting.service.impl;

import com.epmeeting.dao.UserDao;
import com.epmeeting.module.EpmUser;
import com.epmeeting.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return userDao.add(user);
    }

    @Override
    public List<EpmUser> get(String username) {
        if(StringUtils.isBlank(username)) {
            return null;
        }
        logger.info("UserServiceImpl.get " + username);
        return userDao.get(username);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
