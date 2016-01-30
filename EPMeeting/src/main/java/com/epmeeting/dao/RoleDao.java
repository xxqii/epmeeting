package com.epmeeting.dao;

import com.epmeeting.module.EpmRole;

import java.util.List;

/**
 * Created by 草帽boy on 2016/1/29.
 */
public interface RoleDao {
    /**
     * 增添方法
     * @param role
     * @return
     */
    public int add(EpmRole role);

    /**
     * 查看所有记录
     * @param index
     * @param limit
     * @return
     */
    public List<EpmRole> listRole(int index, int limit);

    /**
     * 按照权限编号查看记录
     * @param rolenumber
     * @return
     */
    public List<EpmRole> getlistRole(String rolenumber);

    /**
     * 按照id 删除记录
     * @param roleid
     * @return
     */
    public  int del(int roleid);
}
