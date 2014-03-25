package com.shopping.service.server.send.impl;

import com.shopping.common.util.CommonConstant;
import com.shopping.domain.order.Order;
import com.shopping.domain.order.query.OrderQuery;
import com.shopping.domain.send.Send;
import com.shopping.domain.send.query.SendQuery;
import com.shopping.manager.order.OrderManager;
import com.shopping.manager.send.SendManager;
import com.shopping.service.server.send.SendInfoWebService;
import org.apache.commons.lang.xwork.StringUtils;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 配送信息WebServices实现类
 * 
 * @author WangYue
 */
@WebService(endpointInterface = "com.shopping.service.server.send.SendInfoWebService", serviceName = "sendInfoService")
public class SendInfoWebServiceImpl implements SendInfoWebService {
	/**
	 * Send information manager interface
	 */
	private SendManager sendManager;

	/**
	 * Order information manager interface
	 */
	private OrderManager orderManager;

	@Override
	public boolean updateSendInfo(String sendCode,String orderCode,
			String dealInformation, String remark,String operator) {
		if (StringUtils.isBlank(sendCode)||StringUtils.isBlank(orderCode)|| StringUtils.isBlank(dealInformation)) {
			return false;
		}

		SendQuery sendQuery = new SendQuery();
		sendQuery.setSendCode(sendCode);
		sendQuery.setOrderCode(orderCode);
		sendQuery.setYn(CommonConstant.YN_NO_DELETE);
		List<Send> sendList = sendManager.querySendListWithUniqueByQueryBean(sendQuery);
		if (null != sendList && sendList.size() > 0) {
			Send send = sendList.get(0);
			send.setDealTime(new Date());
			send.setDealInformation(dealInformation);
			send.setRemark(remark);
			send.setOperator(operator);
			return sendManager.addSend(send);
		}
		return false;
	}


	@Override
	public List<Send> querySendInfoList(String employeeCode) {
		OrderQuery orderQuery = new OrderQuery();
		orderQuery.setEmployeeCode(employeeCode);
		orderQuery.setYn(CommonConstant.YN_NO_DELETE);
		List<Order> orders = orderManager.queryOrderListByQueryBean(orderQuery);
		List<Send> sends = new ArrayList<Send>();
		if (orders != null && orders.size() > 0) {
			for (Order o : orders) {
				SendQuery sendQuery = new SendQuery();
				sendQuery.setOrderCode(o.getOrderCode());
				List<Send> tempSends = sendManager.querySendListWithUniqueByQueryBean(sendQuery);
				if (null !=tempSends&&tempSends.size()>0){
					for(Send s:tempSends){
						sends.add(s);
					}
				}
			}
		}
		return sends;
	}

	@Override
	public Send getSendInfoById(Long id) {
		Send send = null;
		if (null != id && id.intValue() > 0) {
			send = sendManager.getSendById(id);
		}
		return send;
	}
	
	@Override
	public List<Send> querySendInfoListBySendCodeAndOrderCode(String sendCode,String orderCode) {
		List<Send> sendList = null;
		if (StringUtils.isNotBlank(sendCode) && StringUtils.isNotBlank(orderCode)) {
			SendQuery sendQuery= new SendQuery(); //new send query object name is sendQuery
			sendQuery.setSendCode(sendCode);  //set send code
			sendQuery.setOrderCode(orderCode);  //set order code
			 sendList=sendManager.querySendListByQueryBean(sendQuery); // call sendQueryListByQueryBean() method
		}
		return sendList;
	}
	

	public void setOrderManager(OrderManager orderManager) {
		this.orderManager = orderManager;
	}
	
	public void setSendManager(SendManager sendManager) {
		this.sendManager = sendManager;
	}

}
