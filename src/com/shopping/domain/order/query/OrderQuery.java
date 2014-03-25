package com.shopping.domain.order.query;

import java.util.Date;

import com.shopping.common.util.page.BaseQuery;

/**
 * Order Query Value Class
 * @author WangYue
 *
 */
public class OrderQuery extends BaseQuery{

	/**
	 * order code
	 */
	private String orderCode;
	
	/**
	 * commodity id
	 */
	private String commodityId;
	
	
	/**
	 * commodity code
	 */
	private String commodityCode;
	
	/**
	 * user code
	 */
	private String userCode;
	
	/**
	 * order status
	 */
	private int status;
	
	/**
	 * Employee code
	 */
	private String employeeCode;
	/**
	 * start time
	 */
	private Date startTime;
	
	/**
	 * end time
	 */
	private Date endTime;
	
	
	/**
	 * order yes or no delete
	 */
	private int yn;

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}

	public String getCommodityCode() {
		return commodityCode;
	}

	public void setCommodityCode(String commodityCode) {
		this.commodityCode = commodityCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
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
