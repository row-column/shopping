package com.haos.web.action.order.json;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.haos.common.util.action.BaseAction;
import com.haos.common.util.page.ResultCollection;
import com.haos.domain.commodity.Commodity;
import com.haos.domain.order.Order;
import com.haos.service.commodity.CommodityService;
import com.haos.service.order.OrderService;
import com.opensymphony.xwork2.ActionContext;


/**
 * Order Information JsonAction
 * @author WangYue
 *
 */
public class OrderJsonAction extends BaseAction {
   // private final static Log logger = LogFactory.getLog(OrderJsonAction.class);
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * user information service interface
     */
    private OrderService orderService;
    
    /**
     * commodity information service interface
     */
    private CommodityService commodityService;
    
    /**
     * json return  result
     */
    private String result;
    
    /**
     * alert information
     */
    private String resultMsg;
    
    /**
     * order information object
     */
    private Order order;
    /**
     * order id array
     */
    private Long[]ids;
    
    /**
     * order id
     */
    private Long id;

    
    /**
     * put to  session 
     */
    private Map<String,Object> map;

    /**
     * add order information
     *
     * @return
     */
    public String addOrder() {
        if (null != order) {

            ResultCollection serviceResult = orderService.addOrder(order);
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false*" + (String) serviceResult.get("resultMsg");
            }
        } else {
            result = "false";
        }
        return "out";
    }

    /**
     * update order information
     *
     * @return
     */
    public String updateOrder() {
        if (null != order) {

            ResultCollection serviceResult = orderService.updateOrder(order);
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false";
            }
        } else {
            result = "false";
        }
        return "out";
    }

    /**
     * delete order information
     *
     * @return
     */
    public String deleteOrder() {
        if (null != order.getId() && order.getId().intValue() > 0) {
            //delete order by id
            ResultCollection serviceResult = orderService.deleteOrderById(order.getId());
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false";
            }
        } else {
            result = "false";
        }
        return "out";
    }

    
    /**
     * delete orders information
     *
     * @return
     */
    public String deleteOrders() {
        if(ids!=null&&ids.length>1){
        	 //call deleteOrderByIds method
            ResultCollection serviceResult = orderService.deleteOrderByIds(ids);
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false";
            }
        }else {
            result = "false";
        }
        return "out";
    }
    
    
    /**
     * check order code
     *
     * @return
     */
    public String checkOrderCode() {
        if (null != order) {

            ResultCollection serviceResult = orderService.getOrderByOrderCode(order.getOrderCode());
            
            if (null != serviceResult && serviceResult.getSuccess()) {
            	Order order=(Order)serviceResult.get("order");
            	if(order!=null&&order.getOrderCode()!=null){
            		result = "该订单代码已经存在！！！";
            	}else{
            		result = "恭喜你，该订单代码可用！！！";
            	}
            } else {
            	result = "恭喜你，该订单代码可用！！！";
            }
        } 
        return "out";
    }
    
    
    /**
     * add to cart 
     * @return
     */
    public String addToCart(){
    	
    	List<Commodity> userCommodityList=null; //cart commodity information list
    	Integer commodityNum=0;
    	map= ActionContext.getContext().getSession(); //get session 
    	//map object is null
    	if(null!=map){
    		userCommodityList=(List<Commodity>)map.get("userCommodityList"); // get userCommodityList from session
    		//userCommodityList is null
    		if(null==userCommodityList){
    			userCommodityList= new ArrayList<Commodity>(); // new List name is userCommodityList
    		}
    		if(id!=null&&id>0){
    			ResultCollection commodityResult=commodityService.getCommodityById(id); //call getCommodityById method
    			//commodityResult is null
    			if(null!=commodityResult){
    				//whether success
    				if(commodityResult.getSuccess()){
    					Commodity commodity=(Commodity)commodityResult.get("commodity"); //get commodity object from commodityResult
    					userCommodityList.add(commodity); //add commodity to userCommodityList
    					map.put("userCommodityList", userCommodityList); //put commodity to session
    					commodityNum= (Integer) map.get("commodityNum"+id);
    					if(null==commodityNum){
    						commodityNum=0;
    					}
    					
    					commodityNum++;  //set commodityNum plus 1
    					
    					map.put("commodityNum"+id, commodityNum);  //put commodityNum to session
    					
    					result="true"; //set result =true
    				}
    			}
    				
    		}
    			
    		
    	}
    	 
        return "out";

    }
    
    
    /**
     * remove from cart 
     * @return
     */
    public String removeFromCart(){
    	
    	List<Commodity> userCommodityList=null;
    	map= ActionContext.getContext().getSession(); //get session 
    	//map object is null
    	if(null!=map){
    		userCommodityList=(List<Commodity>)map.get("userCommodityList"); // get userCommodityList from session
    		//userCommodityList is null
    		if(null==userCommodityList){
    			userCommodityList= new ArrayList<Commodity>(); // new List name is userCommodityList
    		}else{
    			if(id!=null&&id>0){
    				// traval
    				for(Commodity c:userCommodityList){
    					// commodity is null
    					if(null!=c){
    						// whether id equasl commodity id
    						if(id.equals(c.getId())&&id==c.getId()){
    							userCommodityList.remove(c); //remove commodity from userCommodiytList
    						}
    					}
    				}
    				
    				map.put("userCommodityList", userCommodityList); //put commodity to session
					result="true"; //set result =true
        				
        		}
        			
    		}
    		
    	}
    	 
        return "out";

    }
    
    
    
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}
 
  
}
