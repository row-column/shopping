package com.haos.domain.employee.query;

import java.util.Date;

import com.haos.common.util.page.BaseQuery;
/**
 * Employee  query value class
 * @author WangYue
 *
 */

public class EmployeeQuery extends BaseQuery  {
	/**
	 * Employee code
	 */
	private String employeeCode;
	
	/**
	 * Employee name
	 */
	private String employeeName;
	
	/**
	 * Employee zip code
	 */
	private String zipCode;
	
	/**
	 * employee status
	 */
	private Byte status;
	
	/**
     * start time
     */
    private Date startTime;

    /**
     * end time
     */
    private Date endTime;

	
	/**
	 * employee yes or no delete
	 */
	private int yn;

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
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