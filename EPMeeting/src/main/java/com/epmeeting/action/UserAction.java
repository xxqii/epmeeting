package com.epmeeting.action;

import com.epmeeting.module.EpmUser;
import com.epmeeting.service.UserService;
import com.epmeeting.utils.MD5Utils;
import com.epmeeting.utils.Page;
import com.epmeeting.utils.ResultCode;
import com.epmeeting.utils.UserType;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;


/**
 * 用户管理模块
 * Created by chqi on 2016/1/27.
 */
@Controller
public class UserAction extends ActionSupport {
    private Logger logger = LoggerFactory.getLogger(UserAction.class);
    private Page page;
    private EpmUser user;
    private List<EpmUser> users;
    private ResultCode resultCode;

    @Autowired
    private UserService userService;

    /**
     * 跳转到首页
     * @return
     */
    public String homepage() {
        user = (EpmUser)ServletActionContext.getRequest().getAttribute("__current_user__");
        if(user == null) {
            return this.LOGIN;
        }

        UserType userType = UserType.get(user.getUserType());
        switch(userType) {
            case SYSTEM_ADMIN: return "system_admin";   //跳转到系统管理员界面
            default: return null;
        }
    }

    /**
     * 跳转到添加用户界面
     * @return
     */
    public String addui() {
        return "addui";
    }

    /**
     * 添加用户
     * @return
     */
    public String add() {
        if(resultCode == null) {
            resultCode = new ResultCode();
        }

        if(user == null) {
            resultCode.setMessage("请填写用户信息");
            return "addui";
        }
        if(StringUtils.isBlank(user.getRealName())) {
            resultCode.setMessage("用户姓名不能为空");
            return "addui";
        }
        if(StringUtils.isBlank(user.getEmail())) {
            resultCode.setMessage("用户邮箱不能为空");
            return "addui";
        }
        //判断用户名是否使用
        EpmUser tmp = userService.get(user.getEmail());
        if(tmp != null) {
            resultCode.setMessage("此用户名已被使用");
            return "addui";
        }
        user.setPasswdMd5(MD5Utils.getDefaultPasswd()); //设置初始密码
        user.setCreateTime(new Date());
        user.setCreator((String)ServletActionContext.getRequest().getAttribute("__current_username__"));
        int id = userService.add(user);
        if(id > 0) {
            return this.SUCCESS;
        } else {
            resultCode.setMessage("添加用户错误");
            return "addui";
        }
    }

    /**
     * 用户列表
     * @return
     */
    public String list() {
        if(page == null) {
            page = new Page();
        }
        users = userService.list(user, page);
        return "list";
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

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<EpmUser> getUsers() {
        return users;
    }

    public void setUsers(List<EpmUser> users) {
        this.users = users;
    }
}
