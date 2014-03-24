package com.haos.dao.favorites.impl;

import java.util.List;

import com.haos.common.util.dao.BaseDao;
import com.haos.dao.favorites.FavoritesDao;
import com.haos.domain.favorites.Favorites;
import com.haos.domain.favorites.query.FavoritesQuery;

/**
 * Favorites information DAO implementation
 * @author WangYue
 *
 */
@SuppressWarnings("rawtypes")
public class FavoritesDaoImpl extends BaseDao implements FavoritesDao {

	@SuppressWarnings("unchecked")
	@Override
	public boolean addFavorites(Favorites favorites) {
		return this.insert("Favorites.insert", favorites);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Favorites> queryFavoritesByUserCode(String userCode) {
		return (List<Favorites>)this.queryForList("Favorites.queryFavoritesByUserCode", userCode);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Favorites> queryFavoritesListByQueryBean(FavoritesQuery favoritesQuery) {
		return (List<Favorites>)this.queryForList("Favorites.queryFavoritesListByQueryBean", favoritesQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Favorites> queryFavoritesListPageByQueryBean(FavoritesQuery favoritesQuery) {
		return this.queryForList("Favorites.queryFavoritesListPageByQueryBean", favoritesQuery);
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteFavoritesById(Long id) {
		return this.delete("Favorites.deleteFavoritesById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int queryFavoritesCountByQueryBean(FavoritesQuery favoritesQuery) {
		return (Integer)this.queryForObject("Favorites.queryFavoritesCountByQueryBean", favoritesQuery);
	}
	
}
