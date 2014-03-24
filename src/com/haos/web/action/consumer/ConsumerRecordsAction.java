package com.haos.web.action.consumer;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.haos.common.util.CommonConstant;
import com.haos.common.util.action.BaseAction;
import com.haos.common.util.page.ResultCollection;
import com.haos.domain.consumer.ConsumerRecords;
import com.haos.domain.consumer.query.ConsumerRecordsQuery;
import com.haos.domain.order.query.OrderQuery;
import com.haos.service.consumer.ConsumerRecordsService;
import com.haos.service.order.OrderService;
import com.opensymphony.xwork2.ActionContext;


/**
 * ConsumerRecords information  action
 * @author WangYue
 *
 */
public class ConsumerRecordsAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static Log log = LogFactory.getLog(ConsumerRecordsAction.class);
    
    /**
     * ConsumerRecords information Service interface
     */
    private ConsumerRecordsService consumerRecordsService;
    
    /**
     * order information service interface
     */
    private OrderService orderService;
    /**
     * ConsumerRecords information query value class
     */
    private ConsumerRecordsQuery consumerRecordsQuery;
    
    /**
     * ConsumerRecords information
     */
    private ConsumerRecords consumerRecords;
    
    /**
     *  Page size 
     */
    private int pageSize = CommonConstant.PAGESIZE;

    /**
     * To consumerRecords information list page
     *
     * @return
     */
    public String consumerRecordsMain() {
        if (null == consumerRecordsQuery) {
            consumerRecordsQuery = new ConsumerRecordsQuery();
        }
        consumerRecordsQuery.setYn(CommonConstant.YN_NO_DELETE);     // not delete
        ResultCollection result = consumerRecordsService.queryConsumerRecordsListPageByQueryBean(consumerRecordsQuery, page, pageSize);
        setValueStack(result);
        return "consumerRecordsMain";
    }

    /**
     * 
     * To add consumerRecords information page
     * @return
     */
    public String toAddConsumerRecords() {
        this.setValueStack(null);
        return "toAddConsumerRecords";
    }

    /**
     * 
     * To update consumerRecords information page
     * @return
     */
    public String toUpdateConsumerRecords() {
    	
        if (null != consumerRecords) {
            // get consumerRecords information by id
            ResultCollection result = consumerRecordsService.getConsumerRecordsById(consumerRecords.getId());
            setValueStack(result);
        } else {
            log.error("ConsumerRecordsAction!toUpdateConsumerRecords() error!");
        }
        return "toUpdateConsumerRecords";
    }
    
    /**
     * 
     * To delete consumerRecords information page
     * @return
     */
    public String toDeleteConsumerRecords() {
    	
        if (null != consumerRecords) {
            // get consumerRecords information by id
            ResultCollection result = consumerRecordsService.getConsumerRecordsById(consumerRecords.getId());
            setValueStack(result);
        } else {
            log.error("ConsumerRecordsAction!toDeleteConsumerRecords() error!");
        }
        return "toDeleteConsumerRecords";
    }

    
    public String myAccount(){
    	Map<String,Object> map= ActionContext.getContext().getSession(); //get session
    	String userCode =(String)map.get("userCode"); //get user code from session
    	if(!StringUtils.isBlank(userCode)){
    		OrderQuery orderQuery= new OrderQuery(); // new order query object name is orderQuery
    		orderQuery.setUserCode(userCode); //set user code
    		orderQuery.setYn(CommonConstant.YN_NO_DELETE);
    		setValueStack(orderService.queryOrderListByQueryBean(orderQuery)); //call queryOrderListByQueryBean method
    		
    	}else{
    		return ERROR;
    	}
    	
    	
    	return SUCCESS;
    }
    
    public String myConsumerRecords(){
    	Map<String,Object> map= ActionContext.getContext().getSession(); //get session
    	String userCode =(String)map.get("userCode"); //get user code from session
    	if(!StringUtils.isBlank(userCode)){
    		ConsumerRecordsQuery consumerRecordsQuery= new ConsumerRecordsQuery(); // new order query object name is consumerRecordsQuery
    		consumerRecordsQuery.setUserCode(userCode); //set user code
    		consumerRecordsQuery.setYn(CommonConstant.YN_NO_DELETE);
    		setValueStack(consumerRecordsService.queryConsumerRecordsListByQueryBean(consumerRecordsQuery)); //call queryConsumerRecordsListByQueryBean method
    		
    	}else{
    		return ERROR;
    	}
    	
    	
    	return SUCCESS;
    }
	public ConsumerRecordsService getConsumerRecordsService() {
		return consumerRecordsService;
	}

	public void setConsumerRecordsService(
			ConsumerRecordsService consumerRecordsService) {
		this.consumerRecordsService = consumerRecordsService;
	}

	public ConsumerRecordsQuery getConsumerRecordsQuery() {
		return consumerRecordsQuery;
	}

	public void setConsumerRecordsQuery(ConsumerRecordsQuery consumerRecordsQuery) {
		this.consumerRecordsQuery = consumerRecordsQuery;
	}

	public ConsumerRecords getConsumerRecords() {
		return consumerRecords;
	}

	public void setConsumerRecords(ConsumerRecords consumerRecords) {
		this.consumerRecords = consumerRecords;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

  
}
