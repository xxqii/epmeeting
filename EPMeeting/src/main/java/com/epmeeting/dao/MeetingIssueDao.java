package com.epmeeting.dao;

import com.epmeeting.module.EpmField;
import com.epmeeting.module.EpmMeetingIssue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by ptf on 2016/1/29.
 */
public interface MeetingIssueDao {
    public Logger logger = LoggerFactory.getLogger(MeetingIssueDao.class);

    /**
     * 新增领域
     * @param meetingIssue ： 需要添加的议题
     * @return
     */
    public int add(EpmMeetingIssue meetingIssue);

    /**
     * 根据会议ID查找会议领域
     * @param meetingid
     * @return
     */
    public List<EpmMeetingIssue> get(int meetingid);

    /**
     * 会议领域列表
     * @param index : 第几页
     * @param limit : 每页显示数目
     * @return
     */
    public List<EpmMeetingIssue> list(int index, int limit);


/**
 * 删除会议领域
 * @param meetingissueid : 会议议题id
 * @return
 */
     public int delete(int meetingissueid);
}