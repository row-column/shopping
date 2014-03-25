package com.shopping.domain.commodity.query;

import java.util.Date;

import com.shopping.common.util.page.BaseQuery;

/**
 * Commodity Information Query Class
 * @author WangYue
 *
 */
public class CommodityQuery extends BaseQuery {

	
	/**
	 * Commodity Code
	 */
	private String commodityCode;
	
	/**
	 * Commodity Name
	 */
	private String commodityName;
	
	
	/**
	 * Commodity category code
	 */
	private String categoryCode;
	
	/**
	 * commodity category name
	 */
	private String categoryName;
	
	/**
     * start time
     */
    private Date startTime;

    /**
     * end time
     */
    private Date endTime;

	
	/**
	 * yes or no Delete
	 */
	private int yn;
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
	
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getYn() {
		return yn;
	}
	public void setYn(int yn) {
		this.yn = yn;
	}
	
}
