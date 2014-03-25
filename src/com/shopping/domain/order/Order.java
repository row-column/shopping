package com.shopping.domain.order;

import java.io.Serializable;
import java.util.Date;

/**
 * Order information value class
 * 
 * @author WangYue
 * 
 */
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * ID
	 */
	private Long id;

	/**
	 * Order Code
	 */
	private String orderCode;

	/**
	 * commodity id
	 * 
	 */
	private Long commodityId;

	/**
	 * Commodity Code
	 */
	private String commodityCode;

	/**
	 * Commodity Name
	 */
	private String commodityName;

	/**
	 * Commodity Count
	 */
	private Long commodityCount;

	/**
	 * amount
	 */
	private double amount;

	/**
	 * Order Time
	 */
	private Date orderTime;

	/**
	 * User Code
	 */
	private String userCode;

	/**
	 * User Name
	 */

	private String userName;

	/**
	 * consignee
	 */
	private String consignee;

	/**
	 * User address
	 */
	private String address;

	/**
	 * User mobile
	 */
	private String mobile;

	/**
	 * User email
	 */
	private String email;

	/**
	 * user zip code
	 */
	private String zipCode;

	/**
	 * payment method
	 */
	private int paymentMethod;

	/**
	 * shipping method
	 */
	private int shippingMethod;
	
	
	/**
	 * type code
	 */
	private String typeCode;
	
	/**
	 * carrier code
	 */
	private String carrierCode;

	/**
	 * Order status
	 */
	private int status;

	/**
	 * employee code
	 */
	private String employeeCode;
	/**
	 * Order remark
	 */
	private String remark;

	/**
	 * Order create time
	 */
	private Date createTime;

	/**
	 * order update time
	 */
	private Date updateTime;

	/**
	 * order yes or no delete
	 */
	private int yn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getCommodityCount() {
		return commodityCount;
	}

	public void setCommodityCount(Long commodityCount) {
		this.commodityCount = commodityCount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public int getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(int paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public int getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(int shippingMethod) {
		this.shippingMethod = shippingMethod;
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
