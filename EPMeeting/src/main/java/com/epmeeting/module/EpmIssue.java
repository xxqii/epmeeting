package com.epmeeting.module;

import com.epmeeting.utils.Constant;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2016/1/29.
 */
@Entity
 @Table(catalog= Constant.DB_CATALOG_EPM, name="epm_issue")
 public class EpmIssue implements Serializable {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)         //id设置为自增方式
    @Column(name = "id")
    private int id;
    /**
     * 领域编号
     */
    @Column(name = "issue_number")
    private int number;
    /**
     * 领域名称
     */
    @Column(name = "issue_name")
    private String issue_name;
    /**
     * 领域描述
     */
    @Column(name = "issue_note")
    private String issue_note;
    /**
     * 父领域id
     */
    @Column(name = "meeting_id")
    private int meetingid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getIssue_name() {
        return issue_name;
    }

    public void setIssue_name(String issue_name) {
        this.issue_name = issue_name;
    }

    public String getIssue_note() {
        return issue_note;
    }

    public void setIssue_note(String issue_note) {
        this.issue_note = issue_note;
    }

    public int getMeetingid() {
        return meetingid;
    }

    public void setMeetingid(int meetingid) {
        this.meetingid = meetingid;
    }

    @Override
    public String toString() {
        return "EpmIssue{" +
                "id=" + id +
                ", number=" + number +
                ", issue_name='" + issue_name + '\'' +
                ", issue_note='" + issue_note + '\'' +
                ", meetingid=" + meetingid +
                '}';
    }
}


