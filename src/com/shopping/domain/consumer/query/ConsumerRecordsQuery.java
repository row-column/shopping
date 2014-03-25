package com.shopping.domain.consumer.query;

import java.util.Date;

import com.shopping.common.util.page.BaseQuery;


/**
 * Consumer Records Query Value Class
 * @author WangYue
 *
 */
public class ConsumerRecordsQuery extends BaseQuery{

	/**
	 * user Code
	 */
	private String userCode;
	
	/**
	 * order Code 
	 */
	private String orderCode;
	
	
	/**
	 * commodity code
	 */
	private String commodityCode;
	
	/**
	 * commodity id
	 */
	private Long commodityId;
	
	/**
	 * commodity name
	 */
	private String commodityName;
	/**
     * start time
     */
    private Date startTime;

    /**
     * end time
     */
    private Date endTime;

	
	/**
	 * yes or no delete
	 */
	private int yn;
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
