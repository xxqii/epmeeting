package com.epmeeting.action;

import com.epmeeting.module.EpmUser;
import com.epmeeting.service.UserService;
import com.epmeeting.utils.MD5Utils;
import com.epmeeting.utils.ResultCode;
import com.epmeeting.utils.UserType;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.Cookie;

/**
 * 控制用户登录
 * Created by chqi on 2016/1/27.
 */
@Controller
public class LoginAction extends ActionSupport {
    private Logger logger = LoggerFactory.getLogger(LoginAction.class);

    private EpmUser user;
    private ResultCode resultCode;

    @Autowired
    private UserService userService;

    /**
     * 处理用户登录
     *
     * @return
     * @throws Exception
     */
    public String login() {
        if(resultCode == null) {
            resultCode = new ResultCode();
        }

        //用户名为空
        if(user == null || StringUtils.isBlank(user.getEmail()) || StringUtils.isBlank(user.getPasswdMd5())) {
            resultCode.setMessage("用户名或密码不能为空");
            return this.LOGIN;
        }
        String email = user.getEmail().trim();
        String passwordMd5 = MD5Utils.encrypt(user.getPasswdMd5().trim());

        user = userService.get(email);
        if(user == null) {
            resultCode.setMessage("用户名或密码错误");
            return this.LOGIN;
        }

        if(!passwordMd5.equals(user.getPasswdMd5())) {
            resultCode.setMessage("用户名或密码错误");
            return this.LOGIN;
        } else {    //登录成功
            ServletActionContext.getRequest().getSession().setAttribute(passwordMd5, user);
            Cookie cookie = new Cookie("token", passwordMd5);
            ServletActionContext.getResponse().addCookie(cookie);   //将token放入cookie返回页面
            logger.info("Login:Success: " + email);
            return this.SUCCESS;
        }
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
}
