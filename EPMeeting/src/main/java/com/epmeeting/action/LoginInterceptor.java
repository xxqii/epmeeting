package com.epmeeting.action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by chqi on 2016/1/27.
 */
public class LoginInterceptor extends AbstractInterceptor {
    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
//        HttpServletRequest request = ServletActionContext.getRequest();
//        String userName = request.getParameter("username");
//        String passwd = request.getParameter("passwd");
//        logger.info("interceptor : action=" + request.getRequestURI() + ", userName=" + userName + ", passwd=" + passwd);
//        if(userName.equals("a") && passwd.equals("b")) {
//            return actionInvocation.invoke();
//        } else {
//            return "login";
//        }

        return actionInvocation.invoke();
    }
}
