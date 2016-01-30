package com.epmeeting.dao;

import com.epmeeting.module.EpmUser;
import com.epmeeting.module.ExpertField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by 张宏浩 on 2016/1/29.
 */
public interface ExpertFieldDao {
    public Logger logger = LoggerFactory.getLogger(ExpertFieldDao.class);

    /**
     * 新增专家领域关联
     * @param expertField ： 需要添加的专家领域关联
     * @return
     */
    public int add(ExpertField expertField);

    /**
     * 根据专家Id
     * @param expertId
     * @return
     */
    public List<ExpertField> get(String expertId);

    /**
     * 专家领域关联列表
     * @param index : 第几页
     * @param limit : 每页显示数目
     * @return
     */
    public List<ExpertField> list(int index, int limit);

    /**
     * 删除关联
     * @param id : id
     * @return
     */
    public int delete(int id);
}
