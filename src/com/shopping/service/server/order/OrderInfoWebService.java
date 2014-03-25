package com.shopping.service.server.order;

import java.util.List;
import javax.jws.WebParam;
import javax.jws.WebService;
import com.shopping.domain.order.Order;

/**
 * 订单信息WebService接口
 * 
 * @author WangYue
 * 
 */
@WebService(targetNamespace = "http://www.shopping.com")
public interface OrderInfoWebService {

	/**
	 * 根据员工代码取得所有相关订单信息方法
	 * 
	 * @param status
	 *            订单状态
	 * @param employeeCode
	 *            员工账号
	 * @return 订单信息集合
	 */
	public List<Order> getOrderInfoListByStatusAndEmployeeCode(
			@WebParam(name = "status") int status,
			@WebParam(name = "employeeCode") String employeeCode);

	/**
	 * 修改订单状态方法
	 * 
	 * @param orderCode
	 *            订单代码
	 * @param status
	 *            订单状态
	 * @return true/false
	 */
	public boolean updateOrderStatus(
			@WebParam(name = "orderCode") String orderCode,
			@WebParam(name = "status") int status);

	/**
	 * 根据订单编号，取得订单信息
	 * 
	 * @param id
	 *            订单ID
	 * @return 订单信息
	 */
	public Order getOrderById(@WebParam(name = "id") Long id);
}
