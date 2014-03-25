package com.shopping.service.commodity.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.commodity.Commodity;
import com.shopping.domain.commodity.query.CommodityQuery;
import com.shopping.manager.commodity.CommodityManager;
import com.shopping.service.commodity.CommodityService;

/**
 * Commodity information service interface
 * @author WangYue
 *
 */
public class CommodityServiceImpl implements CommodityService {
    private static final Logger log = LogManager.getLogger(CommodityServiceImpl.class);
	private CommodityManager commodityManager;
	@Override
	public ResultCollection addCommodity(Commodity commodity) {
		 ResultCollection result = new ResultCollection();
	        try {
	            boolean resultFlag = commodityManager.addCommodity(commodity);
	            result.addDefaultModel("resultFlag", resultFlag);
	            result.setSuccess(resultFlag);
	        } catch (Exception e) {
	            log.error("CommodityServiceImpl -> addCommodity() error!!", e);
	        }
	        return result;
	}

	@Override
	public ResultCollection updateCommodity(Commodity commodity) {
		 ResultCollection result = new ResultCollection();
	        try {
	            boolean resultFlag = commodityManager.updateCommodity(commodity);
	            result.addDefaultModel("resultFlag", resultFlag);
	            result.setSuccess(resultFlag);
	        } catch (Exception e) {
	            log.error("CommodityServiceImpl -> updateCommodity() error!!", e);
	        }
	        return result;
	}
	

	@Override
	public ResultCollection updateCommodityQty(Commodity commodity) {
		 ResultCollection result = new ResultCollection();
	        try {
	            boolean resultFlag = commodityManager.updateCommodityQty(commodity);
	            result.addDefaultModel("resultFlag", resultFlag);
	            result.setSuccess(resultFlag);
	        } catch (Exception e) {
	            log.error("CommodityServiceImpl -> updateCommodityQty() error!!", e);
	        }
	        return result;
	}
	

	@Override
	public ResultCollection updateCommodityCommentCount(Commodity commodity) {
		 ResultCollection result = new ResultCollection();
	        try {
	            boolean resultFlag = commodityManager.updateCommodityCommentCount(commodity);
	            result.addDefaultModel("resultFlag", resultFlag);
	            result.setSuccess(resultFlag);
	        } catch (Exception e) {
	            log.error("CommodityServiceImpl -> updateCommodityCommentCount() error!!", e);
	        }
	        return result;
	}
	

	@Override
	public ResultCollection updateCommodityViewedCount(Commodity commodity) {
		 ResultCollection result = new ResultCollection();
	        try {
	            boolean resultFlag = commodityManager.updateCommodityViewedCount(commodity);
	            result.addDefaultModel("resultFlag", resultFlag);
	            result.setSuccess(resultFlag);
	        } catch (Exception e) {
	            log.error("CommodityServiceImpl -> updateCommodityViewedCount() error!!", e);
	        }
	        return result;
	}
	

	public ResultCollection uploadCommodityPhoto(Commodity commodity) {
		 ResultCollection result = new ResultCollection();
	        try {
	            boolean resultFlag = commodityManager.uploadCommodityPhoto(commodity);
	            result.addDefaultModel("resultFlag", resultFlag);
	            result.setSuccess(resultFlag);
	        } catch (Exception e) {
	            log.error("CommodityServiceImpl -> uploadCommodityPhoto() error!!", e);
	        }
	        return result;
	}

	@Override
	public ResultCollection getCommodityById(Long id) {
		 ResultCollection result = new ResultCollection();
	        try {
	        	
	            Commodity commodity = commodityManager.getCommodityById(id);
	            result.addDefaultModel("commodity", commodity);
	            result.setSuccess(true);
	        } catch (Exception e) {
	            log.error("CommodityServiceImpl -> getCommodityById() error!!", e);
	        }
	        return result;
	}

	@Override
	public ResultCollection getCommodityByCommodityCode(String commodityCode) {
		 ResultCollection result = new ResultCollection();
	        try {
	            Commodity commodity = commodityManager.getCommodityByCommodityCode(commodityCode);
	            result.addDefaultModel("commodity", commodity);
	            result.setSuccess(true);
	        } catch (Exception e) {
	            log.error("CommodityServiceImpl -> getCommodityByCommodityCode() error!!", e);
	        }
	        return result;
	}

	
	@Override
	public ResultCollection searchCommodity(String commodityName) {
		ResultCollection result = new ResultCollection();
        try {
            List<Commodity> searchCommodityList = commodityManager.searchCommodity(commodityName);
            result.addDefaultModel("searchCommodityList", searchCommodityList);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("CommodityServiceImpl -> searchCommodity() error!!", e);
        }
        return result;
	}
	
	@Override
	public ResultCollection queryCommodityListByLatestTime() {
		ResultCollection result = new ResultCollection();
        try {
            List<Commodity> commodityListByLatestTime = commodityManager.queryCommodityListByLatestTime();
            result.addDefaultModel("commodityListByLatestTime", commodityListByLatestTime);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("CommodityServiceImpl -> queryCommodityListByLatestTime() error!!", e);
        }
        return result;
	}

	@Override
	public ResultCollection queryCommodityListBySalesCount() {
		ResultCollection result = new ResultCollection();
        try {
            List<Commodity> commodityListBySalesCount = commodityManager.queryCommodityListBySalesCount();
            result.addDefaultModel("commodityListBySalesCount", commodityListBySalesCount);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("CommodityServiceImpl -> queryCommodityListBySalesCount() error!!", e);
        }
        return result;
	}

	@Override
	public ResultCollection queryCommodityListByCommentCountAndSalesCount() {
		ResultCollection result = new ResultCollection();
        try {
            List<Commodity> commodityListByCommentCountAndSalesCount = commodityManager.queryCommodityListByCommentCountAndSalesCount();
            result.addDefaultModel("commodityListByCommentCountAndSalesCount", commodityListByCommentCountAndSalesCount);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("CommodityServiceImpl -> queryCommodityListByCommentCountAndSalesCount() error!!", e);
        }
        return result;
	}

	@Override
	public ResultCollection queryCommodityListByCategoryCodeAndCommentCountAndSalesCount() {
		ResultCollection result = new ResultCollection();
        try {
            List<Commodity> commodityListByCategoryCodeAndCommentCountAndSalesCount = commodityManager.queryCommodityListByCategoryCodeAndCommentCountAndSalesCount();
            result.addDefaultModel("commodityListByCategoryCodeAndCommentCountAndSalesCount", commodityListByCategoryCodeAndCommentCountAndSalesCount);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("CommodityServiceImpl -> queryCommodityListByCategoryCodeAndCommentCountAndSalesCount() error!!", e);
        }
        return result;
	}
	
	@Override
	public ResultCollection queryCommodityListByQueryBean(CommodityQuery commodityQuery) {
		ResultCollection result = new ResultCollection();
        try {
            List<Commodity> commodityList = commodityManager.queryCommodityListByQueryBean(commodityQuery);
            result.addDefaultModel("commodityList", commodityList);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("CommodityServiceImpl -> queryCommodityListByQueryBean() error!!", e);
        }
        return result;
	}
	
	@Override
	public ResultCollection queryCommodityListPageByCategory(CommodityQuery commodityQuery,
			int pageIndex, int pageSize) {
		ResultCollection result = new ResultCollection();
        try {
            List<Commodity> commodityListByCategory = commodityManager.queryCommodityListPageByQueryBean(commodityQuery,pageIndex,pageSize);
            result.addDefaultModel("commodityListByCategory", commodityListByCategory);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("CommodityServiceImpl -> queryCommodityListPageByQueryBean() error!!", e);
        }
        return result;
	}

	@Override
	public ResultCollection queryCommodityListPageByQueryBean(CommodityQuery commodityQuery,
			int pageIndex, int pageSize) {
		ResultCollection result = new ResultCollection();
        try {
            List<Commodity> commodityList = commodityManager.queryCommodityListPageByQueryBean(commodityQuery,pageIndex,pageSize);
            result.addDefaultModel("commodityList", commodityList);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("CommodityServiceImpl -> queryCommodityListPageByQueryBean() error!!", e);
        }
        return result;
	}

	@Override
	public ResultCollection deleteCommodityById(Long id) {
		 ResultCollection result = new ResultCollection();
	        try {
	            boolean resultFlag = commodityManager.deleteCommodityById(id);
	            result.addDefaultModel("resultFlag", resultFlag);
	            result.setSuccess(true);
	        } catch (Exception e) {
	            log.error("CommodityServiceImpl -> deleteCommodityById() error!!", e);
	        }
	        return result;
	}
	
	@Override
	public ResultCollection deleteCommodityByIds(Long ids[]){
		 ResultCollection result = new ResultCollection();
	        try {
	        	if(null!=ids&&ids.length>0){
	        		boolean resultFlag = commodityManager.deleteCommodityByIds(ids);
	        		result.addDefaultModel("resultFlag", resultFlag);
	        		result.setSuccess(true);
	        		
	        	}else{
	        		 log.error("CommodityServiceImpl -> deleteCommodityById() ids param null!!");
	        	}
	        } catch (Exception e) {
	            log.error("CommodityServiceImpl -> deleteCommodityById() error!!", e);
	        }
	    return result;
	}


	public void setCommodityManager(CommodityManager commodityManager) {
		this.commodityManager = commodityManager;
	}

}
