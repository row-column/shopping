package com.haos.service.favorites;

import com.haos.common.util.page.ResultCollection;
import com.haos.domain.favorites.Favorites;
import com.haos.domain.favorites.query.FavoritesQuery;


/**
 * Favorites information manager interface
 * @author WangYue
 *
 */
public interface FavoritesService {

	/**
	 * add favorites information
	 * @param favorites   favorites value class
	 * @return Result
	 */
	public ResultCollection addFavorites(Favorites favorites);
	
	
	

	/**
	 * according to user code ,query favorites information.
	 * @param userCode  user code
	 * @return Result
	 */
	public ResultCollection queryFavoritesByUserCode(String userCode);
	
	
	/**
	 * query all favorites information
	 * @param query  Query favorites value class
	 * @return Result
	 */
	public ResultCollection queryFavoritesListByQueryBean(FavoritesQuery favoritesQuery);
	

	/**
	 * query favorites information with page
	 * @param query  Query favorites value class
	 * @return Result
	 */
	public ResultCollection queryFavoritesListPageByQueryBean(FavoritesQuery favoritesQuery, int pageIndex, int pageSize);
	
	
	/**
	 * according to favorites id,delete favorites information.
	 * @param id  favorites id
	 * @return Result.
	 */
	public ResultCollection deleteFavoritesById(Long id);
	
	
}
