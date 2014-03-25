package com.shopping.service.order;

import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.order.Order;
import com.shopping.domain.order.query.OrderQuery;
import com.shopping.domain.send.Send;

/**
 * Order information service interface
 * @author WangYue
 *
 */
public interface OrderService {

	/**
	 * add order information
	 * @param order   order value class
	 * @return Result 
	 */
	public ResultCollection addOrder(Order order);
	
	
	/**
	 * update order information
	 * @param order  order value class
	 * @return Result 
	 */
	public ResultCollection updateOrder(Order order);
	
	/**
	 * according to order id ,query order information.
	 * @param id  order id
	 * @return  Result
	 */
	public ResultCollection getOrderById(Long id);
	
	/**
	 * according to order code ,query order information.
	 * @param orderCode  order code
	 * @return Result
	 */
	public ResultCollection getOrderByOrderCode(String orderCode);
	
	/**
	 * according to order id ,query order information.
	 * @param id  id
	 * @return Result
	 */
	public ResultCollection getOrderDetailById(Long id);
	
	/**
	 * according to order code,query order information.
	 * @param id  id
	 * @return Result
	 */
	public ResultCollection getOrderDetailByOrderCode(String orderCode);
	
	
	/**
	 * query order information with page
	 * @param query Query order value class
	 * @return Result
	 */
	public ResultCollection queryOrderListByQueryBean(OrderQuery orderQuery);
	
	/**
	 * query order information with page
	 * @param query Query order value class
	 * @return Result
	 */
	public ResultCollection queryOrderListPageByQueryBean(OrderQuery orderQuery, int pageIndex, int pageSize);
	
	
	/**
	 * according to order id,delete order information.
	 * @param id  order id
	 * @return Result .
	 */
	public ResultCollection deleteOrderById(Long id);

	/**
	 * according to order ids,delete orders information
	 * @param ids orders ids
	 * @return Result
	 */
	public ResultCollection deleteOrderByIds(Long[] ids);

	
}
