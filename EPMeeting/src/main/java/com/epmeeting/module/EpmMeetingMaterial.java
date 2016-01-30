package com.epmeeting.module;

import com.epmeeting.utils.Constant;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by PTF on 2016/1/29.
 */
@Entity
@Table(catalog= Constant.DB_CATALOG_EPM,name="meeting_material")
public class EpmMeetingMaterial implements  Serializable {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MeetingMaterialId")
    private int MeetingMaterialId;
    /**
     * 会议ID
     */
    @Column(name = "MeetingId")
    private int MeetingId;
    /**
     * 资料ID
     */
    @Column(name = "MaterialId")
    private int MaterialId;

    public int getMeetingMaterialId() {
        return MeetingMaterialId;
    }

    public void setMeetingMaterialId(int meetingMaterialId) {
        MeetingMaterialId = meetingMaterialId;
    }

    public int getMeetingId() {
        return MeetingId;
    }

    public void setMeetingId(int meetingId) {
        MeetingId = meetingId;
    }

    public int getMaterialId() {
        return MaterialId;
    }

    public void setMaterialId(int materialId) {
        MaterialId = materialId;
    }

    @Override
    public String toString() {
        return "EpmMeetingMaterial{" +
                "MeetingMaterialId=" + MeetingMaterialId +
                ", MeetingId=" + MeetingId +
                ", MaterialId=" + MaterialId +
                '}';
    }
}










