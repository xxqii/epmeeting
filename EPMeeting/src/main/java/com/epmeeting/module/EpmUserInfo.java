package com.epmeeting.module;

import com.epmeeting.utils.Constant;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 草帽boy on 2016/1/29.
 */
@Entity
@Table(catalog= Constant.DB_CATALOG_EPM, name="epm_userinfo")
public class EpmUserInfo implements Serializable {
    /**
     * 用户信息表自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userinfo_id")
    private int userinfo_id;
    /**
     * 用户id  注释：主要是为了关联用户表
     */
    @Column(name="user_id")
    private int user_id;
    /**
     * 用户姓名
     */
    @Column(name="user_name")
    private String user_name;
    /**
     * 用户手机
     */
    @Column(name="user_mobile")
    private String user_mobile;
    /**
     * 用户电话
     */
    @Column(name="user_tel")
    private String user_tel;
    /**
     * 用户邮箱
     */
    @Column(name="user_email")
    private String user_email;
    /**
     * 用户图像
     */
    @Column(name="user_photo")
    private String user_photo;
    /**
     * 用户QQ
     */
    @Column(name="user_qq")
    private String user_qq;
    /**
     * 用户职业
     */
    @Column(name="user_workunit")
    private String user_workunit;
    /**
     * 用户地址
     */
    @Column(name="user_postaddress")
    private String user_postaddress;

    public int getUserinfo_id() {
        return userinfo_id;
    }

    public void setUserinfo_id(int userinfo_id) {
        this.userinfo_id = userinfo_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_mobile() {
        return user_mobile;
    }

    public void setUser_mobile(String user_mobile) {
        this.user_mobile = user_mobile;
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public String getUser_qq() {
        return user_qq;
    }

    public void setUser_qq(String user_qq) {
        this.user_qq = user_qq;
    }

    public String getUser_workunit() {
        return user_workunit;
    }

    public void setUser_workunit(String user_workunit) {
        this.user_workunit = user_workunit;
    }

    public String getUser_postaddress() {
        return user_postaddress;
    }

    public void setUser_postaddress(String user_postaddress) {
        this.user_postaddress = user_postaddress;
    }

    /**
     * 带参数构造函数
     * @param user_id 用户id
     * @param user_name 用户姓名
     * @param user_mobile 用户手机
     * @param user_tel 用户电话
     * @param user_email 用户Email
     * @param user_photo 用户图像
     * @param user_qq 用户QQ
     * @param user_workunit 用户工作
     * @param user_postaddress 用户地址
     */
    public EpmUserInfo(int user_id, String user_name, String user_mobile, String user_tel, String user_email, String user_photo, String user_qq, String user_workunit, String user_postaddress) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_mobile = user_mobile;
        this.user_tel = user_tel;
        this.user_email = user_email;
        this.user_photo = user_photo;
        this.user_qq = user_qq;
        this.user_workunit = user_workunit;
        this.user_postaddress = user_postaddress;
    }

    public EpmUserInfo() {
    }

    @Override
    public String toString() {
        return "EpmUserInfo{" +
                "userinfo_id=" + userinfo_id +
                ", user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_mobile='" + user_mobile + '\'' +
                ", user_tel='" + user_tel + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_photo='" + user_photo + '\'' +
                ", user_qq='" + user_qq + '\'' +
                ", workunit='" + user_workunit + '\'' +
                ", postaddress='" + user_postaddress + '\'' +
                '}';
    }
}
