package com.haos.domain.carrier;

import java.io.Serializable;
import java.util.Date;

/**
 * Carrier value class
 * @author WangYue
 *
 */
public class Carrier implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
    private Long id;
    
    /**
     * carrier code
     */
    private String carrierCode;
    
    /**
     * carrier name
     */
    private String carrierName;
    
    /**
     * carrier mobile
     */
    private String mobile;
    
    /**
     * carrier email
     */
    private String email;
    

    /**
     * carrier contact
     */
    private String contacter;
    
    /**
     * carrier addess
     */
    private String address;
    /**
     * carrier remark
     */
    private String remark;
     
    /**
     * carrier create time
     */
    private Date createTime;
    
    /**
     * carrier update time
     */
    private Date updateTime;
    
    /**
     * carrier is delete
     */
    private int yn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCarrierCode() {
		return carrierCode;
	}

	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContacter() {
		return contacter;
	}

	public void setContacter(String contacter) {
		this.contacter = contacter;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
    
    
}