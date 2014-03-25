package com.shopping.domain.commodity.query;

import java.io.Serializable;
import java.util.Date;

import com.shopping.common.util.page.BaseQuery;

/**
 * �̳�����ѯBean
 * @author WangYue
 *
 */
public class CommodityCategoryQuery extends BaseQuery implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ��Ʒ������
	 */
	private String commodityCategoryCode;
	/**
	 * ��Ʒ�������
	 */
	private String commodityCategoryName;
	
	/**
	 * start time
	 */
	private Date startTime;
	
	/**
	 * end time
	 */
	
	private Date endTime;
	/**
	 * �Ƿ�ɾ��
	 */
	private int yn;
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
