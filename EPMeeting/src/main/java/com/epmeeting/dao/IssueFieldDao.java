package com.epmeeting.dao;

import com.epmeeting.module.IssueField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Administrator on 2016/1/29.
 */
public interface IssueFieldDao {
    public Logger logger = LoggerFactory.getLogger(UserDao.class);

    /**
     * 新增议题与领域对应关系
     * @param user ： 需要添加的用户
     * @return
     */
    public int add(IssueField user);

    /**
     * 根据议题或id查找相关的领域
     * @param issueid
     * @return
     */
    public List<IssueField> getbyissueid(int issueid);

    /**
     * 根据议题或id查找相关的领域
     * @param fieldid
     * @return
     */
    public List<IssueField> getbyfieldid(int fieldid);

    /**
     * 用户列表
     * @param index : 第几页
     * @param limit : 每页显示数目
     * @return
     */
    public List<IssueField> list(int index, int limit);

    /**
     * 删除用户
     * @param id : 用户id
     * @return
     */
    public int delete(int id);
}
