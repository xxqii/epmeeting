package com.epmeeting.action;

import com.epmeeting.module.EpmMaterial;
import com.epmeeting.service.MaterialService;
import com.epmeeting.utils.Constant;
import com.epmeeting.utils.Page;
import com.epmeeting.utils.ResultCode;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;


/**
 * 用户管理模块
 * Created by chqi on 2016/1/27.
 */
@Controller
public class MaterialAction extends ActionSupport {
    private Logger logger = LoggerFactory.getLogger(MaterialAction.class);
    private File uploadFile;
    private String filename;
    private EpmMaterial material;
    private List<EpmMaterial> materialList;
    private ResultCode resultCode;
    private Page page;

    @Autowired
    private MaterialService materialService;

    public String list() {
        if(page == null) {
            page = new Page();
        }
        materialList = materialService.list(page);
        return "list";
    }

    /**
     * 跳转到添加用户界面
     * @return
     */
    public String uploadui() {
        return "uploadui";
    }

    /**
     * 文件上传
     */
    public void upload() {
        File destFile = new File(Constant.FILE_UPLOAD_PATH, filename);
        if(destFile.exists()) {
            destFile.delete();
            logger.info("file " + destFile.getName() + " exist , delete");
        }
        String destFileName = null;
        try {
            destFile.createNewFile();
            destFileName = destFile.getCanonicalPath();
            FileUtils.copyFile(uploadFile, destFile);
            logger.info("upload file : " + destFileName + " successed!");
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("upload file : " + destFileName + " failed!");
        }
    }

    /**
     * 添加资料到db
     * @return
     */
    public String add() {
        if(material == null) {
            resultCode.setMessage("请上传资料并填写资料信息");
            return "uploadui";
        }
        if(StringUtils.isBlank(material.getFilename())) {
            resultCode.setMessage("请先上传文件");
            return "uploadui";
        }
        if(material.getType() == 0) {
            resultCode.setMessage("请选择资料类型");
            return "uploadui";
        }
        if(material.getKeyword() == null) {
            resultCode.setMessage("请填写资料关键字");
            return "uploadui";
        }
        String tmpFileName = material.getFilename();
        if(StringUtils.isNotBlank(tmpFileName)) {
            String[] tmpNames = tmpFileName.split(",");
            Date createDate = new Date();
            String currentUser = (String) ServletActionContext.getRequest().getAttribute("__current_username__");
            for(String item : tmpNames) {
                EpmMaterial itemMaterial = new EpmMaterial();
                itemMaterial.setFilename(item);
                itemMaterial.setKeyword(material.getKeyword());
                itemMaterial.setNote(material.getNote());
                itemMaterial.setType(material.getType());
                itemMaterial.setCreateTime(createDate);
                itemMaterial.setCreator(currentUser);
                File f = new File(Constant.FILE_UPLOAD_PATH, item);
                itemMaterial.setSize(f.length());
                materialService.add(itemMaterial);
            }
        }
        return "add_success";
    }

    public File getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(File uploadFile) {
        this.uploadFile = uploadFile;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public EpmMaterial getMaterial() {
        return material;
    }

    public void setMaterial(EpmMaterial material) {
        this.material = material;
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

    public List<EpmMaterial> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<EpmMaterial> materialList) {
        this.materialList = materialList;
    }

    public MaterialService getMaterialService() {
        return materialService;
    }

    public void setMaterialService(MaterialService materialService) {
        this.materialService = materialService;
    }
}
