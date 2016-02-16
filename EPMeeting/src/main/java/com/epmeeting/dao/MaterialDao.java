package com.epmeeting.dao;

import com.epmeeting.module.EpmMaterial;
import com.epmeeting.utils.Page;
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
     * 资料列表
     * @return
     */
    public List<EpmMaterial> list(Page page);

    /**
     * 得到总记录数目
     * @return
     */
    public int count();

    /**
     * 删除资料
     * @param id : 资料id
     * @return
     */
    public int delete(int id);
}
