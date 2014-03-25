package com.shopping.manager.recentlyviewed;

import java.util.List;

import com.shopping.common.util.page.PageModel;
import com.shopping.domain.recentlyviewed.RecentlyViewed;
import com.shopping.domain.recentlyviewed.query.RecentlyViewedQuery;


/**
 * Recently Viewed information manager interface
 * @author WangYue
 *
 */
public interface RecentlyViewedManager {

	/**
	 * add recentlyViewed information
	 * @param recentlyViewed   recentlyViewed value class
	 * @return true:success;false:fail
	 */
	public boolean addRecentlyViewed(RecentlyViewed recentlyViewed);
	
	
	

	/**
	 * according to user code ,query recentlyViewed information.
	 * @param userCode  user code
	 * @return RecentlyViewed  recentlyViewed value class
	 */
	public List<RecentlyViewed> queryRecentlyViewedByUserCode(String userCode);
	
	
	/**
	 * query all recentlyViewed information
	 * @param query  Query recentlyViewed value class
	 * @return RecentlyViewed  recentlyViewed value class
	 */
	public List<RecentlyViewed> queryRecentlyViewedListByQueryBean(RecentlyViewedQuery recentlyViewedQuery);
	
	/**
	 * query recentlyViewed information with page
	 * @param query Query recentlyViewed value class
	 * @return RecentlyViewed recentlyViewed value class
	 */
	public PageModel<RecentlyViewed> queryRecentlyViewedListPageByQueryBean(RecentlyViewedQuery recentlyViewedQuery, int pageIndex, int pageSize);
	
	
	/**
	 * according to recentlyViewed id,delete recentlyViewed information.
	 * @param id  recentlyViewed id
	 * @return true:success;false:fail.
	 */
	public boolean deleteRecentlyViewedById(Long id);
	
	
}
