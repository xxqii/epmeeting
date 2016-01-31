package com.epmeeting.service;

import com.epmeeting.module.EpmUser;
import com.epmeeting.utils.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by chqi on 2016/1/26.
 */
public interface UserService {
    public Logger logger = LoggerFactory.getLogger(UserService.class);

    public int  add(EpmUser user);

    public EpmUser get(String email);

    public List<EpmUser> list(EpmUser user, Page page);
}
