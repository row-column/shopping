package com.shopping.manager.favorites.impl;

import java.util.List;

import com.shopping.common.util.manager.BaseManager;
import com.shopping.common.util.page.PageModel;
import com.shopping.common.util.page.PageModelImpl;
import com.shopping.dao.favorites.FavoritesDao;
import com.shopping.domain.favorites.Favorites;
import com.shopping.domain.favorites.query.FavoritesQuery;
import com.shopping.manager.favorites.FavoritesManager;

/**
 * Favorites information DAO implementation
 * @author WangYue
 *
 */
public class FavoritesManagerImpl extends BaseManager implements FavoritesManager {
	
	/**
	 * Favorites Dao interface
	 */
	private FavoritesDao favoritesDao;

	@Override
	public boolean addFavorites(Favorites favorites) {
		return favoritesDao.addFavorites(favorites);
	}


	@Override
	public List<Favorites> queryFavoritesByUserCode(String userCode) {
		return (List<Favorites>)favoritesDao.queryFavoritesByUserCode(userCode);
	}


	@Override
	public List<Favorites> queryFavoritesListByQueryBean(FavoritesQuery favoritesQuery) {
		return (List<Favorites>)favoritesDao.queryFavoritesListByQueryBean(favoritesQuery);
	}

	@Override
	public PageModel<Favorites> queryFavoritesListPageByQueryBean(FavoritesQuery favoritesQuery,int pageIndex, int pageSize) {
		
        if (null == favoritesQuery) {
            favoritesQuery = new FavoritesQuery();
        }
        int totalItem = favoritesDao.queryFavoritesCountByQueryBean(favoritesQuery);
        
        PageModel<Favorites> favoritess = new PageModelImpl<Favorites>(pageIndex, pageSize);
        
        favoritess.setTotalItem(totalItem);
        
        favoritesQuery.setStartRow(favoritess.getStartRow());
        
        favoritesQuery.setEndRow(favoritess.getEndRow());
        
        List<Favorites> favoritesList = favoritesDao.queryFavoritesListPageByQueryBean(favoritesQuery);
        
        favoritess.addAll(favoritesList);

        return favoritess;
	}
	@Override
	public boolean deleteFavoritesById(Long id) {
		return favoritesDao.deleteFavoritesById(id);
	}


	public void setFavoritesDao(FavoritesDao favoritesDao) {
		this.favoritesDao = favoritesDao;
	}

	
}
