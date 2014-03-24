package com.haos.dao.shoppingcart.impl;

import java.util.List;

import com.haos.common.util.dao.BaseDao;
import com.haos.dao.shoppingcart.ShoppingCartDao;
import com.haos.domain.shoppingcart.ShoppingCart;
import com.haos.domain.shoppingcart.query.ShoppingCartQuery;

/**
 * ShoppingCart information DAO implementation
 * @author WangYue
 *
 */
@SuppressWarnings("rawtypes")
public class ShoppingCartDaoImpl extends BaseDao implements ShoppingCartDao {

	@SuppressWarnings("unchecked")
	@Override
	public boolean addShoppingCart(ShoppingCart commodity) {
		return this.insert("ShoppingCart.insert", commodity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updateShoppingCart(ShoppingCart commodity) {
		return this.update("ShoppingCart.update", commodity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ShoppingCart getShoppingCartById(Long id) {
		return (ShoppingCart)this.queryForObject("ShoppingCart.getShoppingCartById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShoppingCart> queryShoppingCartByUserCode(String userCode) {
		return (List<ShoppingCart>)this.queryForList("ShoppingCart.queryShoppingCartByUserCode", userCode);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShoppingCart> queryShoppingCartByCommodityCode(String commodityCode) {
		return (List<ShoppingCart>)this.queryForList("ShoppingCart.queryShoppingCartByCommodityCode", commodityCode);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShoppingCart> queryShoppingCartListByQueryBean(ShoppingCartQuery shoppingCartQuery) {
		return (List<ShoppingCart>)this.queryForList("ShoppingCart.queryShoppingCartListByQueryBean", shoppingCartQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteShoppingCartById(Long id) {
		return this.delete("ShoppingCart.deleteShoppingCartById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updateShoppingCartCommodityNum(ShoppingCart shoppingCart) {
		return this.update("ShoppingCart.updateShoppingCartCommodityNum", shoppingCart);
	}

	
}
