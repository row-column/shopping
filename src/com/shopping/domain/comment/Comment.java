package com.shopping.domain.comment;

import java.io.Serializable;
import java.util.Date;

/**
 * Comment Information Value Class
 * @author WangYue
 *
 */
public class Comment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 * ID
	 */
	private Long id;
	
	/**
	 * Comment Title
	 */
	private String title;
	
	/**
	 * Commodity Advantage
	 */
	private String advantage;
	
	/**
	 * Commodity ShortComming
	 */
	private String shortcoming;
	
	/**
	 * Commodity UsageExperience
	 */
	private String usageExperience;
	
	/**
	 * Commodity Comment Time
	 */
	private Date commentTime;
	
	/**
	 * commodity id
	 */
	private Long commodityId;
	
	/**
	 * Commodity code
	 */
	private String commodityCode;
	
	/**
	 * Commodity name
	 */
	private String commodityName;
	
	/**
	 * User Code
	 */
	private String userCode;
	
	/**
	 * Comment Create Time
	 */
	private Date createTime;
	
	/**
	 * Comment Update Time
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAdvantage() {
		return advantage;
	}
	public void setAdvantage(String advantage) {
		this.advantage = advantage;
	}
	
	public String getShortcoming() {
		return shortcoming;
	}
	public void setShortcoming(String shortcoming) {
		this.shortcoming = shortcoming;
	}
	public String getUsageExperience() {
		return usageExperience;
	}
	public void setUsageExperience(String usageExperience) {
		this.usageExperience = usageExperience;
	}
	public Date getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
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
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
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