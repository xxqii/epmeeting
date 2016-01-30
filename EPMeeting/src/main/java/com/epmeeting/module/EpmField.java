package com.epmeeting.module;

import com.epmeeting.utils.Constant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/1/29.
 */

@Entity
@Table(catalog= Constant.DB_CATALOG_EPM, name="epm_field")
public class EpmField implements Serializable {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)         //id设置为自增方式
    @Column(name = "id")
    private int id;
    /**
     *领域编号
     */
    @Column(name = "field_number")
    private int number;
    /**
     * 领域名称
     */
    @Column(name = "field_name")
    private String field_name;
    /**
     * 领域描述
     */
    @Column(name = "field_note")
    private String describe;
    /**
     * 父领域id
     */
    @Column(name = "father_field_id")
    private int ffid;

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

    public String getField_name() {
        return field_name;
    }

    public void setField_name(String field_name) {
        this.field_name = field_name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getFfid() {
        return ffid;
    }

    public void setFfid(int ffid) {
        this.ffid = ffid;
    }

    @Override
    public String toString() {
        return "EpmField{" +
                "id=" + id +
                ", number=" + number +
                ", field_name='" + field_name + '\'' +
                ", describe='" + describe + '\'' +
                ", ffid='" + ffid + '\'' +
                '}';
    }
}
