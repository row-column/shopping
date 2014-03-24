package com.haos.domain.user.query;

import java.util.Date;

import com.haos.common.util.page.BaseQuery;

/**
 * User information query value class
 * @author WangYue
 *
 */
public class UserQuery extends BaseQuery {
	
	/**
	 * User code
	 */
	private String userCode;
	
	/**
	 * User name
	 */
	private String userName;
	
	/**
     * ��ʼʱ��
     */
    private Date startTime;

    /**
     * ����ʱ��
     */
    private Date endTime;

	
	/**
	 * user yes or no delete
	 */
	private int yn;

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
