package com.haos.service.commodity;

import com.haos.common.util.page.ResultCollection;
import com.haos.domain.commodity.Commodity;
import com.haos.domain.commodity.query.CommodityQuery;

/**
 * Commodity information service interface
 * @author WangYue
 *
 */
public interface CommodityService {

	/**
	 * add commodity information
	 * @param commodity   commodity value class
	 * @return Result 
	 */
	public ResultCollection addCommodity(Commodity commodity);
	
	/**
	 * update commodity information
	 * @param commodity  commodity value class
	 * @return Result 
	 */
	public ResultCollection updateCommodity(Commodity commodity);
	
	/**
	 * update commodity viewed count information
	 * @param commodity  commodity value class
	 * @return Result 
	 */
	public ResultCollection updateCommodityViewedCount(Commodity commodity);
	
	/**
	 * update commodity comment information
	 * @param commodity  commodity value class
	 * @return Result 
	 */
	public ResultCollection updateCommodityCommentCount(Commodity commodity);
	
	/**
	 * update commodity qty information
	 * @param commodity  commodity value class
	 * @return Result 
	 */
	public ResultCollection updateCommodityQty(Commodity commodity);
	
	
	/**
	 * update commodity photo information
	 * @param commodity  commodity value class
	 * @return Result 
	 */
	public ResultCollection uploadCommodityPhoto(Commodity commodity);
	/**
	 * according to commodity id ,query commodity information.
	 * @param id  commodity id
	 * @return  Result
	 */
	public ResultCollection getCommodityById(Long id);
	
	/**
	 * according to commodity code ,query commodity information.
	 * @param commodityCode  commodity code
	 * @return Result
	 */
	public ResultCollection getCommodityByCommodityCode(String commodityCode);
	
	
	/**
	 * according to commodity name like ,query commodity information.
	 * @param commodityName  commodity name
	 * @return  Result
	 */
	public ResultCollection searchCommodity(String commodityName);
	/**
	 * according to commodity latest time
	 * @return  Result
	 */
	public ResultCollection  queryCommodityListByLatestTime();
	
	/**
	 * according to commodity sales count descend
	 * @return  Result
	 */
	public ResultCollection  queryCommodityListBySalesCount();
	
	/**
	 * according to commodity  comment count descend and sales count descend
	 * @return   Result
	 */
	public ResultCollection  queryCommodityListByCommentCountAndSalesCount();
	
	/**
	 * according to commodity category code ascend and comment count descend ,sales count descend
	 * @return   Result
	 */
	public ResultCollection  queryCommodityListByCategoryCodeAndCommentCountAndSalesCount();
	
	/**
	 * query commodity information with page
	 * @param query Query commodity value class
	 * @return Result
	 */
	public ResultCollection queryCommodityListByQueryBean(CommodityQuery commodityQuery);
	

	/**
	 * according to category query  commodity information with page
	 * @param query Query commodity value class
	 * @return Result
	 */
	public ResultCollection queryCommodityListPageByCategory(CommodityQuery commodityQuery,
			int pageIndex, int pageSize);
	
	/**
	 * query commodity information with page
	 * @param query Query commodity value class
	 * @return Result
	 */
	public ResultCollection queryCommodityListPageByQueryBean(CommodityQuery commodityQuery, int pageIndex, int pageSize);
	
	
	/**
	 * according to commodity id,delete commodity information.
	 * @param id  commodity id
	 * @return Result .
	 */
	public ResultCollection deleteCommodityById(Long id);

	/**
	 * according to  commodity ids,delete commodites information
	 * @param ids commodity ids
	 * @return true:success;false:fail.
	 */
	public ResultCollection deleteCommodityByIds(Long[] ids);


	
	
}
