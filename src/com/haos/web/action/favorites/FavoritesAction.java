package com.haos.web.action.favorites;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.haos.common.util.CommonConstant;
import com.haos.common.util.action.BaseAction;
import com.haos.common.util.page.ResultCollection;
import com.haos.domain.favorites.Favorites;
import com.haos.domain.favorites.query.FavoritesQuery;
import com.haos.service.favorites.FavoritesService;
import com.opensymphony.xwork2.ActionContext;


/**
 * Favorites information  action
 * @author WangYue
 *
 */
public class FavoritesAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static Log log = LogFactory.getLog(FavoritesAction.class);
    
    /**
     * Favorites information Service
     */
    private FavoritesService favoritesService;
    /**
     * Favorites information query value class
     */
    private FavoritesQuery favoritesQuery;
    
    /**
     * Favorites information
     */
    private Favorites favorites;
    
    /**
     *  Page size 
     */
    private int pageSize = 20;

    /**
     * To favorites information list page
     *
     * @return
     */
    public String myFavorites() {
    	Map<String,Object> map=ActionContext.getContext().getSession();
        String userCode=(String) map.get("userCode");
        if(!StringUtils.isBlank(userCode)){
        	if (null == favoritesQuery) {
        		favoritesQuery = new FavoritesQuery();
        	}
        	favoritesQuery.setUserCode(userCode); //set user code
        	favoritesQuery.setYn(CommonConstant.YN_NO_DELETE);     // not delete
        	ResultCollection result = favoritesService.queryFavoritesListPageByQueryBean(favoritesQuery, page, pageSize);
        	setValueStack(result);
        	
        }else{
           return ERROR;        	
        }
        return SUCCESS;
    }

	public FavoritesQuery getFavoritesQuery() {
		return favoritesQuery;
	}

	public void setFavoritesQuery(FavoritesQuery favoritesQuery) {
		this.favoritesQuery = favoritesQuery;
	}

	public Favorites getFavorites() {
		return favorites;
	}

	public void setFavorites(Favorites favorites) {
		this.favorites = favorites;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setFavoritesService(FavoritesService favoritesService) {
		this.favoritesService = favoritesService;
	}

    
  
}
