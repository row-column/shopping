package com.haos.service.send.impl;

import java.util.Date;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.haos.common.util.CommonConstant;
import com.haos.common.util.page.ResultCollection;
import com.haos.domain.send.Send;
import com.haos.domain.send.query.SendQuery;
import com.haos.manager.carrier.CarrierManager;
import com.haos.manager.send.SendManager;
import com.haos.manager.send.SendTypeManager;
import com.haos.service.send.SendService;

/**
 * Send information service interface
 * @author WangYue
 *
 */
public class SendServiceImpl implements SendService {
	
    private static final Logger log = LogManager.getLogger(SendServiceImpl.class);
	
    private SendManager sendManager;
	
	/**
	 * send type information manager interface
	 */
	private SendTypeManager sendTypeManager;
	
	/**
	 *  carrier information manager interface
	 */
	private CarrierManager carrierManager;
	@Override
	public ResultCollection addSend(Send send) {
		 ResultCollection result = new ResultCollection();
		 if(null!=send){
			 try {
		        	send.setCreateTime(new Date()); //set create time
	                send.setUpdateTime(new Date()); //set update time
	                send.setDealTime(new Date());  //set deal time
	                
	                if(StringUtils.isNotBlank(send.getTypeCode())){
	                	send.setTypeName((sendTypeManager.getSendTypeBySendTypeCode(send.getTypeCode())).getSendTypeName()); //set type name
	                }
	                
	                if(!StringUtils.isBlank(send.getCarrierCode())){
	                	send.setCarrierName((carrierManager.getCarrierByCarrierCode(send.getCarrierCode())).getCarrierName()); //set carrier name
	                }
	                
	                send.setYn(CommonConstant.YN_NO_DELETE);  //set yn =0
		            boolean resultFlag = sendManager.addSend(send);
		            result.addDefaultModel("resultFlag", resultFlag);
		            result.setSuccess(true);
		        } catch (Exception e) {
		            log.error("SendServiceImpl -> addSend() error!!");
		        } 
		 }else{
			 log.error("SendServiceImpl -> addSend() error!!");
			 throw new RuntimeException("SendServiceImpl.addSend.parameter.empty.");
		 }
	        
	   return result;
	}

	@Override
	public ResultCollection updateSend(Send send) {
		 ResultCollection result = new ResultCollection();
		 if(null!=send){
		 
	        try {
	        	send.setUpdateTime(new Date());  // set update time
                send.setDealTime(new Date());    //set deal time
                
                if(!StringUtils.isBlank(send.getSendCode())){
                	send.setTypeName((sendTypeManager.getSendTypeBySendTypeCode(send.getSendCode())).getSendTypeName()); //set type name
                }
                
                if(!StringUtils.isBlank(send.getCarrierCode())){
                	send.setCarrierName((carrierManager.getCarrierByCarrierCode(send.getCarrierCode())).getCarrierName()); //set carrier name
                }
	            boolean resultFlag = sendManager.updateSend(send);
	            result.addDefaultModel("resultFlag", resultFlag);
	            result.setSuccess(true);
	        } catch (Exception e) {
	            log.error("SendServiceImpl -> updateSend() error!!", e);
	        }
		 }else{
			 log.error("SendServiceImpl -> updateSend() error!!");
			 throw new RuntimeException("SendServiceImpl.updateSend.parameter.empty.");
		 }
	        return result;
	}

	@Override
	public ResultCollection getSendById(Long id) {
		 ResultCollection result = new ResultCollection();
	        try {
	            Send send = sendManager.getSendById(id);
	            result.addDefaultModel("send", send);
	            result.setSuccess(true);
	        } catch (Exception e) {
	            log.error("SendServiceImpl -> getSendById() error!!", e);
	        }
	        return result;
	}

	@Override
	public ResultCollection getSendBySendCode(String sendCode) {
		 ResultCollection result = new ResultCollection();
	        try {
	            List<Send> sendList = sendManager.getSendBySendCode(sendCode);
	            result.addDefaultModel("sendList", sendList);
	            result.setSuccess(true);
	        } catch (Exception e) {
	            log.error("SendServiceImpl -> getSendBySendCode() error!!", e);
	        }
	        return result;
	}

	@Override
	public ResultCollection querySendListWithUniqueByQueryBean(SendQuery sendQuery) {
		ResultCollection result = new ResultCollection();
        try {
            List<Send> sendList = sendManager.querySendListWithUniqueByQueryBean(sendQuery);
            result.addDefaultModel("sendList", sendList);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("SendServiceImpl -> querySendListByQueryBean() error!!", e);
        }
        return result;
	}
	@Override
	public ResultCollection querySendListByQueryBean(SendQuery sendQuery) {
		ResultCollection result = new ResultCollection();
		try {
			List<Send> sendList = sendManager.querySendListByQueryBean(sendQuery);
			result.addDefaultModel("sendList", sendList);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error("SendServiceImpl -> querySendListByQueryBean() error!!", e);
		}
		return result;
	}

	@Override
	public ResultCollection querySendListPageByQueryBean(SendQuery sendQuery,
			int pageIndex, int pageSize) {
		ResultCollection result = new ResultCollection();
        try {
            List<Send> sendList = sendManager.querySendListPageByQueryBean(sendQuery,pageIndex,pageSize);
            result.addDefaultModel("sendList", sendList);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("SendServiceImpl -> querySendListPageByQueryBean() error!!", e);
        }
        return result;
	}

	@Override
	public ResultCollection deleteSendById(Long id) {
		 ResultCollection result = new ResultCollection();
	        try {
	            boolean resultFlag = sendManager.deleteSendById(id);
	            result.addDefaultModel("resultFlag", resultFlag);
	            result.setSuccess(true);
	        } catch (Exception e) {
	            log.error("SendServiceImpl -> deleteSendById() error!!", e);
	        }
	        return result;
	}

	public void setSendManager(SendManager sendManager) {
		this.sendManager = sendManager;
	}
	
	@Override
	public ResultCollection deleteSendByIds(Long ids[]){
		 ResultCollection result = new ResultCollection();
	        try {
	        	if(null!=ids&&ids.length>0){
	        		boolean resultFlag = sendManager.deleteSendByIds(ids);
	        		result.addDefaultModel("resultFlag", resultFlag);
	        		result.setSuccess(true);
	        		
	        	}else{
	        		 log.error("SendServiceImpl -> deleteSendById() ids param null!!");
	        	}
	        } catch (Exception e) {
	            log.error("SendServiceImpl -> deleteSendById() error!!", e);
	        }
	    return result;
	}

	public void setSendTypeManager(SendTypeManager sendTypeManager) {
		this.sendTypeManager = sendTypeManager;
	}

	public void setCarrierManager(CarrierManager carrierManager) {
		this.carrierManager = carrierManager;
	}
	

}
