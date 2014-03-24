package com.haos.dao.order.impl;

import java.util.List;

import com.haos.common.util.dao.BaseDao;
import com.haos.dao.order.OrderDao;
import com.haos.domain.order.Order;
import com.haos.domain.order.query.OrderQuery;

/**
 * Order information DAO implementation
 * @author WangYue
 *
 */
@SuppressWarnings("rawtypes")
public class OrderDaoImpl extends BaseDao implements OrderDao {

	@SuppressWarnings("unchecked")
	@Override
	public boolean addOrder(Order order) {
		return this.insert("Order.insert", order);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updateOrder(Order order) {
		return this.update("Order.update", order);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updateOrderStatus(Order order) {
		return this.update("Order.updateOrderStatus", order);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Order getOrderById(Long id) {
		return (Order)this.queryForObject("Order.getOrderById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Order getOrderByOrderCode(String orderCode) {
		return (Order)this.queryForObject("Order.getOrderByOrderCode", orderCode);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> queryOrderListByQueryBean(OrderQuery orderQuery) {
		return this.queryForList("Order.queryOrderListByQueryBean",orderQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> queryOrderListPageByQueryBean(OrderQuery orderQuery) {
		return this.queryForList("Order.queryOrderListPageByQueryBean", orderQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteOrderById(Long id) {
		return this.delete("Order.deleteOrderById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int queryOrderCountByQueryBean(OrderQuery orderQuery) {
		return (Integer)this.queryForObject("Order.queryOrderCountByQueryBean", orderQuery);
	}

}
