package com.haos.manager.send;

import java.util.List;

import com.haos.common.util.page.PageModel;
import com.haos.domain.send.Send;
import com.haos.domain.send.query.SendQuery;


/**
 * Send information manager interface
 * @author WangYue
 *
 */
public interface SendManager {

	/**
	 * add send information
	 * @param send   send value class
	 * @return true:success;false:fail
	 */
	public boolean addSend(Send send);
	
	/**
	 * update send information
	 * @param send  send value class
	 * @return true:success;false:fail
	 */
	public boolean updateSend(Send send);
	
	/**
	 * according to send id ,query send information.
	 * @param id  send id
	 * @return  Send  send value class
	 */
	public Send getSendById(Long id);
	
	/**
	 * according to send code ,query send information.
	 * @param sendCode  send code
	 * @return Send  send value class of List
	 */
	public List<Send> getSendBySendCode(String sendCode);
	
	/**
	 * query send information with page
	 * @param query Query send value class
	 * @return Send send value class
	 */
	public List<Send> querySendListWithUniqueByQueryBean(SendQuery sendQuery);
	
	/**
	 * query send information with page
	 * @param query Query send value class
	 * @return Send send value class
	 */
	public List<Send> querySendListByQueryBean(SendQuery sendQuery);
	
	/**
	 * query send information with page
	 * @param query Query send value class
	 * @return Send send vlalue class
	 */
	public PageModel<Send> querySendListPageByQueryBean(SendQuery sendQuery, int pageIndex, int pageSize);
	
	
	/**
	 * according to send id,delete send information.
	 * @param id  send id
	 * @return true:success;false:fail.
	 */
	public boolean deleteSendById(Long id);
	
	/**
	 * according to send ids,delete sends information.
	 * @param ids   send ids 
	 * @return  true:success;false:fail
	 */
	boolean deleteSendByIds(Long[] ids);
	
	/**
	 * get send records 
	 * @param sendQuery  Query send value class 
	 * @return send count 
	 */
	public int querySendCountByQueryBean(SendQuery sendQuery);

	
	
}
