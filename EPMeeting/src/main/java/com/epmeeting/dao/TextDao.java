package com.epmeeting.dao;

import com.epmeeting.module.EpmText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by 草帽boy on 2016/1/29.
 */
public interface TextDao {
    public Logger logger = LoggerFactory.getLogger(TextDao.class);

    /**
     * 添加一个文本记录消息
     * @param text
     * @return
     */
    public int addtest(EpmText text);

    /**
     * 分页查看所有text中的记录
     * @param index 当前页数
     * @param limit 每页数
     * @return
     */
    public List<EpmText> listtest(int index, int limit);

    /**
     * 删除操作
     * @param textid //文本id
     * @return
     */
    public int deltest(int textid);

    /**
     * 通过文本编号查找
     * @param textnumber
     * @return
     */
    public List<EpmText> gettext(String textnumber);
}
