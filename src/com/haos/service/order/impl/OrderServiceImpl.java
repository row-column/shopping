package com.haos.service.order.impl;

import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.haos.common.util.CommonConstant;
import com.haos.common.util.date.DateUtil;
import com.haos.common.util.page.ResultCollection;
import com.haos.domain.commodity.Commodity;
import com.haos.domain.consumer.ConsumerRecords;
import com.haos.domain.level.Level;
import com.haos.domain.level.query.LevelQuery;
import com.haos.domain.order.Order;
import com.haos.domain.order.query.OrderQuery;
import com.haos.domain.send.Send;
import com.haos.domain.send.query.SendQuery;
import com.haos.domain.shoppingcart.ShoppingCart;
import com.haos.domain.user.User;
import com.haos.manager.carrier.CarrierManager;
import com.haos.manager.commodity.CommodityManager;
import com.haos.manager.consumer.ConsumerRecordsManager;
import com.haos.manager.level.LevelManager;
import com.haos.manager.order.OrderManager;
import com.haos.manager.send.SendManager;
import com.haos.manager.send.SendTypeManager;
import com.haos.manager.shoppingcart.ShoppingCartManager;
import com.haos.manager.user.UserManager;
import com.haos.service.order.OrderService;

/**
 * Order information service interface
 * 
 * @author WangYue
 * 
 */
public class OrderServiceImpl implements OrderService {
	private static final Logger log = LogManager
			.getLogger(OrderServiceImpl.class);
	private OrderManager orderManager;

	/**
	 * shopping cart information manager interface
	 */
	private ShoppingCartManager shoppingCartManager;

	/**
	 * commodity information manager interface
	 */
	private CommodityManager commodityManager;

	/**
	 * consumer records information manager interface
	 */
	private ConsumerRecordsManager consumerRecordsManager;

	/**
	 * user information manager interface
	 */
	private UserManager userManager;

	/**
	 * send information manager interface
	 */
	private SendManager sendManager;

	/**
	 * send type information manager interface
	 */
	private SendTypeManager sendTypeManager;

	/**
	 * carrier information manager interface
	 */
	private CarrierManager carrierManager;

	/**
	 * level information manager interface
	 */
	private LevelManager levelManager;
	// 创建一个可缓存的线程池
	ExecutorService pool = null;

	Queue<Order> queue = null;

	DealWithOrderThread thread = null;



	@Override
	public ResultCollection addOrder(Order order) {
		ResultCollection result = new ResultCollection();
        if(null==order) {
        	result.addDefaultModel("resultFlag", false);
    		result.setSuccess(false);
    		return result;
        }
		if (null == pool) {
			pool = Executors.newCachedThreadPool();
		}

		boolean resultFlag = doWork(order);
		result.addDefaultModel("resultFlag", resultFlag);
		result.setSuccess(true);
		return result;
	}

	private boolean doWork(Order order) {
		if (null == queue) {
			queue = new ConcurrentLinkedQueue<Order>();
		}

		if (queue.offer(order)) {
			thread = new DealWithOrderThread(queue);
			pool.execute(thread);
		}
		return false;

	}

	@Override
	public ResultCollection updateOrder(Order order) {
		ResultCollection result = new ResultCollection();
		try {
			boolean resultFlag = orderManager.updateOrder(order);
			result.addDefaultModel("resultFlag", resultFlag);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error("OrderServiceImpl -> updateOrder() error!!", e);
		}
		return result;
	}

	@Override
	public ResultCollection getOrderById(Long id) {
		ResultCollection result = new ResultCollection();
		try {
			Order order = orderManager.getOrderById(id);
			result.addDefaultModel("order", order);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error("OrderServiceImpl -> getOrderById() error!!", e);
		}
		return result;
	}

	@Override
	public ResultCollection getOrderByOrderCode(String orderCode) {
		ResultCollection result = new ResultCollection();
		try {
			Order order = orderManager.getOrderByOrderCode(orderCode);
			result.addDefaultModel("order", order);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error("OrderServiceImpl -> getOrderByOrderCode() error!!", e);
		}
		return result;
	}

	@Override
	public ResultCollection getOrderDetailById(Long id) {
		if (id != null && id > 0) {
			ResultCollection result = new ResultCollection();

			try {
				Order order = orderManager.getOrderById(id);

				if (null != order) {
					SendQuery sendQuery = new SendQuery(); // new send query
															// object name is
															// sendQuery
					sendQuery.setOrderCode(order.getOrderCode()); // set order
																	// code
					List<Send> sendList = sendManager
							.querySendListWithUniqueByQueryBean(sendQuery); // call
																			// sendQueryListByQueryBean()
																			// method
					result.addDefaultModel("sendList", sendList); // set
																	// sendList
																	// to map
					result.addDefaultModel("order", order); // set order object
															// to map
					result.setSuccess(true);
				} else {
					// set sendList to map
					result.addDefaultModel("sendList", null); 
					// set order object to map
					result.addDefaultModel("order", null); 
					result.setSuccess(false);
				}

			} catch (Exception e) {
				log.error("OrderServiceImpl -> getOrderDetailById() error!!", e);
			}
			return result;

		} else {
			return null;
		}
	}

	@Override
	public ResultCollection getOrderDetailByOrderCode(String orderCode) {
		if (!StringUtils.isBlank(orderCode)) {
			ResultCollection result = new ResultCollection();

			try {
				Order order = orderManager.getOrderByOrderCode(orderCode);

				if (null != order) {
					// new send query object name is sendQuery
					SendQuery sendQuery = new SendQuery(); 
					sendQuery.setOrderCode(orderCode); // set order code
					// call sendQueryListByQueryBean() method
					List<Send> sendList = sendManager
							.querySendListWithUniqueByQueryBean(sendQuery); 
					// set sendList to map
					result.addDefaultModel("sendList", sendList); 
					// set order object to map
					result.addDefaultModel("order", order); 
					result.setSuccess(true);
				} else {
					// set sendList to map
					result.addDefaultModel("sendList", null); 
					// set order object to map
					result.addDefaultModel("order", null); 
					result.setSuccess(false);
				}

			} catch (Exception e) {
				log.error("OrderServiceImpl -> getOrderDetailById() error!!", e);
			}
			return result;

		} else {
			return null;
		}
	}

	@Override
	public ResultCollection queryOrderListByQueryBean(OrderQuery orderQuery) {
		ResultCollection result = new ResultCollection();
		try {
			List<Order> orderList = orderManager
					.queryOrderListByQueryBean(orderQuery);
			result.addDefaultModel("orderList", orderList);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error(
					"OrderServiceImpl -> queryOrderListByQueryBean() error!!",
					e);
		}
		return result;
	}

	@Override
	public ResultCollection queryOrderListPageByQueryBean(
			OrderQuery orderQuery, int pageIndex, int pageSize) {
		ResultCollection result = new ResultCollection();
		try {
			List<Order> orderList = orderManager.queryOrderListPageByQueryBean(
					orderQuery, pageIndex, pageSize);
			result.addDefaultModel("orderList", orderList);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error(
					"OrderServiceImpl -> queryOrderListPageByQueryBean() error!!",
					e);
		}
		return result;
	}

	@Override
	public ResultCollection deleteOrderById(Long id) {
		ResultCollection result = new ResultCollection();
		try {
			boolean resultFlag = orderManager.deleteOrderById(id);
			result.addDefaultModel("resultFlag", resultFlag);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error("OrderServiceImpl -> deleteOrderById() error!!", e);
		}
		return result;
	}

	public void setOrderManager(OrderManager orderManager) {
		this.orderManager = orderManager;
	}

	@Override
	public ResultCollection deleteOrderByIds(Long ids[]) {
		ResultCollection result = new ResultCollection();
		try {
			if (null != ids && ids.length > 0) {
				boolean resultFlag = orderManager.deleteOrderByIds(ids);
				result.addDefaultModel("resultFlag", resultFlag);
				result.setSuccess(true);

			} else {
				log.error("OrderServiceImpl -> deleteOrderById() ids param null!!");
			}
		} catch (Exception e) {
			log.error("OrderServiceImpl -> deleteOrderById() error!!", e);
		}
		return result;
	}


	/**
	 * 处理订单多线程
	 * @author Helios
	 *
	 */
	
	class DealWithOrderThread implements Runnable {
		private Queue<Order> queue;
		public DealWithOrderThread(Queue<Order> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {

			synchronized (queue) {
				if (!queue.isEmpty()) {
					Order order = queue.poll();
					Send send = new Send();
					send.setTypeCode(order.getTypeCode());
					send.setCarrierCode(order.getCarrierCode());

					try {
						// get user code from order object
						String userCode = order.getUserCode(); 
						if (!StringUtils.isBlank(userCode)) {
							List<ShoppingCart> shoppingCartList = shoppingCartManager
									.queryShoppingCartByUserCode(userCode);
							if (null != shoppingCartList
									&& shoppingCartList.size() > 0) {
								for (ShoppingCart shoppingCart : shoppingCartList) {
									// random order code
									String orderCode = DateUtil
											.getOrderSerialNumber(); 
									Double amount = shoppingCart
									.getCommodityNum()
									* shoppingCart.getPrice();
									User user = null;
									user = updateOrderInfo(order, userCode,
											shoppingCart, orderCode, amount,
											user);

									// call add order method
									boolean resultFlag = orderManager
											.addOrder(order); 

									if (resultFlag) {
										Commodity commodity = updateCommodityQty(shoppingCart);

										updateUserIntetralAndLevel(user);

										addConsumerRecords(userCode, orderCode,
												amount, commodity);

										addSendInfo(order, send, shoppingCart,
												orderCode);

									} else {
										throw new RuntimeException(
												"OrderManagerImpl.addOrder.error.");
									}

								}

							} else {
								throw new RuntimeException(
										"OrderManagerImpl.shopping cart list is empty.");
							}

						} else {
							throw new RuntimeException(
									"OrderManagerImpl.user code is empty.");
						}

					} catch (Exception e) {
						log.error("OrderServiceImpl -> addOrder() error!!", e);
					}

				}
			}
		}

		/**
		 * 设置订单信息
		 * @param order 订单
		 * @param userCode 用户账号
		 * @param shoppingCart 购物车
		 * @param orderCode 订单嗲吗
		 * @param amount 金额
		 * @param user 用户
		 * @return
		 */
		private User updateOrderInfo(Order order, String userCode,
				ShoppingCart shoppingCart, String orderCode, Double amount,
				User user) {
			// set order code
			order.setOrderCode(orderCode); 
			// commodity id
			order.setCommodityId(shoppingCart
					.getCommodityId()); 
			// set commodity code
			order.setCommodityCode(shoppingCart
					.getCommodityCode()); 
			// set commodity name
			order.setCommodityName(shoppingCart
					.getCommodityName()); 
			// set commodity Number
			order.setCommodityCount(shoppingCart
					.getCommodityNum()); 
			// set order amount
			order.setAmount(amount); 
			// set create time
			order.setCreateTime(new Date()); 
			// set update time
			order.setUpdateTime(new Date()); 
			// order time
			order.setOrderTime(new Date()); 
			// set order status dealing with
			order.setStatus(CommonConstant.ORDER_DEALING); 
			
			// set yn=0
			order.setYn(CommonConstant.YN_NO_DELETE); 

			if (!StringUtils.isBlank(userCode)) {
				user = userManager
						.getUserByUserCode(userCode);
				if (StringUtils.isBlank(order
						.getUserName())) {
					// set user name
					order.setUserName(user
							.getUserName()); 
				}
			}
			return user;
		}

		/**
		 * 添加配送信息
		 * @param order 订单信息
		 * @param send  配送信息
		 * @param shoppingCart 购物车系想你
		 * @param orderCode 订单号
		 * @throws Exception
		 */
		private void addSendInfo(Order order, Send send,
				ShoppingCart shoppingCart, String orderCode) throws Exception {
			if (null != send) {
				if (!StringUtils.isBlank(orderCode)) {
					// random send code
					send.setSendCode(DateUtil.getOrderSerialNumber()); 

					if (!StringUtils.isBlank(send.getTypeCode())) {
						send.setTypeName((sendTypeManager
								.getSendTypeBySendTypeCode(send.getTypeCode()))
								.getSendTypeName()); // set type name
					}

					if (!StringUtils.isBlank(send.getCarrierCode())) {
						send.setCarrierName((carrierManager
								.getCarrierByCarrierCode(send.getCarrierCode()))
								.getCarrierName()); // set carrier name
					}
					// set deal information
					send.setDealInformation("您提交了订单，请等待系统确认"); 
					send.setOperator("客户"); // set operator
					send.setDealTime(new Date()); // set deal time
					send.setOrderCode(orderCode); // order code
					// set commodity name
					send.setCommodityName(order.getCommodityName()); 
					send.setCreateTime(new Date()); // set create time
					send.setUpdateTime(new Date()); // set update time
					send.setYn(CommonConstant.YN_NO_DELETE); // set yn =0
					// call addSend method
					boolean isSuccess = sendManager.addSend(send); 
					if (!isSuccess) {
						log.error("OrderServiceImpl -> addOrder()-->>addSend.error!!");
						throw new RuntimeException(
								"OrderManagerImpl-> addOrder()-->>addSend.error!!");
					}

					shoppingCartManager.deleteShoppingCartById(shoppingCart
							.getId()); // call deleteShoppingCartById()method
				}

			} else {
				log.error("OrderServiceImpl -> addOrder() error!!");
				throw new RuntimeException(
						"OrderServiceImpl.addOrder.parameter.empty.");
			}
		}

		/**
		 * 添加消费记录
		 * @param userCode 用户账号
		 * @param orderCode 订单号
		 * @param amount 金额
		 * @param commodity 商品信息
		 */
		private void addConsumerRecords(String userCode, String orderCode,
				Double amount, Commodity commodity) {
			// new consumer records object name is consumer records
			ConsumerRecords consumerRecords = new ConsumerRecords(); 
			consumerRecords.setUserCode(userCode); // set user code
			consumerRecords.setOrderCode(orderCode); // set order code
			// set commodity id
			consumerRecords.setCommodityId(commodity.getId()); 
			// set commodity code
			consumerRecords.setCommodityCode(commodity.getCommodityCode()); 
			// set commodity name
			consumerRecords.setCommodityName(commodity.getCommodityName()); 
			consumerRecords.setAmount(amount); // set amount
			consumerRecords.setCreateTime(new Date()); // set create time
			consumerRecords.setUpdateTime(new Date()); // set update time
			consumerRecords.setConsumerTime(new Date()); // set consumer time
			consumerRecords.setYn(CommonConstant.YN_NO_DELETE); // set yn=0
			// call addConsumerRecords() method
			boolean updateConsumerRecordsFlag = consumerRecordsManager
					.addConsumerRecords(consumerRecords); 
			if (!updateConsumerRecordsFlag) {
				log.error("OrderServiceImpl -> addOrder()->>addConsumerRecords error!!");
				throw new RuntimeException(
						"OrderServiceImpl.addOrder->>addConsumerRecords error!!");
			}
		}

		/**
		 * 更新用户积分和等级
		 * @param user
		 */
		private void updateUserIntetralAndLevel(User user) {
			// user integral and level command
			Long integral = user.getIntegral(); // get integral from user
			if (null == integral) {
				integral = 0L;
			}
			integral = integral + CommonConstant.INTEGRAL_ORDER; // submit order
																	// will plus
																	// 2
																	// integral

			user.setIntegral(integral); // set user integral
			List<Level> levelList = levelManager
					.queryLevelListByQueryBean(new LevelQuery()); // call
																	// queryLevelListByQueryBean()method
			if (null != levelList && levelList.size() > 0) {
				for (Level l : levelList) {
					if (integral >= l.getStartPoint()
							&& integral <= l.getEndPoint()) {
						user.setLevelCode(l.getLevelCode()); // set level code
						user.setLevelName(l.getLevelName()); // set level name
						break;
					}
				}

			}

			boolean updateUserIntegralAndLevelFlag = userManager
					.updateUserIntegralAndLevel(user); // call
														// updateUserIntegralAndLevel()
														// method

			if (!updateUserIntegralAndLevelFlag) {
				log.error("OrderServiceImpl -> addOrder()->>updateUserIntegralAndLevel error!!");
				throw new RuntimeException(
						"OrderServiceImpl.addOrder->>updateUserIntegralAndLevel error!!");
			}
		}

		private Commodity updateCommodityQty(ShoppingCart shoppingCart) {
			Commodity commodity = commodityManager
					.getCommodityByCommodityCode(shoppingCart
							.getCommodityCode());
			if (null != commodity
					&& !StringUtils.isBlank(commodity.getCommodityCode())) {
				commodity.setQty(commodity.getQty() - 1); // set qty
				commodity.setUpdateTime(new Date()); // set update time
				commodityManager.updateCommodityQty(commodity);
			}
			return commodity;
		}

	}
	
	public void setShoppingCartManager(ShoppingCartManager shoppingCartManager) {
		this.shoppingCartManager = shoppingCartManager;
	}

	public void setCommodityManager(CommodityManager commodityManager) {
		this.commodityManager = commodityManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public void setSendManager(SendManager sendManager) {
		this.sendManager = sendManager;
	}

	public void setSendTypeManager(SendTypeManager sendTypeManager) {
		this.sendTypeManager = sendTypeManager;
	}

	public void setCarrierManager(CarrierManager carrierManager) {
		this.carrierManager = carrierManager;
	}

	public void setConsumerRecordsManager(
			ConsumerRecordsManager consumerRecordsManager) {
		this.consumerRecordsManager = consumerRecordsManager;
	}

	public void setLevelManager(LevelManager levelManager) {
		this.levelManager = levelManager;
	}

}
