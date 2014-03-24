package com.haos.manager.commodity.impl;

import java.util.Date;
import java.util.List;

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
import com.haos.domain.commodity.CommodityCategory;
import com.haos.domain.commodity.query.CommodityCategoryQuery;
import com.haos.manager.commodity.CommodityCategoryManager;

/**
 * Commodity category Manager implementation
 * @author WangYue
 *
 */
public class CommodityCategoryManagerImpl extends BaseManager implements CommodityCategoryManager {
	

    /**
     * ��־
     */
    private static final Logger log = LogManager.getLogger(CommodityCategoryManagerImpl.class);
	
	private CommodityCategoryDao commodityCategoryDao;

	@Override
	public boolean addCommodityCategory(final CommodityCategory commodityCategory) {
        boolean resultFlag = true;
        try {
            TransactionTemplate template = this.getDataSourceTransactionManager();
            template.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                    try {
                        boolean insertFlag = false;
                        if (commodityCategory != null) {
                        	commodityCategory.setCommodityCategoryCode(DateUtil.getSerialNumber());    //set commodity category code
                            commodityCategory.setCreateTime(new Date());    //set create time	
                            commodityCategory.setUpdateTime(new Date());    //set update time
                            commodityCategory.setYn(CommonConstant.YN_NO_DELETE);   //set yn=0
                            insertFlag = commodityCategoryDao.addCommodityCategory(commodityCategory);
                            
                            if (!insertFlag) {
                                throw new RuntimeException("CommodityCategoryManagerImpl.addCommodityCategory.error.");
                            } else {
                            }

                        } else {
                            log.debug("CommodityCategoryManagerImpl.addCommodityCategory.parameter.empty.");
                            throw new RuntimeException("CommodityCategoryManagerImpl.addCommodityCategory.parameter.empty.");
                        }
                    } catch (Exception e) {
                        log.error(e);
                        transactionStatus.setRollbackOnly();
                        throw new RuntimeException("CommodityCategoryManagerImpl.addCommodityCategory.exception:", e);
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
	public boolean updateCommodityCategory(CommodityCategory commodityCategory) {
        boolean resultFlag = true;
        try {
            if (null != commodityCategory) {
                commodityCategory.setUpdateTime(new Date());    //set update time
                
                boolean updateFlag = commodityCategoryDao.updateCommodityCategory(commodityCategory);
                
                if (!updateFlag) {
                	
                    throw new RuntimeException("CommodityCategoryManagerImpl.updateCommodityCategory.fail.");
                }
            } else {
                log.debug("CommodityCategoryManagerImpl.updateCommodityCategory.parameter.empty.");
                throw new RuntimeException("CommodityCategoryManagerImpl.updateCommodityCategory.parameter.empty.");
            }
        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}

	@Override
	public CommodityCategory getCommodityCategoryById(Long id) {
		return commodityCategoryDao.getCommodityCategoryById(id);
	}

	@Override
	public CommodityCategory getCommodityCategoryByCommodityCategoryCode(String commodityCategoryCode) {
		return commodityCategoryDao.getCommodityCategoryByCommodityCategoryCode(commodityCategoryCode);
	}

	@Override
	public List<CommodityCategory> queryCommodityCategoryListByQueryBean(CommodityCategoryQuery commodityCategoryQuery) {
		return commodityCategoryDao.queryCommodityCategoryListByQueryBean(commodityCategoryQuery);
	}

	@Override
	public PageModel<CommodityCategory> queryCommodityCategoryListPageByQueryBean(CommodityCategoryQuery commodityCategoryQuery,int pageIndex, int pageSize) {
		
        if (null == commodityCategoryQuery) {
            commodityCategoryQuery = new CommodityCategoryQuery();
        }
        int totalItem = commodityCategoryDao.queryCommodityCategoryCountByQueryBean(commodityCategoryQuery);
        
        PageModel<CommodityCategory> commodityCategorys = new PageModelImpl<CommodityCategory>(pageIndex, pageSize);
        
        commodityCategorys.setTotalItem(totalItem);
        
        commodityCategoryQuery.setStartRow(commodityCategorys.getStartRow());
        
        commodityCategoryQuery.setEndRow(commodityCategorys.getEndRow());
        
        List<CommodityCategory> commodityCategoryList = commodityCategoryDao.queryCommodityCategoryListPageByQueryBean(commodityCategoryQuery);
        
        commodityCategorys.addAll(commodityCategoryList);

        return commodityCategorys;
	}

	@Override
	public boolean deleteCommodityCategoryById(Long id) {
		
        boolean resultFlag = true;
        try {
            if (null != id && !("").equals(id)) {
                boolean deleteFlag = commodityCategoryDao.deleteCommodityCategoryById(id);
                if (!deleteFlag) {
                    throw new RuntimeException("CommodityCategoryManagerImpl.deleteCommodityCategory.fail.");
                }
            } else {
                log.debug("CommodityCategoryManagerImpl.deleteCommodityCategory.empty.");
                throw new RuntimeException("");
            }
        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}
	
 
	@Override
	public boolean deleteCommodityCategoryByIds(final Long[]ids){
		
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
								deleteFlag=commodityCategoryDao.deleteCommodityCategoryById(id);
							}
							if(!deleteFlag){
								throw new RuntimeException("CommodityCategoryManagerImpl.deleteCommodityCategoryByIds(),Fail.");
							}
						}else{
							throw new RuntimeException("CommodityCategoryManagerImpl.deleteCommodityCategoryByIds(), ids param null.");
						}
						
					}catch(Exception e){
						//record log
                        log.error(e);
                        // roll back
                        transactionStatus.setRollbackOnly();
                        throw new RuntimeException("CommodityCategoryManagerImpl.deleteCommodityCategoryByIds.exception:", e);
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
	public int queryCommodityCategoryCountByQueryBean(CommodityCategoryQuery commodityCategoryQuery) {
		return commodityCategoryDao.queryCommodityCategoryCountByQueryBean(commodityCategoryQuery);
	}

	public void setCommodityCategoryDao(CommodityCategoryDao commodityCategoryDao) {
		this.commodityCategoryDao = commodityCategoryDao;
	}
	
	

}
