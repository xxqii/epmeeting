package com.epmeeting.action;

import com.epmeeting.module.EpmUser;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by chqi on 2016/1/27.
 */
public class LoginInterceptor extends AbstractInterceptor {
    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    /**
     * 拦截器放行的uri
     */
    private String exclusiveUri = "/login.action";
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        if(request.getRequestURI().equals(exclusiveUri)) {
            return actionInvocation.invoke();
        }
        logger.info("LoginInterceptor: " + request.getRequestURI());
        Cookie[] cookies = request.getCookies();
        boolean isLogin = false;
        EpmUser user = null;
        for(Cookie cookie : cookies) {
            if(cookie.getName().equalsIgnoreCase("token")) {
                String token = cookie.getValue();
                Object obj = ServletActionContext.getRequest().getSession().getAttribute(token);
                if(obj != null) {
                    user = (EpmUser)obj;
                    isLogin = true;
                }
            }
        }
        if(isLogin) {
            request.setAttribute("__date__", sdf.format(new Date()));
            request.setAttribute("__current_username__", user.getRealName());
            request.setAttribute("__current_user__", user);
            return actionInvocation.invoke();
        } else {
            return "login";
        }
    }
}
