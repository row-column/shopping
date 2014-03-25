package com.shopping.service.order;

/**
 * 订单处理定时器接口
 * @author Helios
 *
 */
public interface OrderDealTaskService {

	/**
	 * 处理订单方法
	 * @return
	 */
	public boolean processMonitor();
}
