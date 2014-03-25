package com.shopping.web.action.employee.json;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.shopping.common.util.action.BaseAction;
import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.employee.EmployeeFun;
import com.shopping.service.employee.EmployeeFunService;


/**
 * Employee Fun JsonAction
 * @author WangYue
 *
 */
public class EmployeeFunJsonAction extends BaseAction {
   // private final static Log logger = LogFactory.getLog(EmployeeFunJsonAction.class);
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * employee fun service interface
     */
    private EmployeeFunService employeeFunService;
    
    /**
     * json result
     */
    private String result;
    
    /**
     * result msg
     */
    private String resultMsg;
    
    /**
     *  employee fun value class
     */
    private EmployeeFun employeeFun;
    
    /**
     * employee code
     */
    private String employeeCode;
    
    
    private List<String> employeeCodes;
    
    /**
     * add employee fun method
     *
     * @return
     */
    public String addEmployeeFun() {
        if (null != employeeFun) {

            ResultCollection serviceResult = employeeFunService.addEmployeeFun(employeeFun);
            
            if (null != serviceResult && serviceResult.getSuccess()) {
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
     * delete employee fun
     *
     * @return
     */
    public String deleteEmployeeFun() {

    		 if(!StringUtils.isBlank(employeeCode)){
    			 ResultCollection serviceResult = employeeFunService.deleteEmployeeFunByEmployeeCode(employeeCode);
    			 
    			 if (null != serviceResult && serviceResult.getSuccess()) {
    				 result = "true";
    			 } else {
    				 result = "false*" + (String) serviceResult.get("resultMsg");
    			 }
    			 
    		 }else{
    			 
    			 result = "false*员工账号为空";
    		 }
         return "out";
    }
    
    /**
     * delete employee funs
     *
     * @return
     */
    public String deleteEmployeeFuns() {
		 if(null!=employeeCodes&&employeeCodes.size()>0){
			 ResultCollection serviceResult = employeeFunService.deleteEmployeeFunsByEmployeeCode(employeeCodes);
			 
			 if (null != serviceResult && serviceResult.getSuccess()) {
				 result = "true";
			 } else {
				 result = "false*" + (String) serviceResult.get("resultMsg");
			 }
			 
		 }else{
			 
			 result = "false*员工账号为空";
		 }
         return "out";
    }

    public void setEmployeeFunService(EmployeeFunService employeeFunService) {
        this.employeeFunService = employeeFunService;
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

	public EmployeeFun getEmployeeFun() {
		return employeeFun;
	}

	public void setEmployeeFun(EmployeeFun employeeFun) {
		this.employeeFun = employeeFun;
	}

	public EmployeeFunService getEmployeeFunService() {
		return employeeFunService;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public List<String> getEmployeeCodes() {
		return employeeCodes;
	}

	public void setEmployeeCodes(List<String> employeeCodes) {
		this.employeeCodes = employeeCodes;
	}
    
}
