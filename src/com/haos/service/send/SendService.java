package com.haos.service.send;

import com.haos.common.util.page.ResultCollection;
import com.haos.domain.send.Send;
import com.haos.domain.send.query.SendQuery;

/**
 * Send information service interface
 * @author WangYue
 *
 */
public interface SendService {

	/**
	 * add send information
	 * @param send   send value class
	 * @return Result 
	 */
	public ResultCollection addSend(Send send);
	
	/**
	 * update send information
	 * @param send  send value class
	 * @return Result 
	 */
	public ResultCollection updateSend(Send send);
	
	/**
	 * according to send id ,query send information.
	 * @param id  send id
	 * @return  Result
	 */
	public ResultCollection getSendById(Long id);
	
	/**
	 * according to send code ,query send information.
	 * @param sendCode  send code
	 * @return Result
	 */
	public ResultCollection getSendBySendCode(String sendCode);
	
	/**
	 * query send information with page
	 * @param query Query send value class
	 * @return Result
	 */
	public ResultCollection querySendListWithUniqueByQueryBean(SendQuery sendQuery);
	/**
	 * query send information with page
	 * @param query Query send value class
	 * @return Result
	 */
	public ResultCollection querySendListByQueryBean(SendQuery sendQuery);
	
	/**
	 * query send information with page
	 * @param query Query send value class
	 * @return Result
	 */
	public ResultCollection querySendListPageByQueryBean(SendQuery sendQuery, int pageIndex, int pageSize);
	
	
	/**
	 * according to send id,delete send information.
	 * @param id  send id
	 * @return Result .
	 */
	public ResultCollection deleteSendById(Long id);

	/**
	 * according to send ids,delete sends information
	 * @param ids send ids
	 * @return Result
	 */
	public ResultCollection deleteSendByIds(Long[] ids);
	
}
