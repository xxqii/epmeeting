package com.epmeeting.module;

import com.epmeeting.utils.Constant;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 张宏浩 on 2016/1/29.
 */
@Entity
@Table(catalog= Constant.DB_CATALOG_EPM, name="expert_meeting")
public class ExpertMeeting {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    /*
    专家Id string类型
     */
    @Column(name="expert_id")
    private String expertId;
    /*
    会议Id
     */
    @Column(name="meeting_id")
    private int meetingId;
    /*
    记录插入时间或者最后修改时间
     */
    @Column(name="operate_time")
    private Date operateTime;
    /*
    记录插入者姓名或者最后修改者姓名
     */
    @Column(name="operator_name")
    private String operatorName;

   //Getter和Setter方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpertId() {
        return expertId;
    }

    public void setExpertId(String expertId) {
        this.expertId = expertId;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    @Override
    public String toString() {
        return "ExpertMeeting{" +
                "id=" + id +
                ", expertId='" + expertId + '\'' +
                ", meetingId=" + meetingId +
                ", operateTime=" + operateTime +
                ", operatorName='" + operatorName + '\'' +
                '}';
    }
}
