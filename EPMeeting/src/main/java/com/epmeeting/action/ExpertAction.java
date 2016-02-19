package com.epmeeting.action;

import com.epmeeting.module.EpmExpert;
import com.epmeeting.module.EpmUser;
import com.epmeeting.service.ExpertService;
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
 * 专家管理模块
 * Created by chqi on 2016/1/27.
 */
@Controller
public class ExpertAction extends ActionSupport {
    private Logger logger = LoggerFactory.getLogger(ExpertAction.class);
    private Page page;
    private EpmExpert expert;
    private List<EpmExpert> experts;
    private ResultCode resultCode;
    //查找关键字
    private String keyword;

    @Autowired
    private ExpertService expertService;

    /**
     * 跳转到添加用户界面
     * @return
     */
    public String addui() {
        return "addui";
    }

    /**
     * 添加专家
     * @return
     */
    public String add() {
        if(resultCode == null) {
            resultCode = new ResultCode();
        }

        if(expert == null) {
            resultCode.setMessage("请填写用户信息");
            return "addui";
        }
        if(StringUtils.isBlank(expert.getName())) {
            resultCode.setMessage("用户姓名不能为空");
            return "addui";
        }
        if(StringUtils.isBlank(expert.getEmail())) {
            resultCode.setMessage("用户邮箱不能为空");
            return "addui";
        }
        //判断用户名是否使用
        List<EpmExpert> tmpArray = expertService.get(expert.getEmail());
        if(tmpArray != null && tmpArray.size() > 0) {
            resultCode.setMessage("此用户名已被使用");
            return "addui";
        }
        expert.setCreateTime(new Date());
        expert.setCreator((String)ServletActionContext.getRequest().getAttribute("__current_username__"));
        int id = expertService.add(expert);
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
        experts = expertService.list(page, keyword);
        return "list";
    }

    /**
     * 编辑用户
     * @return
     */
    public String editui() {
        if(expert == null || expert.getId() <= 0) {
            return this.SUCCESS;
        }
        int id = expert.getId();
        expert = expertService.get(id);
        logger.info(expert.getName() + "    " + id);
        return "editui";
    }

    public String edit() {
        if(resultCode == null) {
            resultCode = new ResultCode();
        }

        if(StringUtils.isBlank(expert.getName())) {
            resultCode.setMessage("用户姓名不能为空");
            return null;
        }
        if(StringUtils.isBlank(expert.getEmail())) {
            resultCode.setMessage("用户邮箱不能为空");
            return null;
        }
        //判断用户名是否使用
        List<EpmExpert> array = expertService.get(expert.getEmail());
        if(array != null && array.size() > 0) {
            if(array.size() > 1 || (array.size() == 1 && array.get(0).getId() != expert.getId())) {
                resultCode.setMessage("此用户名已被使用");
                return null;
            }
        }
        expert.setCreateTime(new Date());
        expert.setCreator((String)ServletActionContext.getRequest().getAttribute("__current_username__"));
        expertService.update(expert);
        return this.SUCCESS;
    }

    /**
     * 删除用户
     * @return
     */
    public String delete(){
        expertService.delete(expert.getId());
        return this.SUCCESS;
    }


    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public EpmExpert getExpert() {
        return expert;
    }

    public void setExpert(EpmExpert expert) {
        this.expert = expert;
    }

    public List<EpmExpert> getExperts() {
        return experts;
    }

    public void setExperts(List<EpmExpert> experts) {
        this.experts = experts;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public ExpertService getExpertService() {
        return expertService;
    }

    public void setExpertService(ExpertService expertService) {
        this.expertService = expertService;
    }
}
