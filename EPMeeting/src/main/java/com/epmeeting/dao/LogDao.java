package com.epmeeting.dao;
import com.epmeeting.module.EpmLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by zhy on 2016/1/29.
 */
public interface LogDao {
    public Logger logger = LoggerFactory.getLogger(LogDao.class);
    /**
     * 新增日志
     * @param log ： 需要添加的日志
     * @return
     */
    public int add(EpmLog log);

    /**
     * 根据日志类型查找日志
     * @param logType
     * @return
     */
    public List<EpmLog> get(String logType);

    /**
     * 日志列表
     * @param index : 第几页
     * @param limit : 每页显示数目
     * @return
     */
    public List<EpmLog> list(int index, int limit);

    /**
     * 删除日志
     * @param id : 日志id
     * @return
     */
    public int delete(int id);

}
