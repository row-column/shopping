package com.haos.service.commodity.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.haos.common.util.page.ResultCollection;
import com.haos.domain.commodity.CommodityCategory;
import com.haos.domain.commodity.query.CommodityCategoryQuery;
import com.haos.manager.commodity.CommodityCategoryManager;
import com.haos.service.commodity.CommodityCategoryService;

/**
 * CommodityCategory information service interface
 * 
 * @author WangYue
 * 
 */
public class CommodityCategoryServiceImpl implements CommodityCategoryService {
	private static final Logger log = LogManager
			.getLogger(CommodityCategoryServiceImpl.class);
	private CommodityCategoryManager commodityCategoryManager;

	@Override
	public ResultCollection addCommodityCategory(
			CommodityCategory commodityCategory) {
		ResultCollection result = new ResultCollection();
		try {
			boolean resultFlag = commodityCategoryManager
					.addCommodityCategory(commodityCategory);
			result.addDefaultModel("resultFlag", resultFlag);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error(
					"CommodityCategoryServiceImpl -> addCommodityCategory() error!!",
					e);
		}
		return result;
	}

	@Override
	public ResultCollection updateCommodityCategory(
			CommodityCategory commodityCategory) {
		ResultCollection result = new ResultCollection();
		try {
			boolean resultFlag = commodityCategoryManager
					.updateCommodityCategory(commodityCategory);
			result.addDefaultModel("resultFlag", resultFlag);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error(
					"CommodityCategoryServiceImpl -> updateCommodityCategory() error!!",
					e);
		}
		return result;
	}

	@Override
	public ResultCollection getCommodityCategoryById(Long id) {
		ResultCollection result = new ResultCollection();
		try {
			CommodityCategory commodityCategory = commodityCategoryManager
					.getCommodityCategoryById(id);
			result.addDefaultModel("commodityCategory", commodityCategory);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error(
					"CommodityCategoryServiceImpl -> getCommodityCategoryById() error!!",
					e);
		}
		return result;
	}

	@Override
	public ResultCollection getCommodityCategoryByCommodityCategoryCode(
			String commodityCategoryCode) {
		ResultCollection result = new ResultCollection();
		try {
			CommodityCategory commodityCategory = commodityCategoryManager
					.getCommodityCategoryByCommodityCategoryCode(commodityCategoryCode);
			result.addDefaultModel("commodityCategory", commodityCategory);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error(
					"CommodityCategoryServiceImpl -> getCommodityCategoryByCommodityCategoryCode() error!!",
					e);
		}
		return result;
	}

	@Override
	public ResultCollection queryCommodityCategoryListByQueryBean(
			CommodityCategoryQuery commodityCategoryQuery) {
		ResultCollection result = new ResultCollection();
		try {
			List<CommodityCategory> commodityCategoryList = commodityCategoryManager
					.queryCommodityCategoryListByQueryBean(commodityCategoryQuery);
			result.addDefaultModel("commodityCategoryList",
					commodityCategoryList);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error(
					"CommodityCategoryServiceImpl -> queryCommodityCategoryListByQueryBean() error!!",
					e);
		}
		return result;
	}

	@Override
	public ResultCollection queryCommodityCategoryListPageByQueryBean(
			CommodityCategoryQuery commodityCategoryQuery, int pageIndex,
			int pageSize) {
		ResultCollection result = new ResultCollection();
		try {
			List<CommodityCategory> commodityCategoryList = commodityCategoryManager
					.queryCommodityCategoryListPageByQueryBean(
							commodityCategoryQuery, pageIndex, pageSize);
			result.addDefaultModel("commodityCategoryList",
					commodityCategoryList);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error(
					"CommodityCategoryServiceImpl -> queryCommodityCategoryListPageByQueryBean() error!!",
					e);
		}
		return result;
	}

	@Override
	public ResultCollection deleteCommodityCategoryById(Long id) {
		ResultCollection result = new ResultCollection();
		try {
			boolean resultFlag = commodityCategoryManager
					.deleteCommodityCategoryById(id);
			result.addDefaultModel("resultFlag", resultFlag);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error(
					"CommodityCategoryServiceImpl -> deleteCommodityCategoryById() error!!",
					e);
		}
		return result;
	}

	@Override
	public ResultCollection deleteCommodityCategoryByIds(Long ids[]) {
		ResultCollection result = new ResultCollection();
		try {
			if (null != ids && ids.length > 0) {
				boolean resultFlag = commodityCategoryManager
						.deleteCommodityCategoryByIds(ids);
				result.addDefaultModel("resultFlag", resultFlag);
				result.setSuccess(true);

			} else {
				log.error("CommodityCategoryServiceImpl -> deleteCommodityCategoryById() ids param null!!");
			}
		} catch (Exception e) {
			log.error(
					"CommodityCategoryServiceImpl -> deleteCommodityCategoryById() error!!",
					e);
		}
		return result;
	}

	public void setCommodityCategoryManager(
			CommodityCategoryManager commodityCategoryManager) {
		this.commodityCategoryManager = commodityCategoryManager;
	}

}
