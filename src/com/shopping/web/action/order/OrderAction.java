package com.shopping.web.action.order;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.shopping.common.util.CommonConstant;
import com.shopping.common.util.action.BaseAction;
import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.commodity.query.CommodityCategoryQuery;
import com.shopping.domain.order.Order;
import com.shopping.domain.order.query.OrderQuery;
import com.shopping.service.commodity.CommodityCategoryService;
import com.shopping.service.commodity.CommodityService;
import com.shopping.service.order.OrderService;


/**
 * Order information  action
 * @author WangYue
 *
 */
public class OrderAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static Log log = LogFactory.getLog(OrderAction.class);
    
    /**
     * Order information Service
     */
    private OrderService orderService;
    
    /**
	 * commodity information service interface
	 */
	private CommodityService commodityService;                             

	/**
	 * commodity category information service interface         
	 */
	private CommodityCategoryService commodityCategoryService;
    
    /**
     * Order information query value class
     */
    private OrderQuery orderQuery;
    
    /**
     * Order information
     */
    private Order order;
    
    /**
     *  Page size 
     */
    private int pageSize = CommonConstant.PAGESIZE;
    
    /**
     * order id
     */
    private Long id;
    
    /**
     * order coce
     */
    private String orderCode;

    /**
     * To order information list page
     *
     * @return
     */
    public String orderMain() {
        if (null == orderQuery) {
            orderQuery = new OrderQuery();
        }
        ResultCollection result = orderService.queryOrderListPageByQueryBean(orderQuery, page, pageSize);
        setValueStack(result);
        return "orderMain";
    }

    /**
     * 
     * To add order information page
     * @return
     */
    public String toAddOrder() {
        this.setValueStack(null);
        return "toAddOrder";
    }

    /**
     * 
     * To update order information page
     * @return
     */
    public String toUpdateOrder() {
    	
        if (null != order) {
            // get order information by id
            ResultCollection result = orderService.getOrderById(order.getId());
            setValueStack(result);
        } else {
            log.error("OrderAction!toUpdateOrder() error!");
        }
        return "toUpdateOrder";
    }


    /**
     * 
     * To delete order information page
     * @return
     */
    public String toDeleteOrder() {
    	
        if (null != order) {
            // get order information by id
            ResultCollection result = orderService.getOrderById(order.getId());
            setValueStack(result);
        } else {
            log.error("OrderAction!toDeleteOrder() error!");
        }
        return "toDeleteOrder";
    }

    /**
     * to my shopping cart
     * @return
     */
    public String myCart(){
    	
    	 CommodityCategoryQuery commodityCategoryQuery= new CommodityCategoryQuery(); // new commodityCategoryQuery object
         commodityCategoryQuery.setYn(CommonConstant.YN_NO_DELETE); //set yn=0
         setValueStack(commodityCategoryService.queryCommodityCategoryListByQueryBean(commodityCategoryQuery)); //call  query commodity category list method
         setValueStack(commodityService.queryCommodityListByLatestTime()); //call query commodity by latest time
         setValueStack(commodityService.queryCommodityListBySalesCount()); //call query commodity by sales count descent
    	
    	
    	return SUCCESS;
    }
    
    /**
     * 
     * To  order  detail information page
     * @return
     */
    public String orderDetail() {
    	
        if (null != id&&id>0) {
            // get order detail information by id
            ResultCollection result = orderService.getOrderDetailById(id);
            setValueStack(result);
        } else {
            log.error("OrderAction!orderDetail() error!");
        }
        return SUCCESS;
    }
    
    /**
     * 
     * To  order  detail information page
     * @return
     */
    public String orderDetailByOrderCode() {
    	
        if (!StringUtils.isBlank(orderCode)) {
            // get order detail information by order code
            ResultCollection result = orderService.getOrderDetailByOrderCode(orderCode);
            setValueStack(result);
        } else {
            log.error("OrderAction!orderDetailByOrderCode() error!");
        }
        return SUCCESS;
    }

    
	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public OrderQuery getOrderQuery() {
		return orderQuery;
	}

	public void setOrderQuery(OrderQuery orderQuery) {
		this.orderQuery = orderQuery;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}

	public void setCommodityCategoryService(
			CommodityCategoryService commodityCategoryService) {
		this.commodityCategoryService = commodityCategoryService;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

    
}
