package com.haos.domain.fun;

import java.io.Serializable;
import java.util.Date;
/**
 * User function value class
 * @author WangYue
 *
 */

public class UserFun implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
    private Long id;
    
    /**
     *  user code
     */
    private String userCode;
    
    /**
     * function code
     */
    private String funCode;
    /**
     * yes or not  read
     */
    private int isRead;
    
    /**
     * create time
     */
    private Date createTime;
    
    /**
     * update time
     */
    private Date updateTime;
    
    /**
     * yes or not  delete
     */
    private int yn;
    

    public int getYn() {
        return yn;
    }

    public void setYn(int yn) {
        this.yn = yn;
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

    public String getFunCode() {
        return funCode;
    }

    public void setFunCode(String funCode) {
        this.funCode = funCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRead() {
        return isRead;
    }

    public void setRead(int read) {
        isRead = read;
    }
}