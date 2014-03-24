package com.haos.service.commodity;

import com.haos.common.util.page.ResultCollection;
import com.haos.domain.commodity.CommodityCategory;
import com.haos.domain.commodity.query.CommodityCategoryQuery;

/**
 * CommodityCategory information service interface
 * @author WangYue
 *
 */
public interface CommodityCategoryService {

	/**
	 * add commodityCategory information
	 * @param commodityCategory   commodityCategory value class
	 * @return Result 
	 */
	public ResultCollection addCommodityCategory(CommodityCategory commodityCategory);
	
	/**
	 * update commodityCategory information
	 * @param commodityCategory  commodityCategory value class
	 * @return Result 
	 */
	public ResultCollection updateCommodityCategory(CommodityCategory commodityCategory);
	
	/**
	 * according to commodityCategory id ,query commodityCategory information.
	 * @param id  commodityCategory id
	 * @return  Result
	 */
	public ResultCollection getCommodityCategoryById(Long id);
	
	/**
	 * according to commodityCategory code ,query commodityCategory information.
	 * @param commodityCategoryCode  commodityCategory code
	 * @return Result
	 */
	public ResultCollection getCommodityCategoryByCommodityCategoryCode(String commodityCategoryCode);
	
	/**
	 * query commodityCategory information with page
	 * @param query Query commodityCategory value class
	 * @return Result
	 */
	public ResultCollection queryCommodityCategoryListByQueryBean(CommodityCategoryQuery commodityCategoryQuery);
	
	/**
	 * query commodityCategory information with page
	 * @param query Query commodityCategory value class
	 * @return Result
	 */
	public ResultCollection queryCommodityCategoryListPageByQueryBean(CommodityCategoryQuery commodityCategoryQuery, int pageIndex, int pageSize);
	
	
	/**
	 * according to commodityCategory id,delete commodityCategory information.
	 * @param id  commodityCategory id
	 * @return Result .
	 */
	public ResultCollection deleteCommodityCategoryById(Long id);

	/**
	 * according to commodity category ids,delete commodity categories informatin.
	 * @param ids commodity category ids
 	 * @return true:success;false:fail.
	 */
	ResultCollection deleteCommodityCategoryByIds(Long[] ids);
	
}
