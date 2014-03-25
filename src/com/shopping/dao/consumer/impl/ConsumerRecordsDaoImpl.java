package com.shopping.dao.consumer.impl;

import java.util.List;

import com.shopping.common.util.dao.BaseDao;
import com.shopping.dao.consumer.ConsumerRecordsDao;
import com.shopping.domain.consumer.ConsumerRecords;
import com.shopping.domain.consumer.query.ConsumerRecordsQuery;

/**
 * ConsumerRecords information DAO implementation
 * @author WangYue
 *
 */
@SuppressWarnings("rawtypes")
public class ConsumerRecordsDaoImpl extends BaseDao implements ConsumerRecordsDao {

	@SuppressWarnings("unchecked")
	@Override
	public boolean addConsumerRecords(ConsumerRecords consumerRecords) {
		return this.insert("ConsumerRecords.insert", consumerRecords);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updateConsumerRecords(ConsumerRecords consumerRecords) {
		return this.update("ConsumerRecords.update", consumerRecords);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ConsumerRecords getConsumerRecordsById(Long id) {
		return (ConsumerRecords)this.queryForObject("ConsumerRecords.getConsumerRecordsById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ConsumerRecords getConsumerRecordsByConsumerRecordsCode(String consumerRecordsCode) {
		return (ConsumerRecords)this.queryForObject("ConsumerRecords.getConsumerRecordsByConsumerRecordsCode", consumerRecordsCode);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ConsumerRecords> queryConsumerRecordsListByQueryBean(ConsumerRecordsQuery consumerRecordsQuery) {
		return this.queryForList("ConsumerRecords.queryConsumerRecordsListByQueryBean",consumerRecordsQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ConsumerRecords> queryConsumerRecordsListPageByQueryBean(ConsumerRecordsQuery consumerRecordsQuery) {
		return this.queryForList("ConsumerRecords.queryConsumerRecordsListPageByQueryBean", consumerRecordsQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteConsumerRecordsById(Long id) {
		return this.delete("ConsumerRecords.deleteConsumerRecordsById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int queryConsumerRecordsCountByQueryBean(ConsumerRecordsQuery consumerRecordsQuery) {
		return (Integer)this.queryForObject("ConsumerRecords.queryConsumerRecordsCountByQueryBean", consumerRecordsQuery);
	}

}
