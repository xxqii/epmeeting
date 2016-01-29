package com.epmeeting.action;

import com.epmeeting.module.User;
import com.epmeeting.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;

/**
 * Created by chqi on 2016/1/26.
 */
@Repository
public class UserAction extends ActionSupport {
    private Logger logger = LoggerFactory.getLogger(UserAction.class);
    @Resource
    private UserService userService;

    /**
     * 添加用户
     * @return
     * @throws Exception
     */
    public String addUser() throws Exception {
        System.out.println("-----UserAction.addUser()-----");
        User user = new User();
        user.setAvatar("http://img1.imgtn.bdimg.com/it/u=2282547951,3816622274&fm=21&gp=0.jpg");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(sdf.parse("2016-01-20"));
        user.setPasswdMd5("123456");
        user.setRealName("张三");
        user.setRoleIds("1,2,3,");
        user.setUserName("zhangsan@hbut.com");
        user.setUserType((short)0);
        int result = userService.addUser(user);
        logger.info("save user finished : result=" + result);
        return SUCCESS;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
