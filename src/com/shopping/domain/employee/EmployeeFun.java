package com.shopping.domain.employee;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * Employee function value class
 * @author WangYue
 *
 */

public class EmployeeFun implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
    private Long id;
    
    /**
     *  employee code
     */
    private String employeeCode;
    
    /**
     * function code
     */
    private String funCode;
    
    /**
     * employee fun codes
     */
    private List<String> employeeFunCodes;
    
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

    
    public List<String> getEmployeeFunCodes() {
		return employeeFunCodes;
	}

	public void setEmployeeFunCodes(List<String> employeeFunCodes) {
		this.employeeFunCodes = employeeFunCodes;
	}

	public int getIsRead() {
		return isRead;
	}

	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}

	public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
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