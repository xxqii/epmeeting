package com.epmeeting.dao;

import com.epmeeting.module.EpmField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Administrator on 2016/1/29.
 */
public interface FieldDao {
    public Logger logger = LoggerFactory.getLogger(UserDao.class);

    /**
     * 新增领域
     * @param field ： 需要增加的领域       //  参数说明
     * @return                              //说明该方法有返回值
     */
    public void add(EpmField field);

    /**
     * 根据领域名查找领域
     * @param fieldname
     * @return
     */
    public List<EpmField> get(String fieldname);

    /**
     * 领域列表
     * @param index : 第几页
     * @param limit : 每页显示数目
     * @return
     */
    public List<EpmField> list(int index, int limit);

    /**
     * 删除领域
     * @param id : 领域id
     * @return
     */
    public int delete(int id);
}
