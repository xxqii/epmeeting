package com.epmeeting.module;

import com.epmeeting.utils.Constant;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 草帽boy on 2016/1/29.Str
 */
@Entity
@Table(catalog= Constant.DB_CATALOG_EPM, name="epm_role")
public class EpmRole implements Serializable {
    /**
     *自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int role_id;
    /**
     * 角色编号 注：数据库中存放role_no
     */
    @Column(name="role_no")
    private String role_no;
    /**
     * 用户拥有的权限值
     */
    @Column(name="permissions")
    private String permissions;
    /**
     *角色描述
     */
    @Column(name="note")
    private String note;

    public int getId() {
        return role_id;
    }

    public void setId(int id) {
        this.role_id = id;
    }

    public String getRole_no() {
        return role_no;
    }

    public void setRole_no(String role_no) {
        this.role_no = role_no;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getDesc() {
        return note;
    }

    public void setDesc(String desc) {
        this.note = desc;
    }

    /**
     * 带参数的构造方法
     *
     * @param role_no　角色编号
     * @param desc　角色权限值
     * @param permissions　角色编号
     */
    public EpmRole( String role_no, String desc, String permissions) {
        this.role_no = role_no;
        this.note = desc;
        this.permissions = permissions;
    }

    public EpmRole() {
    }

    @Override
    public String toString() {
        return "EpmRole{" +
                "id=" + role_id +
                ", role_no='" + role_no + '\'' +
                ", permissions='" + permissions + '\'' +
                ", desc='" + note + '\'' +
                '}';
    }
}
