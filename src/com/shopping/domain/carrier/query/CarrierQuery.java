package com.shopping.domain.carrier.query;

import java.util.Date;

import com.shopping.common.util.page.BaseQuery;

/**
 * Carrier information query value class
 * @author WangYue
 *
 */
public class CarrierQuery extends BaseQuery {
	/**
	 * carrier id
	 */
	private int id;
	
	/**
	 * carrier code
	 */
	private String carrierCode;
	
	/**
	 * carrier name
	 */
	private String carrierName;
	
	private String contacter;
	
	/**
     * start time
     */
    private Date startTime;

    /**
     * end time
     */
    private Date endTime;
	
    /**
     * delete or not
     */
    private int  yn;

    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarrierCode() {
		return carrierCode;
	}

	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getContacter() {
		return contacter;
	}

	public void setContacter(String contacter) {
		this.contacter = contacter;
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
