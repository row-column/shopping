package com.shopping.manager.favorites;

import java.util.List;

import com.shopping.common.util.page.PageModel;
import com.shopping.domain.favorites.Favorites;
import com.shopping.domain.favorites.query.FavoritesQuery;


/**
 * Favorites information manager interface
 * @author WangYue
 *
 */
public interface FavoritesManager {

	/**
	 * add favorites information
	 * @param favorites   favorites value class
	 * @return true:success;false:fail
	 */
	public boolean addFavorites(Favorites favorites);
	
	
	

	/**
	 * according to user code ,query favorites information.
	 * @param userCode  user code
	 * @return Favorites  favorites value class
	 */
	public List<Favorites> queryFavoritesByUserCode(String userCode);
	
	
	/**
	 * query all favorites information
	 * @param query  Query favorites value class
	 * @return Favorites  favorites value class
	 */
	public List<Favorites> queryFavoritesListByQueryBean(FavoritesQuery favoritesQuery);
	
	/**
	 * query favorites information with page
	 * @param query Query favorites value class
	 * @return Favorites favorites value class
	 */
	public PageModel<Favorites> queryFavoritesListPageByQueryBean(FavoritesQuery favoritesQuery, int pageIndex, int pageSize);
	
	
	/**
	 * according to favorites id,delete favorites information.
	 * @param id  favorites id
	 * @return true:success;false:fail.
	 */
	public boolean deleteFavoritesById(Long id);
	
	
}
