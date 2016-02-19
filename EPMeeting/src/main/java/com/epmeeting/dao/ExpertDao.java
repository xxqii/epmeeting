package com.epmeeting.dao;

import com.epmeeting.module.EpmExpert;
import com.epmeeting.utils.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by 张宏浩 on 2016/1/29.
 */
public interface ExpertDao {
    public Logger logger = LoggerFactory.getLogger(ExpertDao.class);

    /**
     * 根据主键id查找专家
     * @param id
     * @return
     */
    public EpmExpert get(int id);

    /**
     * 新增专家
     * @param expert ： 需要添加的专家
     * @return
     */
    public int add(EpmExpert expert);

    /**
     * 根据邮箱查找专家
     * @param email;
     * @return
     */
    public List<EpmExpert> get(String email);

    /**
     * 分页查找专家
     * @param page
     * @param keyword
     * @return
     */
    public List<EpmExpert> list(Page page, String keyword);

    /**
     * 查找专家的总数目
     * @param keyword
     * @return
     */
    public int count(String keyword);

    /**
     * 删除专家
     * @param id
     * @return
     */
    public int delete(int id);

    /**
     * 更新专家
     * @param expert
     */
    public void update(EpmExpert expert);
}


