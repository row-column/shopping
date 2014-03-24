package com.haos.domain.fun;

import java.io.Serializable;
import java.util.Date;

/**
 * Function value class
 * @author Administrator
 *
 */
public class Fun implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
    private Long id;
    
    /**
     * function code
     */
    private String funCode;
    
    /**
     * function name
     */
    private String funName;
    
    /**
     * function type
     */
    private int funType;
    
    /**
     * function url name
     */
    private String urlName;
    
    /**
     * function url param
     */
    private String urlParam;
    
    /**
     * function url order
     */
    private int urlOrder;
    
    /**
     * function  status
     */
    private int isStatus;
    
    /**
     * function parent code
     */
    private String parentCode;
    
    /**
     * belong to function system
     */
    private int funSystem;

    
    /**
     * function remark
     */
    private String remark;
     
    /**
     * function create time
     */
    private Date createTime;
    
    /**
     * function update time
     */
    private Date updateTime;
    
    /**
     * function is delete
     */
    private int yn;
    
  
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFunCode() {
        return funCode;
    }

    public void setFunCode(String funCode) {
        this.funCode = funCode;
    }

    public String getFunName() {
        return funName;
    }

    public void setFunName(String funName) {
        this.funName = funName;
    }

    public int getFunType() {
        return funType;
    }

    public void setFunType(int funType) {
        this.funType = funType;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public String getUrlParam() {
        return urlParam;
    }

    public void setUrlParam(String urlParam) {
        this.urlParam = urlParam;
    }

    public int getUrlOrder() {
        return urlOrder;
    }

    public void setUrlOrder(int urlOrder) {
        this.urlOrder = urlOrder;
    }

    public int getStatus() {
        return isStatus;
    }

    public void setStatus(int status) {
        isStatus = status;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getYn() {
        return yn;
    }

    public void setYn(int yn) {
        this.yn = yn;
    }

    public int getFunSystem() {
        return funSystem;
    }

    public void setFunSystem(int funSystem) {
        this.funSystem = funSystem;
    }

	public int getIsStatus() {
		return isStatus;
	}

	public void setIsStatus(int isStatus) {
		this.isStatus = isStatus;
	}
    
    
}