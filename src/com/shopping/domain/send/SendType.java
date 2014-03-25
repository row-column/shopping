package com.shopping.domain.send;

import java.io.Serializable;
import java.util.Date;

/**
 * �������ֵ��
 * @author WangYue
 *
 */
public class SendType implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * ID
	 */
	private Long id;
	/**
	 * ����������
	 */
	private String sendTypeCode;
	/**
	 * ����������
	 */
	private String sendTypeName;
	/**
	 * ���ͱ�ע
	 */
	private String remark;
	/**
	 * ���ʱ��
	 */
	private Date createTime;
	/**
	 * ����ʱ��
	 */
	private Date updateTime;
	/**
	 * �Ƿ�ɾ��
	 */
	private int yn;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSendTypeCode() {
		return sendTypeCode;
	}
	public void setSendTypeCode(String sendTypeCode) {
		this.sendTypeCode = sendTypeCode;
	}
	public String getSendTypeName() {
		return sendTypeName;
	}
	public void setSendTypeName(String sendTypeName) {
		this.sendTypeName = sendTypeName;
	}
	public String getRemark() {
		return remark.trim();
	}
	public void setRemark(String remark) {
		this.remark = remark.trim();
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
