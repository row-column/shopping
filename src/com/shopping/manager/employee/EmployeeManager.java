package com.shopping.manager.employee;

import java.util.List;

import com.shopping.common.util.page.PageModel;
import com.shopping.domain.employee.Employee;
import com.shopping.domain.employee.query.EmployeeQuery;


/**
 * Employee information manager interface
 * @author WangYue
 *
 */
public interface EmployeeManager {

	/**
	 * add employee information
	 * @param employee   employee value class
	 * @return true:success;false:fail
	 */
	public boolean addEmployee(Employee employee);
	
	/**
	 * update employee information
	 * @param employee  employee value class
	 * @return true:success;false:fail
	 */
	public boolean updateEmployee(Employee employee);
	
	/**
	 * update employee information
	 * @param employee  employee value class
	 * @return true:success;false:fail
	 */
	public boolean updateEmployeeStatus(Employee employee);
	
	/**
	 * according to employee id ,query employee information.
	 * @param id  employee id
	 * @return  Employee  employee value class
	 */
	public Employee getEmployeeById(Long id);
	
	/**
	 * according to employee code ,query employee information.
	 * @param employeeCode  employee code
	 * @return Employee  employee value class
	 */
	public Employee getEmployeeByEmployeeCode(String employeeCode);
	
	/**
	 * query employee information with page
	 * @param query Query employee value class
	 * @return Employee employee value class
	 */
	public List<Employee> queryEmployeeListByQueryBean(EmployeeQuery employeeQuery);
	
	/**
	 * query employee information with page
	 * @param query Query employee value class
	 * @return Employee employee value class
	 */
	public PageModel<Employee> queryEmployeeListPageByQueryBean(EmployeeQuery employeeQuery, int pageIndex, int pageSize);
	
	/**
	 * 取得所有配送员工
	 * @return
	 */
	public List<Employee>  queryEmployeeListBySendEmployee(String isEmployeeFlag);
	
	/**
	 * according to employee id,delete employee information.
	 * @param id  employee id
	 * @return true:success;false:fail.
	 */
	public boolean deleteEmployeeById(Long id);
	
	/**
	 * according to employee id,delete employee information.
	 * @param ids  employee id array
	 * @return true:success;false:fail.
	 */
	public boolean deleteEmployeeByIds(Long ids[]);
	
	/**
	 * get employee records 
	 * @param query  Query employee value class 
	 * @return employee count 
	 */
	public int queryEmployeeCountByQueryBean(EmployeeQuery employeequery);
	
	
}
