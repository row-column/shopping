package com.shopping.web.action.recentlyviewed;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.shopping.common.util.CommonConstant;
import com.shopping.common.util.action.BaseAction;
import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.recentlyviewed.RecentlyViewed;
import com.shopping.domain.recentlyviewed.query.RecentlyViewedQuery;
import com.shopping.service.recentlyviewed.RecentlyViewedService;
import com.opensymphony.xwork2.ActionContext;


/**
 * RecentlyViewed information  action
 * @author WangYue
 *
 */
public class RecentlyViewedAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static Log log = LogFactory.getLog(RecentlyViewedAction.class);
    
    /**
     * RecentlyViewed information Service
     */
    private RecentlyViewedService recentlyViewedService;
    /**
     * RecentlyViewed information query value class
     */
    private RecentlyViewedQuery recentlyViewedQuery;
    
    /**
     * RecentlyViewed information
     */
    private RecentlyViewed recentlyViewed;
    
    /**
     *  Page size 
     */
    private int pageSize = 20;

    /**
     * To recentlyViewed information list page
     *
     * @return
     */
    public String myRecentlyViewed() {
    	Map<String,Object> map=ActionContext.getContext().getSession();
        String userCode=(String) map.get("userCode");
        if(!StringUtils.isBlank(userCode)){
        	if (null == recentlyViewedQuery) {
        		recentlyViewedQuery = new RecentlyViewedQuery();
        	}
        	recentlyViewedQuery.setUserCode(userCode); //set user code
        	ResultCollection result = recentlyViewedService.queryRecentlyViewedListPageByQueryBean(recentlyViewedQuery, page, pageSize);
        	setValueStack(result);
        	
        }else{
        	return ERROR;
        }
    		
        return SUCCESS;
    }

	public RecentlyViewedQuery getRecentlyViewedQuery() {
		return recentlyViewedQuery;
	}

	public void setRecentlyViewedQuery(RecentlyViewedQuery recentlyViewedQuery) {
		this.recentlyViewedQuery = recentlyViewedQuery;
	}

	public RecentlyViewed getRecentlyViewed() {
		return recentlyViewed;
	}

	public void setRecentlyViewed(RecentlyViewed recentlyViewed) {
		this.recentlyViewed = recentlyViewed;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setRecentlyViewedService(RecentlyViewedService recentlyViewedService) {
		this.recentlyViewedService = recentlyViewedService;
	}

    
  
}
