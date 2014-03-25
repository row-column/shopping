package com.shopping.dao.shoppingcart;

import java.util.List;

import com.shopping.domain.shoppingcart.ShoppingCart;
import com.shopping.domain.shoppingcart.query.ShoppingCartQuery;


/**
 * Shopping Cart information DAO interface
 * @author WangYue
 *
 */
public interface ShoppingCartDao {

	/**
	 * add shoppingCart information
	 * @param shoppingCart   shoppingCart value class
	 * @return true:success;false:fail
	 */
	public boolean addShoppingCart(ShoppingCart shoppingCart);
	
	/**
	 * update shoppingCart information
	 * @param shoppingCart  shoppingCart value class
	 * @return true:success;false:fail
	 */
	public boolean updateShoppingCart(ShoppingCart shoppingCart);
	
	/**
	 * according to shoppingCart id ,query shoppingCart information.
	 * @param id  shoppingCart id
	 * @return  ShoppingCart  shoppingCart value class
	 */
	public ShoppingCart getShoppingCartById(Long id);
	
	

	/**
	 * according to user code ,query shoppingCart information.
	 * @param userCode  user code
	 * @return ShoppingCart  shoppingCart value class
	 */
	public List<ShoppingCart> queryShoppingCartByUserCode(String userCode);
	
	
	/**
	 * according to user code ,query shoppingCart information.
	 * @param commodityCode  commodity code
	 * @return ShoppingCart  shoppingCart value class
	 */
	public List<ShoppingCart> queryShoppingCartByCommodityCode(String commodityCode);
	
	/**
	 * query all shoppingCart information
	 * @param query  Query shoppingCart value class
	 * @return ShoppingCart  shoppingCart value class
	 */
	public List<ShoppingCart> queryShoppingCartListByQueryBean(ShoppingCartQuery shoppingCartQuery);
	
	
	/**
	 * according to shoppingCart id,delete shoppingCart information.
	 * @param id  shoppingCart id
	 * @return true:success;false:fail.
	 */
	public boolean deleteShoppingCartById(Long id);
	
	
	/**
	 * according to shoppingCart id  ,update shoppingCart commodity number information.
	 * @param shoppingCartCode  shoppingCart code
	 *  @return true:success;false:fail.
	 */
	public boolean updateShoppingCartCommodityNum(ShoppingCart shoppingCart);

	
}
