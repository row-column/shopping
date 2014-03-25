package com.shopping.dao.favorites;

import java.util.List;

import com.shopping.domain.favorites.Favorites;
import com.shopping.domain.favorites.query.FavoritesQuery;


/**
 * Favorites information DAO interface
 * @author WangYue
 *
 */
public interface FavoritesDao {

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
	 * query all favorites information with page
	 * @param query  Query favorites value class
	 * @return Favorites  favorites value class
	 */
	public List<Favorites> queryFavoritesListPageByQueryBean(FavoritesQuery favoritesQuery);
	
	
	/**
	 * according to favorites id,delete favorites information.
	 * @param id  favorites id
	 * @return true:success;false:fail.
	 */
	public boolean deleteFavoritesById(Long id);
	
	/**
	 * get favorites records 
	 * @param query  Query favorites value class 
	 * @return favorites count 
	 */
	public int queryFavoritesCountByQueryBean(FavoritesQuery favoritesQuery);
}
