package com.shopping.service.consumer;

import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.consumer.ConsumerRecords;
import com.shopping.domain.consumer.query.ConsumerRecordsQuery;

/**
 * ConsumerRecords information service interface
 * @author WangYue
 *
 */
public interface ConsumerRecordsService {

	/**
	 * add consumerRecords information
	 * @param consumerRecords   consumer records value class
	 * @return Result 
	 */
	public ResultCollection addConsumerRecords(ConsumerRecords consumerRecords);
	
	/**
	 * update consumerRecords information
	 * @param consumerRecords  consumer records value class
	 * @return Result 
	 */
	public ResultCollection updateConsumerRecords(ConsumerRecords consumerRecords);
	
	/**
	 * according to consumerRecords id ,query consumer records information.
	 * @param id  consumer records id
	 * @return  Result
	 */
	public ResultCollection getConsumerRecordsById(Long id);
	
	/**
	 * according to consumerRecords code ,query consumerRecords information.
	 * @param consumerRecordsCode  consumer records code
	 * @return Result
	 */
	public ResultCollection getConsumerRecordsByConsumerRecordsCode(String consumerRecordsCode);
	
	/**
	 * query consumerRecords information with page
	 * @param query Query consumer records value class
	 * @return Result
	 */
	public ResultCollection queryConsumerRecordsListByQueryBean(ConsumerRecordsQuery consumerRecordsQuery);
	
	/**
	 * query consumerRecords information with page
	 * @param query Query consumer records value class
	 * @return Result
	 */
	public ResultCollection queryConsumerRecordsListPageByQueryBean(ConsumerRecordsQuery consumerRecordsQuery, int pageIndex, int pageSize);
	
	
	/**
	 * according to consumerRecords id,delete consumer records information.
	 * @param id  consumerRecords id
	 * @return Result .
	 */
	public ResultCollection deleteConsumerRecordsById(Long id);

	/**
	 * according to consumer records ids,delete consumer records information
	 * @param ids consumer records ids
	 * @return true:succes;false:fail.
	 */
	ResultCollection deleteConsumerRecordsByIds(Long[] ids);
	
}
