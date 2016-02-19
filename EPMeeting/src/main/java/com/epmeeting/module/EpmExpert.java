package com.epmeeting.module;

import com.epmeeting.utils.Constant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by 张宏浩 on 2016/1/29.
 */
@Entity
@Table(catalog= Constant.DB_CATALOG_EPM, name="epm_expert")
public class EpmExpert implements Serializable {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /**
     * 专家编号
     */
    private String number;
    /**
    * 专家姓名
     */
    private String name;

    /**
     * 专家性别，0：男性；1：女性。
     */
    private short sex;

    /**
     * 专家生日
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    private Date birthday;

    /**
     * 专家职务
     */
    private String position;
    /*
    专家职称
     */
    private String title;
    /*
    专家学历
     */
    private String education;
    /*
    专家学位
     */
    private String degree;
    /*
    工作地点
     */
    private String workunit;

    /*
    个人成就
     */
    private String achievement;
    /*
    个人简介
     */
    private String introduction;
    /*
    手机
     */
    private String mobile;
    /*
    电话
     */
    private String telphone;
    /*
    qq
     */
    private int qq;
    /*
    邮箱
     */
    private String email;

    /**
     * 图像url连接
     */
    private String avatar;

    /**
     * 添加时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_time")
    private Date createTime;
    /**
     * 添加者
     */
    @Column(name="creator")
    private String creator;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getSex() {
        return sex;
    }

    public void setSex(short sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getWorkunit() {
        return workunit;
    }

    public void setWorkunit(String workunit) {
        this.workunit = workunit;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
