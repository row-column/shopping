package com.haos.manager.recentlyviewed.impl;

import java.util.List;

import com.haos.common.util.CommonConstant;
import com.haos.common.util.manager.BaseManager;
import com.haos.common.util.page.PageModel;
import com.haos.common.util.page.PageModelImpl;
import com.haos.dao.recentlyviewed.RecentlyViewedDao;
import com.haos.domain.recentlyviewed.RecentlyViewed;
import com.haos.domain.recentlyviewed.query.RecentlyViewedQuery;
import com.haos.manager.recentlyviewed.RecentlyViewedManager;

/**
 * RecentlyViewed information DAO implementation
 * @author WangYue
 *
 */
public class RecentlyViewedManagerImpl extends BaseManager implements RecentlyViewedManager {
	
	/**
	 * Recently Viewed Dao interface
	 */
	private RecentlyViewedDao recentlyViewedDao;

	@Override
	public boolean addRecentlyViewed(RecentlyViewed recentlyViewed) {
		return recentlyViewedDao.addRecentlyViewed(recentlyViewed);
	}


	@Override
	public List<RecentlyViewed> queryRecentlyViewedByUserCode(String userCode) {
		return (List<RecentlyViewed>)recentlyViewedDao.queryRecentlyViewedByUserCode(userCode);
	}


	@Override
	public List<RecentlyViewed> queryRecentlyViewedListByQueryBean(RecentlyViewedQuery recentlyViewedQuery) {
		return (List<RecentlyViewed>)recentlyViewedDao.queryRecentlyViewedListByQueryBean(recentlyViewedQuery);
	}
	
	@Override
	public PageModel<RecentlyViewed> queryRecentlyViewedListPageByQueryBean(RecentlyViewedQuery recentlyViewedQuery,int pageIndex, int pageSize) {
		
        if (null == recentlyViewedQuery) {
            recentlyViewedQuery = new RecentlyViewedQuery();
        }
        recentlyViewedQuery.setYn(CommonConstant.YN_NO_DELETE);     // not delete
        int totalItem = recentlyViewedDao.queryRecentlyViewedCountByQueryBean(recentlyViewedQuery);
        
        PageModel<RecentlyViewed> recentlyVieweds = new PageModelImpl<RecentlyViewed>(pageIndex, pageSize);
        
        recentlyVieweds.setTotalItem(totalItem);
        
        recentlyViewedQuery.setStartRow(recentlyVieweds.getStartRow());
        
        recentlyViewedQuery.setEndRow(recentlyVieweds.getEndRow());
        
        List<RecentlyViewed> recentlyViewedList = recentlyViewedDao.queryRecentlyViewedListPageByQueryBean(recentlyViewedQuery);
        
        recentlyVieweds.addAll(recentlyViewedList);

        return recentlyVieweds;
	}

	@Override
	public boolean deleteRecentlyViewedById(Long id) {
		return recentlyViewedDao.deleteRecentlyViewedById(id);
	}


	public void setRecentlyViewedDao(RecentlyViewedDao recentlyViewedDao) {
		this.recentlyViewedDao = recentlyViewedDao;
	}

	
	
}
