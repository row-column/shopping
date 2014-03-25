package com.shopping.web.action.shoppingcart;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.shopping.common.util.action.BaseAction;
import com.shopping.domain.carrier.query.CarrierQuery;
import com.shopping.domain.send.query.SendTypeQuery;
import com.shopping.service.carrier.CarrierService;
import com.shopping.service.send.SendTypeService;
import com.shopping.service.shoppingcart.ShoppingCartService;
import com.opensymphony.xwork2.ActionContext;


/**
 * Commodity information  action
 * @author WangYue
 *
 */
public class ShoppingCartAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * shopping cart information service information
     */
    private ShoppingCartService shoppingCartService;
    
    /**
     * send type information service information
     */
    private SendTypeService sendTypeService;
    
    /**
     * carrier information service interface
     */
    private CarrierService carrierService;
    
    private Double totalPrice;
    
   
    
    

    /**
     * my shopping cart
     * @return
     */
   public String myShoppingCart(){
	   Map<String,Object> map=ActionContext.getContext().getSession();
	   
	   String userCode=(String)map.get("userCode");
	   
	   if(!StringUtils.isBlank(userCode)){
		   
		   setValueStack(shoppingCartService.queryShoppingCartByUserCode(userCode));
	   }else{
		   return ERROR;
	   }
	   
	   return SUCCESS; 
   }
   
   /**
    * my shopping cart
    * @return
    */
  public String toCheckOut(){
	   Map<String,Object> map=ActionContext.getContext().getSession();
	   
	   String userCode=(String)map.get("userCode"); //get user code from session
	   
	   if(!StringUtils.isBlank(userCode)){
		   setValueStack(sendTypeService.querySendTypeListByQueryBean(new SendTypeQuery()));  //call querySendTypeListByQueryBean method
		   setValueStack(carrierService.queryCarrierListByQueryBean(new CarrierQuery())); //call queryCarrierListByQueryBean method
		   setValueStack(shoppingCartService.queryShoppingCartByUserCode(userCode)); //call queryShoppingCartByUserCode method
	   }else{
		   return ERROR;
	   }
	   
	   return SUCCESS; 
  }




	public void setShoppingCartService(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}



	public Double getTotalPrice() {
		return totalPrice;
	}



	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setSendTypeService(SendTypeService sendTypeService) {
		this.sendTypeService = sendTypeService;
	}

	public void setCarrierService(CarrierService carrierService) {
		this.carrierService = carrierService;
	}

	
}
