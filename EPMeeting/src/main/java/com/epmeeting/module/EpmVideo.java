package com.epmeeting.module;

import com.epmeeting.utils.Constant;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 张宏浩 on 2016/1/29.
 */
@Entity
@Table(catalog= Constant.DB_CATALOG_EPM, name="epm_video")
public class EpmVideo {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /*
    录像编号
     */
    @Column(name="video_number")
    private int videoNumber;

    /*
    用户编号
     */
    @Column(name = "user_id")
    private int userId;

    /*
    专家编号
     */
    @Column(name="expert_id")
    private String expertId;

    /*
    会议编号
     */
    @Column(name="meeting_id")
    private int meetingId;

    /*
    录像内容
     */
    @Column(name="video")
    private String video;

    /*
    录像开始时间
     */
    @Column(name="video_begin")
    private Date videoBegin;

    /*
    录像结束时间
     */
    @Column(name="video_end")
    private Date videoEnd;

    /*
    录像大小
     */
    @Column(name="video_size")
    private String videoSzie;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVideoNumber() {
        return videoNumber;
    }

    public void setVideoNumber(int videoNumber) {
        this.videoNumber = videoNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Date getVideoBegin() {
        return videoBegin;
    }

    public void setVideoBegin(Date videoBegin) {
        this.videoBegin = videoBegin;
    }

    public Date getVideoEnd() {
        return videoEnd;
    }

    public void setVideoEnd(Date videoEnd) {
        this.videoEnd = videoEnd;
    }

    public String getVideoSzie() {
        return videoSzie;
    }

    public void setVideoSzie(String videoSzie) {
        this.videoSzie = videoSzie;
    }

    @Override
    public String toString() {
        return "EpmVideo{" +
                "id=" + id +
                ", videoNumber=" + videoNumber +
                ", userId=" + userId +
                ", expertId='" + expertId + '\'' +
                ", meetingId=" + meetingId +
                ", video='" + video + '\'' +
                ", videoBegin=" + videoBegin +
                ", videoEnd=" + videoEnd +
                ", videoSzie='" + videoSzie + '\'' +
                '}';
    }
}
