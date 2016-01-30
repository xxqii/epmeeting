package com.epmeeting.module;

import com.epmeeting.utils.Constant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhy on 2016/1/29.
 */
@Entity  //实体
@Table(catalog= Constant.DB_CATALOG_EPM, name="epm_log")
public class EpmLog implements Serializable {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    /**
     * 创建本条日志记录的IP
     */
    @Column(name="create_ipaddr")
    private String  createIpaddr;
    /**
     * 创建本条日志的用户名
     */
    @Column(name = "create_username")
    private String createUsername;
    /**
     * 创建时间
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "create_datetime")
    private Date createDatetime;
    /**
     * 日志类型
     */
    @Column(name = "log_type")
    private String logType;
    /**
     * 本条日志的详细内容
     */
    @Column(name = "content")
    private String content;
    /**
     * 操作类型
     */
    @Column(name = "operation_type")
    private String operationType;
    /**
     * 操作所对应的表
     */
    @Column(name = "operated_table")
    private String operateTable;

    public String getOperateTable() {
        return operateTable;
    }

    public void setOperateTable(String operateTable) {
        this.operateTable = operateTable;
    }

    /**
     * 文本

     */
    @Column(name = "memo")
    private String memo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreateIpaddr() {
        return createIpaddr;
    }

    public void setCreateIpaddr(String createIpaddr) {
        this.createIpaddr=createIpaddr;
    }

    public String getCreateUsername() {
        return createUsername;
    }

    public void setCreateUsername(String createUsername) {
        this.createUsername = createUsername;
    }

    public Date getCreateDatetime (){return createDatetime; }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getContent() { return content;}

    public void setContent(String content) {
        this.content = content;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "EpmLog{" +
                "id=" + id +
                ", createIpaddr='" + createIpaddr + '\'' +
                ", createUsername='" + createUsername + '\'' +
                ", createDatetime=" + createDatetime +
                ", logType='" + logType + '\'' +
                ", content='" + content + '\'' +
                ", operationType='" + operationType + '\'' +
                ", operateTable='" + operateTable + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }
}
