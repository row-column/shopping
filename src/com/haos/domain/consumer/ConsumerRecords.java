package com.haos.domain.consumer;

import java.io.Serializable;
import java.util.Date;

/**
 * Consumer Records Information Value Class
 * @author WangYue
 *
 */
public class ConsumerRecords implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ID
	 */
	private Long id;
	
	/**
	 * User Code 
	 */
	private String userCode;
	
	/**
	 * Order Code
	 */
	private String orderCode;
	
	/**
	 * commodity id
	 */
	private Long commodityId;
	
	/**
	 * commodity code
	 */
	
	private String commodityCode;
	
	/**
	 * commodity name
	 */
	private String commodityName;
	
	/**
	 * Consumer Amount
	 */
	private Double amount;
	
	/**
	 * Consumer Time
	 */
	private Date consumerTime;
	
	/**
	 * Create Consumer Time
	 */
	private Date createTime;
	
	/**
	 * Update Consumer Time
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
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	
	public Long getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(Long commodityId) {
		this.commodityId = commodityId;
	}
	public String getCommodityCode() {
		return commodityCode;
	}
	public void setCommodityCode(String commodityCode) {
		this.commodityCode = commodityCode;
	}
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getConsumerTime() {
		return consumerTime;
	}
	public void setConsumerTime(Date consumerTime) {
		this.consumerTime = consumerTime;
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
