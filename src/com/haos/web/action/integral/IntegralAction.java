package com.haos.web.action.integral;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.haos.common.util.action.BaseAction;
import com.haos.common.util.page.ResultCollection;
import com.haos.domain.level.query.LevelQuery;
import com.haos.service.level.LevelService;


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
