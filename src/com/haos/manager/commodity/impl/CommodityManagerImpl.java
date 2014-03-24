package com.haos.manager.commodity.impl;

import java.util.Date;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.haos.common.util.CommonConstant;
import com.haos.common.util.date.DateUtil;
import com.haos.common.util.manager.BaseManager;
import com.haos.common.util.page.PageModel;
import com.haos.common.util.page.PageModelImpl;
import com.haos.dao.commodity.CommodityCategoryDao;
import com.haos.dao.commodity.CommodityDao;
import com.haos.domain.commodity.Commodity;
import com.haos.domain.commodity.query.CommodityQuery;
import com.haos.manager.commodity.CommodityManager;

public class CommodityManagerImpl extends BaseManager implements CommodityManager {
	

    /**
     * 日志
     */
    private static final Logger log = LogManager.getLogger(CommodityManagerImpl.class);
	
    /**
     * commodity information dao interface
     */
	private CommodityDao commodityDao;

	 /**
     * commodity interface information dao interface
     */
	private CommodityCategoryDao commodityCategoryDao;
	@Override
	public boolean addCommodity(final Commodity commodity) {
		   // 操作结果
        boolean resultFlag = true;
        try {
            // 事务 多个数据处理时，放入事务处理中 （此处作为实例，没有多个数据处理时，无需进行事务处理）
            TransactionTemplate template = this.getDataSourceTransactionManager();
            template.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                    try {
                        boolean insertFlag = false;
                        if (commodity != null) {
                        	commodity.setCommodityCode(DateUtil.getOrderSerialNumber()); //set commodity code 
                            commodity.setCreateTime(new Date()); //set  commodity create time
                            commodity.setUpdateTime(new Date()); //set commodity update time
                            /**
                             * set commodity category name
                             */
                            if(!StringUtils.isBlank(commodity.getCategoryCode())){
                            	commodity.setCategoryName((commodityCategoryDao.getCommodityCategoryByCommodityCategoryCode(commodity.getCategoryCode())).getCommodityCategoryName());
                            }
                            
                            commodity.setYn(CommonConstant.YN_NO_DELETE); //set yn =0 
                            
                            insertFlag = commodityDao.addCommodity(commodity); //call add commodity method
                            
                            // 新增失败
                            if (!insertFlag) {
                                //添加失败，抛出异常
                                throw new RuntimeException("CommodityManagerImpl.addCommodity.error.");
                            } else {
                                // 事务中的其他数据处理
                                // 调用内部方法
                            }

                        } else {
                            //对象为null，抛出异常
                            log.debug("CommodityManagerImpl.addCommodity.parameter.empty.");
                            throw new RuntimeException("CommodityManagerImpl.addCommodity.parameter.empty.");
                        }
                    } catch (Exception e) {
                        // 日志记录
                        log.error(e);
                        // 回滚
                        transactionStatus.setRollbackOnly();
                        throw new RuntimeException("CommodityManagerImpl.addCommodity.exception:", e);
                    }
                }

                // 添加 事务中的其他数据处理的内部方法

            });

        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}

	@Override
	public boolean updateCommodity(Commodity commodity) {
		// 操作结果
        boolean resultFlag = true;
        try {
            if (null != commodity) {
            	
                commodity.setUpdateTime(new Date()); //set  update time
                
                /**
                 * set commodity category name
                 */
                if(!StringUtils.isBlank(commodity.getCategoryCode())){
                	commodity.setCategoryName((commodityCategoryDao.getCommodityCategoryByCommodityCategoryCode(commodity.getCategoryCode())).getCommodityCategoryName());
                }
                
                boolean updateRouteFlag = commodityDao.updateCommodity(commodity); //call update commodity
                
                if (!updateRouteFlag) {
                	
                    //update fail,throw exception
                    throw new RuntimeException("CommodityManagerImpl.updateCommodity.fail.");
                }
            } else {
                log.debug("CommodityManagerImpl.updateCommodity.parameter.empty.");
                throw new RuntimeException("CommodityManagerImpl.updateCommodity.parameter.empty.");
            }
        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}
	
	@Override
	public boolean updateCommodityQty(Commodity commodity) {
		// 操作结果
        boolean resultFlag = true;
        try {
            if (null != commodity) {
            	
                commodity.setUpdateTime(new Date()); //set  update time
                
                boolean updateRouteFlag = commodityDao.updateCommodityQty(commodity); //call update commodity
                
                if (!updateRouteFlag) {
                	
                    //update fail,throw exception
                    throw new RuntimeException("CommodityManagerImpl.updateCommodity.fail.");
                }
            } else {
                log.debug("CommodityManagerImpl.updateCommodityQty.parameter.empty.");
                throw new RuntimeException("CommodityManagerImpl.updateCommodityQty.parameter.empty.");
            }
        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}
	
	@Override
	public boolean updateCommodityCommentCount(Commodity commodity) {
		// 操作结果
        boolean resultFlag = true;
        try {
            if (null != commodity) {
            	
                commodity.setUpdateTime(new Date()); //set  update time
                
                boolean updateRouteFlag = commodityDao.updateCommodityCommentCount(commodity); //call update commodity comment count
                
                if (!updateRouteFlag) {
                	
                    //update fail,throw exception
                    throw new RuntimeException("CommodityManagerImpl.updateCommodityCommentCount.fail.");
                }
            } else {
                log.debug("CommodityManagerImpl.updateCommodityCommentCount.parameter.empty.");
                throw new RuntimeException("CommodityManagerImpl.updateCommodityCommentCount.parameter.empty.");
            }
        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}
	
	@Override
	public boolean updateCommodityViewedCount(Commodity commodity) {
		// 操作结果
        boolean resultFlag = true;
        try {
            if (null != commodity) {
            	
                commodity.setUpdateTime(new Date()); //set  update time
                
                
                boolean updateRouteFlag = commodityDao.updateCommodityViewedCount(commodity); //call update commodity viewed count
                
                if (!updateRouteFlag) {
                	
                    //update fail,throw exception
                    throw new RuntimeException("CommodityManagerImpl.updateCommodityViewedCount.fail.");
                }
            } else {
                log.debug("CommodityManagerImpl.updateCommodityViewedCount.parameter.empty.");
                throw new RuntimeException("CommodityManagerImpl.updateCommodityViewedCount.parameter.empty.");
            }
        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}
	
	@Override
	public boolean uploadCommodityPhoto(Commodity commodity) {
		// 操作结果
        boolean resultFlag = true;
        try {
            if (null != commodity) {
            	
                commodity.setUpdateTime(new Date()); //set  update time
                
                
                boolean updateRouteFlag = commodityDao.uploadCommodityPhoto(commodity); //call uploadCommodityPhoto()method
                
                if (!updateRouteFlag) {
                	
                    //update fail,throw exception
                    throw new RuntimeException("CommodityManagerImpl.uploadCommodityPhoto.fail.");
                }
            } else {
                log.debug("CommodityManagerImpl.uploadCommodityPhoto.parameter.empty.");
                throw new RuntimeException("CommodityManagerImpl.uploadCommodityPhoto.parameter.empty.");
            }
        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}

	@Override
	public Commodity getCommodityById(Long id) {
		return commodityDao.getCommodityById(id);
	}

	@Override
	public Commodity getCommodityByCommodityCode(String commodityCode) {
		return commodityDao.getCommodityByCommodityCode(commodityCode);
	}

	@Override
	public List<Commodity> searchCommodity(String commodityName) {
		return commodityDao.searchCommodity(commodityName);
	}
	
	@Override
	public List<Commodity> queryCommodityListByLatestTime() {
		return commodityDao.queryCommodityListByLatestTime();
	}

	@Override
	public List<Commodity> queryCommodityListBySalesCount() {
		return commodityDao.queryCommodityListBySalesCount();
	}

	@Override
	public List<Commodity> queryCommodityListByCommentCountAndSalesCount() {
		return commodityDao.queryCommodityListByCommentCountAndSalesCount();
	}

	@Override
	public List<Commodity> queryCommodityListByCategoryCodeAndCommentCountAndSalesCount() {
		return commodityDao.queryCommodityListByCategoryCodeAndCommentCountAndSalesCount();
	}
	
	
	@Override
	public List<Commodity> queryCommodityListByQueryBean(CommodityQuery commodityQuery) {
		return commodityDao.queryCommodityListByQueryBean(commodityQuery);
	}

	@Override
	public PageModel<Commodity> queryCommodityListPageByQueryBean(CommodityQuery commodityQuery,int pageIndex, int pageSize) {
		
		  //必须有这行代码
        if (null == commodityQuery) {
            commodityQuery = new CommodityQuery();
        }
        //查询总数
        int totalItem = commodityDao.queryCommodityCountByQueryBean(commodityQuery);
        
        //创建翻页集合,根据第几页和每页大小
        PageModel<Commodity> commoditys = new PageModelImpl<Commodity>(pageIndex, pageSize);
        
        //设置总数,同时将会计算出开始行和结束行
        commoditys.setTotalItem(totalItem);
        
        //设置开始行
        commodityQuery.setStartRow(commoditys.getStartRow());
        
        //设置最后行
        commodityQuery.setEndRow(commoditys.getEndRow());
        
        //调用Dao翻页方法
        List<Commodity> commodityList = commodityDao.queryCommodityListPageByQueryBean(commodityQuery);
        
        //添加到翻页集合中
        commoditys.addAll(commodityList);

        return commoditys;
	}

	@Override
	public boolean deleteCommodityById(Long id) {
		
		// 操作结果
        boolean resultFlag = true;
        try {
            if (null != id && !("").equals(id)) {
                // 删除
                boolean deleteFlag = commodityDao.deleteCommodityById(id);
                if (!deleteFlag) {
                    //删除失败，抛出异常
                    throw new RuntimeException("CommodityManagerImpl.deleteCommodity.fail.");
                }
            } else {
                //记录id 为null，抛出异常
                log.debug("CommodityManagerImpl.deleteCommodity.empty.");
                throw new RuntimeException("");
            }
        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}
	
	@Override
	public boolean deleteCommodityByIds(final Long[]ids){
		
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
								deleteFlag=commodityDao.deleteCommodityById(id);
							}
							if(!deleteFlag){
								throw new RuntimeException("CommodityManagerImpl.deleteCommodityByIds(),Fail.");
							}
						}else{
							throw new RuntimeException("CommodityManagerImpl.deleteCommodityByIds(), ids param null.");
						}
						
					}catch(Exception e){
						//record log
                        log.error(e);
                        // roll back
                        transactionStatus.setRollbackOnly();
                        throw new RuntimeException("CommodityManagerImpl.deleteCommodityByIds.exception:", e);
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
	public int queryCommodityCountByQueryBean(CommodityQuery commodityQuery) {
		return commodityDao.queryCommodityCountByQueryBean(commodityQuery);
	}

	public void setCommodityDao(CommodityDao commodityDao) {
		this.commodityDao = commodityDao;
	}

	public void setCommodityCategoryDao(CommodityCategoryDao commodityCategoryDao) {
		this.commodityCategoryDao = commodityCategoryDao;
	}

}
