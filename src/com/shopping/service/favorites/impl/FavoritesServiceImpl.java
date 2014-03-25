package com.shopping.service.favorites.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.shopping.common.util.CommonConstant;
import com.shopping.common.util.page.PageModel;
import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.commodity.Commodity;
import com.shopping.domain.favorites.Favorites;
import com.shopping.domain.favorites.query.FavoritesQuery;
import com.shopping.domain.shoppingcart.ShoppingCart;
import com.shopping.manager.commodity.CommodityManager;
import com.shopping.manager.favorites.FavoritesManager;
import com.shopping.manager.shoppingcart.ShoppingCartManager;
import com.shopping.service.favorites.FavoritesService;

/**
 * Favorites information DAO implementation
 * @author WangYue
 *
 */
public class FavoritesServiceImpl  implements FavoritesService {
	 private static final Logger log = LogManager.getLogger(FavoritesServiceImpl.class);
	
	/**
	 * FavoritesManager information Manager interface
	 */
	private FavoritesManager favoritesManager;
	
	/**
	 * ShoppingCartManager information Manager interface
	 */
	private ShoppingCartManager shoppingCartManager;
	
	/**
	 * Commodity information manager interface
	 */
	private CommodityManager commodityManager;

	@Override
	public ResultCollection addFavorites(Favorites favorites) {
		if(null!=favorites){
			ResultCollection result = new ResultCollection();
			try {
				if(!StringUtils.isBlank(favorites.getUserCode())){
					List<Favorites> favoritesList=favoritesManager.queryFavoritesByUserCode(favorites.getUserCode());
					
					if(null!=favoritesList&&favoritesList.size()>0){
						
						for(Favorites f:favoritesList){
							
							if(null!=favorites.getCommodityId()&&favorites.getCommodityId()>0){
								Commodity commodity= commodityManager.getCommodityById(favorites.getCommodityId()); //  call getCommodityById()method
								if(null!=commodity&&null!=commodity.getId()){
									if(commodity.getId().equals(f.getCommodityId())&&commodity.getCommodityCode().equals(f.getCommodityCode())){
										result.addDefaultModel("resultFlag", "exist");
										
									}else{
										favorites.setCommodityCode(commodity.getCommodityCode());  //set commodity code
										favorites.setCommodityName(commodity.getCommodityName());  //set commodity name
										//new price  < old price
				             			if(null!=commodity.getNewPrice()&&commodity.getNewPrice()>0){
				             				Double price=commodity.getNewPrice()<commodity.getPrice()?commodity.getNewPrice():commodity.getPrice();
				             				favorites.setPrice(price); //set price
				             				
				             			}else{
				             				favorites.setPrice(commodity.getPrice()); //set price
				             			}
										favorites.setCommodityPhoto(commodity.getCommodityPhoto()); //set commodity photo
										favorites.setViewedCount(commodity.getViewedCount()); //set commodity viewed count
										favorites.setCommentCount(commodity.getCommentCount()); //set commodity comment count
									    favorites.setIsRead(CommonConstant.YN_NO_DELETE); //set  is read =0
									    favorites.setStatus(commodity.getStatus()); //set commodity status
									    favorites.setCreateTime(new Date()); //set create time
									    favorites.setUpdateTime(new Date()); //set update time
									    favorites.setYn(CommonConstant.YN_NO_DELETE); //set yn=0
									    boolean resultFlag = favoritesManager.addFavorites(favorites);
										result.addDefaultModel("resultFlag", resultFlag);
										result.setSuccess(true);
									}
									
									
								}else{
									log.error("FavoritesServiceImpl -> addFavorites() id empty");
									throw new RuntimeException("FavoritesServiceImpl -> addFavorites() id empty");
								}
								
							}else{
								List<ShoppingCart> shoppingCartList=shoppingCartManager.queryShoppingCartByUserCode(favorites.getUserCode()); //call queryShoppingCartByUserCode()method
								
								if(null!=shoppingCartList&&shoppingCartList.size()>0){
									
									
									for(ShoppingCart shoppingCart:shoppingCartList){
										if((f.getCommodityId().equals(shoppingCart.getCommodityId()))&&(f.getCommodityCode().equals(shoppingCart.getCommodityCode()))){
											result.addDefaultModel("resultFlag", "exist");
										}else{
											favorites.setCommodityId(shoppingCart.getCommodityId()); //set commodity id
											favorites.setCommodityCode(shoppingCart.getCommodityCode());  //set commodity code
											favorites.setCommodityName(shoppingCart.getCommodityName());  //set commodity name
											favorites.setPrice(shoppingCart.getPrice()); //set commodity price
											favorites.setCommodityPhoto(shoppingCart.getCommodityPhoto()); //set commodity photo
											favorites.setViewedCount(shoppingCart.getViewedCount()); //set commodity viewed count
											favorites.setCommentCount(shoppingCart.getCommentCount()); //set commodity comment count
											favorites.setIsRead(CommonConstant.YN_NO_DELETE); //set  is read =0
											favorites.setStatus(shoppingCart.getStatus()); //set commodity status
											favorites.setCreateTime(new Date()); //set create time
											favorites.setUpdateTime(new Date()); //set update time
											favorites.setYn(CommonConstant.YN_NO_DELETE); //set yn=0
											boolean resultFlag = favoritesManager.addFavorites(favorites);
											result.addDefaultModel("resultFlag", resultFlag);
											result.setSuccess(true);
											
										}
									}
									
								}else{
									log.error("FavoritesServiceImpl -> addFavorites() shoppingCartList empty!");
									throw new RuntimeException("FavoritesServiceImpl -> shoppingCartList empty!");
								}
								
							}
						}
					}else{
						if(null!=favorites.getCommodityId()&&favorites.getCommodityId()>0){
							Commodity commodity= commodityManager.getCommodityById(favorites.getCommodityId()); //  call getCommodityById()method
							if(null!=commodity&&null!=commodity.getId()){
								favorites.setCommodityCode(commodity.getCommodityCode());  //set commodity code
								favorites.setCommodityName(commodity.getCommodityName());  //set commodity name
								//new price  < old price
		             			if(null!=commodity.getNewPrice()&&commodity.getNewPrice()>0){
		             				Double price=commodity.getNewPrice()<commodity.getPrice()?commodity.getNewPrice():commodity.getPrice();
		             				favorites.setPrice(price); //set price
		             				
		             			}else{
		             				favorites.setPrice(commodity.getPrice()); //set price
		             			}
								favorites.setCommodityPhoto(commodity.getCommodityPhoto()); //set commodity photo
								favorites.setViewedCount(commodity.getViewedCount()); //set commodity viewed count
								favorites.setCommentCount(commodity.getCommentCount()); //set commodity comment count
							    favorites.setIsRead(CommonConstant.YN_NO_DELETE); //set  is read =0
							    favorites.setStatus(commodity.getStatus()); //set commodity status
							    favorites.setCreateTime(new Date()); //set create time
							    favorites.setUpdateTime(new Date()); //set update time
							    favorites.setYn(CommonConstant.YN_NO_DELETE); //set yn=0
							    boolean resultFlag = favoritesManager.addFavorites(favorites);
								result.addDefaultModel("resultFlag", resultFlag);
								result.setSuccess(true);
							}else{
								log.error("FavoritesServiceImpl -> addFavorites() id empty");
								throw new RuntimeException("FavoritesServiceImpl -> addFavorites() id empty");
							}
							
						}else{
							List<ShoppingCart> shoppingCartList=shoppingCartManager.queryShoppingCartByUserCode(favorites.getUserCode()); //call queryShoppingCartByUserCode()method
							
							if(null!=shoppingCartList&&shoppingCartList.size()>0){
								for(ShoppingCart shoppingCart:shoppingCartList){
									favorites.setCommodityId(shoppingCart.getCommodityId()); //set commodity id
									favorites.setCommodityCode(shoppingCart.getCommodityCode());  //set commodity code
									favorites.setCommodityName(shoppingCart.getCommodityName());  //set commodity name
									favorites.setPrice(shoppingCart.getPrice()); //set commodity price
									favorites.setCommodityPhoto(shoppingCart.getCommodityPhoto()); //set commodity photo
									favorites.setViewedCount(shoppingCart.getViewedCount()); //set commodity viewed count
									favorites.setCommentCount(shoppingCart.getCommentCount()); //set commodity comment count
								    favorites.setIsRead(CommonConstant.YN_NO_DELETE); //set  is read =0
								    favorites.setStatus(shoppingCart.getStatus()); //set commodity status
								    favorites.setCreateTime(new Date()); //set create time
								    favorites.setUpdateTime(new Date()); //set update time
								    favorites.setYn(CommonConstant.YN_NO_DELETE); //set yn=0
								    boolean resultFlag = favoritesManager.addFavorites(favorites);
									result.addDefaultModel("resultFlag", resultFlag);
									result.setSuccess(true);
								}
								
							}else{
								log.error("FavoritesServiceImpl -> addFavorites() shoppingCartList empty!");
								throw new RuntimeException("FavoritesServiceImpl -> shoppingCartList empty!");
							}
							
						}
					}
					
				}else{
					log.error("FavoritesServiceImpl -> user code empty!");
					throw new RuntimeException("FavoritesServiceImpl -> user code empty!");
				}
				
			
				
			} catch (Exception e) {
				log.error("FavoritesServiceImpl -> addFavorites() error!!", e);
				throw new RuntimeException("FavoritesServiceImpl -> addFavorites() error!!");
			}
			return result;
			
			
		}else{
			log.error("FavoritesServiceImpl -> addFavorites() favorites empty");
			throw new RuntimeException("FavoritesServiceImpl -> addFavorites() favorites empty");
		}
	}


	@Override
	public ResultCollection queryFavoritesByUserCode(String userCode) {
		ResultCollection result = new ResultCollection();
        try {
            List<Favorites> favoritesList = favoritesManager.queryFavoritesByUserCode(userCode);
            result.addDefaultModel("favoritesList", favoritesList);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("FavoritesServiceImpl -> queryFavoritesByUserCode() error!!", e);
        }
        return result;
	}


	@Override
	public ResultCollection queryFavoritesListByQueryBean(FavoritesQuery favoritesQuery) {
		 ResultCollection result = new ResultCollection();
	        try {
	            List<Favorites> favoritesList = favoritesManager.queryFavoritesListByQueryBean(favoritesQuery);
	            result.addDefaultModel("favoritesList", favoritesList);
	            result.setSuccess(true);
	        } catch (Exception e) {
	            log.error("FavoritesServiceImpl -> queryFavoritesListByQueryBean() error!!", e);
	        }
	        return result;
	}
	
	@Override
	public ResultCollection queryFavoritesListPageByQueryBean(FavoritesQuery favoritesQuery,
			int pageIndex, int pageSize) {
		ResultCollection result = new ResultCollection();
		if(null==favoritesQuery){
			favoritesQuery = new FavoritesQuery();
		}
        try {
        	PageModel<Favorites> favoritesList = favoritesManager.queryFavoritesListPageByQueryBean(favoritesQuery,pageIndex,pageSize);
            result.addDefaultModel("favoritesList", favoritesList);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("FavoritesServiceImpl -> queryFavoritesListPageByQueryBean() error!!", e);
        }
        return result;
	}

	@Override
	public ResultCollection deleteFavoritesById(Long id) {
		 ResultCollection result = new ResultCollection();
	        try {
	            boolean resultFlag = favoritesManager.deleteFavoritesById(id);
	            result.addDefaultModel("resultFlag", resultFlag);
	            result.setSuccess(true);
	        } catch (Exception e) {
	            log.error("FavoritesServiceImpl -> deleteFavoritesById() error!!", e);
	        }
	        return result;
	}


	public void setFavoritesManager(FavoritesManager favoritesManager) {
		this.favoritesManager = favoritesManager;
	}


	public void setShoppingCartManager(ShoppingCartManager shoppingCartManager) {
		this.shoppingCartManager = shoppingCartManager;
	}


	public void setCommodityManager(CommodityManager commodityManager) {
		this.commodityManager = commodityManager;
	}

	
}
