package com.haos.service.consumer.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.haos.common.util.CommonConstant;
import com.haos.common.util.page.ResultCollection;
import com.haos.domain.consumer.ConsumerRecords;
import com.haos.domain.consumer.query.ConsumerRecordsQuery;
import com.haos.manager.consumer.ConsumerRecordsManager;
import com.haos.service.consumer.ConsumerRecordsService;

/**
 * ConsumerRecords information service interface
 * @author WangYue
 *
 */
public class ConsumerRecordsServiceImpl implements ConsumerRecordsService {
	  /**
     * ��־
     */
    private static final Logger log = LogManager.getLogger(ConsumerRecordsServiceImpl.class);
	private ConsumerRecordsManager consumerRecordsManager;
	@Override
	public ResultCollection addConsumerRecords(ConsumerRecords consumerRecords) {
		 ResultCollection result = new ResultCollection();
	        try {
	        	consumerRecords.setCreateTime(new Date());
                consumerRecords.setUpdateTime(new Date());
                consumerRecords.setConsumerTime(new Date());
                consumerRecords.setYn(CommonConstant.YN_NO_DELETE);
	            boolean resultFlag = consumerRecordsManager.addConsumerRecords(consumerRecords);
	            result.addDefaultModel("resultFlag", resultFlag);
	            result.setSuccess(true);
	        } catch (Exception e) {
	            log.error("ConsumerRecordsServiceImpl -> addConsumerRecords() error!!", e);
	        }
	        return result;
	}

	@Override
	public ResultCollection updateConsumerRecords(ConsumerRecords consumerRecords) {
		 ResultCollection result = new ResultCollection();
	        try {
	        	 consumerRecords.setUpdateTime(new Date());
	             consumerRecords.setConsumerTime(new Date());
	            boolean resultFlag = consumerRecordsManager.updateConsumerRecords(consumerRecords);
	            result.addDefaultModel("resultFlag", resultFlag);
	            result.setSuccess(true);
	        } catch (Exception e) {
	            log.error("ConsumerRecordsServiceImpl -> updateConsumerRecords() error!!", e);
	        }
	        return result;
	}

	@Override
	public ResultCollection getConsumerRecordsById(Long id) {
		 ResultCollection result = new ResultCollection();
	        try {
	            ConsumerRecords consumerRecords = consumerRecordsManager.getConsumerRecordsById(id);
	            result.addDefaultModel("consumerRecords", consumerRecords);
	            result.setSuccess(true);
	        } catch (Exception e) {
	            log.error("ConsumerRecordsServiceImpl -> getConsumerRecordsById() error!!", e);
	        }
	        return result;
	}

	@Override
	public ResultCollection getConsumerRecordsByConsumerRecordsCode(String consumerRecordsCode) {
		 ResultCollection result = new ResultCollection();
	        try {
	            ConsumerRecords consumerRecords = consumerRecordsManager.getConsumerRecordsByConsumerRecordsCode(consumerRecordsCode);
	            result.addDefaultModel("consumerRecords", consumerRecords);
	            result.setSuccess(true);
	        } catch (Exception e) {
	            log.error("ConsumerRecordsServiceImpl -> getConsumerRecordsByConsumerRecordsCode() error!!", e);
	        }
	        return result;
	}

	@Override
	public ResultCollection queryConsumerRecordsListByQueryBean(ConsumerRecordsQuery consumerRecordsQuery) {
		ResultCollection result = new ResultCollection();
        try {
            List<ConsumerRecords> consumerRecordsList = consumerRecordsManager.queryConsumerRecordsListByQueryBean(consumerRecordsQuery);
            result.addDefaultModel("consumerRecordsList", consumerRecordsList);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("ConsumerRecordsServiceImpl -> queryConsumerRecordsListByQueryBean() error!!", e);
        }
        return result;
	}

	@Override
	public ResultCollection queryConsumerRecordsListPageByQueryBean(ConsumerRecordsQuery consumerRecordsQuery,
			int pageIndex, int pageSize) {
		ResultCollection result = new ResultCollection();
        try {
            List<ConsumerRecords> consumerRecordsList = consumerRecordsManager.queryConsumerRecordsListPageByQueryBean(consumerRecordsQuery,pageIndex,pageSize);
            result.addDefaultModel("consumerRecordsList", consumerRecordsList);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("ConsumerRecordsServiceImpl -> queryConsumerRecordsListPageByQueryBean() error!!", e);
        }
        return result;
	}

	@Override
	public ResultCollection deleteConsumerRecordsById(Long id) {
		 ResultCollection result = new ResultCollection();
	        try {
	            boolean resultFlag = consumerRecordsManager.deleteConsumerRecordsById(id);
	            result.addDefaultModel("resultFlag", resultFlag);
	            result.setSuccess(true);
	        } catch (Exception e) {
	            log.error("ConsumerRecordsServiceImpl -> deleteConsumerRecordsById() error!!", e);
	        }
	        return result;
	}
	
	@Override
	public ResultCollection deleteConsumerRecordsByIds(Long ids[]){
		 ResultCollection result = new ResultCollection();
	        try {
	        	if(null!=ids&&ids.length>0){
	        		boolean resultFlag = consumerRecordsManager.deleteConsumerRecordsByIds(ids);
	        		result.addDefaultModel("resultFlag", resultFlag);
	        		result.setSuccess(true);
	        		
	        	}else{
	        		 log.error("ConsumerRecordsServiceImpl -> deleteConsumerRecordsById() ids param null!!");
	        	}
	        } catch (Exception e) {
	            log.error("ConsumerRecordsServiceImpl -> deleteConsumerRecordsById() error!!", e);
	        }
	    return result;
	}


	public void setConsumerRecordsManager(ConsumerRecordsManager consumerRecordsManager) {
		this.consumerRecordsManager = consumerRecordsManager;
	}
	
	

}
