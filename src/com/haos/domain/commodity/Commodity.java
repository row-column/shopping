package com.haos.domain.commodity;

import java.io.Serializable;
import java.util.Date;

/**
 * Commodity Information Value Class
 * @author WangYue
 *
 */
public class Commodity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * ID
	 */
	private Long id;
	/**
	 * Commodity Code
	 */
	private String commodityCode;
	/**
	 * Commodity Name
	 */
	private String commodityName;
	/**
	 * Commodity Category Code 
	 */
	private String categoryCode;
	
	/**
	 * Commodity Category name
	 */
	private String categoryName;
	
	/**
	 * Commodity qty
	 */
	private Long qty;
	/**
	 * Commodity price
	 */
	private Double price;
	
	/**
	 * Commodity new price
	 */
    private Double newPrice;
	 
	/**
	 * Sales Count
	 */
	private Long salesCount;
	
	/**
	 * viewed count
	 */
	private Long viewedCount;
	/**
	 * Commodity Comment Count
	 */
	private Long commentCount;
    
	/**
	 *  Commodity quick override
	 */
	private String quickOverride;
	
	/**
	 * Commodity Description
	 */
	private String description;
	
	/**
	 * Commodity specifications
	 */
	private String specifications;
	
	/**
	 * Commodity packing list
	 */
	private String packingList;
	
	/**
	 * commodity photo
	 */
	private String commodityPhoto;
	
	/**
	 * Commodity status
	 */
	private int status;
	
	/**
	 * Commodity Remark
	 */
	private String remark;
	
	/**
	 * Commodity Create Time
	 */
	private Date createTime;
	
	/**
	 * Commodity Update Time
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

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(Double newPrice) {
		this.newPrice = newPrice;
	}

	public Long getSalesCount() {
		return salesCount;
	}

	public void setSalesCount(Long salesCount) {
		this.salesCount = salesCount;
	}

	public Long getViewedCount() {
		return viewedCount;
	}

	public void setViewedCount(Long viewedCount) {
		this.viewedCount = viewedCount;
	}

	public Long getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}

	public String getQuickOverride() {
		return quickOverride;
	}

	public void setQuickOverride(String quickOverride) {
		this.quickOverride = quickOverride;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public String getPackingList() {
		return packingList;
	}

	public void setPackingList(String packingList) {
		this.packingList = packingList;
	}

	public String getCommodityPhoto() {
		return commodityPhoto;
	}

	public void setCommodityPhoto(String commodityPhoto) {
		this.commodityPhoto = commodityPhoto;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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
