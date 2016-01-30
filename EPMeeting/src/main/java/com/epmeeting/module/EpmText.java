package com.epmeeting.module;

import com.epmeeting.utils.Constant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by 草帽boy on 2016/1/29.
 */
@Entity
@Table(catalog= Constant.DB_CATALOG_EPM, name="epm_text")
public class EpmText  implements Serializable {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "text_id")
    private int text_id;
    /**
     * 文本编号
     */
    @Column(name="text_number")
    private String text_number;
    /**
     * 会议ID 注释：此次会议id通过匹配会议表得到会议的其他字段
     */
    @Column(name="text_meetingid")
    private int text_meetingid;
    /**
     * 专家Id  注释：此处的专家id通过匹配专家表得到专家表中的其他字段
     */
    @Column(name ="text_expertid")
    private int text_expertid;
    /**
     * 用户ID 注释：此处的用户ID 通过匹配用户表得到用户表中的其他字段
     */
    @Column(name="text_userid")
    private int text_userid;
    /**
     *文本内容
     */
    @Column(name="text_content")
    private String text_content;
    /**
     * 文本上传时间
     */
    @Column(name="text_uploadtime")
    private Date text_uploadtime;

    public int getText_id() {
        return text_id;
    }

    public void setText_id(int text_id) {
        this.text_id = text_id;
    }

    public String getText_number() {
        return text_number;
    }

    public void setText_number(String text_number) {
        this.text_number = text_number;
    }

    public int getText_meetingid() {
        return text_meetingid;
    }

    public void setText_meetingid(int text_meetingid) {
        this.text_meetingid = text_meetingid;
    }

    public int getText_expertid() {
        return text_expertid;
    }

    public void setText_expertid(int text_expertid) {
        this.text_expertid = text_expertid;
    }

    public int getText_userid() {
        return text_userid;
    }

    public void setText_userid(int text_userid) {
        this.text_userid = text_userid;
    }

    public String getText_content() {
        return text_content;
    }

    public void setText_content(String text_content) {
        this.text_content = text_content;
    }

    public Date getText_uploadtime() {
        return text_uploadtime;
    }

    public void setText_uploadtime(Date text_uploadtime) {
        this.text_uploadtime = text_uploadtime;
    }

    /**
     * 无参构造函数
     */
    public EpmText() {
    }

    /**
     * 带参数的构造函数
     * @param text_id 文本id 自增
     * @param text_meetingid 会议id
     * @param text_number 会议编号
     * @param text_expertid 专家id
     * @param text_userid 用户id
     * @param text_content 文本记录
     * @param text_uploadtime 文本上传时间
     */
    public EpmText(int text_id, int text_meetingid, String text_number, int text_expertid, int text_userid, String text_content, Date text_uploadtime) {
        this.text_id = text_id;
        this.text_meetingid = text_meetingid;
        this.text_number = text_number;
        this.text_expertid = text_expertid;
        this.text_userid = text_userid;
        this.text_content = text_content;
        this.text_uploadtime = text_uploadtime;
    }

    @Override
    public String toString() {
        return "EpmText{" +
                "text_id=" + text_id +
                ", text_number='" + text_number + '\'' +
                ", text_meetingid=" + text_meetingid +
                ", text_expertid=" + text_expertid +
                ", text_userid=" + text_userid +
                ", text_content='" + text_content + '\'' +
                ", text_uploadtime='" + text_uploadtime + '\'' +
                '}';
    }
}
