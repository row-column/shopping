package com.haos.web.action.fun;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.haos.common.util.CommonConstant;
import com.haos.common.util.action.BaseAction;
import com.haos.domain.fun.Fun;
import com.haos.domain.fun.query.FunQuery;
import com.haos.service.fun.FunService;


/**
 * Fun information  action
 * @author WangYue
 *
 */
public class FunAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static Log log = LogFactory.getLog(FunAction.class);
    
    /**
     * Fun information service interface
     */
    private FunService funService;
    
    /**
     * Fun information query value class
     */
    private FunQuery funQuery;
    
    /**
     * Fun information
     */
    private Fun fun;
    
    /**
     *  Page size 
     */
    private int pageSize = CommonConstant.PAGESIZE;

    /**
     * To fun information list page
     *
     * @return
     */
    public String funMain() {
       if (null == funQuery) {
    			funQuery = new FunQuery();
    	}
    	
    	setValueStack(funService.queryFunListPageByQueryBean(funQuery, page, pageSize)); //call queryFunListPageByQueryBean()method
    		
        return "funMain";
    }

    /**
     * 
     * To add fun information page
     * @return
     */
    public String toAddFun() {
    	
        setValueStack(null);
        
        return "toAddFun";
    }

    /**
     * 
     * To update fun information page
     * @return
     */
    public String toUpdateFun() {
    	
        if (null != fun&&null!=fun.getId()) {
            setValueStack(funService.getFunById(fun.getId())); //call getFunById() method
        } else {
            log.error("FunAction!toUpdateFun() error!");
        }
        return "toUpdateFun";
    }
    
    /**
     * 
     * To delete fun information page
     * @return
     */
    public String toDeleteFun() {
        if (null != fun&&null!=fun.getId()) {
        	setValueStack(funService.getFunById(fun.getId()));  //call getFunById() method
        } else {
            log.error("FunAction!toUpdateFun() error!");
        }
        
        return "toDeleteFun";
    }

    
    
	public FunService getFunService() {
		return funService;
	}

	public void setFunService(FunService funService) {
		this.funService = funService;
	}

	public FunQuery getFunQuery() {
		return funQuery;
	}

	public void setFunQuery(FunQuery funQuery) {
		this.funQuery = funQuery;
	}

	public Fun getFun() {
		return fun;
	}

	public void setFun(Fun fun) {
		this.fun = fun;
	}

}
