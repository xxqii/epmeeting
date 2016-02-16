package com.epmeeting.module;

import com.epmeeting.utils.Constant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 资料
 * Created by zhy on 2016/1/29.
 */
@Entity
@Table(catalog= Constant.DB_CATALOG_EPM, name="epm_material")
public class EpmMaterial implements Serializable {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /**
     * 文件名
     */
    private String filename;
    /**
     * 文件大小
     */
    private long size;
    /**
     * 资料类型； 1：word文档；2：PPT；3：视频；4：音频；5：图片；0：其它类型
     */
    private short type;

    /**
     * 关键字，多个关键字之间用‘,’分隔
     */
    private String keyword;

    /**
     * 备注
     */
    private String note;

    /**
     * 添加时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_time")
    private Date createTime;

    /**
     * 添加者
     */
    private String creator;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
