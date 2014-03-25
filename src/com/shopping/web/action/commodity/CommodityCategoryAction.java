package com.shopping.web.action.commodity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.shopping.common.util.CommonConstant;
import com.shopping.common.util.action.BaseAction;
import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.commodity.CommodityCategory;
import com.shopping.domain.commodity.query.CommodityCategoryQuery;
import com.shopping.service.commodity.CommodityCategoryService;


/**
 * CommodityCategory information  action
 * @author WangYue
 *
 */
public class CommodityCategoryAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static Log log = LogFactory.getLog(CommodityCategoryAction.class);
    
    /**
     * CommodityCategory information Service
     */
    private CommodityCategoryService commodityCategoryService;
    /**
     * CommodityCategory information query value class
     */
    private CommodityCategoryQuery commodityCategoryQuery;
    
    /**
     * CommodityCategory information
     */
    private CommodityCategory commodityCategory;
    
    /**
     *  Page size 
     */
    private int pageSize = CommonConstant.PAGESIZE;

    /**
     * To commodityCategory information list page
     *
     * @return
     */
    public String commodityCategoryMain() {
        if (null == commodityCategoryQuery) {
            commodityCategoryQuery = new CommodityCategoryQuery();
        }
        commodityCategoryQuery.setYn(CommonConstant.YN_NO_DELETE);     // not delete
        ResultCollection result = commodityCategoryService.queryCommodityCategoryListPageByQueryBean(commodityCategoryQuery, page, pageSize);
        setValueStack(result);
        return "commodityCategoryMain";
    }

    /**
     * 
     * To add commodityCategory information page
     * @return
     */
    public String toAddCommodityCategory() {
        this.setValueStack(null);
        return "toAddCommodityCategory";
    }

    /**
     * 
     * To update commodityCategory information page
     * @return
     */
    public String toUpdateCommodityCategory() {
    	
        if (null != commodityCategory) {
            // get commodityCategory information by id
            ResultCollection result = commodityCategoryService.getCommodityCategoryById(commodityCategory.getId());
            setValueStack(result);
        } else {
            log.error("CommodityCategoryAction!toUpdateCommodityCategory() error!");
        }
        return "toUpdateCommodityCategory";
    }
    
    /**
     * 
     * To delete commodityCategory information page
     * @return
     */
    public String toDeleteCommodityCategory() {
    	
        if (null != commodityCategory) {
            // get commodityCategory information by id
            ResultCollection result = commodityCategoryService.getCommodityCategoryById(commodityCategory.getId());
            setValueStack(result);
        } else {
            log.error("CommodityCategoryAction!toDeleteCommodityCategory() error!");
        }
        return "toDeleteCommodityCategory";
    }

	public CommodityCategoryService getCommodityCategoryService() {
		return commodityCategoryService;
	}

	public void setCommodityCategoryService(
			CommodityCategoryService commodityCategoryService) {
		this.commodityCategoryService = commodityCategoryService;
	}

	public CommodityCategoryQuery getCommodityCategoryQuery() {
		return commodityCategoryQuery;
	}

	public void setCommodityCategoryQuery(
			CommodityCategoryQuery commodityCategoryQuery) {
		this.commodityCategoryQuery = commodityCategoryQuery;
	}

	public CommodityCategory getCommodityCategory() {
		return commodityCategory;
	}

	public void setCommodityCategory(CommodityCategory commodityCategory) {
		this.commodityCategory = commodityCategory;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

  
}
