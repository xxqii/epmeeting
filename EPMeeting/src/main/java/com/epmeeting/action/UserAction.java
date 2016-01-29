package com.epmeeting.action;

import com.epmeeting.module.EpmUser;
import com.epmeeting.module.Result;
import com.epmeeting.service.UserService;
import com.epmeeting.utils.UserType;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

/**
 * 用户管理模块
 * Created by chqi on 2016/1/27.
 */
@Controller
public class UserAction extends ActionSupport {
    private Logger logger = LoggerFactory.getLogger(UserAction.class);
    private EpmUser user;

    private Result result;

    @Autowired
    private UserService userService;

    /**
     * 用户列表
     * @return
     */
    public String list() {
        logger.info("UserAction.list");
        return "list";
    }


    /**
     * 处理用户登出
     *
     * @return
     */
    public String logout() {
        return this.SUCCESS;
    }

    public EpmUser getUser() {
        return user;
    }

    public void setUser(EpmUser user) {
        this.user = user;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
