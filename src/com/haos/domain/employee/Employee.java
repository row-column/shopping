package com.haos.domain.employee;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
/**
 * employee  value class
 * @author WangYue
 *
 */

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * ID
	 */
	private Long id;
	
	/**
	 * employee code
	 */
	private String employeeCode;
	
	/**
	 * employee name
	 */
	private String employeeName;
	
	
	/**
	 * employee password
	 */
	private String password;
	
	/**
	 * employee sex
	 */
	private int sex;
	
	/**
	 * employee mobile
	 */
	private String mobile;
	
	/**
	 * employee email
	 */
	private String email;
	
	/**
	 * employee address
	 */
	private String address;
	
	/**
	 * zip code
	 */
	private String zipCode;
	
	
	/**
	 * employee id card
	 */
	private String idCard;
	
	/**
	 * employee birthday
	 */
	private Date birthday;
	
	
	/**
	 * Employee photo
	 */
	 private	File employeePhoto; 	
	/**
	 * 	Employee photo file name
	 */
	private String employeePhotoFileName;
		
	/**
	 * Employee photo content type
	 */
   private String employeePhotoContentType;	
	
	
	/**
	 * employee register date
	 */
	private Date reqDate;
	
	
	/**
	 * employee status
	 */
	private Byte status;
	/**
	 * employee create time
	 */
	private Date createTime;
	
	/**
	 * employee update time
	 */
	private Date updateTime;
	
	/**
	 * employee yes or no delete
	 */
	private int yn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	
	public File getEmployeePhoto() {
		return employeePhoto;
	}

	public void setEmployeePhoto(File employeePhoto) {
		this.employeePhoto = employeePhoto;
	}

	public String getEmployeePhotoFileName() {
		return employeePhotoFileName;
	}

	public void setEmployeePhotoFileName(String employeePhotoFileName) {
		this.employeePhotoFileName = employeePhotoFileName;
	}

	public String getEmployeePhotoContentType() {
		return employeePhotoContentType;
	}

	public void setEmployeePhotoContentType(String employeePhotoContentType) {
		this.employeePhotoContentType = employeePhotoContentType;
	}

	public Date getReqDate() {
		return reqDate;
	}

	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}
	

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
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