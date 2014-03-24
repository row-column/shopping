package com.haos.service.employee;

import com.haos.common.util.page.ResultCollection;
import com.haos.domain.employee.Employee;
import com.haos.domain.employee.query.EmployeeQuery;

/**
 * Employee information service interface
 * @author WangYue
 *
 */
public interface EmployeeService {

	/**
	 * add employee information
	 * @param employee   employee value class
	 * @return Result 
	 */
	public ResultCollection addEmployee(Employee employee);
	
	/**
	 * update employee information
	 * @param employee  employee value class
	 * @return Result 
	 */
	public ResultCollection updateEmployee(Employee employee);
	
	/**
	 * according to employee id ,query employee information.
	 * @param id  employee id
	 * @return  Result
	 */
	public ResultCollection getEmployeeById(Long id);
	
	/**
	 * according to employee code ,query employee information.
	 * @param employeeCode  employee code
	 * @return Result
	 */
	public ResultCollection getEmployeeByEmployeeCode(String employeeCode);
	
	/**
	 * query employee information with page
	 * @param query Query employee value class
	 * @return Result
	 */
	public ResultCollection queryEmployeeListByQueryBean(EmployeeQuery employeeQuery);
	
	/**
	 * query employee information with page
	 * @param query Query employee value class
	 * @return Result
	 */
	public ResultCollection queryEmployeeListPageByQueryBean(EmployeeQuery employeeQuery, int pageIndex, int pageSize);
	
	
	/**
	 * according to employee id,delete employee information.
	 * @param id  employee id
	 * @return Result .
	 */
	public ResultCollection deleteEmployeeById(Long id);
	
	/**
	 * according to employee id,delete employee information.
	 * @param ids  employee id array
	 * @return Result .
	 */
	public ResultCollection deleteEmployeeByIds(Long ids[]);
	
}
