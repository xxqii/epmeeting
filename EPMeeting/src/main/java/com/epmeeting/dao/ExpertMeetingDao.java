package com.epmeeting.dao;
import com.epmeeting.module.ExpertMeeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by 张宏浩 on 2016/1/29.
 */
public interface ExpertMeetingDao {

    public Logger logger = LoggerFactory.getLogger(ExpertMeetingDao.class);

    /**
     * 新增专家和会议关联
     * @param expertMeeting ： 需要添加的关联
     * @return
     */
    public int add(ExpertMeeting expertMeeting);

    /**
     * 根据专家id查找关联
     * @param expertId
     * @return
     */
    public List<ExpertMeeting> get(String expertId);

    /**
     * 关联列表
     * @param index : 第几页
     * @param limit : 每页显示数目
     * @return
     */
    public List<ExpertMeeting> list(int index, int limit);

    /**
     * 删除关联
     * @param id : 用户id
     * @return
     */
    public int delete(int id);
}
