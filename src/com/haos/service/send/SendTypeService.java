package com.haos.service.send;

import com.haos.common.util.page.ResultCollection;
import com.haos.domain.send.SendType;
import com.haos.domain.send.query.SendTypeQuery;

/**
 * SendType information service interface
 * @author WangYue
 *
 */
public interface SendTypeService {

	/**
	 * add sendType information
	 * @param sendType   sendType value class
	 * @return Result 
	 */
	public ResultCollection addSendType(SendType sendType);
	
	/**
	 * update sendType information
	 * @param sendType  sendType value class
	 * @return Result 
	 */
	public ResultCollection updateSendType(SendType sendType);
	
	/**
	 * according to sendType id ,query sendType information.
	 * @param id  sendType id
	 * @return  Result
	 */
	public ResultCollection getSendTypeById(Long id);
	
	/**
	 * according to sendType code ,query sendType information.
	 * @param sendTypeCode  sendType code
	 * @return Result
	 */
	public ResultCollection getSendTypeBySendTypeCode(String sendTypeCode);
	
	/**
	 * query sendType information with page
	 * @param query Query sendType value class
	 * @return Result
	 */
	public ResultCollection querySendTypeListByQueryBean(SendTypeQuery sendTypeQuery);
	
	/**
	 * query sendType information with page
	 * @param query Query sendType value class
	 * @return Result
	 */
	public ResultCollection querySendTypeListPageByQueryBean(SendTypeQuery sendTypeQuery, int pageIndex, int pageSize);
	
	
	/**
	 * according to sendType id,delete sendType information.
	 * @param id  sendType id
	 * @return Result .
	 */
	public ResultCollection deleteSendTypeById(Long id);
	
	/**
	 * according to sendType id,delete sendType information.
	 * @param ids  sendType id array
	 * @return Result .
	 */
	public ResultCollection deleteSendTypeByIds(Long[] id);
	
}
