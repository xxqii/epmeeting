package com.epmeeting.dao;

import com.epmeeting.module.EpmExpert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by 张宏浩 on 2016/1/29.
 */
public interface ExpertDao {
    public Logger logger = LoggerFactory.getLogger(ExpertDao.class);

    /**
     * 新增专家
     * @param expert ： 需要添加的专家
     * @return
     */
    public int add(EpmExpert expert);

    /**
     * 根据专家名查找专家
     * @param expertname;
     * @return
     */
    public List<EpmExpert> get(String expertname);

    /**
     * 专家列表
     * @param index : 第几页
     * @param limit : 每页显示数目
     * @return
     */
    public List<EpmExpert> list(int index, int limit);

    /**
     * 删除专家
     * @param id : 专家id
     * @return
     */
    public int delete(int id);
}


