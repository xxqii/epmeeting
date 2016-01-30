package com.epmeeting.module;

import com.epmeeting.utils.Constant;

import javax.persistence.*;
import java.io.Serializable;

/**
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
     * 会议ID
     */
    @Column(name = "meeting_id")
    private int meetingId;
    /**

     * 资料ID
     */
    @Column(name = "material_id")
    private int materialId;

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    @Override
    public String toString() {
        return "EpmMaterial{" +
                "id=" + id +
                ", meetingId=" + meetingId +
                ", materialId=" + materialId +
                '}';
    }
}
