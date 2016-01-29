package com.epmeeting.action;

import com.epmeeting.module.EpmUser;
import com.epmeeting.module.Result;
import com.epmeeting.service.UserService;
import com.epmeeting.utils.UserType;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang.StringUtils;
import org.apache.cxf.transport.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

/**
 * 控制用户登录
 * Created by chqi on 2016/1/27.
 */
@Controller
public class LoginAction extends ActionSupport {
    private Logger logger = LoggerFactory.getLogger(LoginAction.class);
    private EpmUser user;

    private Result result;

    @Autowired
    private UserService userService;

    /**
     * 处理用户登录
     *
     * @return
     * @throws Exception
     */
    public String login() {
        logger.info("LoginAction : username=" + user.getUserName() + ", passwd=" + user.getPasswdMd5());
        if(result == null) {
            result = new Result();
        }

        //用户名为空
        if(user == null || StringUtils.isBlank(user.getUserName()) || StringUtils.isBlank(user.getPasswdMd5())) {
            result.setMessage("用户名和密码不能为空");
            return this.LOGIN;
        }
        List<EpmUser> users = userService.get(user.getUserName());
        if(users != null && users.size() == 1) {
            EpmUser _user = users.get(0);
            if(_user.getPasswdMd5().equals(user.getPasswdMd5())) {
                //登录成功，标记session
                Map<String, Object> session = ActionContext.getContext().getSession();
                logger.info("LoginAction:success:" + _user.getUserName(), _user.getUserType());
                session.put(_user.getUserName(), _user.getUserType());
                UserType userType = UserType.get(_user.getUserType());
                switch(userType) {
                    case SYSTEM_ADMIN: return "system_admin";  //超级管理员首页
                    default: return this.LOGIN;
                }
            }
        }
        result.setMessage("用户名或者密码不正确");
        return this.LOGIN;
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
