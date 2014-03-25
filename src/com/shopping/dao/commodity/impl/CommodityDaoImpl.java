package com.shopping.dao.commodity.impl;

import java.util.List;

import com.shopping.common.util.dao.BaseDao;
import com.shopping.dao.commodity.CommodityDao;
import com.shopping.domain.commodity.Commodity;
import com.shopping.domain.commodity.query.CommodityQuery;

/**
 * Commodity information DAO implementation
 * @author WangYue
 *
 */
@SuppressWarnings("rawtypes")
public class CommodityDaoImpl extends BaseDao implements CommodityDao {

	@SuppressWarnings("unchecked")
	@Override
	public boolean addCommodity(Commodity commodity) {
		return this.insert("Commodity.insert", commodity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updateCommodity(Commodity commodity) {
		return this.update("Commodity.update", commodity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updateCommodityQty(Commodity commodity) {
		return this.update("Commodity.updateCommodityQty", commodity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updateCommodityCommentCount(Commodity commodity) {
		return this.update("Commodity.updateCommodityCommentCount", commodity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updateCommodityViewedCount(Commodity commodity) {
		return this.update("Commodity.updateCommodityViewedCount", commodity);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean uploadCommodityPhoto(Commodity commodity) {
		return this.update("Commodity.uploadCommodityPhoto", commodity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Commodity getCommodityById(Long id) {
		return (Commodity)this.queryForObject("Commodity.getCommodityById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Commodity getCommodityByCommodityCode(String commodityCode) {
		return (Commodity)this.queryForObject("Commodity.getCommodityByCommodityCode", commodityCode);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Commodity> searchCommodity(String commodityName) {
		return this.queryForList("Commodity.searchCommodity", commodityName);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Commodity> queryCommodityListByLatestTime() {
		return this.queryForList("Commodity.queryCommodityListByLatestTime");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commodity> queryCommodityListBySalesCount() {
		return this.queryForList("Commodity.queryCommodityListBySalesCount");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commodity> queryCommodityListByCommentCountAndSalesCount() {
		return this.queryForList("Commodity.queryCommodityListByCommentCountAndSalesCount");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commodity> queryCommodityListByCategoryCodeAndCommentCountAndSalesCount() {
		return this.queryForList("Commodity.queryCommodityListByCategoryCodeAndCommentCountAndSalesCount");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commodity> queryCommodityListByQueryBean(CommodityQuery commodityQuery) {
		return this.queryForList("Commodity.queryCommodityListByQueryBean",commodityQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commodity> queryCommodityListPageByQueryBean(CommodityQuery commodityQuery) {
		return this.queryForList("Commodity.queryCommodityListPageByQueryBean", commodityQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteCommodityById(Long id) {
		return this.delete("Commodity.deleteCommodityById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int queryCommodityCountByQueryBean(CommodityQuery commodityQuery) {
		return (Integer)this.queryForObject("Commodity.queryCommodityCountByQueryBean", commodityQuery);
	}


}
