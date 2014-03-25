package com.shopping.dao.employee;

import java.util.List;

import com.shopping.domain.employee.Employee;
import com.shopping.domain.employee.query.EmployeeQuery;


/**
 * Employee information DAO interface
 * @author WangYue
 *
 */
public interface EmployeeDao {

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
	 * query all employee information
	 * @param query  Query employee value class
	 * @return Employee  employee value class
	 */
	public List<Employee> queryEmployeeListByQueryBean(EmployeeQuery employeeQuery);
	
	/**
	 * query employee information with page
	 * @param query Query employee value class
	 * @return Employee employee value class
	 */
	public List<Employee> queryEmployeeListPageByQueryBean(EmployeeQuery employeeQuery);
	
	/**
	 * according to employee id,delete employee information.
	 * @param id  employee id
	 * @return true:success;false:fail.
	 */
	public boolean deleteEmployeeById(Long id);
	
	/**
	 * get employee records 
	 * @param query  Query employee value class 
	 * @return employee count 
	 */
	public int queryEmployeeCountByQueryBean(EmployeeQuery employeeQuery);
	
	/**
	 * 取得所有配送员工
	 * @return
	 */
	public List<Employee>  queryEmployeeListBySendEmployee(String isEmployeeFlag);
	
	
}
