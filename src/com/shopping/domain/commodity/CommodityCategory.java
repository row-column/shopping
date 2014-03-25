package com.shopping.domain.commodity;

import java.io.Serializable;
import java.util.Date;

/**
 * Commodity Category value class information
 * 
 * @author WangYue
 * 
 */
public class CommodityCategory implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * ID
	 */
	private Long id;
	/**
	 * Commodity category code
	 */
	private String commodityCategoryCode;
	/**
	 * Commodity category name
	 */
	private String commodityCategoryName;
	/**
	 * Commodity category remark
	 */
	private String remark;
	/**
	 * Commodity category create time
	 */
	private Date createTime;
	/**
	 * Commodity category update time
	 */
	private Date updateTime;
	/**
	 * delete flag
	 */
	private int yn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCommodityCategoryCode() {
		return commodityCategoryCode;
	}

	public void setCommodityCategoryCode(String commodityCategoryCode) {
		this.commodityCategoryCode = commodityCategoryCode;
	}

	public String getCommodityCategoryName() {
		return commodityCategoryName;
	}

	public void setCommodityCategoryName(String commodityCategoryName) {
		this.commodityCategoryName = commodityCategoryName;
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
