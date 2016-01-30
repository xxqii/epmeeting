package com.epmeeting.dao;
import com.epmeeting.module.EpmMeetingMaterial;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by ptf on 2016/1/29.
 */
public interface MeetingMaterialDao {
    public Logger logger = LoggerFactory.getLogger(MeetingMaterialDao.class);

    /**
     * 新增领域
     * @param  ： meetingMaterial 需要添加的议题
     * @return
     */
    public int add(EpmMeetingMaterial meetingMaterial);

    /**
     * 根据会议ID查找会议资料
     * @param meetingid
     * @return
     */
    public List<EpmMeetingMaterial> get(int meetingid);

    /**
     * 会议领域列表
     * @param index : 第几页
     * @param limit : 每页显示数目
     * @return
     */
    public List<EpmMeetingMaterial> list(int index, int limit);


/**
 * 删除会议领域
 * @param meetingmaterialid : 会议议题id
 * @return
 */
     public int delete(int meetingmaterialid);
}