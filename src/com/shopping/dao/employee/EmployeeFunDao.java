package com.shopping.dao.employee;

import java.util.List;

import com.shopping.domain.employee.EmployeeFun;
import com.shopping.domain.employee.query.EmployeeFunQuery;


/**
 * EmployeeFun information DAO interface
 * @author WangYue
 *
 */
public interface EmployeeFunDao {

	/**
	 * add employeeFun information
	 * @param employeeFun   employeeFun value class
	 * @return true:success;false:fail
	 */
	public boolean addEmployeeFun(EmployeeFun employeeFun);
	
	/**
	 * update employeeFun information
	 * @param employeeFun  employeeFun value class
	 * @return true:success;false:fail
	 */
	public boolean updateEmployeeFun(EmployeeFun employeeFun);
	
	/**
	 * according to employeeFun id ,query employeeFun information.
	 * @param id  employeeFun id
	 * @return  EmployeeFun  employeeFun value class
	 */
	public EmployeeFun getEmployeeFunById(Long id);
	
	/**
	 * according to employeeFun code ,query employeeFun information.
	 * @param employeeFunCode  employeeFun code
	 * @return EmployeeFun  employeeFun value class
	 */
	public EmployeeFun getEmployeeFunByEmployeeFunCode(String employeeFunCode);
	
	/**
	 * query all employeeFun information
	 * @param query  Query employeeFun value class
	 * @return EmployeeFun  employeeFun value class
	 */
	public List<EmployeeFun> queryEmployeeFunListByQueryBean(EmployeeFunQuery employeeFunQuery);
	
	/**
	 * query employeeFun information with page
	 * @param query Query employeeFun value class
	 * @return EmployeeFun employeeFun value class
	 */
	public List<EmployeeFun> queryEmployeeFunListPageByQueryBean(EmployeeFunQuery employeeFunQuery);
	
	/**
	 * according to employeeFun id,delete employeeFun information.
	 * @param id  employeeFun id
	 * @return true:success;false:fail.
	 */
	public boolean deleteEmployeeFunById(Long id);
	
	/**
	 * according to employeeCode ,delete employeeFun information.
	 * @param employeeCode  
	 * @return true:success;false:fail.
	 */
	public boolean deleteEmployeeFunByEmployeeCode(String employeeCode);
	/**
	 * get employeeFun records 
	 * @param query  Query employeeFun value class 
	 * @return employeeFun count 
	 */
	public int queryEmployeeFunCountByQueryBean(EmployeeFunQuery employeeFunQuery);

	
	
}
