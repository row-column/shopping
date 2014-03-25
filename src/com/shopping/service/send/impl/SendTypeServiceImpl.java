package com.shopping.service.send.impl;

import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.send.SendType;
import com.shopping.domain.send.query.SendTypeQuery;
import com.shopping.manager.send.SendTypeManager;
import com.shopping.service.fun.impl.FunServiceImpl;
import com.shopping.service.send.SendTypeService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * SendType information service interface
 * @author WangYue
 *
 */
public class SendTypeServiceImpl implements SendTypeService {
	  /**
     * ��־
     */
    private static final Logger log = LogManager.getLogger(FunServiceImpl.class);
	private SendTypeManager sendTypeManager;
	@Override
	public ResultCollection addSendType(SendType sendType) {
		 ResultCollection result = new ResultCollection();
	        try {
	            boolean resultFlag = sendTypeManager.addSendType(sendType);
	            result.addDefaultModel("resultFlag", resultFlag);
	            result.setSuccess(true);
	        } catch (Exception e) {
	            log.error("SendTypeServiceImpl -> addSendType() error!!", e);
	        }
	        return result;
	}

	@Override
	public ResultCollection updateSendType(SendType sendType) {
		 ResultCollection result = new ResultCollection();
	        try {
	            boolean resultFlag = sendTypeManager.updateSendType(sendType);
	            result.addDefaultModel("resultFlag", resultFlag);
	            result.setSuccess(true);
	        } catch (Exception e) {
	            log.error("SendTypeServiceImpl -> updateSendType() error!!", e);
	        }
	        return result;
	}

	@Override
	public ResultCollection getSendTypeById(Long id) {
		 ResultCollection result = new ResultCollection();
	        try {
	            SendType sendType = sendTypeManager.getSendTypeById(id);
	            result.addDefaultModel("sendType", sendType);
	            result.setSuccess(true);
	        } catch (Exception e) {
	            log.error("SendTypeServiceImpl -> getSendTypeById() error!!", e);
	        }
	        return result;
	}

	@Override
	public ResultCollection getSendTypeBySendTypeCode(String sendTypeCode) {
		 ResultCollection result = new ResultCollection();
	        try {
	            SendType sendType = sendTypeManager.getSendTypeBySendTypeCode(sendTypeCode);
	            result.addDefaultModel("sendType", sendType);
	            result.setSuccess(true);
	        } catch (Exception e) {
	            log.error("SendTypeServiceImpl -> getSendTypeBySendTypeCode() error!!", e);
	        }
	        return result;
	}

	@Override
	public ResultCollection querySendTypeListByQueryBean(SendTypeQuery sendTypeQuery) {
		ResultCollection result = new ResultCollection();
        try {
            List<SendType> sendTypeList = sendTypeManager.querySendTypeListByQueryBean(sendTypeQuery);
            result.addDefaultModel("sendTypeList", sendTypeList);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("SendTypeServiceImpl -> querySendTypeListByQueryBean() error!!", e);
        }
        return result;
	}

	@Override
	public ResultCollection querySendTypeListPageByQueryBean(SendTypeQuery sendTypeQuery,
			int pageIndex, int pageSize) {
		ResultCollection result = new ResultCollection();
        try {
            List<SendType> sendTypeList = sendTypeManager.querySendTypeListPageByQueryBean(sendTypeQuery,pageIndex,pageSize);
            result.addDefaultModel("sendTypeList", sendTypeList);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("SendTypeServiceImpl -> querySendTypeListPageByQueryBean() error!!", e);
        }
        return result;
	}

	@Override
	public ResultCollection deleteSendTypeById(Long id) {
		 ResultCollection result = new ResultCollection();
	        try {
	            boolean resultFlag = sendTypeManager.deleteSendTypeById(id);
	            result.addDefaultModel("resultFlag", resultFlag);
	            result.setSuccess(true);
	        } catch (Exception e) {
	            log.error("SendTypeServiceImpl -> deleteSendTypeById() error!!", e);
	        }
	        return result;
	}

	public void setSendTypeManager(SendTypeManager sendTypeManager) {
		this.sendTypeManager = sendTypeManager;
	}

	@Override
	public ResultCollection deleteSendTypeByIds(Long ids[]){
		 ResultCollection result = new ResultCollection();
	        try {
	        	if(null!=ids&&ids.length>0){
	        		boolean resultFlag = sendTypeManager.deleteSendTypeByIds(ids);
	        		result.addDefaultModel("resultFlag", resultFlag);
	        		result.setSuccess(true);
	        		
	        	}else{
	        		 log.error("SendTypeServiceImpl -> deleteSendTypeById() ids param null!!");
	        	}
	        } catch (Exception e) {
	            log.error("SendTypeServiceImpl -> deleteSendTypeById() error!!", e);
	        }
	    return result;
	}



}
