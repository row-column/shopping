package com.shopping.web.action.commodity.json;

import java.util.Date;

import com.shopping.common.util.action.BaseAction;
import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.commodity.CommodityCategory;
import com.shopping.service.commodity.CommodityCategoryService;


/**
 * Commodity Category JsonAction
 * @author WangYue
 *
 */
public class CommodityCategoryJsonAction extends BaseAction {
   // private final static Log logger = LogFactory.getLog(CommodityCategoryJsonAction.class);
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * commodity category information service interface
     */
    private CommodityCategoryService commodityCategoryService;
    
    /**
     * json result
     */
    private String result;
    
    /**
     * result msg
     */
    private String resultMsg;
    
    /**
     * Commodity category value class
     */
    private CommodityCategory commodityCategory;
    
    /**
     * ids array
     */
    private Long[]ids;

    /**
     * Add commodity category method
     *
     * @return
     */
    public String addCommodityCategory() {
        if (null != commodityCategory) {

            ResultCollection serviceResult = commodityCategoryService.addCommodityCategory(commodityCategory);
            
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
     * Update commodity category method
     *
     * @return
     */
    public String updateCommodityCategory() {
        if (null != commodityCategory) {
        	commodityCategory.setUpdateTime(new Date());

            ResultCollection serviceResult = commodityCategoryService.updateCommodityCategory(commodityCategory);
            
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
     * Delete commodity category method
     *
     * @return
     */
    public String deleteCommodityCategory() {
        if (null != commodityCategory.getId() && commodityCategory.getId().intValue() > 0) {
            ResultCollection serviceResult = commodityCategoryService.deleteCommodityCategoryById(commodityCategory.getId());
            
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
     * Delete commodity categories method
     *
     * @return
     */
    public String deleteCommodityCategories() {
        if(ids!=null&&ids.length>1){
            ResultCollection serviceResult = commodityCategoryService.deleteCommodityCategoryByIds(ids);
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false";
            }
        }else {
            result = "false";
        }
        return "out";
    }
    
    public void setIds(Long[] ids) {
		this.ids = ids;
	}

	/**
     * Check commodity category method
     *
     * @return
     */
    public String checkCommodityCategoryCode() {
        if (null != commodityCategory) {

            ResultCollection serviceResult = commodityCategoryService.getCommodityCategoryByCommodityCategoryCode(commodityCategory.getCommodityCategoryCode());
            
            if (null != serviceResult && serviceResult.getSuccess()) {
            	CommodityCategory commodityCategory=(CommodityCategory)serviceResult.get("commodityCategory");
            	if(commodityCategory!=null&&commodityCategory.getCommodityCategoryCode()!=null){
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

    public void setCommodityCategoryService(CommodityCategoryService commodityCategoryService) {
        this.commodityCategoryService = commodityCategoryService;
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

	public CommodityCategory getCommodityCategory() {
		return commodityCategory;
	}

	public void setCommodityCategory(CommodityCategory commodityCategory) {
		this.commodityCategory = commodityCategory;
	}

	public CommodityCategoryService getCommodityCategoryService() {
		return commodityCategoryService;
	}
    
  
}
