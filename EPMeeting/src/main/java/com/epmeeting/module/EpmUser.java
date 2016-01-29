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
     * 用户登录名
     */
    @Column(name = "user_name")
    private String userName;
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
     * 图像url连接
     */
    @Column(name = "avatar")
    private String avatar;
    /**
     * 用户拥有的角色id列表，多个id之间用','分隔，eg：1,2,3,
     */
    @Column(name = "role_ids")
    private String roleIds;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=").append(this.getId()).append(",name=").append(this.getUserName());
        return sb.toString();
    }
}
