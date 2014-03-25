package com.shopping.domain.recentlyviewed;

import java.io.Serializable;
import java.util.Date;

/**
 * Recently Viewed Information Value Class
 * @author WangYue
 *
 */
public class RecentlyViewed implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * recently viewed id
	 */
	private Long id;
	/**
	 * user  code 
	 */
	private String userCode;
	
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
	 * Commodity price
	 */
	private Double price;
	
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
	 * is read
	 */
	private int isRead;
	
	/**
	 * Commodity status
	 */
	private int status;
	
	/**
	 *  create time
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public int getIsRead() {
		return isRead;
	}

	public void setIsRead(int isRead) {
		this.isRead = isRead;
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
