package com.epmeeting.dao;

import com.epmeeting.module.EpmIssue;
import com.epmeeting.module.EpmUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Administrator on 2016/1/29.
 */
public interface IssueDao {
    public Logger logger = LoggerFactory.getLogger(IssueDao.class);

    /**
     * 新增议题
     * @param issue ： 需要添加的议题
     * @return
     */
    public int add(EpmIssue issue);

    /**
     * 根据议题名查找议题
     * @param issuename
     * @return
     */
    public List<EpmIssue> get(String issuename);

    /**
     * 议题列表
     * @param index : 第几页
     * @param limit : 每页显示数目
     * @return
     */
    public List<EpmIssue> list(int index, int limit);

    /**
     * 删除议题
     * @param id : 用户id
     * @return
     */
    public int delete(int id);
}
