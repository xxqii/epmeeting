package com.epmeeting.service.impl;

import com.epmeeting.dao.MaterialDao;
import com.epmeeting.module.EpmMaterial;
import com.epmeeting.service.MaterialService;
import com.epmeeting.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chqi on 2016/1/26.
 */
@Service("materialService")
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    private MaterialDao materialDao;

    @Override
    public int add(EpmMaterial material) {
        return materialDao.add(material);
    }

    @Override
    public List<EpmMaterial> list(Page page) {
        try {
            int totalCount = materialDao.count();
            if(totalCount > 0) {
                page.setTotalCount(totalCount);
                int pageCount = totalCount/page.getPageSize();
                if(totalCount % page.getPageSize() != 0) {
                    ++pageCount;
                }
                page.setTotalPageCount(pageCount);
                return materialDao.list(page);
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.error("UserServiceImpl.list : error" , e);
            return null;
        }
    }
}
