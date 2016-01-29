package com.epmeeting.dao;

import com.epmeeting.module.EpmUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by chqi on 2016/1/27.
 */
public interface UserDao {
    public Logger logger = LoggerFactory.getLogger(UserDao.class);

    /**
     * 新增用户
     * @param user ： 需要添加的用户
     * @return
     */
    public int add(EpmUser user);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public List<EpmUser> get(String username);

    /**
     * 用户列表
     * @param index : 第几页
     * @param limit : 每页显示数目
     * @return
     */
    public List<EpmUser> list(int index, int limit);

    /**
     * 删除用户
     * @param id : 用户id
     * @return
     */
    public int delete(int id);
}
