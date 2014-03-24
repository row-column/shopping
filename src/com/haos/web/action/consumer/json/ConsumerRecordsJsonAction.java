package com.haos.web.action.consumer.json;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.haos.common.util.action.BaseAction;
import com.haos.common.util.page.ResultCollection;
import com.haos.domain.consumer.ConsumerRecords;
import com.haos.service.consumer.ConsumerRecordsService;


/**
 * 消费记录JsonAction
 * @author WangYue
 *
 */
public class ConsumerRecordsJsonAction extends BaseAction {
    private final static Log logger = LogFactory.getLog(ConsumerRecordsJsonAction.class);
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 用户消费记录Service 借口
     */
    private ConsumerRecordsService consumerRecordsService;
    
    /**
     * json返回值
     */
    private String result;
    
    /**
     * 返回消息
     */
    private String resultMsg;
    
    /**
     * 消费记录值类对象
     */
    private ConsumerRecords consumerRecords;

    /**
     * 消费记录编号数组
     */
    private Long[]ids;
    /**
     * 添加用户消费记录方法
     *
     * @return
     */
    public String addConsumerRecords() {
        if (null != consumerRecords) {

        	//调用添加用户消费记录方法
            ResultCollection serviceResult = consumerRecordsService.addConsumerRecords(consumerRecords);
            
            /**
             * 取得操作结果
             * 如果成功，将会返回true；
             * 否则，将会返回false。
             */
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false*" + (String) serviceResult.get("resultMsg");
            }
        } else {
        	logger.error("ConsumerRecordsJsonAction-->>addConsumerRecords()---->>>>consumerRecords parameter null!");
            result = "false";
        }
        return "out";
    }

    /**
     * 更新用户消费记录方法
     *
     * @return
     */
    public String updateConsumerRecords() {
        if (null != consumerRecords) {

        	//调用更新用户消费记录方法
            ResultCollection serviceResult = consumerRecordsService.updateConsumerRecords(consumerRecords);
            
            /**
             * 取得操作结果
             * 如果成功，将会返回true；
             * 否则，将会返回false。
             */
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false";
            }
        } else {
        	logger.error("ConsumerRecordsJsonAction-->>updateConsumerRecords()---->>>>consumerRecords parameter null!");
            result = "false";
        }
        return "out";
    }

    /**
     * 删除用户消费记录方法
     *
     * @return
     */
    public String deleteConsumerRecord() {
        if (null != consumerRecords.getId() && consumerRecords.getId().intValue() > 0) {
            
        	//调用删除用户消费记录方法
            ResultCollection serviceResult = consumerRecordsService.deleteConsumerRecordsById(consumerRecords.getId());
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false";
            }
        } else {
        	logger.error("ConsumerRecordsJsonAction-->>deleteConsumerRecords()---->>>>consumerRecords parameter null!");
            result = "false";
        }
        return "out";
    }
    
    
    /**
     * 删除多个用户消费记录方法
     *
     * @return
     */
    public String deleteConsumerRecordss() {
        if(ids!=null&&ids.length>1){
        	 //调用多个用户消费记录方法
            ResultCollection serviceResult = consumerRecordsService.deleteConsumerRecordsByIds(ids);
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false";
            }
        }else {
        	logger.error("ConsumerRecordsJsonAction-->>deleteConsumerRecordss()---->>>>ids parameter null!");
            result = "false";
        }
        return "out";
    }
    

    public void setConsumerRecordsService(ConsumerRecordsService consumerRecordsService) {
        this.consumerRecordsService = consumerRecordsService;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

	public ConsumerRecords getConsumerRecords() {
		return consumerRecords;
	}

	public void setConsumerRecords(ConsumerRecords consumerRecords) {
		this.consumerRecords = consumerRecords;
	}

	public ConsumerRecordsService getConsumerRecordsService() {
		return consumerRecordsService;
	}

	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}
    
  
}
