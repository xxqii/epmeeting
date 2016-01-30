package com.epmeeting.dao;

import com.epmeeting.module.EpmUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by 草帽boy on 2016/1/29.
 */
public interface UserInfoDao {
    public Logger logger = LoggerFactory.getLogger(UserInfoDao.class);

    /**
     * 添加用户的基本形象
     * @param userInfo
     * @return
     */
    public int addUserInfo(EpmUserInfo userInfo);

    /**
     * 显示用户形象 注释（此处当前显示页数 应该需要定死 有待考虑）
     * @param index 当前页数
     * @param limit 每页显示的数目
     * @return
     */
    public List<EpmUserInfo> showuserinfolist(int index, int limit);

    /**
     * 按照id删除用户
     * @param id
     * @return
     */
    public int del(int id);

    /**
     * 通过用户姓名查找用户
     * @param name
     * @return
     */
    public List<EpmUserInfo> getuserinfo(String name);
}
