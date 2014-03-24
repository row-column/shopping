package com.haos.service.shoppingcart;

import com.haos.common.util.page.ResultCollection;
import com.haos.domain.shoppingcart.ShoppingCart;
import com.haos.domain.shoppingcart.query.ShoppingCartQuery;


/**
 * Shopping Cart information Service interface
 * @author WangYue
 *
 */
public interface ShoppingCartService {

	/**
	 * add shoppingCart information
	 * @param shoppingCart   shoppingCart value class
	 * @return Result
	 */
	public ResultCollection addShoppingCart(ShoppingCart shoppingCart);
	
	/**
	 * update shoppingCart information
	 * @param shoppingCart  shoppingCart value class
	 * @return Result
	 */
	public ResultCollection updateShoppingCart(ShoppingCart shoppingCart);
	
	/**
	 * according to shoppingCart id ,query shoppingCart information.
	 * @param id  shoppingCart id
	 * @return  Result
	 */
	public ResultCollection getShoppingCartById(Long id);
	
	

	/**
	 * according to user code ,query shoppingCart information.
	 * @param userCode  user code
	 * @return Result
	 */
	public ResultCollection queryShoppingCartByUserCode(String userCode);
	
	
	/**
	 * according to user code ,query shoppingCart information.
	 * @param commodityCode  commodity code
	 * @return Result
	 */
	public ResultCollection queryShoppingCartByCommodityCode(String commodityCode);
	
	/**
	 * query all shoppingCart information
	 * @param query  Query shoppingCart value class
	 * @return Result
	 */
	public ResultCollection queryShoppingCartListByQueryBean(ShoppingCartQuery shoppingCartQuery);
	
	
	/**
	 * according to shoppingCart id,delete shoppingCart information.
	 * @param id  shoppingCart id
	 * @return Result.
	 */
	public ResultCollection deleteShoppingCartById(Long id);
	
	
	/**
	 * according to shoppingCart id  ,update shoppingCart commodity number information.
	 * @param shoppingCartCode  shoppingCart code
	 *  @return Result.
	 */
	public ResultCollection updateShoppingCartCommodityNum(ShoppingCart shoppingCart);

	
}
