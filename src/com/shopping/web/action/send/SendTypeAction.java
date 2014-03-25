package com.shopping.web.action.send;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.shopping.common.util.CommonConstant;
import com.shopping.common.util.action.BaseAction;
import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.send.SendType;
import com.shopping.domain.send.query.SendTypeQuery;
import com.shopping.service.send.SendTypeService;


/**
 * SendType information  action
 * @author WangYue
 *
 */
public class SendTypeAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static Log log = LogFactory.getLog(SendTypeAction.class);
    
    /**
     * SendType information Service
     */
    private SendTypeService SendTypeService;
    /**
     * SendType information query value class
     */
    private SendTypeQuery SendTypeQuery;
    
    /**
     * SendType information
     */
    private SendType SendType;
    
    /**
     *  Page size 
     */
    private int pageSize = CommonConstant.PAGESIZE;

    /**
     * To SendType information list page
     *
     * @return
     */
    public String sendTypeMain() {
      if (null == SendTypeQuery) {
            SendTypeQuery = new SendTypeQuery();
        }
        SendTypeQuery.setYn(CommonConstant.YN_NO_DELETE);     // not delete
        ResultCollection result = SendTypeService.querySendTypeListPageByQueryBean(SendTypeQuery, page, pageSize);
        setValueStack(result);
        return "sendTypeMain";
    }

    /**
     * 
     * To add SendType information page
     * @return
     */
    public String toAddSendType() {
        this.setValueStack(null);
        return "toAddSendType";
    }

    /**
     * 
     * To update SendType information page
     * @return
     */
    public String toUpdateSendType() {
    	
        if (null != SendType) {
            // get SendType information by id
            ResultCollection result = SendTypeService.getSendTypeById(SendType.getId());
            setValueStack(result);
        } else {
            log.error("SendTypeAction!toUpdateSendType() error!");
        }
        return "toUpdateSendType";
    }
    
    /**
     * 
     * To update SendType information page
     * @return
     */
    public String toDeleteSendType() {
    	
        if (null != SendType) {
            // get SendType information by id
            ResultCollection result = SendTypeService.getSendTypeById(SendType.getId());
            setValueStack(result);
        } else {
            log.error("SendTypeAction!toDeleteSendType() error!");
        }
        return "toDeleteSendType";
    }

	public SendTypeService getSendTypeService() {
		return SendTypeService;
	}

	public void setSendTypeService(SendTypeService sendTypeService) {
		SendTypeService = sendTypeService;
	}

	public SendTypeQuery getSendTypeQuery() {
		return SendTypeQuery;
	}

	public void setSendTypeQuery(SendTypeQuery sendTypeQuery) {
		SendTypeQuery = sendTypeQuery;
	}

	public SendType getSendType() {
		return SendType;
	}

	public void setSendType(SendType sendType) {
		SendType = sendType;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


  
}
