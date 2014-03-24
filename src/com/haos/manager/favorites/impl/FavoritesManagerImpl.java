package com.haos.manager.favorites.impl;

import java.util.List;

import com.haos.common.util.manager.BaseManager;
import com.haos.common.util.page.PageModel;
import com.haos.common.util.page.PageModelImpl;
import com.haos.dao.favorites.FavoritesDao;
import com.haos.domain.favorites.Favorites;
import com.haos.domain.favorites.query.FavoritesQuery;
import com.haos.manager.favorites.FavoritesManager;

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
