package com.shopping.web.action.employee;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.shopping.common.util.CommonConstant;
import com.shopping.common.util.action.BaseAction;
import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.employee.EmployeeFun;
import com.shopping.domain.employee.query.EmployeeFunQuery;
import com.shopping.domain.employee.query.EmployeeQuery;
import com.shopping.service.employee.EmployeeFunService;
import com.shopping.service.employee.EmployeeService;


/**
 * EmployeeFun information  action
 * @author WangYue
 *
 */
public class EmployeeFunAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static Log log = LogFactory.getLog(EmployeeFunAction.class);
    
    /**
     * EmployeeFun information Service
     */
    private EmployeeFunService employeeFunService;
    /**
     * EmployeeFun information query value class
     */
    private EmployeeFunQuery employeeFunQuery;
    
    /**
     * EmployeeFun information
     */
    //private EmployeeFun employeeFun;
    
    /**
     * Employee information Service
     */
    private EmployeeService employeeService;

	/**
     * Employee information query value class
     */
    private EmployeeQuery employeeQuery;
    
    /**
     * user code
     */
    private String userCode;
    
    
    /**
     *  Page size 
     */
    private int pageSize = CommonConstant.PAGESIZE;

    /**
     * To employeeFun information list page
     *
     * @return
     */
    public String employeeFunList() {
        if (null == employeeFunQuery) {
            employeeFunQuery = new EmployeeFunQuery();
        }
        employeeFunQuery.setYn(CommonConstant.YN_NO_DELETE);     // not delete
        ResultCollection result = employeeFunService.queryEmployeeFunListPageByQueryBean(employeeFunQuery, page, pageSize);
        setValueStack(result);
        return "employeeFunList";
    }
    

    /**
     * To employee fun information main page
     *
     * @return
     */
    public String employeeFunMain() {
        if (null == employeeQuery) {
            employeeQuery = new EmployeeQuery();
        }
        employeeQuery.setStatus(CommonConstant.STATUS_AVAILABLE);//set employee available status
        employeeQuery.setYn(CommonConstant.YN_NO_DELETE);     // not delete
        
        try{
        	
        	ResultCollection result = employeeService.queryEmployeeListPageByQueryBean(employeeQuery, page, pageSize);
        	setValueStack(result);
        }catch(Exception e){
        	e.printStackTrace();
        }
        return "employeeFunMain";
    }

    /**
     * 
     * To add employeeFun information page
     * @return
     */
    public String toAddEmployeeFun() {
        this.setValueStack(null);
        return "toAddEmployeeFun";
    }

    /**
     * 
     * To update employeeFun information page
     * @return
     */
    public String toUpdateEmployeeFun() {
    	
        if (null != employeeFunQuery) {
           setValueStack(employeeFunService.queryEmployeeFunListByQueryBean(employeeFunQuery)); // call queryEmployeeFunListByQueryBean() method
        } else {
            log.error("EmployeeFunAction!toUpdateEmployeeFun() employeeFunQuery empty!");
        }
        return "toUpdateEmployeeFun";
    }
    
    /**
     * 
     * To delete employeeFun information page
     * @return
     */
    public String toDeleteEmployeeFun() {
    	
        if (null != employeeFunQuery) {
           setValueStack(employeeFunService.queryEmployeeFunListByQueryBean(employeeFunQuery)); // call queryEmployeeFunListByQueryBean() method
        } else {
            log.error("EmployeeFunAction!toUpdateEmployeeFun() employeeFunQuery empty!");
        }
        return "toDeleteEmployeeFun";
    }



	public String getUserCode() {
		return userCode;
	}


	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}


	public void setEmployeeFunService(EmployeeFunService employeeFunService) {
		this.employeeFunService = employeeFunService;
	}


	public void setEmployeeFunQuery(EmployeeFunQuery employeeFunQuery) {
		this.employeeFunQuery = employeeFunQuery;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}


	public void setEmployeeQuery(EmployeeQuery employeeQuery) {
		this.employeeQuery = employeeQuery;
	}
	 public int getPageSize() {
			return pageSize;
		}


		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}

	
}
