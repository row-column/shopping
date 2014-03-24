package com.haos.web.action.commodity.json;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.haos.common.util.action.BaseAction;
import com.haos.common.util.page.ResultCollection;
import com.haos.domain.commodity.Commodity;
import com.haos.service.commodity.CommodityService;


/**
 * Commodity JsonAction
 * @author WangYue
 *
 */
public class CommodityJsonAction extends BaseAction {
  private final static Log logger = LogFactory.getLog(CommodityJsonAction.class);
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * commodity category Service interface
     */
    private CommodityService commodityService;
    
    
    /**
     * json return result
     */
    private String result;
    
    /**
     * alert information
     */
    private String resultMsg;
    
    /**
     * commodity value class
     */
    private Commodity commodity;
    
    private Long id;
    
    /**
     * commodity code array
     */
    private Long[]ids;
    
    private String removeCommodityPhoto;
    
    /**
     *  add commodity method
     *
     * @return
     */
    public String addCommodity() {
    	
        if (null != commodity) {
            ResultCollection serviceResult = commodityService.addCommodity(commodity);
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false*" + (String) serviceResult.get("resultMsg");
            }
        } else {
            result = "false";
        }
        return "out";
    }

    /**
     * update commodity information
     *
     * @return
     */
    public String updateCommodity() {
        if (null != commodity) {

            ResultCollection serviceResult = commodityService.updateCommodity(commodity);
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false";
            }
        } else {
            result = "false";
        }
        return "out";
    }
    
    /**
     * update commodity information
     *
     * @return
     */
    public String updateCommodityQty() {
        if (null != commodity) {

            ResultCollection serviceResult = commodityService.updateCommodityQty(commodity);
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false";
            }
        } else {
            result = "false";
        }
        return "out";
    }
    
    /**
     * update commodity information
     *
     * @return
     */
    public String updateCommodityCommentCount() {
        if (null != commodity) {

            ResultCollection serviceResult = commodityService.updateCommodityCommentCount(commodity);
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false";
            }
        } else {
            result = "false";
        }
        return "out";
    }
    
    /**
     * update commodity information
     *
     * @return
     */
    public String updateCommodityViewedCount() {
        if (null != commodity) {

            ResultCollection serviceResult = commodityService.updateCommodityViewedCount(commodity);
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false";
            }
        } else {
            result = "false";
        }
        return "out";
    }

    /**
     * delete commodity information
     *
     * @return
     */
    public String deleteCommodity() {
    	Long commodityId=commodity.getId();
        if (null != commodityId && commodityId.intValue() > 0) {
            ResultCollection serviceResult = commodityService.deleteCommodityById(commodityId);  // call deleteCommodityById()method
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
            	try {
					deletePhotoById(commodityId);
				} catch (Exception e) {
					logger.error("CommodityJsonAction->deleteCommodity--->>>deletePhotoById error",e);
				}
                result = "true";
            } else {
                result = "false";
            }
        } else {
            result = "false";
        }
        return "out";
    }
    
    /**
     * delete more commodities information
     *
     * @return
     */
    public String deleteCommodities() {
        if(ids!=null&&ids.length>1){
            ResultCollection serviceResult = commodityService.deleteCommodityByIds(ids); //call deleteCommodityByIds()method
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
            	for (Long commodityId:ids){
            		try {
    					deletePhotoById(commodityId);
    				} catch (Exception e) {
    					logger.error("CommodityJsonAction->deleteCommodities--->>>deletePhotoById error",e);
    				}
            	}
                result = "true";
            } else {
                result = "false";
            }
        }else {
            result = "false";
        }
        return "out";
    }
    
    /**
     * check commodity code
     *
     * @return
     */
    public String checkCommodityCode() {
        if (null != commodity) {

            ResultCollection serviceResult = commodityService.getCommodityByCommodityCode(commodity.getCommodityCode());
            
            if (null != serviceResult && serviceResult.getSuccess()) {
            	Commodity commodity=(Commodity)serviceResult.get("commodity");
            	if(commodity!=null&&commodity.getCommodityCode()!=null){
            		result = "exist";
            	}else{
            		result = "ok";
            	}
            } else {
            	result = "ok";
            }
        } 
        return "out";
    }

    
    /**
     * update commodity information
     *
     * @return
     */
    public String removeCommodityPhoto() {
        if (null != id ) {

        	ResultCollection commodityResult = commodityService.getCommodityById(id);
        	if (null != commodityResult && commodityResult.getSuccess() ){
        		Commodity commodity =(Commodity)commodityResult.get("commodity");
        		commodity.setCommodityPhoto(commodity.getCommodityPhoto().replace(removeCommodityPhoto+";",""));
        		ResultCollection serviceResult = commodityService.updateCommodity(commodity);
        		
        		if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
        			try {
        				deletePhoto(removeCommodityPhoto);
					} catch (Exception e) {
						logger.error("CommodityJsonAction->removeCommodityPhoto--->>>deletePhoto error",e);
					}
        			result = "true";
        		} else {
        			result = "商品图片失败！";
        		}
        		
        	}else{
        		result="商品编号不正确！";
        	}
        } else {
            result = "商品编号不存在！";
        }
        return "out";
    }
    
    
	/**
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deletePhoto(String deletePhotoName) throws Exception
	{
		
		// 得到图片保存的位置(根据root来得到图片保存的路径在tomcat下的该工程里)
		String realPath=ServletActionContext.getServletContext().getRealPath("/commodityImages");
		
		//判断deletePhotoNames是否为空以及长度是否大于0
		if(deletePhotoName !=null&&deletePhotoName.length()>0)
		{
			//根据文件目录和文件名称，创建该文件
			File deleteFile= new File(new File(realPath),deletePhotoName);	
			
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
    public void setCommodityService(CommodityService commodityService) {
        this.commodityService = commodityService;
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

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public CommodityService getCommodityService() {
		return commodityService;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}

	public String getRemoveCommodityPhoto() {
		return removeCommodityPhoto;
	}

	public void setRemoveCommodityPhoto(String removeCommodityPhoto) {
		this.removeCommodityPhoto = removeCommodityPhoto;
	}

}
