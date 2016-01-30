package com.epmeeting.dao;

import com.epmeeting.module.EpmMeeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by zhy on 2016/1/29.
 */
public interface MeetingDao {
    public Logger logger = LoggerFactory.getLogger(MeetingDao.class);
    /**
     * 新增会议
     * @param meeting ： 需要添加的会议
     * @return
     */
    public int add(EpmMeeting meeting);

    /**
     * 根据会议名查找会议
     * @param meetingName
     * @return
     */
    public List<EpmMeeting> get(String meetingName);

    /**
     * 会议列表
     * @param index : 第几页
     * @param limit : 每页显示数目
     * @return
     */
    public List<EpmMeeting> list(int index, int limit);

    /**
     * 删除会议
     * @param id : 会议id
     * @return
     */
    public int delete(int id);
}
