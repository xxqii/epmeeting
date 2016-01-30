package com.epmeeting.module;

import com.epmeeting.utils.Constant;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by PTF on 2016/1/29.
 */
@Entity
@Table(catalog= Constant.DB_CATALOG_EPM,name="meeting_issue")
public class EpmMeetingIssue implements  Serializable {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MeetingIssueId")
    private int MeetingIssueId;
    /**
     * 会议ID
     */
    @Column(name = "MeetingId")
    private int MeetingId;
    /**
     * 议题ID
     */
    @Column(name = "IssueId")
    private int IssueId;

    public int getMeetingIssueId() {
        return MeetingIssueId;
    }

    public void setMeetingIssueId(int meetingIssueId) {
        MeetingIssueId = meetingIssueId;
    }

    public int getMeetingId() {
        return MeetingId;
    }

    public void setMeetingId(int meetingId) {
        MeetingId = meetingId;
    }

    public int getIssueId() {
        return IssueId;
    }

    @Override
    public String toString() {
        return "EpmMeetingIssue{" +
                "MeetingIssueId=" + MeetingIssueId +
                ", MeetingId=" + MeetingId +
                ", IssueId=" + IssueId +
                '}';
    }

    public void setIssueId(int issueId) {
        IssueId = issueId;


    }
}










