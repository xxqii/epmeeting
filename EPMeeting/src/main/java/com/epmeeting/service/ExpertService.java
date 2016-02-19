package com.epmeeting.service;

import com.epmeeting.module.EpmExpert;
import com.epmeeting.module.EpmUser;
import com.epmeeting.utils.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by chqi on 2016/1/26.
 */
public interface ExpertService {
    public Logger logger = LoggerFactory.getLogger(ExpertService.class);

    public int  add(EpmExpert expert);

    /**
     * 按照用户邮箱查找用户
     * @param email
     * @return
     */
    public List<EpmExpert> get(String email);

    public EpmExpert get(int id);

    public void update(EpmExpert expert);

    public List<EpmExpert> list(Page page, String keyword);

    public int delete(int id);
}
