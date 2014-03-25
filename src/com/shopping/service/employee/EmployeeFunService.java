package com.shopping.service.employee;

import java.util.List;

import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.employee.EmployeeFun;
import com.shopping.domain.employee.query.EmployeeFunQuery;

/**
 * EmployeeFun information service interface
 * @author WangYue
 *
 */
public interface EmployeeFunService {

	/**
	 * add employeeFun information
	 * @param employeeFun   employeeFun value class
	 * @return Result 
	 */
	public ResultCollection addEmployeeFun(EmployeeFun employeeFun);
	
	/**
	 * update employeeFun information
	 * @param employeeFun  employeeFun value class
	 * @return Result 
	 */
	public ResultCollection updateEmployeeFun(EmployeeFun employeeFun);
	
	/**
	 * according to employeeFun id ,query employeeFun information.
	 * @param id  employeeFun id
	 * @return  Result
	 */
	public ResultCollection getEmployeeFunById(Long id);
	
	/**
	 * according to employeeFun code ,query employeeFun information.
	 * @param employeeFunCode  employeeFun code
	 * @return Result
	 */
	public ResultCollection getEmployeeFunByEmployeeFunCode(String employeeFunCode);
	
	/**
	 * query employeeFun information with page
	 * @param query Query employeeFun value class
	 * @return Result
	 */
	public ResultCollection queryEmployeeFunListByQueryBean(EmployeeFunQuery employeeFunQuery);
	
	/**
	 * query employeeFun information with page
	 * @param query Query employeeFun value class
	 * @return Result
	 */
	public ResultCollection queryEmployeeFunListPageByQueryBean(EmployeeFunQuery employeeFunQuery, int pageIndex, int pageSize);
	
	
	/**
	 * according to employeeFun id,delete employeeFun information.
	 * @param id  employeeFun id
	 * @return Result .
	 */
	public ResultCollection deleteEmployeeFunById(Long id);
	

	/**
	 * according to employee code,delete employeeFun information.
	 * @param id  employeeFun id
	 * @return Result .
	 */
	public ResultCollection deleteEmployeeFunByEmployeeCode(String employeeCode);
	
	/**
	 * according to list employee code,delete employeeFuns information.
	 * @param id  employeeFun id
	 * @return Result .
	 */
	public ResultCollection deleteEmployeeFunsByEmployeeCode(List<String> employeeCodes);
	
}
