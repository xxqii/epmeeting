package com.epmeeting.utils;

/**
 * 定义用户类型
 *
 * 用户类型，0：系统管理员；1：会议控制员；2：会议记录员；3：高级用户；4：音视频记录人员；5：会议管理员；
 *
 * Created by chqi on 2016/1/29.
 */
public enum UserType {
    SYSTEM_ADMIN(0, "系统管理员"),
    ;
    private int id;
    private String desc;

    /**
     * 根据用户的类型id得到枚举类型
     *
     * @param id
     * @return
     */
    public static UserType get(int id) {
        for(UserType type : UserType.values()) {
            if(type.getId() == id) {
                return type;
            }
        }
        return null;
    }


    UserType(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
