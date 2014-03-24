package com.haos.web.action.send.json;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.haos.common.util.action.BaseAction;
import com.haos.common.util.page.ResultCollection;
import com.haos.domain.send.Send;
import com.haos.service.send.SendService;
import com.opensymphony.xwork2.ActionContext;


/**
 * 配送信息 JsonAction
 * @author WangYue
 *
 */
public class SendJsonAction extends BaseAction {
    private final static Log logger = LogFactory.getLog(SendJsonAction.class);
    
    /**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 配送ID
	 */
	private Long id;
	
	/**
	 * 配送处理信息
	 */
	private String dealInformation;
	/**
	 * 配送备注
	 */
	private String remark;

	/**
     * 配送Service 接口
     */
    private SendService sendService;
    
    /**
     * json 返回值
     */
    private String result;
    
    /**
     * 返回信息
     */
    private String resultMsg;
    
    /**
     * 配送值类对象
     */
    private Send send;


    /**
     * 配送编号数组
     */
    private Long[]ids;
    
    /**
     * 添加配送信息方法
     *
     * @return
     */
    public String addSend() {
        if (null != id) {
        	ResultCollection serviceSendResult=sendService.getSendById(id);
        	if(null!=serviceSendResult&&serviceSendResult.getSuccess()){
        		Send s =(Send)serviceSendResult.get("send");
        		String employeeName = (String) ActionContext.getContext().getSession().get("employeeName");
        		if(StringUtils.isNotBlank(employeeName)){
        			s.setOperator(employeeName);  //set operator 
        			s.setDealInformation(dealInformation); //set deal information
        			s.setRemark(remark); //set remark
        			ResultCollection serviceResult = sendService.addSend(s);
        			
        			if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
        				result = "true";
        			} else {
        				result = "false*" + (String) serviceResult.get("resultMsg");
        			}
        	}else{
        		logger.error("SendJsonAction-->>getSendById()---->>>>error!");
                result = "false";
        	}
        } else {
        	logger.error("SendJsonAction-->>addSend()---->>>>send parameter null!");
            result = "false";
        }
      }
        return "out";
    }

    /**
     * 更新配送信息方法
     *
     * @return
     */
    public String updateSend() {
        if (null != send) {
            ResultCollection serviceResult = sendService.updateSend(send);
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false";
            }
        } else {
        	logger.error("SendJsonAction-->>updateSend()---->>>>send parameter null!");
            result = "false";
        }
        return "out";
    }

    /**
     * 删除配送信息方法
     *
     * @return
     */
    public String deleteSend() {
        if (null != send.getId() && send.getId().intValue() > 0) {
            //删除配送信息方法
            ResultCollection serviceResult = sendService.deleteSendById(send.getId());
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false";
            }
        } else {
        	logger.error("SendJsonAction-->>deleteSend()---->>>>send parameter null!");
            result = "false";
        }
        return "out";
    }
    
    /**
     * 删除多个配送信息方法
     *
     * @return
     */
    public String deleteSends() {
        if(ids!=null&&ids.length>1){
        	 //调用删除多个配送信息方法
            ResultCollection serviceResult = sendService.deleteSendByIds(ids);
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false";
            }
        }else {
        	logger.error("SendJsonAction-->>deleteSends()---->>>>send parameter null!");
            result = "false";
        }
        return "out";
    }
    
    
    /**
     * 检查配送代码是否已经存在
     *
     * @return
     */
    public String checkSendCode() {
        if (null != send) {

            ResultCollection serviceResult = sendService.getSendBySendCode(send.getSendCode());
            
            if (null != serviceResult && serviceResult.getSuccess()) {
            	Send send=(Send)serviceResult.get("send");
            	if(send!=null&&send.getSendCode()!=null){
            		result = "exist";
            	}else{
            		result = "ok";
            	}
            } else {
            	result = "ok";
            }
        } else {
        	logger.error("SendJsonAction-->>checkSendCode()---->>>>send parameter null!");
        }
        return "out";
    }


    
    public void setId(Long id) {
		this.id = id;
	}

	public void setDealInformation(String dealInformation) {
		this.dealInformation = dealInformation;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setSendService(SendService sendService) {
        this.sendService = sendService;
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

	public Send getSend() {
		return send;
	}

	public void setSend(Send send) {
		this.send = send;
	}

	public SendService getSendService() {
		return sendService;
	}

	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}
  
}
