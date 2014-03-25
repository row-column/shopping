package com.shopping.domain.send.query;

import java.io.Serializable;

import com.shopping.common.util.page.BaseQuery;

/**
 * �̳�����ѯBean
 * @author WangYue
 *
 */
public class SendTypeQuery extends BaseQuery implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ����������
	 */
	private String sendTypeCode;
	/**
	 * �����������
	 */
	private String sendTypeName;
	/**
	 * �Ƿ�ɾ��
	 */
	private int yn;
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
	public int getYn() {
		return yn;
	}
	public void setYn(int yn) {
		this.yn = yn;
	}
	
	
}
