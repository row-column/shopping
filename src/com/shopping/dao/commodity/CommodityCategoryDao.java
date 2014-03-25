package com.shopping.dao.commodity;

import java.util.List;

import com.shopping.domain.commodity.CommodityCategory;
import com.shopping.domain.commodity.query.CommodityCategoryQuery;


/**
 * CommodityCategory information DAO interface
 * @author WangYue
 *
 */
public interface CommodityCategoryDao {

	/**
	 * add commodityCategory information
	 * @param commodityCategory   commodityCategory value class
	 * @return true:success;false:fail
	 */
	public boolean addCommodityCategory(CommodityCategory commodityCategory);
	
	/**
	 * update commodityCategory information
	 * @param commodityCategory  commodityCategory value class
	 * @return true:success;false:fail
	 */
	public boolean updateCommodityCategory(CommodityCategory commodityCategory);
	
	/**
	 * according to commodityCategory id ,query commodityCategory information.
	 * @param id  commodityCategory id
	 * @return  CommodityCategory  commodityCategory value class
	 */
	public CommodityCategory getCommodityCategoryById(Long id);
	
	/**
	 * according to commodityCategory code ,query commodityCategory information.
	 * @param commodityCategoryCode  commodityCategory code
	 * @return CommodityCategory  commodityCategory value class
	 */
	public CommodityCategory getCommodityCategoryByCommodityCategoryCode(String commodityCategoryCode);
	
	/**
	 * query all commodityCategory information
	 * @param query  Query commodityCategory value class
	 * @return CommodityCategory  commodityCategory value class
	 */
	public List<CommodityCategory> queryCommodityCategoryListByQueryBean(CommodityCategoryQuery commodityCategoryQuery);
	
	/**
	 * query commodityCategory information with page
	 * @param query Query commodityCategory value class
	 * @return CommodityCategory commodityCategory value class
	 */
	public List<CommodityCategory> queryCommodityCategoryListPageByQueryBean(CommodityCategoryQuery commodityCategoryQuery);
	
	/**
	 * according to commodityCategory id,delete commodityCategory information.
	 * @param id  commodityCategory id
	 * @return true:success;false:fail.
	 */
	public boolean deleteCommodityCategoryById(Long id);
	
	/**
	 * get commodityCategory records 
	 * @param query  Query commodityCategory value class 
	 * @return commodityCategory count 
	 */
	public int queryCommodityCategoryCountByQueryBean(CommodityCategoryQuery commodityCategoryQuery);
	
	
}
