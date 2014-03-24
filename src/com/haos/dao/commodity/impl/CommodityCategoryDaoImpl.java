package com.haos.dao.commodity.impl;

import java.util.List;

import com.haos.common.util.dao.BaseDao;
import com.haos.dao.commodity.CommodityCategoryDao;
import com.haos.domain.commodity.CommodityCategory;
import com.haos.domain.commodity.query.CommodityCategoryQuery;

/**
 * CommodityCategory information DAO implementation
 * @author WangYue
 *
 */
@SuppressWarnings("rawtypes")
public class CommodityCategoryDaoImpl extends BaseDao implements CommodityCategoryDao {

	@SuppressWarnings("unchecked")
	@Override
	public boolean addCommodityCategory(CommodityCategory commodityCategory) {
		return this.insert("CommodityCategory.insert", commodityCategory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updateCommodityCategory(CommodityCategory commodityCategory) {
		return this.update("CommodityCategory.update", commodityCategory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CommodityCategory getCommodityCategoryById(Long id) {
		return (CommodityCategory)this.queryForObject("CommodityCategory.getCommodityCategoryById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CommodityCategory getCommodityCategoryByCommodityCategoryCode(String commodityCategoryCode) {
		return (CommodityCategory)this.queryForObject("CommodityCategory.getCommodityCategoryByCommodityCategoryCode", commodityCategoryCode);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CommodityCategory> queryCommodityCategoryListByQueryBean(CommodityCategoryQuery commodityCategoryQuery) {
		return this.queryForList("CommodityCategory.queryCommodityCategoryListByQueryBean",commodityCategoryQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CommodityCategory> queryCommodityCategoryListPageByQueryBean(CommodityCategoryQuery commodityCategoryQuery) {
		return this.queryForList("CommodityCategory.queryCommodityCategoryListPageByQueryBean", commodityCategoryQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteCommodityCategoryById(Long id) {
		return this.delete("CommodityCategory.deleteCommodityCategoryById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int queryCommodityCategoryCountByQueryBean(CommodityCategoryQuery commodityCategoryQuery) {
		return (Integer)this.queryForObject("CommodityCategory.queryCommodityCategoryCountByQueryBean", commodityCategoryQuery);
	}

}
