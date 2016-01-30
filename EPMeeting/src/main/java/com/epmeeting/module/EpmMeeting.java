package com.epmeeting.module;

import com.epmeeting.utils.Constant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhy on 2016/1/29.
 */
@Entity
@Table(catalog= Constant.DB_CATALOG_EPM, name="epm_meeting")
public class EpmMeeting implements Serializable {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    /**
     * 会议编号
     */
    @Column(name = "meeting_no")
    private String meetingNo;
    /**
     * 会议名称
     */
    @Column(name = "meeting_name")
    private String meetingName;
    /**
     * 会议地点
     */
    @Column(name = "place")
    private String place;
    /**
     * 主持人ID
     */
    @Column(name = "emcee_id")
    private String emceeId;
    /**
     * 开始时间，eg：2016-01-20 00:00:00
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "time_begin")
    private Date timeBegin;
    /**
     * 结束时间，eg：2016-01-20 00:00:00
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "time_end")
    private Date timeEnd;
    /**
     * 会议状态
     */
    @Column(name = "state")
    private int state;
    /**
     * 会议简介
     */
    @Column(name = "summary")
    private String  summary;
    /**
     * 会议视频
     */
    @Column(name = "video_path")
    private String  videoPath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeetingNo() {
        return meetingNo;
    }

    public void setMeetingNo(String meetingNo) {
        this.meetingNo = meetingNo;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getEmceeId() {
        return emceeId;
    }

    public void setEmceeId(String emceeId) {
        this.emceeId = emceeId;
    }

    public Date getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(Date timeBegin) {
        this.timeBegin = timeBegin;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    @Override
    public String toString() {
        return "EpmMeeting{" +
                "id=" + id +
                ", meetingNo='" + meetingNo + '\'' +
                ", meetingName='" + meetingName + '\'' +
                ", place='" + place + '\'' +
                ", emceeId=" + emceeId +
                ", timeBegin=" + timeBegin +
                ", timeEnd=" + timeEnd +
                ", state=" + state +
                ", summary='" + summary + '\'' +
                ", videoPath='" + videoPath + '\'' +
                '}';
    }
}
