package com.haos.service.order.impl;

import java.util.ArrayList;
import java.util.List;

import com.haos.common.util.CommonConstant;
import com.haos.domain.employee.Employee;
import com.haos.domain.order.Order;
import com.haos.domain.order.query.OrderQuery;
import com.haos.manager.employee.EmployeeManager;
import com.haos.manager.order.OrderManager;
import com.haos.service.order.OrderDealTaskService;

/**
 * 订单处理定时器实现
 * @author Helios
 *
 */
public class OrderDealTaskServiceImpl implements OrderDealTaskService {

	/**
	 * 订单信息manager接口
	 */
	private OrderManager orderManager;
	
	/**
	 * 员工信息manager接口
	 */
	private EmployeeManager employeeManager;
	@Override
	public boolean processMonitor() {
  
		OrderQuery orderQuery = new OrderQuery();
		orderQuery.setStatus(CommonConstant.ORDER_OUTBOUND);
		List<Order> orders= orderManager.queryOrderListByQueryBean(orderQuery);
		List<Employee> employees=employeeManager.queryEmployeeListBySendEmployee(CommonConstant.IS_SENDEMPLOYEE_FLAG);
		List<Employee> matchEmployees1=null;
		List<Employee> matchEmployees2=null;
		List<Employee> matchEmployees3=null;
		List<Employee> matchEmployees4=null;
		if(null!=orders &&orders.size()>0){
			
			for(Order order:orders){
				String orderZipCode=order.getZipCode();
				for(Employee emp:employees){
					String empZipCode=emp.getZipCode();
					if(orderZipCode.equals(empZipCode)){
						if(null==matchEmployees1) matchEmployees1 =  new ArrayList<Employee>();
						matchEmployees1.add(emp);
					}else if((orderZipCode.substring(0, orderZipCode.length()-1).equals(empZipCode.substring(0,empZipCode.length()-1)))){
						if(null==matchEmployees2) matchEmployees2 =  new ArrayList<Employee>();
						matchEmployees2.add(emp);
					}else if((orderZipCode.substring(0, orderZipCode.length()-2).equals(empZipCode.substring(0,empZipCode.length()-2)))){
						if(null==matchEmployees3) matchEmployees3 =  new ArrayList<Employee>();
						matchEmployees3.add(emp);
					}else if((orderZipCode.substring(0, orderZipCode.length()-3).equals(empZipCode.substring(0,empZipCode.length()-3)))){
						if(null==matchEmployees4) matchEmployees4 =  new ArrayList<Employee>();
						matchEmployees4.add(emp);
					}
				}
				
				if(null!=matchEmployees1&&matchEmployees1.size()>0){
					// 0-matchEmployees1的长度之间的随机数n
					int n = (int) (Math.random()*(matchEmployees1.size()));
					Employee emp= matchEmployees1.get(n);
					order.setEmployeeCode(emp.getEmployeeCode());
					order.setStatus(CommonConstant.ORDER_DISPATCHING);
					orderManager.updateOrder(order);
					matchEmployees1=null;
				}else if(null!=matchEmployees2&&matchEmployees2.size()>0){
					// 0-matchEmployees2的长度之间的随机数n
					int n = (int) (Math.random()*(matchEmployees2.size()));
					Employee emp= matchEmployees2.get(n);
					order.setEmployeeCode(emp.getEmployeeCode());
					order.setStatus(CommonConstant.ORDER_DISPATCHING);
					orderManager.updateOrder(order);
					matchEmployees2=null;
				}else if(null!=matchEmployees3&&matchEmployees3.size()>0){
					// 0-matchEmployees3的长度之间的随机数n
					int n = (int) (Math.random()*(matchEmployees3.size()));
					Employee emp= matchEmployees3.get(n);
					order.setEmployeeCode(emp.getEmployeeCode());
					order.setStatus(CommonConstant.ORDER_DISPATCHING);
					orderManager.updateOrder(order);
					matchEmployees3=null;
				} else if(null!=matchEmployees4&&matchEmployees4.size()>0){
					// 0-matchEmployees4的长度之间的随机数n
					int n = (int) (Math.random()*(matchEmployees4.size()));
					Employee emp= matchEmployees4.get(n);
					order.setEmployeeCode(emp.getEmployeeCode());
					order.setStatus(CommonConstant.ORDER_DISPATCHING);
					orderManager.updateOrder(order);
					matchEmployees4=null;
				}
				
			}
		}
		
		
		return false;
	}
	public void setOrderManager(OrderManager orderManager) {
		this.orderManager = orderManager;
	}
	public void setEmployeeManager(EmployeeManager employeeManager) {
		this.employeeManager = employeeManager;
	}
	
	
}
