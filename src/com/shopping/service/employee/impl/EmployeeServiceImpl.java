package com.shopping.service.employee.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.shopping.common.util.CommonConstant;
import com.shopping.common.util.page.PageModel;
import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.employee.Employee;
import com.shopping.domain.employee.query.EmployeeQuery;
import com.shopping.manager.employee.EmployeeManager;
import com.shopping.service.employee.EmployeeService;

/**
 * Employee information service interface
 * @author WangYue
 *
 */
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger log = LogManager.getLogger(EmployeeServiceImpl.class);
	private EmployeeManager employeeManager;
	@Override
	public ResultCollection addEmployee(Employee employee) {
		if(null!=employee){
			
			ResultCollection result = new ResultCollection();
			try {
				employee.setReqDate(new Date()); //set register date
				employee.setCreateTime(new Date()); //set create time
				employee.setUpdateTime(new Date()); //set update time
				employee.setStatus(CommonConstant.STATUS_DISAVAILABLE); //set employee status
                employee.setYn(CommonConstant.YN_NO_DELETE); //set yn-0
				boolean resultFlag = employeeManager.addEmployee(employee); //call addEmpployee()method
				result.addDefaultModel("resultFlag", resultFlag);
				result.setSuccess(resultFlag);
			} catch (Exception e) {
				log.error("EmployeeServiceImpl -> addEmployee() error!!", e);
				throw new RuntimeException("EmployeeServiceImpl -> addEmployee() error!!",e);
			}
			return result;
		}else{
			log.error("EmployeeServiceImpl -> addEmployee() employee empty!!");
			throw new RuntimeException("EmployeeServiceImpl -> addEmployee() employee empty!!");
		}
	}

	@Override
	public ResultCollection updateEmployee(Employee employee) {
       if(null!=employee){
    	   ResultCollection result = new ResultCollection();
    	   try {
    		   boolean resultFlag = employeeManager.updateEmployee(employee);
    		   result.addDefaultModel("resultFlag", resultFlag);
    		   result.setSuccess(true);
    	   } catch (Exception e) {
    		   log.error("EmployeeServiceImpl -> updateEmployee() error!!", e);
    		   throw new RuntimeException("EmployeeServiceImpl -> updateEmployee() error!!",e);
    	   }
    	   return result;
    	   
       }else{
    	    log.error("EmployeeServiceImpl -> updateEmployee() employee empty!!");
			throw new RuntimeException("EmployeeServiceImpl -> updateEmployee() employee empty!!");
       }
	}

	@Override
	public ResultCollection getEmployeeById(Long id) {
		if(null!=id){
			ResultCollection result = new ResultCollection();
			try {
				Employee employee = employeeManager.getEmployeeById(id);
				result.addDefaultModel("employee", employee);
				result.setSuccess(true);
			} catch (Exception e) {
				log.error("EmployeeServiceImpl -> getEmployeeById() error!!", e);
				throw new RuntimeException("EmployeeServiceImpl -> getEmployeeById() error!!",e);
			}
			return result;
			
		}else{
			log.error("EmployeeServiceImpl -> getEmployeeById() id empty!!");
			throw new RuntimeException("EmployeeServiceImpl -> getEmployeeById() id empty!!");
		}
	}

	@Override
	public ResultCollection getEmployeeByEmployeeCode(String employeeCode) {
		if(!StringUtils.isBlank(employeeCode)){
			ResultCollection result = new ResultCollection();
			try {
				Employee employee = employeeManager.getEmployeeByEmployeeCode(employeeCode);
				result.addDefaultModel("employee", employee);
				result.setSuccess(true);
			} catch (Exception e) {
				log.error("EmployeeServiceImpl -> getEmployeeByEmployeeCode() error!!", e);
			}
			return result;
			
		}else{
			 log.error("EmployeeServiceImpl -> getEmployeeByEmployeeCode() employee code empty!!");
			throw new RuntimeException("EmployeeServiceImpl -> getEmployeeByEmployeeCode() employee code empty!!");
		}
	}

	@Override
	public ResultCollection queryEmployeeListByQueryBean(EmployeeQuery employeeQuery) {
		if(null!=employeeQuery){
			ResultCollection result = new ResultCollection();
			try {
				List<Employee> employeeList = employeeManager.queryEmployeeListByQueryBean(employeeQuery);
				result.addDefaultModel("employeeList", employeeList);
				result.setSuccess(true);
			} catch (Exception e) {
				log.error("EmployeeServiceImpl -> queryEmployeeListByQueryBean() error!!", e);
				throw new RuntimeException("EmployeeServiceImpl -> queryEmployeeListByQueryBean() error!!", e);
			}
			return result;
			
		}else{
			log.error("EmployeeServiceImpl -> queryEmployeeListByQueryBean() employeeQuery empty!!");
            throw new RuntimeException("EmployeeServiceImpl -> queryEmployeeListByQueryBean() employeeQuery empty!!");
		}
	}

	@Override
	public ResultCollection queryEmployeeListPageByQueryBean(EmployeeQuery employeeQuery,int pageIndex, int pageSize) {
		ResultCollection result = new ResultCollection();
		if(null==employeeQuery){
			employeeQuery = new EmployeeQuery();
		}
        try {
        	PageModel<Employee> employeeList = employeeManager.queryEmployeeListPageByQueryBean(employeeQuery,pageIndex,pageSize);
            result.addDefaultModel("employeeList", employeeList);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("EmployeeServiceImpl -> queryEmployeeListPageByQueryBean() error!!", e);
            throw new RuntimeException("EmployeeServiceImpl -> queryEmployeeListPageByQueryBean() error!!", e);
        }
        return result;
	}

	@Override
	public ResultCollection deleteEmployeeById(Long id) {
		if(null!=id){
			ResultCollection result = new ResultCollection();
			try {
				boolean resultFlag = employeeManager.deleteEmployeeById(id);
				result.addDefaultModel("resultFlag", resultFlag);
				result.setSuccess(true);
			} catch (Exception e) {
				log.error("EmployeeServiceImpl -> deleteEmployeeById() error!!", e);
				throw new RuntimeException("EmployeeServiceImpl -> deleteEmployeeById() error!!",e);
			}
			return result;
			
		}else{
			log.error("EmployeeServiceImpl -> deleteEmployeeById() id empty!!");
            throw new RuntimeException("EmployeeServiceImpl -> deleteEmployeeById() id empty!!");
		}
	}
	@Override
	public ResultCollection deleteEmployeeByIds(Long ids[]){
		if(null!=ids){
			ResultCollection result = new ResultCollection();
			try {
				boolean resultFlag = employeeManager.deleteEmployeeByIds(ids);
				result.addDefaultModel("resultFlag", resultFlag);
				result.setSuccess(true);
			} catch (Exception e) {
				log.error("EmployeeServiceImpl -> deleteEmployeeByIds() error!!", e);
				throw new RuntimeException("EmployeeServiceImpl -> deleteEmployeeByIds() error!!",e);
			}
			return result;
			
		}else{
			log.error("EmployeeServiceImpl -> deleteEmployeeByIds() ids empty!!");
            throw new RuntimeException("EmployeeServiceImpl -> deleteEmployeeByIds() ids empty!!");

		}
	}

	public void setEmployeeManager(EmployeeManager employeeManager) {
		this.employeeManager = employeeManager;
	}
}
