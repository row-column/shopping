package com.haos.manager.order;

import java.util.List;

import com.haos.common.util.page.PageModel;
import com.haos.domain.order.Order;
import com.haos.domain.order.query.OrderQuery;
import com.haos.domain.send.Send;


/**
 * Order information manager interface
 * @author WangYue
 *
 */
public interface OrderManager {

	/**
	 * add order information
	 * @param order   order value class
	 * @return true:success;false:fail
	 */
	public boolean addOrder(Order order);
	
	/**
	 * add order information
	 * @param order value class ,send value class
	 * @return true:success;false:fail
	 */
	public boolean addOrder(Order order,Send send);
	
	
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
	 * query order information with page
	 * @param query Query order value class
	 * @return Order order value class
	 */
	public List<Order> queryOrderListByQueryBean(OrderQuery orderQuery);
	
	/**
	 * query order information with page
	 * @param query Query order value class
	 * @return Order order value class
	 */
	public PageModel<Order> queryOrderListPageByQueryBean(OrderQuery orderQuery, int pageIndex, int pageSize);
	
	
	/**
	 * according to order id,delete order information.
	 * @param id  order id
	 * @return true:success;false:fail.
	 */
	public boolean deleteOrderById(Long id);

	/**]
	 * according to order ids,delete orders information
	 * @param ids order ids
	 * @return true:success;false:fail.
	 */
	boolean deleteOrderByIds(Long[] ids);
	
	/**
	 * get order records 
	 * @param orderQuery  Query order value class 
	 * @return order count 
	 */
	public int queryOrderCountByQueryBean(OrderQuery orderQuery);

	
	
}
