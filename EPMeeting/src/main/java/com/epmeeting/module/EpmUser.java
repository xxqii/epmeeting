package com.epmeeting.module;

import com.epmeeting.utils.Constant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by chqi on 2016/1/26.
 */
@Entity
@Table(catalog=Constant.DB_CATALOG_EPM, name="epm_user")
public class EpmUser implements Serializable {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    /**
     * 用户类型，0：系统管理员；1：会议控制员；2：会议记录员；3：高级用户；4：音视频记录人员；5：会议管理员；
     */
    @Column(name = "user_type")
    private short userType;
    /**
     * 用户登录名：邮箱
     */
    @Column(name = "user_email")
    private String email;
    /**
     * 登录密码，注：db中存放md5
     */
    @Column(name = "passwd_md5")
    private String passwdMd5;
    /**
     * 真是姓名
     */
    @Column(name = "real_name")
    private String realName;
    /**
     * 日期，eg：2016-01-20
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    private Date birthday;

    /**
     * 手机号码
     */
    @Column(name = "mobile")
    private String mobile;

    /**
     * 固定电话
     */
    @Column(name = "telphone")
    private String telphone;

    /**
     * QQ号码
     */
    @Column(name = "qq")
    private String qq;

    /**
     * 图像url连接
     */
    @Column(name = "avatar")
    private String avatar;

    /**
     * 工作单位
     */
    @Column(name="workunit")
    private String workunit;

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

    public short getUserType() {
        return userType;
    }

    public void setUserType(short userType) {
        this.userType = userType;
    }

    public String getPasswdMd5() {
        return passwdMd5;
    }

    public void setPasswdMd5(String passwdMd5) {
        this.passwdMd5 = passwdMd5;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkunit() {
        return workunit;
    }

    public void setWorkunit(String workunit) {
        this.workunit = workunit;
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=").append(this.getId()).append(",name=").append(this.getEmail());
        return sb.toString();
    }
}
