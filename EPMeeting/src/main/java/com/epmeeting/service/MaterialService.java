package com.epmeeting.service;

import com.epmeeting.module.EpmMaterial;
import com.epmeeting.module.EpmUser;
import com.epmeeting.utils.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by chqi on 2016/1/26.
 */
public interface MaterialService {
    public Logger logger = LoggerFactory.getLogger(MaterialService.class);

    public int  add(EpmMaterial material);

    public List<EpmMaterial> list(Page page);
}
