package com.epmeeting.dao;

import com.epmeeting.module.EpmMaterial;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by zhy on 2016/1/29.
 */
public interface MaterialDao {
    public Logger logger = LoggerFactory.getLogger(MaterialDao.class);
    /**
     * 新增资料
     * @param material ： 需要添加的资料
     * @return
     */
    public int add(EpmMaterial material);

    /**
     * 根据资料Id查找资料
     * @param materialId
     * @return
     */
    public List<EpmMaterial> get(String materialId);

    /**
     * 资料列表
     * @param index : 第几页
     * @param limit : 每页显示数目
     * @return
     */
    public List<EpmMaterial> list(int index, int limit);

    /**
     * 删除资料
     * @param id : 资料id
     * @return
     */
    public int delete(int id);
}
