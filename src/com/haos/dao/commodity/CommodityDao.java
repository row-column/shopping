package com.haos.dao.commodity;

import java.util.List;

import com.haos.domain.commodity.Commodity;
import com.haos.domain.commodity.query.CommodityQuery;


/**
 * Commodity information DAO interface
 * @author WangYue
 *
 */
public interface CommodityDao {

	/**
	 * add commodity information
	 * @param commodity   commodity value class
	 * @return true:success;false:fail
	 */
	public boolean addCommodity(Commodity commodity);
	
	/**
	 * update commodity information
	 * @param commodity  commodity value class
	 * @return true:success;false:fail
	 */
	public boolean updateCommodity(Commodity commodity);
	
	/**
	 * update commodity qty information
	 * @param commodity  commodity value class
	 * @return true:success;false:fail
	 */
	public boolean updateCommodityQty(Commodity commodity);

	/**
	 * update commodity comment count information
	 * @param commodity  commodity value class
	 * @return true:success;false:fail
	 */
	public boolean updateCommodityCommentCount(Commodity commodity);

	/**
	 * update commodity viewed count information
	 * @param commodity  commodity value class
	 * @return true:success;false:fail
	 */
	public boolean updateCommodityViewedCount(Commodity commodity);
	
	/**
	 * update commodity photo information
	 * @param commodity  commodity value class
	 * @return true:success;false:fail
	 */
	public boolean uploadCommodityPhoto(Commodity commodity);
	
	/**
	 * according to commodity id ,query commodity information.
	 * @param id  commodity id
	 * @return  Commodity  commodity value class
	 */
	public Commodity getCommodityById(Long id);
	
	
	/**
	 * according to commodity code ,query commodity information.
	 * @param commodityCode  commodity code
	 * @return Commodity  commodity value class
	 */
	public Commodity getCommodityByCommodityCode(String commodityCode);
	
	/**
	 * according to commodity name like ,query commodity information.
	 * @param commodityName  commodity name
	 * @return  Commodity  commodity value class Collection
	 */
	public List<Commodity> searchCommodity(String commodityName);
	
	/**
	 * according to commodity latest time
	 * @return  Commodity List commodity value class of list
	 */
	public List<Commodity>  queryCommodityListByLatestTime();
	
	/**
	 * according to commodity sales count descend
	 * @return  Commodity List commodity value class of list
	 */
	public List<Commodity>  queryCommodityListBySalesCount();
	
	/**
	 * according to commodity  comment count descend and sales count descend
	 * @return   Commodity List commodity value class of list
	 */
	public List<Commodity>  queryCommodityListByCommentCountAndSalesCount();
	
	/**
	 * according to commodity category code ascend and comment count descend ,sales count descend
	 * @return   Commodity List commodity value class of list
	 */
	public List<Commodity>  queryCommodityListByCategoryCodeAndCommentCountAndSalesCount();
	
	/**
	 * query all commodity information
	 * @param query  Query commodity value class
	 * @return Commodity  commodity value class
	 */
	public List<Commodity> queryCommodityListByQueryBean(CommodityQuery commodityQuery);
	
	/**
	 * query commodity information with page
	 * @param query Query commodity value class
	 * @return  Commodity List commodity value class of list
	 */
	public List<Commodity> queryCommodityListPageByQueryBean(CommodityQuery commodityQuery);
	
	/**
	 * according to commodity id,delete commodity information.
	 * @param id  commodity id
	 * @return true:success;false:fail.
	 */
	public boolean deleteCommodityById(Long id);
	
	/**
	 * get commodity records 
	 * @param query  Query commodity value class 
	 * @return commodity count 
	 */
	public int queryCommodityCountByQueryBean(CommodityQuery commodityQuery);

}
