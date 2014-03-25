package com.shopping.manager.order.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.shopping.common.util.CommonConstant;
import com.shopping.common.util.manager.BaseManager;
import com.shopping.common.util.page.PageModel;
import com.shopping.common.util.page.PageModelImpl;
import com.shopping.dao.commodity.CommodityDao;
import com.shopping.dao.order.OrderDao;
import com.shopping.dao.user.UserDao;
import com.shopping.domain.order.Order;
import com.shopping.domain.order.query.OrderQuery;
import com.shopping.domain.send.Send;
import com.shopping.manager.order.OrderManager;

public class OrderManagerImpl extends BaseManager implements OrderManager {
	

    /**
     * ־
     */
    private static final Logger log = LogManager.getLogger(OrderManagerImpl.class);
	
    /**
     * order information dao interface
     */
	private OrderDao orderDao;
	
	/**
	 * commodity information dao interface
	 */
	private CommodityDao commodityDao;
	
	/**
	 * user information dao interface
	 */
	private UserDao userDao;
	

	
	@Override
	public boolean addOrder(final Order order) {
		   boolean resultFlag = true;
	        try {
	            TransactionTemplate template = this.getDataSourceTransactionManager();
	            template.execute(new TransactionCallbackWithoutResult() {
	                @Override
	                protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
	                    try {
	                        boolean insertFlag = false;
	                        
	                        if (order != null) {
	                        	  insertFlag = orderDao.addOrder(order);  //call add order method
	                        	  
	                        	  
	                        	if (!insertFlag) {
	                                 throw new RuntimeException("OrderManagerImpl.addOrder.error.");
	                             } 

	                        		
	                        } else {
	                            log.debug("OrderManagerImpl.addOrder.parameter.empty.");
	                            throw new RuntimeException("OrderManagerImpl.addOrder.parameter.empty.");
	                        }
	                    } catch (Exception e) {
	                        log.error(e);
	                        transactionStatus.setRollbackOnly();
	                        throw new RuntimeException("OrderManagerImpl.addOrder.exception:", e);
	                    }
	                }


	            });

	        } catch (Exception e) {
	            resultFlag = false;
	            log.error(e);
	        }
	        
	        return resultFlag;
	        
}
	

	@Override
	public boolean addOrder(final Order order,final Send send) {
        boolean resultFlag = true;
        try {
            TransactionTemplate template = this.getDataSourceTransactionManager();
            template.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                    try {
                        boolean insertFlag = false;
                        
                        if (order != null) {
                        	  insertFlag = orderDao.addOrder(order);  //call add order method
                        	  
                        	  
                        	if (!insertFlag) {
                                 throw new RuntimeException("OrderManagerImpl.addOrder.error.");
                             } 

                        		
                        } else {
                            log.debug("OrderManagerImpl.addOrder.parameter.empty.");
                            throw new RuntimeException("OrderManagerImpl.addOrder.parameter.empty.");
                        }
                    } catch (Exception e) {
                        log.error(e);
                        transactionStatus.setRollbackOnly();
                        throw new RuntimeException("OrderManagerImpl.addOrder.exception:", e);
                    }
                }


            });

        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}

	@Override
	public boolean updateOrder(Order order) {
		// result flag
        boolean resultFlag = true;
        try {
            if (null != order) {
                order.setUpdateTime(new Date()); //set update time
                
                if(!StringUtils.isBlank(order.getCommodityCode())){
                	order.setCommodityName((commodityDao.getCommodityByCommodityCode(order.getCommodityCode())).getCommodityName()); //set commodity name
                }
                
                if(!StringUtils.isBlank(order.getUserCode())){
                	order.setUserName((userDao.getUserByUserCode(order.getUserCode())).getUserName()); //set user name
                }
                
                boolean updateRouteFlag = orderDao.updateOrder(order); // call update order method
                
                if (!updateRouteFlag) {
                	
                    throw new RuntimeException("OrderManagerImpl.updateOrder.fail.");
                }
            } else {
                log.debug("OrderManagerImpl.updateOrder.parameter.empty.");
                throw new RuntimeException("OrderManagerImpl.updateOrder.parameter.empty.");
            }
        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}

	@Override
	public boolean updateOrderStatus(Order order) {
		// result flag
        boolean resultFlag = true;
        try {
            if (null != order) {
                order.setUpdateTime(new Date()); //set update time
                
                boolean updateRouteFlag = orderDao.updateOrderStatus(order); // call update order method
                
                if (!updateRouteFlag) {
                	
                    throw new RuntimeException("OrderManagerImpl.updateOrderStatus.fail.");
                }
            } else {
                log.debug("OrderManagerImpl.updateOrderStatus.parameter.empty.");
                throw new RuntimeException("OrderManagerImpl.updateOrderStatus.parameter.empty.");
            }
        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}

	@Override
	public Order getOrderById(Long id) {
		return orderDao.getOrderById(id);
	}

	@Override
	public Order getOrderByOrderCode(String orderCode) {
		return orderDao.getOrderByOrderCode(orderCode);
	}

	@Override
	public List<Order> queryOrderListByQueryBean(OrderQuery orderQuery) {
		return orderDao.queryOrderListByQueryBean(orderQuery);
	}

	@Override
	public PageModel<Order> queryOrderListPageByQueryBean(OrderQuery orderQuery,int pageIndex, int pageSize) {
		
        if (null == orderQuery) {
            orderQuery = new OrderQuery();
        }
        orderQuery.setYn(CommonConstant.YN_NO_DELETE);     // not delete
        int totalItem = orderDao.queryOrderCountByQueryBean(orderQuery);
        
        PageModel<Order> orders = new PageModelImpl<Order>(pageIndex, pageSize);
        
        orders.setTotalItem(totalItem);
        
        orderQuery.setStartRow(orders.getStartRow());
        
        orderQuery.setEndRow(orders.getEndRow());
        
        List<Order> orderList = orderDao.queryOrderListPageByQueryBean(orderQuery);
        
        orders.addAll(orderList);

        return orders;
	}

	@Override
	public boolean deleteOrderById(Long id) {
		
        boolean resultFlag = true;
        try {
            if (null != id && !("").equals(id)) {
                boolean deleteFlag = orderDao.deleteOrderById(id);
                if (!deleteFlag) {
                    throw new RuntimeException("OrderManagerImpl.deleteOrder.fail.");
                }
            } else {
                log.debug("OrderManagerImpl.deleteOrder.empty.");
                throw new RuntimeException("");
            }
        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}
	
	@Override
	public boolean deleteOrderByIds(final Long[]ids){
		
		// result flag
        boolean resultFlag = true;
        try {
        	//deal with many data of transaction, you should execute this transaction.
        	TransactionTemplate template =this.getDataSourceTransactionManager();
        	template.execute(new TransactionCallbackWithoutResult() {
				
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
					try{
						boolean deleteFlag=false; //delete result flag
						//judge on ids whether null or not
						if(ids!=null&&ids.length>0){
							//Traverse array ids
							for(Long id:ids){
								deleteFlag=orderDao.deleteOrderById(id);
							}
							if(!deleteFlag){
								throw new RuntimeException("OrderManagerImpl.deleteOrderByIds(),Fail.");
							}
						}else{
							throw new RuntimeException("OrderManagerImpl.deleteOrderByIds(), ids param null.");
						}
						
					}catch(Exception e){
						//record log
                        log.error(e);
                        // roll back
                        transactionStatus.setRollbackOnly();
                        throw new RuntimeException("OrderManagerImpl.deleteOrderByIds.exception:", e);
					}
				}
			});
        }catch(Exception e){
        	resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}

	@Override
	public int queryOrderCountByQueryBean(OrderQuery orderQuery) {
		return orderDao.queryOrderCountByQueryBean(orderQuery);
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public void setCommodityDao(CommodityDao commodityDao) {
		this.commodityDao = commodityDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
