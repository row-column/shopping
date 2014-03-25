package com.shopping.web.action.commodity;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.shopping.common.util.CommonConstant;
import com.shopping.common.util.action.BaseAction;
import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.comment.query.CommentQuery;
import com.shopping.domain.commodity.Commodity;
import com.shopping.domain.commodity.query.CommodityCategoryQuery;
import com.shopping.domain.commodity.query.CommodityQuery;
import com.shopping.domain.favorites.query.FavoritesQuery;
import com.shopping.service.comment.CommentService;
import com.shopping.service.commodity.CommodityCategoryService;
import com.shopping.service.commodity.CommodityService;
import com.shopping.service.favorites.FavoritesService;
import com.shopping.service.recentlyviewed.RecentlyViewedService;
import com.opensymphony.xwork2.ActionContext;


/**
 * Commodity information  action
 * @author WangYue
 *
 */
public class CommodityAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static Log log = LogFactory.getLog(CommodityAction.class);
    
    /**
     * Commodity information Service
     */
    private CommodityService commodityService;
    
    /**
     * commodity category information service
     */
    private CommodityCategoryService commodityCategoryService;

    /**
     * Comment information service interface
     */
    private CommentService commentService;
    
    /**
     * Recently Viewed information service interface
     */
    private RecentlyViewedService recentlyViewedService;
    
    /**
     * Favorites information service interface
     */
    private FavoritesService favoritesService;
    /**
     * Commodity information query value class
     */
    private CommodityQuery commodityQuery;
    
    
    /**
     * Commodity information
     */
    private Commodity commodity;
    
    /**
     *  Page size 
     */
    private int pageSize = CommonConstant.PAGESIZE;
    
    /**
     * commodity  id
     */
    
    private Long id;
    
    /**
     * Commodity name
     */
    private String commodityName;
    
	/**
	 * Commodity photo
	 */
	 private List<File> photo; 	
	/**
	 * 	Commodity photo file name
	 */
	private List<String> photoFileName;
		
	/**
	 * Commodity photo content type
	 */
   private List<String> photoContentType;	
   
   /**
    * Commodity photos
    */
   private List<String> commodityPhotosList;
   
   private static final int BUFFER_SIZE = 16 * 1024;

    /**
     * To commodity information list page
     *
     * @return
     */
    public String commodityMain() {
    	
    	CommodityCategoryQuery commodityCategoryQuery = new CommodityCategoryQuery(); // new commodityCategoryQuery object
    	commodityCategoryQuery.setYn(CommonConstant.YN_NO_DELETE); // set yn=0
    	ResultCollection commodityCategoryCommandCollection =commodityCategoryService.queryCommodityCategoryListByQueryBean(commodityCategoryQuery);
    	
        if (null == commodityQuery) {
            commodityQuery = new CommodityQuery();
        }
        commodityQuery.setYn(CommonConstant.YN_NO_DELETE);     // not delete
        ResultCollection result = commodityService.queryCommodityListPageByQueryBean(commodityQuery, page, pageSize);
        setValueStack(commodityCategoryCommandCollection);
        setValueStack(result);
        return "commodityMain";
    }

    /**
     * 
     * To add commodity information page
     * @return
     */
    public String toAddCommodity() {
    	CommodityCategoryQuery commodityCategoryQuery = new CommodityCategoryQuery(); // new commodityCategoryQuery object
    	commodityCategoryQuery.setYn(CommonConstant.YN_NO_DELETE); // set yn=0
    	ResultCollection commodityCategoryCommandCollection =commodityCategoryService.queryCommodityCategoryListByQueryBean(commodityCategoryQuery);
    	setValueStack(commodityCategoryCommandCollection);
        return "toAddCommodity";
    }
    

    /**
     * add commodity
     *
     * @return
     */
    public String addCommodity() {
    	
        if (null != commodity) {

            ResultCollection serviceCommandCollection = commodityService.addCommodity(commodity);
            
            if (null != serviceCommandCollection && serviceCommandCollection.getSuccess() && (Boolean) serviceCommandCollection.get("resultFlag")) {
                return  "success";
            } else {
            	return "error";
            }
        } else {
            return "error";
        }
    }

    /**
     * 
     * To update commodity information page
     * @return
     */
    public String toUpdateCommodity() {
    	CommodityCategoryQuery commodityCategoryQuery = new CommodityCategoryQuery(); // new commodityCategoryQuery object
    	commodityCategoryQuery.setYn(CommonConstant.YN_NO_DELETE); // set yn=0
    	ResultCollection commodityCategoryCommandCollection =commodityCategoryService.queryCommodityCategoryListByQueryBean(commodityCategoryQuery);
        if (null != commodity) {
            // get commodity information by id
            ResultCollection result = commodityService.getCommodityById(commodity.getId());
            setValueStack(commodityCategoryCommandCollection);
            setValueStack(result);
        } else {
            log.error("CommodityAction!toUpdateCommodity() error!");
        }
        return "toUpdateCommodity";
    }
    
    /**
     * update 
     *
     * @return
     */
    public String updateCommodity() {
    	
        if (null != commodity) {

            ResultCollection serviceCommandCollection = commodityService.updateCommodity(commodity);
            
            if (null != serviceCommandCollection && serviceCommandCollection.getSuccess() && (Boolean) serviceCommandCollection.get("resultFlag")) {
                return  "success";
            } else {
            	return "error";
            }
        } else {
            return "error";
        }
    }

    
    /**
     * 
     * To delete commodity information page
     * @return
     */
    public String toDeleteCommodity() {
    	
    	CommodityCategoryQuery commodityCategoryQuery = new CommodityCategoryQuery(); // new commodityCategoryQuery object
    	commodityCategoryQuery.setYn(CommonConstant.YN_NO_DELETE); // set yn=0
    	ResultCollection commodityCategoryCommandCollection =commodityCategoryService.queryCommodityCategoryListByQueryBean(commodityCategoryQuery);
        if (null != id&&id>0) {
            // get commodity information by id
            ResultCollection result = commodityService.getCommodityById(id);
            setValueStack(commodityCategoryCommandCollection);
            setValueStack(result);
        } else {
            log.error("CommodityAction!toDeleteCommodity() error!");
        }
        return "toDeleteCommodity";
    }
    
    
    /**
     * delete
     *
     * @return
     */
    public String deleteCommodity() {
    	
        if (null != id&& id > 0) {
            ResultCollection serviceCommandCollection = commodityService.deleteCommodityById(id);
            
                if (null != serviceCommandCollection && serviceCommandCollection.getSuccess() && (Boolean) serviceCommandCollection.get("resultFlag")) {
                	try {
    					deletePhotoById(id);
    				} catch (Exception e) {
    					log.error("CommodityAction->deleteCommodity--->>>deletePhotoById error",e);
    				}
                	return  "success";
                } else {
                	return "error";
                }
            } else {
                return "error";
            }
    }
    
    
    /**
     * 
     * To commodity detail information page
     * @return
     */
    public String detail() {
    	CommodityCategoryQuery commodityCategoryQuery = new CommodityCategoryQuery(); // new commodityCategoryQuery object
    	commodityCategoryQuery.setYn(CommonConstant.YN_NO_DELETE); // set yn=0
        setValueStack(commodityCategoryService.queryCommodityCategoryListByQueryBean(commodityCategoryQuery)); //call  query commodity category list method
    	ResultCollection commodityCommandCollection=null;// create commodityResut
    	if(null!=id){
    		if(id>0){
    			commodityCommandCollection=commodityService.getCommodityById(id);
    			if(null!=commodityCommandCollection){
    				Commodity c=(Commodity)commodityCommandCollection.get("commodity");
    				if(null!=c){
    					CommentQuery commentQuery = new CommentQuery(); //new commentQuery object
    	    			commentQuery.setCommodityCode(c.getCommodityCode()); //set query commodity code
    	    			setValueStack(commentService.queryCommentListByQueryBean(commentQuery));
    	  
    				}
    				setValueStack(commodityCommandCollection);
    			}else{
    				log.error("CommodityAction!toDetail() error!");
        			return "error";
    			}
    			
    		}else{
    			log.error("CommodityAction!toDetail() error!");
    			return "error";
    		}
    	}else{
    		log.error("CommodityAction!toDetail() error!");
    		return "error";
    	}
    	
    	
    	if(null==commodityQuery){
    		 commodityQuery = new CommodityQuery(); // new commodityQuery object
    	}
    	
    	commodityQuery.setYn(CommonConstant.YN_NO_DELETE); // set yn=0
    	
        setValueStack(commodityService.queryCommodityListPageByCategory(commodityQuery,page,pageSize)); //call queryCommodityListPageByCategory method
        
        commodityQuery.setCategoryCode(null); //set category code null
        setValueStack(commodityService.queryCommodityListByQueryBean(commodityQuery)); //call queryCommodityListByQueryBean method
    	 Map<String,Object> map=ActionContext.getContext().getSession(); //get session
         String userCode =(String)map.get("userCode"); //get user code from session
         if(!StringUtils.isBlank(userCode)){
         	setValueStack(recentlyViewedService.queryRecentlyViewedByUserCode(userCode));  //call queryRecentlyViewedByUserCode() method
         	setValueStack(favoritesService.queryFavoritesByUserCode(userCode));  //call queryFavoritesByUserCode() method
         }else{
        	 setValueStack(favoritesService.queryFavoritesListByQueryBean(new FavoritesQuery()));  //call queryFavoritesListByQueryBean() method
         }
        return "success";
    }
    
    
    
    /**
     * To commodity information list  by category page
     *
     * @return
     */
    public String listingByCategory() {
    	
    	CommodityCategoryQuery commodityCategoryQuery = new CommodityCategoryQuery(); // new commodityCategoryQuery object
    	commodityCategoryQuery.setYn(CommonConstant.YN_NO_DELETE); // set yn=0
    	setValueStack(commodityCategoryService.queryCommodityCategoryListByQueryBean(commodityCategoryQuery));
    	
    	if(null==commodityQuery){
    		 commodityQuery = new CommodityQuery(); // new commodityQuery object
    	}
    	
    	commodityQuery.setYn(CommonConstant.YN_NO_DELETE); // set yn=0
    	
        setValueStack(commodityService.queryCommodityListPageByCategory(commodityQuery,page,pageSize)); //call queryCommodityListPageByCategory method
        
        commodityQuery.setCategoryCode(null); //set category code null
        setValueStack(commodityService.queryCommodityListByQueryBean(commodityQuery)); //call queryCommodityListByQueryBean method
        
        Map<String,Object> map=ActionContext.getContext().getSession(); //get session
        String userCode =(String)map.get("userCode"); //get user code from session
        if(!StringUtils.isBlank(userCode)){
        	setValueStack(recentlyViewedService.queryRecentlyViewedByUserCode(userCode));  //call queryRecentlyViewedByUserCode() method
        }
        return SUCCESS;

    }
    
    /**
     * To commodity information list  by latest time page
     *
     * @return
     */
    public String listingByLatestTime() {
    	
    	CommodityCategoryQuery commodityCategoryQuery = new CommodityCategoryQuery(); // new commodityCategoryQuery object
    	commodityCategoryQuery.setYn(CommonConstant.YN_NO_DELETE); // set yn=0
    	setValueStack(commodityCategoryService.queryCommodityCategoryListByQueryBean(commodityCategoryQuery));
    	
    	if(null==commodityQuery){
    		 commodityQuery = new CommodityQuery(); // new commodityQuery object
    	}
    	
    	commodityQuery.setYn(CommonConstant.YN_NO_DELETE); // set yn=0
    	
        setValueStack(commodityService.queryCommodityListByLatestTime()); //call queryCommodityListByLatestTime method
        
        commodityQuery.setCategoryCode(null); //set category code null
        setValueStack(commodityService.queryCommodityListByQueryBean(commodityQuery)); //call queryCommodityListByQueryBean method
        
        Map<String,Object> map=ActionContext.getContext().getSession(); //get session
        String userCode =(String)map.get("userCode"); //get user code from session
        if(!StringUtils.isBlank(userCode)){
        	setValueStack(recentlyViewedService.queryRecentlyViewedByUserCode(userCode));  //call queryRecentlyViewedByUserCode() method
        }
        return SUCCESS;

    }
    
    /**
     * To commodity information list  by sales  count page
     *
     * @return
     */
    public String listingBySalesCount() {
    	
    	CommodityCategoryQuery commodityCategoryQuery = new CommodityCategoryQuery(); // new commodityCategoryQuery object
    	commodityCategoryQuery.setYn(CommonConstant.YN_NO_DELETE); // set yn=0
    	setValueStack(commodityCategoryService.queryCommodityCategoryListByQueryBean(commodityCategoryQuery));
    	
    	if(null==commodityQuery){
    		 commodityQuery = new CommodityQuery(); // new commodityQuery object
    	}
    	
    	commodityQuery.setYn(CommonConstant.YN_NO_DELETE); // set yn=0
    	
        setValueStack(commodityService.queryCommodityListBySalesCount()); //call queryCommodityListBySalesCount method
        
        commodityQuery.setCategoryCode(null); //set category code null
        setValueStack(commodityService.queryCommodityListByQueryBean(commodityQuery)); //call queryCommodityListByQueryBean method
        
        Map<String,Object> map=ActionContext.getContext().getSession(); //get session
        String userCode =(String)map.get("userCode"); //get user code from session
        if(!StringUtils.isBlank(userCode)){
        	setValueStack(recentlyViewedService.queryRecentlyViewedByUserCode(userCode));  //call queryRecentlyViewedByUserCode() method
        }
        
        return SUCCESS;

    }
    
    /**
     * To commodity information list 
     *
     * @return
     */
    public String listing() {
    	
    	CommodityCategoryQuery commodityCategoryQuery = new CommodityCategoryQuery(); // new commodityCategoryQuery object
    	commodityCategoryQuery.setYn(CommonConstant.YN_NO_DELETE); // set yn=0
    	setValueStack(commodityCategoryService.queryCommodityCategoryListByQueryBean(commodityCategoryQuery));
    	
    	if(null==commodityQuery){
    		 commodityQuery = new CommodityQuery(); // new commodityQuery object
    	}
    	
    	commodityQuery.setYn(CommonConstant.YN_NO_DELETE); // set yn=0
    	
        setValueStack(commodityService.queryCommodityListPageByQueryBean(commodityQuery, page, pageSize)); //call queryCommodityListPageByCategory method
        
        commodityQuery.setCategoryCode(null); //set category code null
        setValueStack(commodityService.queryCommodityListByQueryBean(commodityQuery)); //call queryCommodityListByQueryBean method
        Map<String,Object> map=ActionContext.getContext().getSession(); //get session
        String userCode =(String)map.get("userCode"); //get user code from session
        if(!StringUtils.isBlank(userCode)){
        	setValueStack(recentlyViewedService.queryRecentlyViewedByUserCode(userCode));  //call queryRecentlyViewedByUserCode() method
        }
        
        return SUCCESS;

    }
    
    /**
     * Search commodity method
     *
     * @return
     */
    public String searchCommodity() {
        if (!StringUtils.isBlank(commodityName)) {
        	String strCommodityName=null;
        	try {
				 strCommodityName=new String(commodityName.getBytes("ISO-8859-1"),"UTF-8");
				 commodityName=strCommodityName;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

          setValueStack(commodityService.searchCommodity(commodityName));
            
        }else{
        	return ERROR;
        }
		return SUCCESS;
    }
    
    /**
     * To upload commodity photo
     * @return
     */
    public String toUploadCommodityPhoto(){
    	if(null!=id){
    		ResultCollection commodityCommandCollection=commodityService.getCommodityById(id); //call getCommodityById()method
    		if(null!=commodityCommandCollection&&commodityCommandCollection.getSuccess()){
    			Commodity c=(Commodity)commodityCommandCollection.get("commodity");
    			if(null!=c&&null!=c.getId()){
    				String commodityPhotos=c.getCommodityPhoto(); //get commodity photo from commodity
    				if(!StringUtils.isBlank(commodityPhotos)){
    					commodityPhotosList= Arrays.asList(commodityPhotos.split(";")); 
    				}
    			}
    		}
    	}
    	
    	return "toUploadCommodityPhoto";
    }
    
    
    /**
     * Upload commodity photo
     * @return
     */
    public String uploadCommodityPhoto(){
    	if(null!=id){
    		ResultCollection commodityCommandCollection=commodityService.getCommodityById(id); //call getCommodityById()method
    		if(null!=commodityCommandCollection&&commodityCommandCollection.getSuccess()){
    			Commodity c=(Commodity)commodityCommandCollection.get("commodity");
    			if(null!=c&&null!=c.getId()){
    				String commodityPhotos=c.getCommodityPhoto(); //get commodity photo from commodity
    				if(!StringUtils.isBlank(commodityPhotos)){
    					c.setCommodityPhoto(commodityPhotos+savePhoto());  //set commodity photo
    					
    					ResultCollection uploadCommodityPhotoCommandCollection=commodityService.uploadCommodityPhoto(c);  //call uploadCommodityPhoto() method
    					if(null!=uploadCommodityPhotoCommandCollection&&uploadCommodityPhotoCommandCollection.getSuccess()){
    						return SUCCESS;
    					}else{
    						return ERROR;
    					}
    				}else{
    					
    					c.setCommodityPhoto(savePhoto());  //set commodity photo
    					
    					ResultCollection uploadCommodityPhotoCommandCollection=commodityService.uploadCommodityPhoto(c);  //call uploadCommodityPhoto() method
    					if(null!=uploadCommodityPhotoCommandCollection&&uploadCommodityPhotoCommandCollection.getSuccess()){
    						return SUCCESS;
    					}else{
    						return ERROR;
    					}
    				}
    			}else{
    				return ERROR;
    			}
    		}
    		
    	}else{
    		return ERROR;
    	}
    	return SUCCESS;
    }
	private String savePhoto() {
		if (null!=photo){
			StringBuffer strPhoto= new StringBuffer(); 
			List<String> photoFileNameList=new ArrayList<String>();
			for (int i = 0; i < photo.size(); i++) {
				photoFileNameList.add(new Date().getTime()
						+ getExtention(this.getPhotoFileName().get(i)));
				File photoFile = new File(ServletActionContext.getServletContext() // 得到图片保存的位置(根据root来得到图片保存的路径在tomcat下的该工程里)
						
						.getRealPath("commodityImages") + "/" + photoFileNameList.get(i));
				
				//如果photoFile文件不存在，将会自动创建。
				if(!photoFile.getParentFile().exists())
				{
					photoFile.getParentFile().mkdirs();
				}
				strPhoto.append(photoFile.getName()+";"); //set file name
				copy(photo.get(i), photoFile); // 把图片写入到上面设置的路径里
				
			}
			return strPhoto.toString();
			
		}else{
			return null;
		}

	}

    /**
     * Image copy method
     * @param src
     * @param dst
     */
    private static void copy(File src, File dst) {  
		try {
			InputStream in = null;
			OutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(src),
						BUFFER_SIZE);
				out = new BufferedOutputStream(new FileOutputStream(dst),
						BUFFER_SIZE);
				byte[] buffer = new byte[BUFFER_SIZE];
				while (in.read(buffer) > 0) {
					out.write(buffer);
				}
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
	private static String getExtention(String fileName) {
		int pos = fileName.lastIndexOf(".");
		return fileName.substring(pos);
	}

	/**
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deletePhotoById(Long id) throws Exception
	{
		
		// 得到图片保存的位置(根据root来得到图片保存的路径在tomcat下的该工程里)
		String realPath=ServletActionContext.getServletContext().getRealPath("/commodityImages");
		ResultCollection commodityResult=commodityService.getCommodityById(id);
		if(null!=commodityResult&&commodityResult.getSuccess()){
			Commodity commodity=(Commodity)commodityResult.get("commodity"); 
			
			//判断deletePhotoNames是否为空以及长度是否大于0
			if(commodity !=null&&commodity.getId()>0)
			{
				String []deletePics=commodity.getCommodityPhoto().split(";");
				for (String deletePic:deletePics){
					//根据文件目录和文件名称，创建该文件
					File deleteFile= new File(new File(realPath),deletePic);	
					
					//如果删除的文件上一级目录不存在，就创建该目录
					if(!deleteFile.getParentFile().exists())
					{
						deleteFile.getParentFile().mkdirs();
					}
					//判断deleteFile是否为null
					if(deleteFile!=null)
					{
						deleteFile.delete();	//调用删除该文件方法
					}
					
				}
				
			}
		}
		
		
	}
	public CommodityService getCommodityService() {
		return commodityService;
	}

	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}

	public CommodityQuery getCommodityQuery() {
		return commodityQuery;
	}

	public void setCommodityQuery(CommodityQuery commodityQuery) {
		this.commodityQuery = commodityQuery;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public void setCommodityCategoryService(
			CommodityCategoryService commodityCategoryService) {
		this.commodityCategoryService = commodityCategoryService;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public List<File> getPhoto() {
		return photo;
	}

	public void setPhoto(List<File> photo) {
		this.photo = photo;
	}

	public List<String> getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(List<String> photoFileName) {
		this.photoFileName = photoFileName;
	}

	public List<String> getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(List<String> photoContentType) {
		this.photoContentType = photoContentType;
	}

	public List<String> getCommodityPhotosList() {
		return commodityPhotosList;
	}

	public void setCommodityPhotosList(List<String> commodityPhotosList) {
		this.commodityPhotosList = commodityPhotosList;
	}

	public void setRecentlyViewedService(RecentlyViewedService recentlyViewedService) {
		this.recentlyViewedService = recentlyViewedService;
	}

	public void setFavoritesService(FavoritesService favoritesService) {
		this.favoritesService = favoritesService;
	}

	
}
