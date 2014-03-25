package com.shopping.domain.shoppingcart;

import java.io.Serializable;
import java.util.Date;

/**
 * Shopping Cart Information Value Class
 * @author WangYue
 *
 */
public class ShoppingCart implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * ID
	 */
	private Long id;
	/**
	 * User  Code 
	 */
	private String userCode;
	
	/**
	 * commodity id
	 */
	private Long commodityId;
	/**
	 * Commodity Code
	 */
	private String commodityCode;
	/**
	 * Commodity Name
	 */
	private String commodityName;
	
	/**
	 * Commodity price
	 */
	private Double price;
	
	 
	/**
	 * commodity num
	 */
	private Long commodityNum;
	
	/**
	 * commodity photo
	 */
	private String commodityPhoto;
	
	/**
	 * viewed count
	 */
	private Long viewedCount;
	/**
	 * Commodity Comment Count
	 */
	private Long commentCount;
	/**
	 * Commodity status
	 */
	private int status;
	
	/**
	 * Commodity Remark
	 */
	private String remark;
	
	/**
	 * Commodity Create Time
	 */
	private Date createTime;
	
	/**
	 * Commodity Update Time
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getCommodityNum() {
		return commodityNum;
	}

	public void setCommodityNum(Long commodityNum) {
		this.commodityNum = commodityNum;
	}

	public String getCommodityPhoto() {
		return commodityPhoto;
	}

	public void setCommodityPhoto(String commodityPhoto) {
		this.commodityPhoto = commodityPhoto;
	}

	public Long getViewedCount() {
		return viewedCount;
	}

	public void setViewedCount(Long viewedCount) {
		this.viewedCount = viewedCount;
	}

	public Long getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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
