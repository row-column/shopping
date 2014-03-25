package com.shopping.domain.comment.query;

import java.util.Date;

import com.shopping.common.util.page.BaseQuery;
/**
 * Comment Information Query Class
 * @author WangYue
 *
 */
public class CommentQuery extends BaseQuery {

	/**
	 * Comment Title
	 */
	private String title;
	
	/**
	 * commodity id
	 */
	private Long commodityId;
	
	/**
	 * commodity code
	 */
	private String commodityCode;
	
	/**
	 * commodity name
	 */
	private String commodityName;
	
	/**
	 * User Code
	 */
	private String userCode;
	
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
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
