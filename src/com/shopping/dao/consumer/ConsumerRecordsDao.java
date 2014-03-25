package com.shopping.dao.consumer;

import java.util.List;

import com.shopping.domain.consumer.ConsumerRecords;
import com.shopping.domain.consumer.query.ConsumerRecordsQuery;


/**
 * ConsumerRecords information DAO interface
 * @author WangYue
 *
 */
public interface ConsumerRecordsDao {

	/**
	 * add consumerRecords information
	 * @param consumerRecords   consumerRecords value class
	 * @return true:success;false:fail
	 */
	public boolean addConsumerRecords(ConsumerRecords consumerRecords);
	
	/**
	 * update consumerRecords information
	 * @param consumerRecords  consumerRecords value class
	 * @return true:success;false:fail
	 */
	public boolean updateConsumerRecords(ConsumerRecords consumerRecords);
	
	/**
	 * according to consumerRecords id ,query consumerRecords information.
	 * @param id  consumerRecords id
	 * @return  ConsumerRecords  consumerRecords value class
	 */
	public ConsumerRecords getConsumerRecordsById(Long id);
	
	/**
	 * according to consumerRecords code ,query consumerRecords information.
	 * @param consumerRecordsCode  consumerRecords code
	 * @return ConsumerRecords  consumerRecords value class
	 */
	public ConsumerRecords getConsumerRecordsByConsumerRecordsCode(String consumerRecordsCode);
	
	/**
	 * query all consumerRecords information
	 * @param query  Query consumerRecords value class
	 * @return ConsumerRecords  consumerRecords value class
	 */
	public List<ConsumerRecords> queryConsumerRecordsListByQueryBean(ConsumerRecordsQuery consumerRecordsQuery);
	
	/**
	 * query consumerRecords information with page
	 * @param query Query consumerRecords value class
	 * @return ConsumerRecords consumerRecords value class
	 */
	public List<ConsumerRecords> queryConsumerRecordsListPageByQueryBean(ConsumerRecordsQuery consumerRecordsQuery);
	
	/**
	 * according to consumerRecords id,delete consumerRecords information.
	 * @param id  consumerRecords id
	 * @return true:success;false:fail.
	 */
	public boolean deleteConsumerRecordsById(Long id);
	
	/**
	 * get consumerRecords records 
	 * @param query  Query consumerRecords value class 
	 * @return consumerRecords count 
	 */
	public int queryConsumerRecordsCountByQueryBean(ConsumerRecordsQuery consumerRecordsQuery);
	
	
}
