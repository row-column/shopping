package com.haos.dao.order;

import java.util.List;

import com.haos.domain.order.Order;
import com.haos.domain.order.query.OrderQuery;


/**
 * Order information DAO interface
 * @author WangYue
 *
 */
public interface OrderDao {

	/**
	 * add order information
	 * @param order   order value class
	 * @return true:success;false:fail
	 */
	public boolean addOrder(Order order);
	
	/**
	 * update order information
	 * @param order  order value class
	 * @return true:success;false:fail
	 */
	public boolean updateOrder(Order order);
	
	/**
	 * update order status
	 * @param order  order value class
	 * @return true:success;false:fail
	 */
	public boolean updateOrderStatus(Order order);

	
	/**
	 * according to order id ,query order information.
	 * @param id  order id
	 * @return  Order  order value class
	 */
	public Order getOrderById(Long id);
	
	/**
	 * according to order code ,query order information.
	 * @param orderCode  order code
	 * @return Order  order value class
	 */
	public Order getOrderByOrderCode(String orderCode);
	
	/**
	 * query all order information
	 * @param query  Query order value class
	 * @return Order  order value class
	 */
	public List<Order> queryOrderListByQueryBean(OrderQuery orderQuery);
	
	/**
	 * query order information with page
	 * @param query Query order value class
	 * @return Order order value class
	 */
	public List<Order> queryOrderListPageByQueryBean(OrderQuery orderQuery);
	
	/**
	 * according to order id,delete order information.
	 * @param id  order id
	 * @return true:success;false:fail.
	 */
	public boolean deleteOrderById(Long id);
	
	/**
	 * get order records 
	 * @param query  Query order value class 
	 * @return order count 
	 */
	public int queryOrderCountByQueryBean(OrderQuery orderQuery);
	
	
}
