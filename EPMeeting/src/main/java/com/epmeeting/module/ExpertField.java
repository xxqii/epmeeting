package com.epmeeting.module;

import com.epmeeting.utils.Constant;

import javax.persistence.*;
import javax.print.attribute.standard.DateTimeAtCompleted;
import java.util.Date;

/**
 * Created by 张宏浩 on 2016/1/29.
 */
@Entity
@Table(catalog= Constant.DB_CATALOG_EPM, name="expert_field")
public class ExpertField {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /*
    专家Id String类型
     */
    @Column(name="expert_id")
    private String expertId;

    /*
    领域Id
     */
    @Column(name="field_id")
    private int fieldId;

    /*
    记录插入时间或者最后修改时间
     */
    @Column(name="operate_time")
    private Date operateTime;
    /*
    记录插入者姓名或者最后修改者姓名
     */
    @Column(name="operator_name")
    private String operatorName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpertId() {
        return expertId;
    }

    public void setExpertId(String expertId) {
        this.expertId = expertId;
    }

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    @Override
    public String toString() {
        return "ExpertField{" +
                "id=" + id +
                ", expertId='" + expertId + '\'' +
                ", fieldId=" + fieldId +
                ", operateTime=" + operateTime +
                ", operatorName='" + operatorName + '\'' +
                '}';
    }
}
