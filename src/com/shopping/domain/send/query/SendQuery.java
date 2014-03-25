package com.shopping.domain.send.query;

import java.util.Date;

import com.shopping.common.util.page.BaseQuery;

/**
 * send information query value class
 * @author WangYue
 *
 */
public class SendQuery extends BaseQuery {

	/**
	 * send code
	 */
	private String sendCode;
	
	/**
	 * order code
	 */
	private String orderCode;
	
	/**
	 * type code
	 */
	private String typeCode;
	
	/**
	 * carrier code
	 */
	private String carrierCode;
	
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

	public String getSendCode() {
		return sendCode;
	}

	public void setSendCode(String sendCode) {
		this.sendCode = sendCode;
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
