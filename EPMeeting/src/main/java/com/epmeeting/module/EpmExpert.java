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
    @Column(name="expert_number")
    private String expertNumber;
    /*
   专家姓名
     */
    @Column(name="expert_name")
    private String expertName;
    /**
     * 专家性别，0：男性；1：女性。
     */
    @Column(name = "sex")
    private short sex;
    /*
    专家生日
     */
    @Column(name="birthday")
    private Date birthday;
    /*
    专家职务
     */
    @Column(name="expert_position")
    private String expertPosition;
    /*
    专家职称
     */
    @Column(name="expert_title")
    private String expertTitle;
    /*
    专家学历
     */
    @Column(name="expert_education")
    private String expertEducation;
    /*
    专家学位
     */
    @Column(name="expert_degree")
    private String expertDegree;
    /*
    工作地点
     */
    @Column(name="expert_workunit")
    private String expertWorkUnit;
    /*
    所属领域
     */
    @Column(name="field")
    private int fieldId;
    /*
    个人成就
     */
    @Column(name="expert_achievement")
    private String expertAchievement;
    /*
    个人简介
     */
    @Column(name="expert_introduction")
    private String expertIntroduction;
    /*
    手机
     */
    @Column(name="expert_mobile")
    private int expertMobile;
    /*
    电话
     */
    @Column(name="expert_tel")
    private int expertTel;
    /*
    qq
     */
    @Column(name="expert_QQ")
    private int QQ;
    /*
    邮箱
     */
    @Column(name="expert_Email")
    private String expertEmail;
    /**
     * 图像url连接
     */
    @Column(name = "expert_avatar")
    private String avatar;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getExpertTel() { return expertTel; }

    public void setExpertTel(int expertTel) { this.expertTel = expertTel; }

    public String getExpertNumber() { return expertNumber; }

    public void setExpertNumber(String expertNumber) { this.expertNumber = expertNumber; }

    public String getExpertName() { return expertName; }

    public void setExpertName(String expertName) { this.expertName = expertName; }

    public short getSex() { return sex; }

    public void setSex(short sex) { this.sex = sex; }

    public Date getBirthday() { return birthday; }

    public void setBirthday(Date birthday) { this.birthday = birthday; }

    public String getExpertPosition() { return expertPosition; }

    public void setExpertPosition(String expertPosition) { this.expertPosition = expertPosition; }

    public String getExpertTitle() { return expertTitle; }

    public void setExpertTitle(String expertTitle) { this.expertTitle = expertTitle; }

    public String getExpertEducation() { return expertEducation; }

    public void setExpertEducation(String expertEducation) { this.expertEducation = expertEducation; }

    public String getExpertDegree() { return expertDegree; }

    public void setExpertDegree(String expertDegree) { this.expertDegree = expertDegree; }

    public String getExpertWorkUnit() { return expertWorkUnit; }

    public void setExpertWorkUnit(String expertWorkUnit) { this.expertWorkUnit = expertWorkUnit; }

    public int getFieldId() { return fieldId; } public void setFieldId(int fieldId) { this.fieldId = fieldId; }

    public String getExpertAchievement() { return expertAchievement; }

    public void setExpertAchievement(String expertAchievement) { this.expertAchievement = expertAchievement; }

    public String getExpertIntroduction() {
        return expertIntroduction;
    }

    public void setExpertIntroduction(String expertIntroduction) {
        this.expertIntroduction = expertIntroduction;
    }

    public int getExpertMobile() {
        return expertMobile;
    }

    public void setExpertMobile(int expertMobile) {
        this.expertMobile = expertMobile;
    }

    public int getQQ() {
        return QQ;
    }

    public void setQQ(int QQ) {
        this.QQ = QQ;
    }

    public String getExpertEmail() {
        return expertEmail;
    }

    public void setExpertEmail(String expertEmail) {
        this.expertEmail = expertEmail;
    }

    @Override
    public String toString() {
        return "EpmExpert{" +
                "id=" + id +
                ", expertNumber='" + expertNumber + '\'' +
                ", expertName='" + expertName + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", expertPosition='" + expertPosition + '\'' +
                ", expertTitle='" + expertTitle + '\'' +
                ", expertEducation='" + expertEducation + '\'' +
                ", expertDegree='" + expertDegree + '\'' +
                ", expertWorkUnit='" + expertWorkUnit + '\'' +
                ", fieldId=" + fieldId +
                ", expertAchievement='" + expertAchievement + '\'' +
                ", expertIntroduction='" + expertIntroduction + '\'' +
                ", expertMobile=" + expertMobile +
                ", expertTel=" + expertTel +
                ", QQ=" + QQ +
                ", expertEmail='" + expertEmail + '\'' +
                '}';
    }
}
