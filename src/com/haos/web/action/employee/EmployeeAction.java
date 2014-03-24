package com.haos.web.action.employee;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.haos.common.util.CommonConstant;
import com.haos.common.util.action.BaseAction;
import com.haos.common.util.page.ResultCollection;
import com.haos.domain.employee.Employee;
import com.haos.domain.employee.query.EmployeeQuery;
import com.haos.service.employee.EmployeeService;
import com.opensymphony.xwork2.ActionContext;


/**
 * Employee information  action
 * @author WangYue
 *
 */
public class EmployeeAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static Log log = LogFactory.getLog(EmployeeAction.class);
    
    /**
     * Employee information Service
     */
    private EmployeeService employeeService;
    public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
     * Employee information query value class
     */
    private EmployeeQuery employeeQuery;
    
    /**
     * Employee information
     */
    private Employee employee;
    
    /**
     *  Page size 
     */
    private int pageSize = CommonConstant.PAGESIZE;
    

    /**
     * To employee information main page
     *
     * @return
     */
    public String employeeMain() {
        if (null == employeeQuery) {
            employeeQuery = new EmployeeQuery();
        }
        employeeQuery.setStatus(null);//set employee status null
        employeeQuery.setYn(CommonConstant.YN_NO_DELETE);     // not delete
        try{
        	
        	ResultCollection result = employeeService.queryEmployeeListPageByQueryBean(employeeQuery, page, pageSize);
        	setValueStack(result);
        }catch(Exception e){
        	e.printStackTrace();
        }
        return "employeeMain";
    }
    
    /**
     * 
     * To add employee information page
     * @return
     */
    public String toAddEmployee() {
        //this.toVm(null);
        return "toAddEmployee";
    }
    

    /**
     * 
     * To update employee information page
     * @return
     */
    public String toUpdateEmployee() {
    		
		if (null != employee) {
			// get employee information by id
			ResultCollection result = employeeService.getEmployeeById(employee.getId());
			setValueStack(result);
		} else {
			log.error("EmployeeAction!toUpdateEmployee() error!");
		}
        return "toUpdateEmployee";
    }
    
    /**
     * 
     * To update employee information page
     * @return
     */
    public String toUpdateEmployeeInfo() {
    	
		Map<String,Object> map=ActionContext.getContext().getSession();
		String employeeCode=(String)map.get("employeeCode");
		if(StringUtils.isNotBlank(employeeCode)) {
			// get employee information by employeeCode
			ResultCollection result = employeeService.getEmployeeByEmployeeCode(employeeCode);
			setValueStack(result);
		}else {
			log.error("EmployeeAction!toUpdateEmployee() error!");
			return "toLogin";
		}
        return "toUpdateEmployeeInfo";
    }
    
    /**
     * 
     * To delete employee information page
     * @return
     */
    public String toDeleteEmployee() {
    	try{
    		
    		if (null != employee) {
    			// get employee information by id
    			ResultCollection result = employeeService.getEmployeeById(employee.getId());
    			setValueStack(result);
    		} else {
    			log.error("EmployeeAction!toDeleteEmployee() error!");
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        return "toDeleteEmployee";
    }

    /**
     * 
     * To update employee password page
     * @return
     */
    public String toUpdateEmployeePassword() {
        //this.toVm(null);
        return "toUpdateEmployeePassword";
    }

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public EmployeeQuery getEmployeeQuery() {
		return employeeQuery;
	}

	public void setEmployeeQuery(EmployeeQuery employeeQuery) {
		this.employeeQuery = employeeQuery;
	}

  
}
