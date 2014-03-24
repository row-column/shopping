package com.haos.domain.send;

import java.io.Serializable;
import java.util.Date;


/**
 * Send information Value Class
 * @author WangYue
 *
 */
public class Send implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ID
	 */
	private Long id;
	
	/**
	 * send code
	 */
	private String sendCode;
	
	/**
	 * order code
	 */
	private String orderCode;
	
	/**
	 * commodity name
	 */
	private String commodityName;
	
	/**
	 * type code
	 */
	private String typeCode;
	
	/**
	 * type name
	 */
	private String typeName;
	
	/**
	 * carrier code
	 */
	private String carrierCode;
	
	/**
	 * 
	 */
	private String carrierName;
	
	/**
	 * deal time
	 */
	private Date dealTime;
	
	/**
	 * deal information
	 */
	private String dealInformation;
	
	/**
	 * operator
	 */
	private String operator;
	
	/**
	 * remark
	 */
	private String remark;
	
	/**
	 * create time
	 */
	private Date createTime;
	
	/**
	 * update time
	 */
	private Date updateTime;
	
	/**
	 * yes or no delete
	 */
	private int yn;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSendCode() {
		return sendCode;
	}
	public void setSendCode(String sendCode) {
		this.sendCode = sendCode;
	}
	
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
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
	public Date getDealTime() {
		return dealTime;
	}
	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}
	public String getDealInformation() {
		return dealInformation;
	}
	public void setDealInformation(String dealInformation) {
		this.dealInformation = dealInformation;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
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

