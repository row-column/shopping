package com.shopping.service.server.order.impl;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import org.apache.commons.lang.xwork.StringUtils;

import com.shopping.common.util.CommonConstant;
import com.shopping.domain.order.Order;
import com.shopping.domain.order.query.OrderQuery;
import com.shopping.manager.order.OrderManager;
import com.shopping.service.server.order.OrderInfoWebService;

/**
 * 订单信息WebService接口
 * 
 * @author WangYue
 * 
 */
@WebService(endpointInterface="com.shopping.service.server.order.OrderInfoWebService",serviceName="orderInfoService")
public class OrderInfoWebServiceImpl implements OrderInfoWebService {

	/**
	 * Order Information Manager interface
	 */
	private OrderManager orderManager;

	@Override
	public List<Order> getOrderInfoListByStatusAndEmployeeCode(int status,
			String employeeCode) {
		if (StringUtils.isBlank(employeeCode) || status <= 0) {
			return null;
		}
		/**
		 * 创建OrderQuery对象 orderQuery
		 */
		OrderQuery orderQuery = new OrderQuery();
		orderQuery.setStatus(status);
		orderQuery.setEmployeeCode(employeeCode);
		/**
		 * 调用 根据订单状态和员工账号取得所有订单方法
		 */
		List<Order> orderList = orderManager
				.queryOrderListByQueryBean(orderQuery);
		return orderList;
	}

	@Override
	public boolean updateOrderStatus(String orderCode, int status) {
		if (StringUtils.isBlank(orderCode) || status < 0) {
			return false;
		}
		Order order = new Order();
		order.setOrderCode(orderCode);
		order.setStatus(status);
		order.setUpdateTime(new Date());
		return orderManager.updateOrderStatus(order);
	}

	public void setOrderManager(OrderManager orderManager) {
		this.orderManager = orderManager;
	}

	@Override
	public Order getOrderById(Long id) {
		Order order = null;
		if(id!=null&&id.intValue()>0){
			 order=orderManager.getOrderById(id);
		}
		return order;
	}

}
 