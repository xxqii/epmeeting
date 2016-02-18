package com.epmeeting.dao;

import com.epmeeting.module.EpmUser;
import com.epmeeting.utils.Page;
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
     * @param email
     * @return
     */
    public EpmUser get(String email);

    /**
     * 根据主键查找用户
     * @param id
     * @return
     */
    public EpmUser get(int id);

    /**
     * 更新用户
     * @param user
     * @return
     */
    public void update(EpmUser user);

    /**
     * 用户列表
     * @return
     */
    public List<EpmUser> list(Page page, String keyword);

    /**
     * 查找记录的条数
     *
     * @return
     */
    public int count(String keyword);

    /**
     * 删除用户
     * @param id : 用户id
     * @return
     */
    public int delete(int id);
}
