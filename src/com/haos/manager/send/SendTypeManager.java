package com.haos.manager.send;

import java.util.List;

import com.haos.common.util.page.PageModel;
import com.haos.domain.send.SendType;
import com.haos.domain.send.query.SendTypeQuery;


/**
 * SendType information manager interface
 * @author WangYue
 *
 */
public interface SendTypeManager {

	/**
	 * add sendType information
	 * @param sendType   sendType value class
	 * @return true:success;false:fail
	 */
	public boolean addSendType(SendType sendType);
	
	/**
	 * update sendType information
	 * @param sendType  sendType value class
	 * @return true:success;false:fail
	 */
	public boolean updateSendType(SendType sendType);
	
	/**
	 * according to sendType id ,query sendType information.
	 * @param id  sendType id
	 * @return  SendType  sendType value class
	 */
	public SendType getSendTypeById(Long id);
	
	/**
	 * according to sendType code ,query sendType information.
	 * @param sendTypeCode  sendType code
	 * @return SendType  sendType value class
	 */
	public SendType getSendTypeBySendTypeCode(String sendTypeCode);
	
	/**
	 * query sendType information with page
	 * @param query Query sendType value class
	 * @return SendType sendType value class
	 */
	public List<SendType> querySendTypeListByQueryBean(SendTypeQuery sendTypeQuery);
	
	/**
	 * query sendType information with page
	 * @param query Query sendType value class
	 * @return SendType sendType value class
	 */
	public PageModel<SendType> querySendTypeListPageByQueryBean(SendTypeQuery sendTypeQuery, int pageIndex, int pageSize);
	
	
	/**
	 * according to sendType id,delete sendType information.
	 * @param id  sendType id
	 * @return true:success;false:fail.
	 */
	public boolean deleteSendTypeById(Long id);
	
	/**
	 * according to sendType ids,delete sendType information.
	 * @param ids  sendType id array
	 * @return true:success;false:fail.
	 */
	public boolean deleteSendTypeByIds(Long[] id);
	
	
	/**
	 * get sendType records 
	 * @param query  Query sendType value class 
	 * @return sendType count 
	 */
	public int querySendTypeCountByQueryBean(SendTypeQuery sendTypeQuery);
	
	
}
