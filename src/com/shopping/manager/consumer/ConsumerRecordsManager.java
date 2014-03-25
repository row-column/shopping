package com.shopping.manager.consumer;

import java.util.List;

import com.shopping.common.util.page.PageModel;
import com.shopping.domain.consumer.ConsumerRecords;
import com.shopping.domain.consumer.query.ConsumerRecordsQuery;


/**
 * ConsumerRecords information manager interface
 * @author WangYue
 *
 */
public interface ConsumerRecordsManager {

	/**
	 * add consumerRecords information
	 * @param consumerRecords   consumer records value class
	 * @return true:success;false:fail
	 */
	public boolean addConsumerRecords(ConsumerRecords consumerRecords);
	
	/**
	 * update consumerRecords information
	 * @param consumerRecords  consumer records value class
	 * @return true:success;false:fail
	 */
	public boolean updateConsumerRecords(ConsumerRecords consumerRecords);
	
	/**
	 * according to consumerRecords id ,query consumerRecords information.
	 * @param id  consumerRecords id
	 * @return  ConsumerRecords  consumer records value class
	 */
	public ConsumerRecords getConsumerRecordsById(Long id);
	
	/**
	 * according to consumerRecords code ,query consumerRecords information.
	 * @param consumerRecordsCode  consumer records code
	 * @return ConsumerRecords  consumer records value class
	 */
	public ConsumerRecords getConsumerRecordsByConsumerRecordsCode(String consumerRecordsCode);
	
	/**
	 * query consumerRecords information with page
	 * @param query Query consumer records value class
	 * @return ConsumerRecords consumer records value class
	 */
	public List<ConsumerRecords> queryConsumerRecordsListByQueryBean(ConsumerRecordsQuery consumerRecordsQuery);
	
	/**
	 * query consumerRecords information with page
	 * @param query Query consumer records value class
	 * @return ConsumerRecords consumer records value class
	 */
	public PageModel<ConsumerRecords> queryConsumerRecordsListPageByQueryBean(ConsumerRecordsQuery consumerRecordsQuery, int pageIndex, int pageSize);
	
	
	/**
	 * according to consumerRecords id,delete consumer records information.
	 * @param id  consumerRecords id
	 * @return true:success;false:fail.
	 */
	public boolean deleteConsumerRecordsById(Long id);
	
	/**
	 * according to consumer records ids,delete consumer records information.
	 * @param ids consumer records ids
	 * @return true:success;false:fail.
	 */
	boolean deleteConsumerRecordsByIds(Long[] ids);
	
	/**
	 * get consumerRecords records 
	 * @param query  Query consumer records value class 
	 * @return consumerRecords count 
	 */
	public int queryConsumerRecordsCountByQueryBean(ConsumerRecordsQuery consumerRecordsQuery);

	
	
}
