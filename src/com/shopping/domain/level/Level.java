package com.shopping.domain.level;

import java.io.Serializable;
import java.util.Date;

/**
 * Level information class value
 * @author WangYue
 *
 */
public class Level implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ID
	 */
	private Long id;
	
	/**
	 * Level Code
	 */
	private String levelCode;
	
	/**
	 * Level Name
	 */
	private String levelName;

	/**
	 * start point
	 */
	private Long startPoint;
	
	/**
	 * end point
	 */
	private Long endPoint;
	
	/**
	 * Level Remark
	 */
	private String remark;
	
	/**
	 * Level Create Time
	 */
	private Date createTime;
	
	/**
	 * Level Update Time
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
	public String getLevelCode() {
		return levelCode;
	}
	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	
	public Long getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(Long startPoint) {
		this.startPoint = startPoint;
	}
	public Long getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(Long endPoint) {
		this.endPoint = endPoint;
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
