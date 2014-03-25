package com.shopping.service.employee.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.shopping.common.util.CommonConstant;
import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.employee.Employee;
import com.shopping.domain.employee.EmployeeFun;
import com.shopping.domain.employee.query.EmployeeFunQuery;
import com.shopping.domain.fun.Fun;
import com.shopping.domain.fun.query.FunQuery;
import com.shopping.manager.employee.EmployeeFunManager;
import com.shopping.manager.employee.EmployeeManager;
import com.shopping.manager.fun.FunManager;
import com.shopping.service.employee.EmployeeFunService;

/**
 * EmployeeFun information service interface
 * @author WangYue
 *
 */
public class EmployeeFunServiceImpl implements EmployeeFunService {
    private static final Logger log = LogManager.getLogger(EmployeeFunServiceImpl.class);
    /**
     * employee fun information manager interface
     */
	private EmployeeFunManager employeeFunManager;
	
	/**
	 * employee information manager interface
	 */
	private EmployeeManager employeeManager;
	
	/**
	 * fun information manager interface
	 */
	private FunManager funManager;
	@Override
	public ResultCollection addEmployeeFun(EmployeeFun employeeFun) {
		if(null!=employeeFun){
			ResultCollection result = new ResultCollection();
			try {
				String employeeCode =employeeFun.getEmployeeCode(); //get employee code
				if(!StringUtils.isBlank(employeeCode)){
					
					boolean deleteEmployeeFunFlag= employeeFunManager.deleteEmployeeFunByEmployeeCode(employeeCode); //call deleteEmployeeFunByEmployeeCode()method
					if(!deleteEmployeeFunFlag){
						log.error("EmployeeFunServiceImpl -> addEmployeeFun()-->deleteEmployeeFun() error!!");
					}
				}
				List<String> employeeFunCodes=employeeFun.getEmployeeFunCodes(); // get employeeFunCodes from employeeFun
				if(null!=employeeFunCodes&&employeeFunCodes.size()>0){
					for(String funCode:employeeFunCodes){
						employeeFun.setFunCode(funCode); //set fun code 
						
						boolean addEmployeeFunFlag=employeeFunManager.addEmployeeFun(employeeFun);
						if(!addEmployeeFunFlag){
							log.error("EmployeeFunServiceImpl -> addEmployeeFun() error!!");
							throw new RuntimeException("EmployeeFunServiceImpl -> addEmployeeFun()error!!");
						}
						result.addDefaultModel("resultFlag", addEmployeeFunFlag);
						result.setSuccess(addEmployeeFunFlag);
					}
					
				}else{
					log.error("EmployeeFunServiceImpl -> addEmployeeFun() employeeFunCodes empty!!");
					throw new RuntimeException("EmployeeFunServiceImpl -> addEmployeeFun() employeeFunCodes empty!!");
				}
			} catch (Exception e) {
				log.error("EmployeeFunServiceImpl -> addEmployeeFun() error!!", e);
			}
			return result;
		}else{
			 log.error("EmployeeFunServiceImpl -> addEmployeeFun() employeeFun empty!!");
			 throw new RuntimeException("EmployeeFunServiceImpl -> addEmployeeFun() employeeFun empty!!");
		}
	}

	@Override
	public ResultCollection updateEmployeeFun(EmployeeFun employeeFun) {
		 ResultCollection result = new ResultCollection();
	        try {
	            boolean resultFlag = employeeFunManager.updateEmployeeFun(employeeFun);
	            result.addDefaultModel("resultFlag", resultFlag);
	            result.setSuccess(true);
	        } catch (Exception e) {
	            log.error("EmployeeFunServiceImpl -> updateEmployeeFun() error!!", e);
	        }
	        return result;
	}

	@Override
	public ResultCollection getEmployeeFunById(Long id) {
		 ResultCollection result = new ResultCollection();
	        try {
	            EmployeeFun employeeFun = employeeFunManager.getEmployeeFunById(id);
	            result.addDefaultModel("employeeFun", employeeFun);
	            result.setSuccess(true);
	        } catch (Exception e) {
	            log.error("EmployeeFunServiceImpl -> getEmployeeFunById() error!!", e);
	        }
	        return result;
	}

	@Override
	public ResultCollection getEmployeeFunByEmployeeFunCode(String employeeFunCode) {
		 ResultCollection result = new ResultCollection();
	        try {
	            EmployeeFun employeeFun = employeeFunManager.getEmployeeFunByEmployeeFunCode(employeeFunCode);
	            result.addDefaultModel("employeeFun", employeeFun);
	            result.setSuccess(true);
	        } catch (Exception e) {
	            log.error("EmployeeFunServiceImpl -> getEmployeeFunByEmployeeFunCode() error!!", e);
	        }
	        return result;
	}

	@Override
	public ResultCollection queryEmployeeFunListByQueryBean(EmployeeFunQuery employeeFunQuery) {
		if(null!=employeeFunQuery){
			ResultCollection result = new ResultCollection();
			String employeeCode=employeeFunQuery.getEmployeeCode(); //get employee code
			try {
				if(!StringUtils.isBlank(employeeCode)){
					Employee employee=employeeManager.getEmployeeByEmployeeCode(employeeCode);
					if(null!=employee){
						result.addDefaultModel("employee",employee);
					}else{
						log.error("EmployeeFunServiceImpl -> queryEmployeeFunListByQueryBean() employee  empty!!");
						throw new RuntimeException("EmployeeFunServiceImpl -> queryEmployeeFunListByQueryBean() employee  empty!!");
					}
					List<EmployeeFun> employeeFunList = employeeFunManager.queryEmployeeFunListByQueryBean(employeeFunQuery); //call queryEmployeeFun
					List<String> employeeFunCodes=new ArrayList<String>();
					for(EmployeeFun ef:employeeFunList){
						employeeFunCodes.add(ef.getFunCode());
					}
					result.addDefaultModel("employeeFunCodes", employeeFunCodes);
					
					List<Fun> funList=funManager.queryFunListByQueryBean(new FunQuery()); //call queryFunListByQueryBean()method
					result.addDefaultModel("funList", funList);
					
					result.setSuccess(true);
				}else{
					log.error("EmployeeFunServiceImpl -> queryEmployeeFunListByQueryBean() employee code empty!!");
					throw new RuntimeException("EmployeeFunServiceImpl -> queryEmployeeFunListByQueryBean() employee code empty!!");
				}
				
			} catch (Exception e) {
				log.error("EmployeeFunServiceImpl -> queryEmployeeFunListByQueryBean() error!!", e);
				throw new RuntimeException("EmployeeFunServiceImpl -> queryEmployeeFunListByQueryBean() error!!", e);
			}
			return result;
			
		}else{
			log.error("EmployeeFunServiceImpl -> queryEmployeeFunListByQueryBean() employeeFunQuery empty!!");
		    throw new RuntimeException("EmployeeFunServiceImpl -> queryEmployeeFunListByQueryBean() employeeFunQuery empty!!");
			
		}
	}

	@Override
	public ResultCollection queryEmployeeFunListPageByQueryBean(EmployeeFunQuery employeeFunQuery,
			int pageIndex, int pageSize) {
		ResultCollection result = new ResultCollection();
        try {
            List<EmployeeFun> employeeFunList = employeeFunManager.queryEmployeeFunListPageByQueryBean(employeeFunQuery,pageIndex,pageSize);
            result.addDefaultModel("employeeFunList", employeeFunList);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("EmployeeFunServiceImpl -> queryEmployeeFunListPageByQueryBean() error!!", e);
        }
        return result;
	}

	@Override
	public ResultCollection deleteEmployeeFunById(Long id) {
		 ResultCollection result = new ResultCollection();
	        try {
	            boolean resultFlag = employeeFunManager.deleteEmployeeFunById(id);
	            result.addDefaultModel("resultFlag", resultFlag);
	            result.setSuccess(resultFlag);
	        } catch (Exception e) {
	            log.error("EmployeeFunServiceImpl -> deleteEmployeeFunById() error!!", e);
	        }
	        return result;
	}
	
	@Override
	public ResultCollection deleteEmployeeFunByEmployeeCode(String employeeCode) {
		if(!StringUtils.isBlank(employeeCode)){
			
			ResultCollection result = new ResultCollection();
			try {
				    employeeFunManager.deleteEmployeeFunByEmployeeCode(employeeCode);
				    
					Employee employee = new Employee();
					employee.setEmployeeCode(employeeCode); //set employee  code
					employee.setStatus(CommonConstant.STATUS_DISAVAILABLE); //set employee status=0
					employee.setUpdateTime(new Date()); //set update time
					boolean resultFlag =employeeManager.updateEmployeeStatus(employee);  //call  updateEmployeeStatus() method
						
					result.addDefaultModel("resultFlag", resultFlag);
					result.setSuccess(resultFlag);
			} catch (Exception e) {
				log.error("EmployeeFunServiceImpl -> deleteEmployeeFunByEmployeeCode() error!!", e);
			}
			return result;
		}else{
			log.error("EmployeeFunServiceImpl -> deleteEmployeeFunByEmployeeCode() employeeCode empty !!");
			throw new RuntimeException("EmployeeFunServiceImpl -> deleteEmployeeFunByEmployeeCode() employeeCode empty !!");
		}
	}
	
	@Override
	public ResultCollection deleteEmployeeFunsByEmployeeCode(List<String> employeeCodes) {
		if(null!=employeeCodes&&employeeCodes.size()>0){
			
			ResultCollection result = new ResultCollection();
			for(String employeeCode:employeeCodes){
				
				try {
					employeeFunManager.deleteEmployeeFunByEmployeeCode(employeeCode);
					
					Employee employee = new Employee();
					employee.setEmployeeCode(employeeCode); //set employee  code
					employee.setStatus(CommonConstant.STATUS_DISAVAILABLE); //set employee status=0
					employee.setUpdateTime(new Date()); //set update time
					boolean resultFlag =employeeManager.updateEmployeeStatus(employee);  //call  updateEmployeeStatus() method
					
					result.addDefaultModel("resultFlag", resultFlag);
					result.setSuccess(resultFlag);
				} catch (Exception e) {
					log.error("EmployeeFunServiceImpl -> deleteEmployeeFunByEmployeeCode() error!!", e);
				}
			}
			return result;
		}else{
			log.error("EmployeeFunServiceImpl -> deleteEmployeeFunByEmployeeCode() employeeCodes empty !!");
			throw new RuntimeException("EmployeeFunServiceImpl -> deleteEmployeeFunByEmployeeCode() employeeCodes empty !!");
		}
	}

	public void setEmployeeFunManager(EmployeeFunManager employeeFunManager) {
		this.employeeFunManager = employeeFunManager;
	}

	public void setEmployeeManager(EmployeeManager employeeManager) {
		this.employeeManager = employeeManager;
	}

	public void setFunManager(FunManager funManager) {
		this.funManager = funManager;
	}
	
}
