package com.haos.web.action.favorites.json;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.haos.common.util.action.BaseAction;
import com.haos.common.util.page.ResultCollection;
import com.haos.domain.favorites.Favorites;
import com.haos.service.favorites.FavoritesService;
import com.opensymphony.xwork2.ActionContext;


/**
 * Favorites JsonAction
 * @author WangYue
 *
 */
public class FavoritesJsonAction extends BaseAction {
   // private final static Log logger = LogFactory.getLog(FavoritesJsonAction.class);
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
    private FavoritesService favoritesService;
    
    /**
     * json result
     */
    private String result;
    
    /**
     * result msg
     */
    private String resultMsg;
    
    /**
     * favorites value class
     */
    private Favorites favorites;
    
    /**
     * commodity id
     */
    private Long commodityId;
    
    /**
     * favorites id
     */
    private Long id;



    /**
     * add favorites
     *
     * @return
     */
    public String addFavorites() {
        Map<String, Object> map = new HashMap<String, Object>();
        map=ActionContext.getContext().getSession();  //get session
        String userCode=(String) map.get("userCode");
        
        if(!StringUtils.isBlank(userCode)){
        	
        	favorites= new Favorites();  // new favorites object
        	favorites.setUserCode(userCode); //set user code
        	if(commodityId!=null&&commodityId>0){
        		favorites.setCommodityId(commodityId);  //set commodity id
        	}
        	
        	ResultCollection serviceResult = favoritesService.addFavorites(favorites);
        		
        	if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
        		result = "true";
        	} else {
        		if("exist".equals(serviceResult.get("resultFlag"))){
        			result = "false*您已经添加过了"; 
        		}else{
        			result = "false";
        		}
        	}
        	
        }else{
        	result = "false*您还没有登陆登录，请登录";
        }
        return "out";
    }


    /**
     * 
     * delete favorites
     * @return
     */
    public String deleteFavorites() {
        Map<String, Object> map = new HashMap<String, Object>();
        map=ActionContext.getContext().getSession();  //get session
        String userCode=(String)map.get("userCode");
        if(!StringUtils.isBlank(userCode)){
        	 if (null != id && id > 0) {
                 ResultCollection serviceResult = favoritesService.deleteFavoritesById(id);
                 
                 if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                     result = "true";
                 } else {
                     result = "false";
                 }
             } else {
                 result = "false";
             }
        	
        }else{
        	result = "false*您还没有登陆登录";
        }
       
        return "out";
    }
    
   
    
    
    

    public void setFavoritesService(FavoritesService favoritesService) {
        this.favoritesService = favoritesService;
    }


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

	public Favorites getFavorites() {
		return favorites;
	}

	public void setFavorites(Favorites favorites) {
		this.favorites = favorites;
	}

	public FavoritesService getFavoritesService() {
		return favoritesService;
	}


	public Long getCommodityId() {
		return commodityId;
	}


	public void setCommodityId(Long commodityId) {
		this.commodityId = commodityId;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

  
}
