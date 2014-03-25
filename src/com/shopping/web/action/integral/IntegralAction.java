package com.shopping.web.action.integral;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.shopping.common.util.action.BaseAction;
import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.level.query.LevelQuery;
import com.shopping.service.level.LevelService;


/**
 * Integral information  action
 * @author WangYue
 *
 */
public class IntegralAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static Log log = LogFactory.getLog(IntegralAction.class);
    
    /**
     * Level information Service information
     */
    private LevelService levelService;
   /* *//**
     * Integral information query value class
     *//*
    private IntegralQuery integralQuery;*/
    
    
    /**
     *  Page size 
     */
    private int pageSize = 20;

    /**
     * To integral information list page
     *
     * @return
     */
    public String myIntegral() {
        
        setValueStack(levelService.queryLevelListByQueryBean(new LevelQuery())); //call queryLevelListByQueryBean() method
       
        return SUCCESS;
    }

	public void setLevelService(LevelService levelService) {
		this.levelService = levelService;
	}

    
}
