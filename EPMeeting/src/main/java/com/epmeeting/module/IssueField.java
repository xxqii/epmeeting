package com.epmeeting.module;

import com.epmeeting.utils.Constant;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2016/1/29.
 */
@Entity
 @Table(catalog= Constant.DB_CATALOG_EPM, name="issue_field")
 public class IssueField implements Serializable {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)         //id设置为自增方式
    @Column(name = "id")
    private int id;
    /**
     * 会议议题id
     */
    @Column(name = "issue_id")
    private int issue_id;
    /**
     * 议题所属领域id
     */
    @Column(name = "field_id")
    private int field_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIssue_id() {
        return issue_id;
    }

    public void setIssue_id(int issue_id) {
        this.issue_id = issue_id;
    }

    public int getField_id() {
        return field_id;
    }

    public void setField_id(int field_id) {
        this.field_id = field_id;
    }

    @Override
    public String toString() {
        return "IssueField{" +
                "id=" + id +
                ", issue_id=" + issue_id +
                ", field_id=" + field_id +
                '}';
    }
}
