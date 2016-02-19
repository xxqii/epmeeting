package com.epmeeting.service.impl;

import com.epmeeting.dao.ExpertDao;
import com.epmeeting.module.EpmExpert;
import com.epmeeting.service.ExpertService;
import com.epmeeting.utils.Page;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chqi on 2016/2/19.
 */
@Service("expertService")
public class ExpertServiceImpl implements ExpertService {

    @Autowired
    private ExpertDao expertDao;

    @Override
    public int add(EpmExpert expert) {
        return expertDao.add(expert);
    }

    @Override
    public List<EpmExpert> get(String email) {
        if(StringUtils.isBlank(email)) {
            return null;
        }
        return expertDao.get(email);
    }

    @Override
    public EpmExpert get(int id) {
        if(id <= 0) {
            return null;
        }
        return expertDao.get(id);
    }

    @Override
    public void update(EpmExpert expert) {
        expertDao.update(expert);
    }

    @Override
    public List<EpmExpert> list(Page page, String keyword) {
        try {
            int totalCount = expertDao.count(keyword);
            if(totalCount > 0) {
                page.setTotalCount(totalCount);
                int pageCount = totalCount/page.getPageSize();
                if(totalCount % page.getPageSize() != 0) {
                    ++pageCount;
                }
                page.setTotalPageCount(pageCount);
                return expertDao.list(page, keyword);
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.error("ExpertServiceImpl.list : error" , e);
            return null;
        }
    }

    @Override
    public int delete(int id) {
        if(id <= 0) {
            return 0;
        }
        return expertDao.delete(id);
    }

    public ExpertDao getExpertDao() {
        return expertDao;
    }

    public void setExpertDao(ExpertDao expertDao) {
        this.expertDao = expertDao;
    }
}
