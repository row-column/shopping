package com.haos.dao.employee.impl;

import java.util.List;

import com.haos.common.util.dao.BaseDao;
import com.haos.dao.employee.EmployeeDao;
import com.haos.domain.employee.Employee;
import com.haos.domain.employee.query.EmployeeQuery;

/**
 * Employee information DAO implementation
 * @author WangYue
 *
 */
@SuppressWarnings("rawtypes")
public class EmployeeDaoImpl extends BaseDao implements EmployeeDao {

	@SuppressWarnings("unchecked")
	@Override
	public boolean addEmployee(Employee employee) {
		return this.insert("Employee.insert", employee);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updateEmployee(Employee employee) {
		return this.update("Employee.update", employee);
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean updateEmployeeStatus(Employee employee) {
		return this.update("Employee.updateEmployeeStatus", employee);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Employee getEmployeeById(Long id) {
		return (Employee)this.queryForObject("Employee.getEmployeeById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Employee getEmployeeByEmployeeCode(String employeeCode) {
		return (Employee)this.queryForObject("Employee.getEmployeeByEmployeeCode", employeeCode);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> queryEmployeeListByQueryBean(EmployeeQuery employeeQuery) {
		return this.queryForList("Employee.queryEmployeeListByQueryBean",employeeQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> queryEmployeeListPageByQueryBean(EmployeeQuery employeeQuery) {
		return this.queryForList("Employee.queryEmployeeListPageByQueryBean", employeeQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteEmployeeById(Long id) {
		return this.delete("Employee.deleteEmployeeById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int queryEmployeeCountByQueryBean(EmployeeQuery employeeQuery) {
		return (Integer)this.queryForObject("Employee.queryEmployeeCountByQueryBean", employeeQuery);
	}
	/**
	 * 取得所有配送员工
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee>  queryEmployeeListBySendEmployee(String isEmployeeFlag){
		return this.queryForList("Employee.queryEmployeeListBySendEmployee", isEmployeeFlag);
	}

}
