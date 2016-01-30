package com.epmeeting.dao;

import com.epmeeting.module.EpmVideo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by 张宏浩 on 2016/1/29.
 */
public interface VideoDao {
    public Logger logger = LoggerFactory.getLogger(UserDao.class);

    /**
     * 新增录像
     * @param video ： 需要添加的录像
     * @return
     */
    public int add(EpmVideo video);

    /**
     * 根据录像Id查找录像
     * @param videoNumber
     * @return
     */
    public List<EpmVideo> get(int videoNumber);

    /**
     * 录像列表
     * @param index : 第几页
     * @param limit : 每页显示数目
     * @return
     */
    public List<EpmVideo> list(int index, int limit);

    /**
     * 删除录像
     * @param id : 用户id
     * @return
     */
    public int delete(int id);
}
