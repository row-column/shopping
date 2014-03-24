package com.haos.manager.commodity;

import java.util.List;

import com.haos.common.util.page.PageModel;
import com.haos.domain.commodity.CommodityCategory;
import com.haos.domain.commodity.query.CommodityCategoryQuery;


/**
 * CommodityCategory information manager interface
 * @author WangYue
 *
 */
public interface CommodityCategoryManager {

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
	 * query commodityCategory information with page
	 * @param query Query commodityCategory value class
	 * @return CommodityCategory commodityCategory value class
	 */
	public List<CommodityCategory> queryCommodityCategoryListByQueryBean(CommodityCategoryQuery commodityCategoryQuery);
	
	/**
	 * query commodityCategory information with page
	 * @param query Query commodityCategory value class
	 * @return CommodityCategory commodityCategory value class
	 */
	public PageModel<CommodityCategory> queryCommodityCategoryListPageByQueryBean(CommodityCategoryQuery commodityCategoryQuery, int pageIndex, int pageSize);
	
	
	/**
	 * according to commodityCategory id,delete commodityCategory information.
	 * @param id  commodityCategory id
	 * @return true:success;false:fail.
	 */
	public boolean deleteCommodityCategoryById(Long id);
	
	/**
	 * according to commodity category ids,delete commodity categories information 
	 * @param ids commodity category ids
	 * @return true:success;false:fail.
	 */
	boolean deleteCommodityCategoryByIds(Long[] ids);
	/**
	 * get commodityCategory records 
	 * @param query  Query commodityCategory value class 
	 * @return commodityCategory count 
	 */
	public int queryCommodityCategoryCountByQueryBean(CommodityCategoryQuery commodityCategoryQuery);

	
	
}
