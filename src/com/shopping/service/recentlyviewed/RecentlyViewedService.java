package com.shopping.service.recentlyviewed;

import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.recentlyviewed.RecentlyViewed;
import com.shopping.domain.recentlyviewed.query.RecentlyViewedQuery;


/**
 * Recently Viewed information manager interface
 * @author WangYue
 *
 */
public interface RecentlyViewedService {

	/**
	 * add recentlyViewed information
	 * @param recentlyViewed   recentlyViewed value class
	 * @return Result
	 */
	public ResultCollection addRecentlyViewed(RecentlyViewed recentlyViewed);
	
	
	

	/**
	 * according to user code ,query recentlyViewed information.
	 * @param userCode  user code
	 * @return Result
	 */
	public ResultCollection queryRecentlyViewedByUserCode(String userCode);
	
	
	/**
	 * query all recentlyViewed information
	 * @param query  Query recentlyViewed value class
	 * @return Result
	 */
	public ResultCollection queryRecentlyViewedListByQueryBean(RecentlyViewedQuery recentlyViewedQuery);
	
	/**
	 * query recentlyViewed information with page
	 * @param query  Query recentlyViewed value class
	 * @return Result
	 */
	public ResultCollection queryRecentlyViewedListPageByQueryBean(RecentlyViewedQuery recentlyViewedQuery, int pageIndex, int pageSize);
	
	
	/**
	 * according to recentlyViewed id,delete recentlyViewed information.
	 * @param id  recentlyViewed id
	 * @return Result.
	 */
	public ResultCollection deleteRecentlyViewedById(Long id);
	
	
}
